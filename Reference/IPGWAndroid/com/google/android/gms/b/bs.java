package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

final class bs implements cb {
    bs() {
    }

    public final void a(gv gvVar, Map<String, String> map) {
        b.c("Received log message: " + ((String) map.get("string")));
    }
}
