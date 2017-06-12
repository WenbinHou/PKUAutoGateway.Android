package android.support.v7.widget;

import android.view.View;

public abstract class fe extends dx {
    boolean m = true;

    public abstract boolean a(eq eqVar);

    public abstract boolean a(eq eqVar, int i, int i2, int i3, int i4);

    public final boolean a(eq eqVar, dz dzVar, dz dzVar2) {
        int i = dzVar.a;
        int i2 = dzVar.b;
        View view = eqVar.a;
        int left = dzVar2 == null ? view.getLeft() : dzVar2.a;
        int top = dzVar2 == null ? view.getTop() : dzVar2.b;
        if (eqVar.m() || (i == left && i2 == top)) {
            return a(eqVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(eqVar, i, i2, left, top);
    }

    public abstract boolean a(eq eqVar, eq eqVar2, int i, int i2, int i3, int i4);

    public final boolean a(eq eqVar, eq eqVar2, dz dzVar, dz dzVar2) {
        int i;
        int i2;
        int i3 = dzVar.a;
        int i4 = dzVar.b;
        if (eqVar2.b()) {
            i = dzVar.a;
            i2 = dzVar.b;
        } else {
            i = dzVar2.a;
            i2 = dzVar2.b;
        }
        return a(eqVar, eqVar2, i3, i4, i, i2);
    }

    public abstract boolean b(eq eqVar);

    public final boolean b(eq eqVar, dz dzVar, dz dzVar2) {
        if (dzVar == null || (dzVar.a == dzVar2.a && dzVar.b == dzVar2.b)) {
            return b(eqVar);
        }
        return a(eqVar, dzVar.a, dzVar.b, dzVar2.a, dzVar2.b);
    }

    public final boolean c(eq eqVar, dz dzVar, dz dzVar2) {
        if (dzVar.a == dzVar2.a && dzVar.b == dzVar2.b) {
            e(eqVar);
            return false;
        }
        return a(eqVar, dzVar.a, dzVar.b, dzVar2.a, dzVar2.b);
    }

    public final boolean f(eq eqVar) {
        return !this.m || eqVar.j();
    }
}
