using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;

using Android.App;
using Android.Content;
using Android.Net;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;

namespace PKUAutoGateway.Android
{
    [BroadcastReceiver(Enabled = true)]
    [IntentFilter(
        new[] { ConnectivityManager.ConnectivityAction, Intent.ActionBootCompleted, Intent.ActionLockedBootCompleted },
        Categories = new[] { Intent.CategoryDefault })]
    public class NetworkChangeReceiver : BroadcastReceiver
    {
        public override void OnReceive(Context context, Intent intent)
        {
            string GetStateName(NetworkInfo.State state)
            {
                if (state == null) {
                    return "(null)";
                }

                if (state == NetworkInfo.State.Connected)
                    return nameof(NetworkInfo.State.Connected);
                if (state == NetworkInfo.State.Connecting)
                    return nameof(NetworkInfo.State.Connecting);
                if (state == NetworkInfo.State.Disconnected)
                    return nameof(NetworkInfo.State.Disconnected);
                if (state == NetworkInfo.State.Disconnecting)
                    return nameof(NetworkInfo.State.Disconnecting);
                if (state == NetworkInfo.State.Suspended)
                    return nameof(NetworkInfo.State.Suspended);
                if (state == NetworkInfo.State.Unknown)
                    return nameof(NetworkInfo.State.Unknown);
                return "(unmatch)";
            }

            string message;
            ConnectivityManager cm = (ConnectivityManager)context.GetSystemService(Context.ConnectivityService);
            NetworkInfo.State wifiState = cm.GetNetworkInfo(ConnectivityType.Wifi).GetState();
            NetworkInfo.State mobileState = cm.GetNetworkInfo(ConnectivityType.Mobile).GetState();

            message = $"WIFI: {GetStateName(wifiState)}, MOBILE: {GetStateName(mobileState)}";

            //
            // WIFI Connected
            //
            if (wifiState == NetworkInfo.State.Connected) {
                Intent srv = new Intent(context.ApplicationContext, typeof(MainService));
                context.ApplicationContext.StartService(srv);
            }


            /*
            if (wifiState != null && 
                mobileState != null && 
                NetworkInfo.State.Connected != wifiState && 
                NetworkInfo.State.Connected == mobileState) {
                message = "手机网络连接成功";
            }
            else if (wifiState != null &&
                     mobileState != null &&
                     NetworkInfo.State.Connected != wifiState &&
                     NetworkInfo.State.Connected != mobileState) {
                message = "手机没有任何的网络";
            }
            else if (wifiState != null &&
                     NetworkInfo.State.Connected == wifiState) {
                message = "无线网络连接成功";
            }
            else {
                message = "不知道怎么变了= =";
            }
            */

            //Toast.MakeText(context, message, ToastLength.Short).Show();
        }
    }
}