package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class bb extends Animation {
    final /* synthetic */ SwipeRefreshLayout a;

    bb(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        this.a.setAnimationProgress(this.a.B + ((-this.a.B) * f));
        this.a.a((this.a.a + ((int) (((float) (this.a.b - this.a.a)) * f))) - this.a.z.getTop(), false);
    }
}
