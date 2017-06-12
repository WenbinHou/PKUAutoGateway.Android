package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class ag extends AnimatorListenerAdapter {
    final /* synthetic */ boolean a = false;
    final /* synthetic */ aj b = null;
    final /* synthetic */ ae c;

    ag(ae aeVar) {
        this.c = aeVar;
    }

    public final void onAnimationEnd(Animator animator) {
    }

    public final void onAnimationStart(Animator animator) {
        this.c.k.a(0, this.a);
    }
}
