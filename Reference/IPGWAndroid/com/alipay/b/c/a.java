package com.alipay.b.c;

import android.content.Context;
import com.alipay.b.e.e;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public static synchronized Map<String, String> a(Context context) {
        Map<String, String> hashMap;
        synchronized (a.class) {
            Object obj;
            hashMap = new HashMap();
            hashMap.put("AA1", context.getPackageName());
            hashMap.put("AA2", b(context));
            hashMap.put("AA3", "security-sdk-token");
            hashMap.put("AA4", "3.0.2.20151027");
            String str = "AA5";
            com.alipay.e.a.a.a.b.a d = e.d(context);
            String str2 = d.b;
            String str3 = d.a;
            if (com.alipay.e.a.a.b.a.a(str2) || com.alipay.e.a.a.b.a.a(str3)) {
                obj = "";
            } else {
                com.alipay.e.a.a.c.a.a();
                obj = com.alipay.b.f.a.a(com.alipay.e.a.a.c.a.m(context), str3, str2);
            }
            hashMap.put(str, obj);
        }
        return hashMap;
    }

    private static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName;
        } catch (Exception e) {
            return "0.0.0";
        }
    }
}
