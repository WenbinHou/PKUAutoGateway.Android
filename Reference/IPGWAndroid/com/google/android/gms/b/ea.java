package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.b;
import org.json.JSONObject;

@fd
public class ea {
    private final String a;
    final gv s;

    public ea(gv gvVar) {
        this(gvVar, "");
    }

    public ea(gv gvVar, String str) {
        this.s = gvVar;
        this.a = str;
    }

    public final void a(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.s.a("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (Throwable e) {
            b.b("Error occured while obtaining screen information.", e);
        }
    }

    public final void a(String str) {
        try {
            this.s.a("onError", new JSONObject().put("message", str).put("action", this.a));
        } catch (Throwable e) {
            b.b("Error occurred while dispatching error event.", e);
        }
    }

    public final void b(String str) {
        try {
            this.s.a("onStateChanged", new JSONObject().put("state", str));
        } catch (Throwable e) {
            b.b("Error occured while dispatching state change.", e);
        }
    }
}
