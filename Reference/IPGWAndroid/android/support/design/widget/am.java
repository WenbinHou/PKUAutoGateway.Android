package android.support.design.widget;

import android.support.v4.view.bq;

final class am implements Runnable {
    final /* synthetic */ al a;
    private final CoordinatorLayout b;
    private final V c;

    am(al alVar, CoordinatorLayout coordinatorLayout, V v) {
        this.a = alVar;
        this.b = coordinatorLayout;
        this.c = v;
    }

    public final void run() {
        if (this.c != null && this.a.a != null) {
            if (this.a.a.g()) {
                this.a.a_(this.b, this.c, this.a.a.c());
                bq.a(this.c, (Runnable) this);
                return;
            }
            this.a.a(this.b, this.c);
        }
    }
}
