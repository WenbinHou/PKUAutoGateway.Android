package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

abstract class ab extends Animation {
    final /* synthetic */ y a;
    private float b;
    private float c;

    private ab(y yVar) {
        this.a = yVar;
    }

    protected abstract float a();

    protected void applyTransformation(float f, Transformation transformation) {
        ap apVar = this.a.a;
        apVar.a(this.b + (this.c * f), apVar.h);
    }

    public void reset() {
        super.reset();
        this.b = this.a.a.j;
        this.c = a() - this.b;
    }
}
