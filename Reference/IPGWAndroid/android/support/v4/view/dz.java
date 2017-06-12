package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class dz implements AnimatorUpdateListener {
    final /* synthetic */ ec a;
    final /* synthetic */ View b;

    dz(ec ecVar, View view) {
        this.a = ecVar;
        this.b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a();
    }
}
