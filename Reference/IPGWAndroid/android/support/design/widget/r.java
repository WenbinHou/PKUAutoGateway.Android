package android.support.design.widget;

import android.view.ViewTreeObserver.OnPreDrawListener;

final class r implements OnPreDrawListener {
    final /* synthetic */ CoordinatorLayout a;

    r(CoordinatorLayout coordinatorLayout) {
        this.a = coordinatorLayout;
    }

    public final boolean onPreDraw() {
        this.a.a(false);
        return true;
    }
}
