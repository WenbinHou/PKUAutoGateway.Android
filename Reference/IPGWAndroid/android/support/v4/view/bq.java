package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

public final class bq {
    static final cd a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            a = new cc();
        } else if (i >= 21) {
            a = new cb();
        } else if (i >= 19) {
            a = new ca();
        } else if (i >= 17) {
            a = new by();
        } else if (i >= 16) {
            a = new bx();
        } else if (i >= 15) {
            a = new bv();
        } else if (i >= 14) {
            a = new bw();
        } else if (i >= 11) {
            a = new bu();
        } else if (i >= 9) {
            a = new bt();
        } else if (i >= 7) {
            a = new bs();
        } else {
            a = new br();
        }
    }

    public static boolean A(View view) {
        return a.C(view);
    }

    public static ColorStateList B(View view) {
        return a.E(view);
    }

    public static Mode C(View view) {
        return a.F(view);
    }

    public static boolean D(View view) {
        return a.D(view);
    }

    public static void E(View view) {
        a.G(view);
    }

    public static boolean F(View view) {
        return a.H(view);
    }

    public static float G(View view) {
        return a.I(view);
    }

    public static boolean H(View view) {
        return a.J(view);
    }

    public static boolean I(View view) {
        return a.K(view);
    }

    public static int a(int i, int i2) {
        return a.a(i, i2);
    }

    public static int a(int i, int i2, int i3) {
        return a.a(i, i2, i3);
    }

    public static int a(View view) {
        return a.a(view);
    }

    public static ed a(View view, ed edVar) {
        return a.a(view, edVar);
    }

    public static void a(View view, float f) {
        a.a(view, f);
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        a.a(view, i, i2, i3, i4);
    }

    public static void a(View view, int i, Paint paint) {
        a.a(view, i, paint);
    }

    public static void a(View view, ColorStateList colorStateList) {
        a.a(view, colorStateList);
    }

    public static void a(View view, Mode mode) {
        a.a(view, mode);
    }

    public static void a(View view, a aVar) {
        a.a(view, aVar);
    }

    public static void a(View view, bi biVar) {
        a.a(view, biVar);
    }

    public static void a(View view, Runnable runnable) {
        a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        a.a(view, runnable, j);
    }

    public static void a(View view, boolean z) {
        a.a(view, z);
    }

    public static void a(ViewGroup viewGroup) {
        a.a(viewGroup);
    }

    public static boolean a(View view, int i) {
        return a.a(view, i);
    }

    public static ed b(View view, ed edVar) {
        return a.b(view, edVar);
    }

    public static void b(View view, float f) {
        a.b(view, f);
    }

    public static boolean b(View view) {
        return a.b(view);
    }

    public static boolean b(View view, int i) {
        return a.b(view, i);
    }

    public static void c(View view, float f) {
        a.c(view, f);
    }

    public static void c(View view, int i) {
        a.c(view, i);
    }

    public static boolean c(View view) {
        return a.c(view);
    }

    public static void d(View view) {
        a.d(view);
    }

    public static void d(View view, float f) {
        a.d(view, f);
    }

    public static void d(View view, int i) {
        a.f(view, i);
    }

    public static int e(View view) {
        return a.e(view);
    }

    public static void e(View view, float f) {
        a.e(view, f);
    }

    public static void e(View view, int i) {
        a.e(view, i);
    }

    public static float f(View view) {
        return a.f(view);
    }

    public static void f(View view, float f) {
        a.f(view, f);
    }

    public static void f(View view, int i) {
        a.d(view, i);
    }

    public static int g(View view) {
        return a.g(view);
    }

    public static int h(View view) {
        return a.h(view);
    }

    public static int i(View view) {
        return a.i(view);
    }

    public static int j(View view) {
        return a.j(view);
    }

    public static void k(View view) {
        a.k(view);
    }

    public static int l(View view) {
        return a.l(view);
    }

    public static int m(View view) {
        return a.m(view);
    }

    public static float n(View view) {
        return a.o(view);
    }

    public static float o(View view) {
        return a.p(view);
    }

    public static int p(View view) {
        return a.r(view);
    }

    public static int q(View view) {
        return a.s(view);
    }

    public static dk r(View view) {
        return a.t(view);
    }

    public static float s(View view) {
        return a.q(view);
    }

    public static int t(View view) {
        return a.u(view);
    }

    public static void u(View view) {
        a.v(view);
    }

    public static boolean v(View view) {
        return a.y(view);
    }

    public static void w(View view) {
        a.z(view);
    }

    public static void x(View view) {
        a.A(view);
    }

    public static void y(View view) {
        a.B(view);
    }

    public static boolean z(View view) {
        return a.n(view);
    }
}
