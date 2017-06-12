package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class aw extends Animation {
    final /* synthetic */ SwipeRefreshLayout a;

    aw(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        this.a.setAnimationProgress(1.0f - f);
    }
}
