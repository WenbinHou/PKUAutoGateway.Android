package android.support.design.widget;

import android.support.v4.view.bq;
import android.view.View;

final class bm implements Runnable {
    final /* synthetic */ SwipeDismissBehavior a;
    private final View b;
    private final boolean c;

    bm(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
        this.a = swipeDismissBehavior;
        this.b = view;
        this.c = z;
    }

    public final void run() {
        if (this.a.a != null && this.a.a.b()) {
            bq.a(this.b, (Runnable) this);
        } else if (this.c && this.a.b != null) {
            this.a.b.a(this.b);
        }
    }
}
