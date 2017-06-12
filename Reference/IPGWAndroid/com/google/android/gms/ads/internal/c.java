package com.google.android.gms.ads.internal;

import com.google.android.gms.b.ak;
import com.google.android.gms.b.fd;

@fd
public final class c {
    private boolean a;
    private boolean b;

    public c() {
        this.b = ((Boolean) f.i().a(ak.i)).booleanValue();
    }

    public c(byte b) {
        this.b = false;
    }

    public final boolean a() {
        return !this.b || this.a;
    }
}
