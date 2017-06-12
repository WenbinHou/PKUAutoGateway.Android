package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class as implements AnimationListener {
    final /* synthetic */ int a;
    final /* synthetic */ Snackbar b;

    as(Snackbar snackbar, int i) {
        this.b = snackbar;
        this.a = i;
    }

    public final void onAnimationEnd(Animation animation) {
        this.b.b();
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
