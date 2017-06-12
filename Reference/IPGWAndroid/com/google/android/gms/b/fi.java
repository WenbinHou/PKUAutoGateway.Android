package com.google.android.gms.b;

import java.util.concurrent.Future;

@fd
public abstract class fi {
    private final Runnable a = new fj(this);
    private boolean b = false;
    volatile Thread c;

    public abstract void a();

    public final Future b() {
        return this.b ? fm.a(1, this.a) : fm.a(this.a);
    }
}
