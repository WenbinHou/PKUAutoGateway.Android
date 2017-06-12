package com.alipay.sdk.k;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.alipay.sdk.app.a.a;
import com.alipay.sdk.app.k;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"SetJavaScriptEnabled", "DefaultLocale"})
public final class j {
    public static WebView a(Activity activity, String str, String str2) {
        Method method;
        if (!TextUtils.isEmpty(str2)) {
            CookieSyncManager.createInstance(activity.getApplicationContext()).sync();
            CookieManager.getInstance().setCookie(str, str2);
            CookieSyncManager.getInstance().sync();
        }
        View linearLayout = new LinearLayout(activity);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        activity.setContentView(linearLayout, layoutParams);
        View webView = new WebView(activity);
        layoutParams.weight = 1.0f;
        webView.setVisibility(0);
        linearLayout.addView(webView, layoutParams);
        WebSettings settings = webView.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + c(activity));
        settings.setRenderPriority(RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
        settings.setAllowFileAccess(false);
        settings.setTextSize(TextSize.NORMAL);
        webView.setVerticalScrollbarOverlay(true);
        webView.setDownloadListener(new l(activity));
        if (VERSION.SDK_INT >= 7) {
            try {
                method = webView.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[]{Boolean.TYPE});
                if (method != null) {
                    method.invoke(webView.getSettings(), new Object[]{Boolean.valueOf(true)});
                }
            } catch (Exception e) {
            }
        }
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
        }
        if (VERSION.SDK_INT >= 19) {
            webView.getSettings().setCacheMode(1);
        }
        webView.loadUrl(str);
        return webView;
    }

    public static k a(Context context, String str) {
        for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(64)) {
            if (packageInfo.packageName.equals(str)) {
                k kVar = new k();
                kVar.a = packageInfo.signatures[0].toByteArray();
                kVar.b = packageInfo.versionCode;
                return kVar;
            }
        }
        return null;
    }

    public static String a() {
        return "Android " + VERSION.RELEASE;
    }

    public static String a(String str, String str2, String str3) {
        try {
            int length = str.length() + str3.indexOf(str);
            if (length <= str.length()) {
                return "";
            }
            int i = 0;
            if (!TextUtils.isEmpty(str2)) {
                i = str3.indexOf(str2, length);
            }
            return i <= 0 ? str3.substring(length) : str3.substring(length, i);
        } catch (Throwable th) {
            return "";
        }
    }

    public static String a(byte[] bArr) {
        try {
            String obj = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey().toString();
            if (obj.indexOf("modulus") != -1) {
                return obj.substring(obj.indexOf("modulus") + 8, obj.lastIndexOf(",")).trim();
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static Map<String, String> a(String str) {
        Map<String, String> hashMap = new HashMap();
        for (String str2 : str.split("&")) {
            int indexOf = str2.indexOf("=", 1);
            hashMap.put(str2.substring(0, indexOf), URLDecoder.decode(str2.substring(indexOf + 1)));
        }
        return hashMap;
    }

    public static boolean a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.alipay.android.app", 128) != null;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean a(WebView webView, String str, Activity activity) {
        if (!TextUtils.isEmpty(str)) {
            String a;
            if (str.toLowerCase().startsWith("alipays://platformapi/startApp?".toLowerCase()) || str.toLowerCase().startsWith("intent://platformapi/startapp?".toLowerCase())) {
                try {
                    k a2 = a(activity, "com.eg.android.AlipayGphone");
                    if (a2 != null) {
                        a = a(a2.a);
                        if (a == null || TextUtils.equals(a, "b6cbad6cbd5ed0d209afc69ad3b7a617efaae9b3c47eabe0be42d924936fa78c8001b1fd74b079e5ff9690061dacfa4768e981a526b9ca77156ca36251cf2f906d105481374998a7e6e6e18f75ca98b8ed2eaf86ff402c874cca0a263053f22237858206867d210020daa38c48b20cc9dfd82b44a51aeb5db459b22794e2d649")) {
                            if (str.startsWith("intent://platformapi/startapp")) {
                                str = str.replaceFirst("intent://platformapi/startapp\\?", "alipays://platformapi/startApp?");
                            }
                            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        } else {
                            a.a("biz", "ClientSignError", a);
                        }
                    }
                } catch (Throwable th) {
                }
            } else if (TextUtils.equals(str, "sdklite://h5quit") || TextUtils.equals(str, "http://m.alipay.com/?action=h5quit")) {
                com.alipay.sdk.app.j.a = com.alipay.sdk.app.j.a();
                activity.finish();
            } else if (str.startsWith("sdklite://h5quit?result=")) {
                k a3;
                try {
                    a = str.substring(str.indexOf("sdklite://h5quit?result=") + 24);
                    int parseInt = Integer.parseInt(a.substring(a.lastIndexOf("&end_code=") + 10));
                    if (parseInt == k.SUCCEEDED.h || parseInt == k.PAY_WAITTING.h) {
                        StringBuilder stringBuilder = new StringBuilder();
                        a = URLDecoder.decode(str);
                        a = a.substring(a.indexOf("sdklite://h5quit?result=") + 24, a.lastIndexOf("&end_code="));
                        if (a.contains("&return_url=")) {
                            int indexOf = a.indexOf("&return_url=") + 12;
                            stringBuilder.append(a.split("&return_url=")[0]).append("&return_url=").append(a.substring(indexOf, a.indexOf("\"&", indexOf))).append(a.substring(a.indexOf("\"&", indexOf)));
                            a = stringBuilder.toString();
                        }
                        k a4 = k.a(parseInt);
                        com.alipay.sdk.app.j.a = com.alipay.sdk.app.j.a(a4.h, a4.i, a);
                        activity.runOnUiThread(new m(activity));
                    } else {
                        a3 = k.a(k.FAILED.h);
                        com.alipay.sdk.app.j.a = com.alipay.sdk.app.j.a(a3.h, a3.i, "");
                        activity.runOnUiThread(new m(activity));
                    }
                } catch (Exception e) {
                    a3 = k.a(k.PARAMS_ERROR.h);
                    com.alipay.sdk.app.j.a = com.alipay.sdk.app.j.a(a3.h, a3.i, "");
                }
            } else {
                webView.loadUrl(str);
            }
        }
        return true;
    }

    public static String b() {
        String d = d();
        int indexOf = d.indexOf("-");
        if (indexOf != -1) {
            d = d.substring(0, indexOf);
        }
        indexOf = d.indexOf("\n");
        if (indexOf != -1) {
            d = d.substring(0, indexOf);
        }
        return "Linux " + d;
    }

    public static boolean b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 128);
            if (packageInfo == null) {
                return false;
            }
            int parseInt;
            String str = packageInfo.versionName;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            arrayList.addAll(Arrays.asList(str.split("\\.")));
            arrayList2.addAll(Arrays.asList("7.0.0".split("\\.")));
            int max = Math.max(arrayList.size(), arrayList2.size());
            while (arrayList.size() < max) {
                arrayList.add("0");
            }
            while (arrayList2.size() < max) {
                arrayList2.add("0");
            }
            for (int i = 0; i < max; i++) {
                if (Integer.parseInt((String) arrayList.get(i)) != Integer.parseInt((String) arrayList2.get(i))) {
                    parseInt = Integer.parseInt((String) arrayList.get(i)) - Integer.parseInt((String) arrayList2.get(i));
                    break;
                }
            }
            parseInt = 0;
            return parseInt >= 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean b(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    public static String c() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 24; i++) {
            switch (random.nextInt(3)) {
                case 0:
                    stringBuilder.append(String.valueOf((char) ((int) Math.round((Math.random() * 25.0d) + 65.0d))));
                    break;
                case 1:
                    stringBuilder.append(String.valueOf((char) ((int) Math.round((Math.random() * 25.0d) + 97.0d))));
                    break;
                case 2:
                    stringBuilder.append(String.valueOf(new Random().nextInt(10)));
                    break;
                default:
                    break;
            }
        }
        return stringBuilder.toString();
    }

    public static String c(Context context) {
        String a = a();
        String b = b();
        String d = d(context);
        return " (" + a + ";" + b + ";" + d + ";;" + e(context) + ")(sdk android)";
    }

    private static String d() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            CharSequence readLine = bufferedReader.readLine();
            bufferedReader.close();
            Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(readLine);
            return !matcher.matches() ? "Unavailable" : matcher.groupCount() < 4 ? "Unavailable" : new StringBuilder(matcher.group(1)).append("\n").append(matcher.group(2)).append(" ").append(matcher.group(3)).append("\n").append(matcher.group(4)).toString();
        } catch (IOException e) {
            return "Unavailable";
        } catch (Throwable th) {
            bufferedReader.close();
        }
    }

    public static String d(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static String e(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(displayMetrics.widthPixels);
        stringBuilder.append("*");
        stringBuilder.append(displayMetrics.heightPixels);
        return stringBuilder.toString();
    }

    public static String f(Context context) {
        String str = "";
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals("com.eg.android.AlipayGphone")) {
                    str = str + "#M";
                } else {
                    str = runningAppProcessInfo.processName.startsWith("com.eg.android.AlipayGphone:") ? str + "#" + runningAppProcessInfo.processName.replace("com.eg.android.AlipayGphone:", "") : str;
                }
            }
        } catch (Throwable th) {
            str = "";
        }
        if (str.length() > 0) {
            str = str.substring(1);
        }
        return str.length() == 0 ? "N" : str;
    }
}
