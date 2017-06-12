package com.alipay.sdk.c;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.alipay.d.a.a;
import com.alipay.sdk.i.b;
import java.util.HashMap;
import java.util.Random;

public final class c {
    private static c d;
    public String a;
    public String b = "sdk-and-lite";
    public String c;

    private c() {
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (d == null) {
                d = new c();
            }
            cVar = d;
        }
        return cVar;
    }

    public static String a(Context context, HashMap<String, String> hashMap) {
        String str = "";
        try {
            str = a.a(context, hashMap);
        } catch (Throwable th) {
        }
        return str;
    }

    public static String b() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    public final synchronized void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            PreferenceManager.getDefaultSharedPreferences(b.a().a).edit().putString("trideskey", str).commit();
            com.alipay.sdk.b.a.b = str;
        }
    }
}
