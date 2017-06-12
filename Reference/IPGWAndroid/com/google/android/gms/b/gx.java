package com.google.android.gms.b;

import com.google.android.gms.ads.internal.overlay.c;

final class gx implements Runnable {
    final /* synthetic */ gw a;

    gx(gw gwVar) {
        this.a = gwVar;
    }

    public final void run() {
        this.a.a.t();
        c f = this.a.a.f();
        if (f != null) {
            f.l.removeView(f.f);
            f.a(true);
        }
        if (this.a.h != null) {
            this.a.h;
            this.a.h = null;
        }
    }
}
