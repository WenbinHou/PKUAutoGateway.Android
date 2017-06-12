package com.google.android.gms.b;

import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

final class by implements cb {
    by() {
    }

    public final void a(gv gvVar, Map<String, String> map) {
        c f = gvVar.f();
        if (f != null) {
            f.a();
            return;
        }
        f = gvVar.g();
        if (f != null) {
            f.a();
        } else {
            b.d("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
