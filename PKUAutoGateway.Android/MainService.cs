using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading;
using Android.App;
using Android.Content;
using Android.Net;
using Android.Net.Wifi;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using Newtonsoft.Json.Linq;

namespace PKUAutoGateway.Android
{
    [Service(Exported = false)]
    public class MainService : Service
    {
        private int _counter = 0;


        private static void ShowToast(string text)
        {
            if (Looper.MainLooper == Looper.MyLooper()) {
                Toast.MakeText(Application.Context, text, ToastLength.Short).Show();
            }
            else {
                Handler handler = new Handler(Looper.MainLooper);
                handler.Post(() => {
                    Toast.MakeText(Application.Context, text, ToastLength.Short).Show();
                });
            }
        }

        public override IBinder OnBind(Intent intent)
        {
            return null;
        }

        public override void OnCreate()
        {
            //MainService.ShowToast($"[{this._counter++}] OnCreate");

            this.TryConnectWirelessPKU();

            base.OnCreate();
        }

        public override StartCommandResult OnStartCommand(Intent intent, StartCommandFlags flags, int startId)
        {
            //MainService.ShowToast($"[{this._counter++}] OnStartCommand: startId = {startId}, flags = {flags}");

            this.TryConnectWirelessPKU();

            //return base.OnStartCommand(intent, StartCommandFlags.Retry, startId);
            return StartCommandResult.Sticky;
        }

        private static bool IsTargetWifi(string uuid)
        {
            return (uuid == "\"Wireless PKU\"");
        }

        private static readonly Stopwatch __watch = new Stopwatch();
        private static TimeSpan __lastTimeSpan;

        private static bool IsTooOften()
        {
            lock (__watch) {
                if (!__watch.IsRunning) {
                    __watch.Start();
                    __lastTimeSpan = __watch.Elapsed;
                    return false;
                }

                return ((__watch.Elapsed - __lastTimeSpan).TotalSeconds < 5);
            }
        }

        private void TryConnectWirelessPKU()
        {
            try {
                WifiManager wifiMgr = (WifiManager)this.Application.ApplicationContext.GetSystemService(Context.WifiService);
                WifiState wifiState = wifiMgr.WifiState;
                if (wifiState != WifiState.Enabled) {
                    return;
                }

                WifiInfo info = wifiMgr.ConnectionInfo;
                if (info == null) {
                    return;
                }

                string wifiId = info.SSID;
                if (!MainService.IsTargetWifi(wifiId) || MainService.IsTooOften()) {
                    return;
                }

                IPAddress ip = new IPAddress(BitConverter.GetBytes(info.IpAddress));
                new Thread(() => {
                    try {
                        const string USER_AGENT = "IPGWAndroid1.4_Android6.0_8aeee18a-f4a8-4cab-b6fc-e7fb557b8b2f";
                        const string CONTENT_TYPE = "application/x-www-form-urlencoded; charset=utf-8";

                        Dictionary<string, string> dict = new Dictionary<string, string>();
                        dict["cmd"] = "open";
                        dict["username"] = "<Your ID>";  // TODO
                        dict["password"] = "<Your Password>"; // TODO
                        dict["iprange"] = "fee";
                        dict["ip"] = ip.ToString();
                        dict["lang"] = "en";
                        dict["app"] = USER_AGENT;

                        string @params = string.Join("&",
                            dict.Select(pair => $"{pair.Key}={WebUtility.UrlEncode(pair.Value)}"));
                        string url = $"https://its.pku.edu.cn/cas/ITSClient?{@params}";

                        HttpWebRequest req = new HttpWebRequest(new System.Uri(url));
                        req.Method = HttpMethod.Post.Method;
                        req.ContentType = CONTENT_TYPE;
                        req.UserAgent = USER_AGENT;
                        req.Proxy = null;

                        Stream strm = req.GetResponse().GetResponseStream();
                        StreamReader reader = new StreamReader(strm);
                        string respJson = reader.ReadToEnd();
                        reader.Dispose();
                        strm.Dispose();

                        JObject root = JObject.Parse(respJson);
                        if (((string)root["succ"]).Length != 0) {
                            MainService.ShowToast($"Connect to {wifiId} failed: {(string)root["succ"]}");
                            return;
                        }


                        string connections = (string)root["CONNECTIONS"];
                        string respIp = (string)root["IP"];
                        if (((string)root["succ"]).Length != 0) {
                            MainService.ShowToast($"Connect to {wifiId} failed: {(string) root["succ"]}");
                            return;
                        }

                        MainService.ShowToast($"Connected to {wifiId}.\nIP: {ip}\nConnections: {connections}");

                        //
                        // Update __lastTimeSpan
                        //
                        MainService.__lastTimeSpan = MainService.__watch.Elapsed;
                    }
                    catch (Exception ex) {
                        ShowToast(ex.ToString());
                    }
                }).Start();
            }
            catch (Exception ex) {
                MainService.ShowToast(ex.Message);
            }
        }


        public override void OnDestroy()
        {
            MainService.ShowToast($"[{this._counter++}] OnDestroy");
            base.OnDestroy();

            //
            // Just restart the service
            //
            Intent sevice = new Intent(Application.Context, typeof(MainService));
            Application.Context.StartService(sevice);
        }

    }
}