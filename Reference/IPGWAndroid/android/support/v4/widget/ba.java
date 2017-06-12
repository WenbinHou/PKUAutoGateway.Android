package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class ba extends Animation {
    final /* synthetic */ SwipeRefreshLayout a;

    ba(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        this.a.a((this.a.a + ((int) (((float) (this.a.b - this.a.a)) * f))) - this.a.z.getTop(), false);
    }
}
