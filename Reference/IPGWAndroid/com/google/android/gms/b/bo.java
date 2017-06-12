package com.google.android.gms.b;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

@fd
public final class bo implements cb {
    public final void a(gv gvVar, Map<String, String> map) {
        String str = (String) map.get("action");
        aw awVar;
        if ("tick".equals(str)) {
            str = (String) map.get("label");
            Object obj = (String) map.get("start_label");
            String str2 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str)) {
                b.d("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str2)) {
                b.d("No timestamp given for CSI tick.");
            } else {
                try {
                    long parseLong = (Long.parseLong(str2) - f.g().a()) + f.g().b();
                    if (TextUtils.isEmpty(obj)) {
                        obj = "native:view_load";
                    }
                    av s = gvVar.s();
                    aw awVar2 = s.b;
                    as asVar = (as) s.a.get(obj);
                    String[] strArr = new String[]{str};
                    if (!(awVar2 == null || asVar == null)) {
                        awVar2.a(asVar, parseLong, strArr);
                    }
                    Map map2 = s.a;
                    awVar = s.b;
                    map2.put(str, awVar == null ? null : awVar.a(parseLong));
                } catch (Throwable e) {
                    b.c("Malformed timestamp for CSI tick.", e);
                }
            }
        } else if ("experiment".equals(str)) {
            str = (String) map.get("value");
            if (TextUtils.isEmpty(str)) {
                b.d("No value given for CSI experiment.");
                return;
            }
            awVar = gvVar.s().b;
            if (awVar == null) {
                b.d("No ticker for WebView, dropping experiment ID.");
            } else {
                awVar.a("e", str);
            }
        } else if ("extra".equals(str)) {
            str = (String) map.get("name");
            String str3 = (String) map.get("value");
            if (TextUtils.isEmpty(str3)) {
                b.d("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str)) {
                b.d("No name given for CSI extra.");
            } else {
                aw awVar3 = gvVar.s().b;
                if (awVar3 == null) {
                    b.d("No ticker for WebView, dropping extra parameter.");
                } else {
                    awVar3.a(str, str3);
                }
            }
        }
    }
}
