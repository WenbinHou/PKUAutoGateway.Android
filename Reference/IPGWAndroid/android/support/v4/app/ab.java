package android.support.v4.app;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ab implements AnimationListener {
    private AnimationListener a = null;
    private boolean b = false;
    private View c = null;

    public ab(View view, Animation animation) {
        if (view != null && animation != null) {
            this.c = view;
        }
    }

    public ab(View view, Animation animation, AnimationListener animationListener) {
        if (view != null && animation != null) {
            this.a = animationListener;
            this.c = view;
        }
    }

    public void onAnimationEnd(Animation animation) {
        if (this.c != null && this.b) {
            this.c.post(new ad(this));
        }
        if (this.a != null) {
            this.a.onAnimationEnd(animation);
        }
    }

    public void onAnimationRepeat(Animation animation) {
        if (this.a != null) {
            this.a.onAnimationRepeat(animation);
        }
    }

    public void onAnimationStart(Animation animation) {
        if (this.c != null) {
            this.b = y.a(this.c, animation);
            if (this.b) {
                this.c.post(new ac(this));
            }
        }
        if (this.a != null) {
            this.a.onAnimationStart(animation);
        }
    }
}
