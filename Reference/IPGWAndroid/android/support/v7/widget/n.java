package android.support.v7.widget;

import android.support.v7.view.menu.i;
import android.view.View;

final class n implements Runnable {
    final /* synthetic */ k a;
    private q b;

    public n(k kVar, q qVar) {
        this.a = kVar;
        this.b = qVar;
    }

    public final void run() {
        i iVar = this.a.c;
        if (iVar.b != null) {
            iVar.b.a(iVar);
        }
        View view = (View) this.a.g;
        if (!(view == null || view.getWindowToken() == null || !this.b.b())) {
            this.a.o = this.b;
        }
        this.a.q = null;
    }
}
