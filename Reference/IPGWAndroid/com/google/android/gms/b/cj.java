package com.google.android.gms.b;

import com.google.android.gms.ads.internal.f;

@fd
public final class cj extends fi {
    final gv a;
    final cm b;
    private final String d;

    cj(gv gvVar, cm cmVar, String str) {
        this.a = gvVar;
        this.b = cmVar;
        this.d = str;
        f.k().a.add(this);
    }

    public final void a() {
        fs.a.post(new ck(this));
    }
}
