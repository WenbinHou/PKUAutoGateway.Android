package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class cn extends AnimatorListenerAdapter {
    final /* synthetic */ ch a;
    final /* synthetic */ cl b;

    cn(cl clVar, ch chVar) {
        this.b = clVar;
        this.a = chVar;
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.a();
    }

    public final void onAnimationStart(Animator animator) {
    }
}
