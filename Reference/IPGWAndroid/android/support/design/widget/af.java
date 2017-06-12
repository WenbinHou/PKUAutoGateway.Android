package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class af extends AnimatorListenerAdapter {
    final /* synthetic */ boolean a = false;
    final /* synthetic */ aj b = null;
    final /* synthetic */ ae c;
    private boolean d;

    af(ae aeVar) {
        this.c = aeVar;
    }

    public final void onAnimationCancel(Animator animator) {
        this.c.n = false;
        this.d = true;
    }

    public final void onAnimationEnd(Animator animator) {
        this.c.n = false;
        if (!this.d) {
            this.c.k.a(8, this.a);
        }
    }

    public final void onAnimationStart(Animator animator) {
        this.c.n = true;
        this.d = false;
        this.c.k.a(0, this.a);
    }
}
