package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.ViewTreeObserver.OnPreDrawListener;

abstract class ah {
    static final int[] h = new int[]{16842919, 16842910};
    static final int[] i = new int[]{16842908, 16842910};
    static final int[] j = new int[0];
    private final Rect a = new Rect();
    Drawable b;
    Drawable c;
    k d;
    Drawable e;
    float f;
    float g;
    final da k;
    final aq l;
    OnPreDrawListener m;

    ah(da daVar, aq aqVar) {
        this.k = daVar;
        this.l = aqVar;
    }

    abstract float a();

    abstract void a(float f);

    abstract void a(int i);

    abstract void a(ColorStateList colorStateList);

    abstract void a(Mode mode);

    abstract void a(Rect rect);

    abstract void a(int[] iArr);

    abstract void b();

    void b(Rect rect) {
    }

    abstract void c();

    abstract void d();

    abstract void e();

    boolean f() {
        return false;
    }

    void g() {
    }

    final void h() {
        Rect rect = this.a;
        a(rect);
        b(rect);
        this.l.a(rect.left, rect.top, rect.right, rect.bottom);
    }
}
