package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class dv extends AnimatorListenerAdapter {
    final /* synthetic */ ea a;
    final /* synthetic */ View b;

    dv(ea eaVar, View view) {
        this.a = eaVar;
        this.b = view;
    }

    public final void onAnimationCancel(Animator animator) {
        this.a.c(this.b);
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.b(this.b);
    }

    public final void onAnimationStart(Animator animator) {
        this.a.a(this.b);
    }
}
