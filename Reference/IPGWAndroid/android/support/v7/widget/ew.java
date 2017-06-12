package android.support.v7.widget;

import android.view.View;

final class ew implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ ev b;

    ew(ev evVar, View view) {
        this.b = evVar;
        this.a = view;
    }

    public final void run() {
        this.b.smoothScrollTo(this.a.getLeft() - ((this.b.getWidth() - this.a.getWidth()) / 2), 0);
        this.b.a = null;
    }
}
