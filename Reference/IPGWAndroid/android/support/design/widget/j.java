package android.support.design.widget;

import android.support.v4.view.bq;
import android.view.View;

final class j implements Runnable {
    final /* synthetic */ BottomSheetBehavior a;
    private final View b;
    private final int c;

    j(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
        this.a = bottomSheetBehavior;
        this.b = view;
        this.c = i;
    }

    public final void run() {
        if (this.a.g == null || !this.a.g.b()) {
            this.a.a(this.c);
        } else {
            bq.a(this.b, (Runnable) this);
        }
    }
}
