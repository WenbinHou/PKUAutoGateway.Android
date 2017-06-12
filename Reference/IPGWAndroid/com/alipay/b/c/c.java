package com.alipay.b.c;

import android.content.Context;
import com.alipay.b.e.d;
import com.alipay.e.a.a.c.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c {
    public static Map<String, String> a(Context context) {
        String str;
        a a = a.a();
        Map<String, String> hashMap = new HashMap();
        d a2 = com.alipay.b.e.c.a(context);
        String a3 = a.a(context);
        String b = a.b(context);
        String h = a.h(context);
        String h2 = a.h();
        String j = a.j(context);
        if (a2 != null) {
            if (com.alipay.e.a.a.b.a.a(a3)) {
                a3 = com.alipay.e.a.a.b.a.b(a2.a);
            }
            if (com.alipay.e.a.a.b.a.a(b)) {
                b = com.alipay.e.a.a.b.a.b(a2.b);
            }
            if (com.alipay.e.a.a.b.a.a(h)) {
                h = com.alipay.e.a.a.b.a.b(a2.c);
            }
            if (com.alipay.e.a.a.b.a.a(h2)) {
                h2 = com.alipay.e.a.a.b.a.b(a2.d);
            }
            if (com.alipay.e.a.a.b.a.a(j)) {
                j = com.alipay.e.a.a.b.a.b(a2.e);
            }
            str = j;
            j = h2;
            h2 = h;
            h = b;
            b = a3;
        } else {
            str = j;
            j = h2;
            h2 = h;
            h = b;
            b = a3;
        }
        d dVar = new d(b, h, h2, j, str);
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", com.alipay.e.a.a.b.a.b(dVar.a));
                jSONObject.put("imsi", com.alipay.e.a.a.b.a.b(dVar.b));
                jSONObject.put("mac", com.alipay.e.a.a.b.a.b(dVar.c));
                jSONObject.put("bluetoothmac", com.alipay.e.a.a.b.a.b(dVar.d));
                jSONObject.put("gsi", com.alipay.e.a.a.b.a.b(dVar.e));
                a3 = jSONObject.toString();
                com.alipay.b.f.c.a("device_feature_file_name", "device_feature_file_key", a3);
                com.alipay.b.f.c.a(context, "device_feature_prefs_name", "device_feature_prefs_key", a3);
            } catch (Throwable e) {
                com.alipay.e.a.a.b.c.a(e);
            }
        }
        hashMap.put("AD1", b);
        hashMap.put("AD2", h);
        hashMap.put("AD3", a.d(context));
        hashMap.put("AD5", a.e(context));
        hashMap.put("AD6", a.f(context));
        hashMap.put("AD7", a.g(context));
        hashMap.put("AD8", h2);
        hashMap.put("AD9", a.i(context));
        hashMap.put("AD10", str);
        hashMap.put("AD11", a.b());
        hashMap.put("AD12", a.c());
        hashMap.put("AD13", a.d());
        hashMap.put("AD14", a.e());
        hashMap.put("AD15", a.f());
        hashMap.put("AD16", a.g());
        hashMap.put("AD17", "");
        hashMap.put("AD18", j);
        hashMap.put("AD19", a.k(context));
        hashMap.put("AD20", a.i());
        hashMap.put("AD21", a.c(context));
        hashMap.put("AD22", "");
        hashMap.put("AD23", a.j());
        hashMap.put("AL3", a.l(context));
        return hashMap;
    }
}
