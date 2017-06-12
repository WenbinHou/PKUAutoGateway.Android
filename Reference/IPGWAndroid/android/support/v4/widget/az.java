package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class az extends Animation {
    final /* synthetic */ SwipeRefreshLayout a;

    az(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        this.a.a((((int) (((float) ((!this.a.M ? (int) (this.a.I - ((float) Math.abs(this.a.b))) : (int) this.a.I) - this.a.a)) * f)) + this.a.a) - this.a.z.getTop(), false);
        this.a.C.a(1.0f - f);
    }
}
