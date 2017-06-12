package com.alipay.b.c;

import android.content.Context;
import com.alipay.e.a.a.c.c;
import java.util.HashMap;
import java.util.Map;

public final class d {
    public static synchronized Map<String, String> a(Context context) {
        Map<String, String> hashMap;
        synchronized (d.class) {
            c.a();
            hashMap = new HashMap();
            hashMap.put("AE1", c.b());
            hashMap.put("AE2", (c.c() ? "1" : "0"));
            hashMap.put("AE3", (c.a(context) ? "1" : "0"));
            hashMap.put("AE4", c.d());
            hashMap.put("AE5", c.e());
            hashMap.put("AE6", c.f());
            hashMap.put("AE7", c.g());
            hashMap.put("AE8", c.h());
            hashMap.put("AE9", c.i());
            hashMap.put("AE10", c.j());
            hashMap.put("AE11", c.k());
            hashMap.put("AE12", c.l());
            hashMap.put("AE13", c.m());
            hashMap.put("AE14", c.n());
            hashMap.put("AE15", c.o());
        }
        return hashMap;
    }
}
