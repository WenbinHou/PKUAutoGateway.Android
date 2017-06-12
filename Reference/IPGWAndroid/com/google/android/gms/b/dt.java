package com.google.android.gms.b;

import java.util.Map;

@fd
public final class dt {
    final gv a;
    final boolean b;
    final String c;

    public dt(gv gvVar, Map<String, String> map) {
        this.a = gvVar;
        this.c = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.b = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        } else {
            this.b = true;
        }
    }
}
