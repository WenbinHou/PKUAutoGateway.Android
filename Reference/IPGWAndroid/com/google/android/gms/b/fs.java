package com.google.android.gms.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.client.n;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.a;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@fd
public final class fs {
    public static final Handler a = new fl(Looper.getMainLooper());
    private final Object b = new Object();
    private boolean c = true;
    private String d;
    private boolean e = false;

    public static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            b.d("Could not parse value:" + e);
            return 0;
        }
    }

    public static Bitmap a(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static DisplayMetrics a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static PopupWindow a(View view, int i, int i2) {
        return new PopupWindow(view, i, i2, false);
    }

    public static String a() {
        UUID randomUUID = UUID.randomUUID();
        byte[] toByteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] toByteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, toByteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(toByteArray);
                instance.update(toByteArray2);
                Object obj = new byte[8];
                System.arraycopy(instance.digest(), 0, obj, 0, 8);
                bigInteger = new BigInteger(1, obj).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    protected static String a(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    private static String a(f fVar, String str) {
        Object obj = null;
        if (fVar != null) {
            try {
                Uri parse = Uri.parse(str);
                if (fVar.a(parse)) {
                    for (String endsWith : f.a) {
                        if (parse.getPath().endsWith(endsWith)) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj != null) {
                    parse = fVar.b(parse);
                }
                str = parse.toString();
            } catch (Exception e) {
            }
        }
        return str;
    }

    public static String a(gv gvVar, String str) {
        gvVar.getContext();
        return a(gvVar.k(), str);
    }

    public static Map<String, String> a(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : f.e().a(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    private JSONArray a(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            a(jSONArray, a);
        }
        return jSONArray;
    }

    private JSONObject a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public static void a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void a(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public static void a(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void a(Context context, String str, String str2, Bundle bundle) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        bundle.putString("os", VERSION.RELEASE);
        bundle.putString("api", String.valueOf(VERSION.SDK_INT));
        f.c();
        bundle.putString("device", b());
        bundle.putString("appid", applicationContext.getPackageName());
        bundle.putString("eids", TextUtils.join(",", ak.a()));
        if (str != null) {
            bundle.putString("js", str);
        } else {
            bundle.putString("gmscore_version", Integer.toString(a.c(context)));
        }
        Builder appendQueryParameter = new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", str2);
        for (String str3 : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        f.c();
        String str32 = appendQueryParameter.toString();
        List arrayList = new ArrayList();
        arrayList.add(str32);
        a(context, str, arrayList);
    }

    private static void a(Context context, String str, List<String> list) {
        for (String gnVar : list) {
            new gn(context, str, gnVar).b();
        }
    }

    public static void a(Context context, String str, List<String> list, String str2) {
        for (String gnVar : list) {
            new gn(context, str, gnVar, str2).b();
        }
    }

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            a.post(runnable);
        }
    }

    public static void a(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", str);
        httpURLConnection.setUseCaches(false);
    }

    private void a(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(a((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(a((Collection) obj));
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            JSONArray jSONArray2 = new JSONArray();
            for (Object a : objArr) {
                a(jSONArray2, a);
            }
            jSONArray.put(jSONArray2);
        } else {
            jSONArray.put(obj);
        }
    }

    private void a(JSONObject jSONObject, String str, Object obj) {
        if (obj instanceof Bundle) {
            jSONObject.put(str, a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, a((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    public static boolean a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public static int[] a(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return d();
        }
        return new int[]{window.findViewById(16908290).getWidth(), window.findViewById(16908290).getHeight()};
    }

    public static AlertDialog.Builder b(Context context) {
        return new AlertDialog.Builder(context);
    }

    public static Bitmap b(Context context, String str) {
        String str2 = "getBackgroundImage must not be called on the main UI thread.";
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str2);
        }
        try {
            InputStream openFileInput = context.openFileInput(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
            openFileInput.close();
            return decodeStream;
        } catch (Exception e) {
            b.b("Fail to get background image");
            return null;
        }
    }

    public static String b() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : str + " " + str2;
    }

    public static void b(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public static boolean b(String str) {
        return TextUtils.isEmpty(str) ? false : str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public static int[] b(Activity activity) {
        int[] a = a(activity);
        r1 = new int[2];
        n.a();
        r1[0] = com.google.android.gms.ads.internal.util.client.a.b((Context) activity, a[0]);
        n.a();
        r1[1] = com.google.android.gms.ads.internal.util.client.a.b((Context) activity, a[1]);
        return r1;
    }

    public static aa c(Context context) {
        return new aa(context);
    }

    private static String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    public static int[] c(Activity activity) {
        Window window = activity.getWindow();
        int[] d = (window == null || window.findViewById(16908290) == null) ? d() : new int[]{window.findViewById(16908290).getTop(), window.findViewById(16908290).getBottom()};
        r1 = new int[2];
        n.a();
        r1[0] = com.google.android.gms.ads.internal.util.client.a.b((Context) activity, d[0]);
        n.a();
        r1[1] = com.google.android.gms.ads.internal.util.client.a.b((Context) activity, d[1]);
        return r1;
    }

    private static int[] d() {
        return new int[]{0, 0};
    }

    public final String a(Context context, String str) {
        String str2;
        synchronized (this.b) {
            if (this.d != null) {
                str2 = this.d;
            } else {
                try {
                    this.d = f.e().a(context);
                } catch (Exception e) {
                }
                if (TextUtils.isEmpty(this.d)) {
                    n.a();
                    if (com.google.android.gms.ads.internal.util.client.a.a()) {
                        try {
                            this.d = a(context);
                        } catch (Exception e2) {
                            this.d = c();
                        }
                    } else {
                        this.d = null;
                        a.post(new ft(this, context));
                        while (this.d == null) {
                            try {
                                this.b.wait();
                            } catch (InterruptedException e3) {
                                this.d = c();
                                b.d("Interrupted, use default user agent: " + this.d);
                            }
                        }
                    }
                }
                this.d += " (Mobile; " + str + ")";
                str2 = this.d;
            }
        }
        return str2;
    }

    public final JSONObject a(Map<String, ?> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }

    public final void a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", a(context, str));
        httpURLConnection.setUseCaches(false);
    }
}
