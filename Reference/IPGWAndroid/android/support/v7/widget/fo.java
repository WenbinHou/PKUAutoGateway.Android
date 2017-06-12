package android.support.v7.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class fo extends Animation {
    final float a;
    final float b;
    final float c;
    final /* synthetic */ SwitchCompat d;

    private fo(SwitchCompat switchCompat, float f, float f2) {
        this.d = switchCompat;
        this.a = f;
        this.b = f2;
        this.c = f2 - f;
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        this.d.setThumbPosition(this.a + (this.c * f));
    }
}
