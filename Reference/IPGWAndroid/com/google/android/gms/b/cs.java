package com.google.android.gms.b;

final class cs implements Runnable {
    final /* synthetic */ cq a;
    private final hs b;
    private final hw c;
    private final Runnable d;

    public cs(cq cqVar, hs hsVar, hw hwVar, Runnable runnable) {
        this.a = cqVar;
        this.b = hsVar;
        this.c = hwVar;
        this.d = runnable;
    }

    public final void run() {
        if (this.b.j) {
            this.b.b("canceled-at-delivery");
            return;
        }
        if ((this.c.c == null ? 1 : null) != null) {
            this.b.a(this.c.a);
        } else {
            hs hsVar = this.b;
            il ilVar = this.c.c;
            if (hsVar.f != null) {
                hsVar.f.a(ilVar);
            }
        }
        if (this.c.d) {
            this.b.a("intermediate-response");
        } else {
            this.b.b("done");
        }
        if (this.d != null) {
            this.d.run();
        }
    }
}
