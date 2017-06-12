package com.google.android.gms.b;

import com.google.android.gms.ads.internal.f;
import java.util.Map;

final class bu implements cb {
    bu() {
    }

    public final void a(gv gvVar, Map<String, String> map) {
        if (((Boolean) f.i().a(ak.at)).booleanValue()) {
            gvVar.c(!Boolean.parseBoolean((String) map.get("disabled")));
        }
    }
}
