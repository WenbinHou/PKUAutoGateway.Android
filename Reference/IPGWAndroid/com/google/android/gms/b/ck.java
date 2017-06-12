package com.google.android.gms.b;

import com.google.android.gms.ads.internal.f;

final class ck implements Runnable {
    final /* synthetic */ cj a;

    ck(cj cjVar) {
        this.a = cjVar;
    }

    public final void run() {
        cl k = f.k();
        k.a.remove(this.a);
    }
}
