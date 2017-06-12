package android.support.v7.widget;

import android.support.v4.view.bq;

final class h implements Runnable {
    final /* synthetic */ ActionBarOverlayLayout a;

    h(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.a = actionBarOverlayLayout;
    }

    public final void run() {
        this.a.i();
        this.a.x = bq.r(this.a.f).c((float) (-this.a.f.getHeight())).a(this.a.y);
    }
}
