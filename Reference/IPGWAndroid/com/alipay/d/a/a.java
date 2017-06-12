package com.alipay.d.a;

import android.content.Context;
import com.alipay.b.e.f;
import com.alipay.b.g.b;
import com.alipay.b.g.c;
import com.alipay.b.g.e;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public static synchronized String a(Context context, Map<String, String> map) {
        String a;
        synchronized (a.class) {
            Map hashMap = new HashMap();
            hashMap.put("utdid", com.alipay.e.a.a.b.a.a(map, "utdid", ""));
            hashMap.put("tid", com.alipay.e.a.a.b.a.a(map, "tid", ""));
            hashMap.put("userId", com.alipay.e.a.a.b.a.a(map, "userId", ""));
            com.alipay.b.g.a a2 = com.alipay.b.g.a.a(context);
            String a3 = com.alipay.e.a.a.b.a.a(hashMap, "utdid", "");
            String a4 = com.alipay.e.a.a.b.a.a(hashMap, "tid", "");
            a = com.alipay.e.a.a.b.a.a(hashMap, "userId", "");
            com.alipay.e.a.a.a.a.a.a("https://mobilegw.alipay.com/mgw.htm");
            a2.b.addLast(new e(a2, a3, a4, a));
            if (a2.a == null) {
                a2.a = new Thread(new b(a2));
                a2.a.setUncaughtExceptionHandler(new c(a2));
                a2.a.start();
            }
            a = f.a();
            if (com.alipay.e.a.a.b.a.a(a)) {
                com.alipay.b.e.b a5 = com.alipay.b.e.a.a(context);
                if (a5 == null || com.alipay.e.a.a.b.a.a(a5.a)) {
                    a = com.alipay.b.a.a.a.a(context);
                    if (com.alipay.e.a.a.b.a.a(a)) {
                        a = com.alipay.b.f.b.a(context);
                    }
                } else {
                    a = a5.a;
                }
            }
        }
        return a;
    }
}
