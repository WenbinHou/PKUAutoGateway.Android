package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class cm implements AnimatorUpdateListener {
    final /* synthetic */ ci a;
    final /* synthetic */ cl b;

    cm(cl clVar, ci ciVar) {
        this.b = clVar;
        this.a = ciVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a();
    }
}
