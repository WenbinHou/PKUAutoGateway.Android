package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class bu extends bt {
    bu() {
    }

    public final void A(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public final void B(View view) {
        view.setSaveFromParentEnabled(false);
    }

    public final int a(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    public final int a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    final long a() {
        return ValueAnimator.getFrameDelay();
    }

    public final void a(View view, float f) {
        view.setTranslationX(f);
    }

    public final void a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public final void a(View view, boolean z) {
        view.setActivated(z);
    }

    public final void b(View view, float f) {
        view.setTranslationY(f);
    }

    public final void c(View view, float f) {
        view.setAlpha(f);
    }

    public final void d(View view, float f) {
        view.setScaleX(f);
    }

    public final void e(View view, float f) {
        view.setScaleY(f);
    }

    public void e(View view, int i) {
        cg.b(view, i);
    }

    public final float f(View view) {
        return view.getAlpha();
    }

    public void f(View view, int i) {
        cg.a(view, i);
    }

    public final int g(View view) {
        return view.getLayerType();
    }

    public final int i(View view) {
        return view.getMeasuredWidthAndState();
    }

    public final int j(View view) {
        return view.getMeasuredState();
    }

    public final float o(View view) {
        return view.getTranslationX();
    }

    public final float p(View view) {
        return view.getTranslationY();
    }

    public final float q(View view) {
        return view.getScaleX();
    }
}
