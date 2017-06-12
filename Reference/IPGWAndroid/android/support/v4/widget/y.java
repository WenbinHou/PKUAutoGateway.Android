package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class y extends Animation {
    final /* synthetic */ ab a;
    final /* synthetic */ x b;

    y(x xVar, ab abVar) {
        this.b = xVar;
        this.a = abVar;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        if (this.b.b) {
            x.a(f, this.a);
            return;
        }
        float a = x.b(this.a);
        float f2 = this.a.l;
        float f3 = this.a.k;
        float f4 = this.a.m;
        x.c(f, this.a);
        if (f <= 0.5f) {
            float f5 = 0.8f - a;
            this.a.a(f3 + (x.d.getInterpolation(f / 0.5f) * f5));
        }
        if (f > 0.5f) {
            this.a.b(((0.8f - a) * x.d.getInterpolation((f - 0.5f) / 0.5f)) + f2);
        }
        this.a.c((0.25f * f) + f4);
        this.b.c((216.0f * f) + (1080.0f * (this.b.k / 5.0f)));
    }
}
