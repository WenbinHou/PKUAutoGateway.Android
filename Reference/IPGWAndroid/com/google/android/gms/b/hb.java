package com.google.android.gms.b;

import java.util.Map;

final class hb implements cb {
    final /* synthetic */ gw a;

    private hb(gw gwVar) {
        this.a = gwVar;
    }

    public final void a(gv gvVar, Map<String, String> map) {
        if (map.keySet().contains("start")) {
            gw.a(this.a);
        } else if (map.keySet().contains("stop")) {
            gw.b(this.a);
        } else if (map.keySet().contains("cancel")) {
            gw.c(this.a);
        }
    }
}
