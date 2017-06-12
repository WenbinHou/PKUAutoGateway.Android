package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.b;
import org.json.JSONObject;

@fd
public final class dx {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    private dx(dy dyVar) {
        this.a = dyVar.a;
        this.b = dyVar.b;
        this.c = dyVar.c;
        this.d = dyVar.d;
        this.e = dyVar.e;
    }

    public final JSONObject a() {
        try {
            return new JSONObject().put("sms", this.a).put("tel", this.b).put("calendar", this.c).put("storePicture", this.d).put("inlineVideo", this.e);
        } catch (Throwable e) {
            b.b("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
