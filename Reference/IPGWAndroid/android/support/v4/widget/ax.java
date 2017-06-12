package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class ax extends Animation {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ SwipeRefreshLayout c;

    ax(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
        this.c = swipeRefreshLayout;
        this.a = i;
        this.b = i2;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        this.c.C.setAlpha((int) (((float) this.a) + (((float) (this.b - this.a)) * f)));
    }
}
