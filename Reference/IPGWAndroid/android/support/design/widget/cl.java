package android.support.design.widget;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;

final class cl extends cg {
    final ValueAnimator a = new ValueAnimator();

    cl() {
    }

    public final void a() {
        this.a.start();
    }

    public final void a(float f, float f2) {
        this.a.setFloatValues(new float[]{f, f2});
    }

    public final void a(int i) {
        this.a.setDuration((long) i);
    }

    public final void a(int i, int i2) {
        this.a.setIntValues(new int[]{i, i2});
    }

    public final void a(ch chVar) {
        this.a.addListener(new cn(this, chVar));
    }

    public final void a(ci ciVar) {
        this.a.addUpdateListener(new cm(this, ciVar));
    }

    public final void a(Interpolator interpolator) {
        this.a.setInterpolator(interpolator);
    }

    public final boolean b() {
        return this.a.isRunning();
    }

    public final int c() {
        return ((Integer) this.a.getAnimatedValue()).intValue();
    }

    public final float d() {
        return ((Float) this.a.getAnimatedValue()).floatValue();
    }

    public final void e() {
        this.a.cancel();
    }

    public final float f() {
        return this.a.getAnimatedFraction();
    }

    public final long g() {
        return this.a.getDuration();
    }
}
