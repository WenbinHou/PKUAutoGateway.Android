package com.google.android.gms.b;

import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.internal.a;
import java.util.Map;

@fd
public final class cn implements cb {
    public final void a(gv gvVar, Map<String, String> map) {
        f.k();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str == null) {
                b.d("Precache video action is missing the src parameter.");
                return;
            }
            try {
                Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e) {
            }
            if (map.containsKey("mimetype")) {
                map.get("mimetype");
            }
            if ((cl.b(gvVar) != null ? 1 : null) != null) {
                b.d("Precache task already running.");
                return;
            }
            a.a(gvVar.e());
            new cj(gvVar, gvVar.e().a.a(), str).b();
        } else if (!cl.a(gvVar)) {
            b.d("Precache abort but no preload task running.");
        }
    }
}
