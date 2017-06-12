package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class ay implements AnimationListener {
    final /* synthetic */ Snackbar a;

    ay(Snackbar snackbar) {
        this.a = snackbar;
    }

    public final void onAnimationEnd(Animation animation) {
        Snackbar.g(this.a);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
