package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(21)
final class ak extends ae {
    private final Interpolator n;
    private InsetDrawable o;

    ak(da daVar, aq aqVar) {
        super(daVar, aqVar);
        this.n = daVar.isInEditMode() ? null : AnimationUtils.loadInterpolator(this.k.getContext(), 17563661);
    }

    public final float a() {
        return this.k.getElevation();
    }

    public final void a(float f) {
        this.k.setElevation(f);
        if (this.l.b()) {
            h();
        }
    }

    final void a(int i) {
        if (this.c instanceof RippleDrawable) {
            ((RippleDrawable) this.c).setColor(ColorStateList.valueOf(i));
        } else {
            super.a(i);
        }
    }

    final void a(Rect rect) {
        if (this.l.b()) {
            float a = this.l.a();
            float elevation = this.k.getElevation() + this.g;
            int ceil = (int) Math.ceil((double) ap.b(elevation, a, false));
            int ceil2 = (int) Math.ceil((double) ap.a(elevation, a, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    final void a(int[] iArr) {
    }

    final void b() {
    }

    final void b(Rect rect) {
        if (this.l.b()) {
            this.o = new InsetDrawable(this.c, rect.left, rect.top, rect.right, rect.bottom);
            this.l.a(this.o);
            return;
        }
        this.l.a(this.c);
    }

    final void e() {
        h();
    }

    final boolean f() {
        return false;
    }
}
