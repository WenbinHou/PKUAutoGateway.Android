package android.support.v4.view;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class dr extends dp {
    dr() {
    }

    public final void a(View view, ec ecVar) {
        AnimatorUpdateListener animatorUpdateListener = null;
        if (ecVar != null) {
            animatorUpdateListener = new dz(ecVar, view);
        }
        view.animate().setUpdateListener(animatorUpdateListener);
    }
}
