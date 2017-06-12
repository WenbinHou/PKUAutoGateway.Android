package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

final class br implements cb {
    br() {
    }

    public final void a(gv gvVar, Map<String, String> map) {
        String str = (String) map.get("u");
        if (str == null) {
            b.d("URL missing from httpTrack GMSG.");
        } else {
            new gn(gvVar.getContext(), gvVar.l().b, str).b();
        }
    }
}
