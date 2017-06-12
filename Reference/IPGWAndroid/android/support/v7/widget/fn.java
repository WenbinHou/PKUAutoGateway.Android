package android.support.v7.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class fn implements AnimationListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ SwitchCompat b;

    fn(SwitchCompat switchCompat, boolean z) {
        this.b = switchCompat;
        this.a = z;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.b.C == animation) {
            this.b.setThumbPosition(this.a ? 1.0f : 0.0f);
            this.b.C = null;
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
