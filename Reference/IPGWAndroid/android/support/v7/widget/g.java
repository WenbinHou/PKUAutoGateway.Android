package android.support.v7.widget;

import android.support.v4.view.bq;

final class g implements Runnable {
    final /* synthetic */ ActionBarOverlayLayout a;

    g(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.a = actionBarOverlayLayout;
    }

    public final void run() {
        this.a.i();
        this.a.x = bq.r(this.a.f).c(0.0f).a(this.a.y);
    }
}
