package android.support.v7.a;

import android.view.View;

final class i implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ View b;
    final /* synthetic */ d c;

    i(d dVar, View view, View view2) {
        this.c = dVar;
        this.a = view;
        this.b = view2;
    }

    public final void run() {
        d.a(this.c.f, this.a, this.b);
    }
}
