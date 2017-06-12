package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

public final class ap {
    Object a;
    aq b;

    private ap(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.b = new at();
        } else if (i >= 9) {
            this.b = new as();
        } else {
            this.b = new ar();
        }
        this.a = this.b.a(context, interpolator);
    }

    public static ap a(Context context, Interpolator interpolator) {
        return new ap(VERSION.SDK_INT, context, interpolator);
    }

    public final void a(int i, int i2, int i3, int i4, int i5) {
        this.b.a(this.a, i, i2, i3, i4, i5);
    }

    public final void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.b.a(this.a, i, i2, i3, i4, i5, i6, i7);
    }

    public final boolean a() {
        return this.b.a(this.a);
    }

    public final boolean a(int i, int i2, int i3) {
        return this.b.b(this.a, i, i2, i3);
    }

    public final int b() {
        return this.b.b(this.a);
    }

    public final int c() {
        return this.b.c(this.a);
    }

    public final int d() {
        return this.b.g(this.a);
    }

    public final int e() {
        return this.b.h(this.a);
    }

    public final float f() {
        return this.b.d(this.a);
    }

    public final boolean g() {
        return this.b.e(this.a);
    }

    public final void h() {
        this.b.f(this.a);
    }
}
