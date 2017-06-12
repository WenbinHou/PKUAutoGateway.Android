package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

@fd
public final class bm implements cb {
    private final bn a;

    public bm(bn bnVar) {
        this.a = bnVar;
    }

    public final void a(gv gvVar, Map<String, String> map) {
        if (((String) map.get("name")) == null) {
            b.d("App event with no name parameter.");
        } else {
            map.get("info");
        }
    }
}
