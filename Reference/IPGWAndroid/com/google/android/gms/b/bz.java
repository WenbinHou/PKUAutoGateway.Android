package com.google.android.gms.b;

import com.google.android.gms.ads.internal.overlay.q;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;
import org.json.JSONObject;

final class bz implements cb {
    bz() {
    }

    public final void a(gv gvVar, Map<String, String> map) {
        if ("checkSupport".equals(map.get("action"))) {
            b.c("Received support message, responding.");
            boolean z = false;
            com.google.android.gms.ads.internal.b e = gvVar.e();
            if (e != null) {
                q qVar = e.c;
                if (qVar != null) {
                    z = qVar.b();
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", "checkSupport");
                jSONObject.put("supports", z);
                gvVar.a("appStreaming", jSONObject);
                return;
            } catch (Throwable th) {
                return;
            }
        }
        gvVar.f();
    }
}
