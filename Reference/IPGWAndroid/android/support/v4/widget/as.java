package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

class as implements aq {
    as() {
    }

    public final Object a(Context context, Interpolator interpolator) {
        return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public final void a(Object obj, int i, int i2, int i3) {
        ((OverScroller) obj).startScroll(i, i2, 0, i3);
    }

    public final void a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public final void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        ((OverScroller) obj).fling(0, i, i2, i3, i4, i5, i6, i7);
    }

    public final boolean a(Object obj) {
        return ((OverScroller) obj).isFinished();
    }

    public final int b(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    public final void b(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((OverScroller) obj).fling(i, i2, 0, i3, 0, 0, 0, i4, 0, i5);
    }

    public final boolean b(Object obj, int i, int i2, int i3) {
        return ((OverScroller) obj).springBack(i, i2, 0, 0, 0, i3);
    }

    public final int c(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    public float d(Object obj) {
        return 0.0f;
    }

    public final boolean e(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    public final void f(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    public final int g(Object obj) {
        return ((OverScroller) obj).getFinalX();
    }

    public final int h(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }
}
