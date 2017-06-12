package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

final class bt implements cb {
    bt() {
    }

    public final void a(gv gvVar, Map<String, String> map) {
        String str = (String) map.get("ty");
        String str2 = (String) map.get("td");
        try {
            Integer.parseInt((String) map.get("tx"));
            Integer.parseInt(str);
            Integer.parseInt(str2);
            f k = gvVar.k();
            if (k != null) {
                e eVar = k.b;
            }
        } catch (NumberFormatException e) {
            b.d("Could not parse touch parameters from gmsg.");
        }
    }
}
