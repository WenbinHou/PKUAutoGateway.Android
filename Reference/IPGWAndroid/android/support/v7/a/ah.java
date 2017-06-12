package android.support.v7.a;

import android.support.v4.view.bq;

final class ah implements Runnable {
    final /* synthetic */ ac a;

    ah(ac acVar) {
        this.a = acVar;
    }

    public final void run() {
        this.a.s.showAtLocation(this.a.r, 55, 0, 0);
        this.a.l();
        bq.c(this.a.r, 0.0f);
        this.a.u = bq.r(this.a.r).a(1.0f);
        this.a.u.a(new ai(this));
    }
}
