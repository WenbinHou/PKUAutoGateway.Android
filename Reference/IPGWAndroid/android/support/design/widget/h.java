package android.support.design.widget;

import android.support.v4.view.bq;
import android.support.v4.widget.bp;
import android.view.View;

final class h extends bp {
    final /* synthetic */ BottomSheetBehavior a;

    h(BottomSheetBehavior bottomSheetBehavior) {
        this.a = bottomSheetBehavior;
    }

    public final int a() {
        return this.a.e ? this.a.k - this.a.c : this.a.d - this.a.c;
    }

    public final void a(int i) {
        if (i == 1) {
            this.a.a(1);
        }
    }

    public final void a(View view, float f, float f2) {
        int g;
        int i = 3;
        if (f2 < 0.0f) {
            g = this.a.c;
        } else if (this.a.e && this.a.a(view, f2)) {
            g = this.a.k;
            i = 5;
        } else if (f2 == 0.0f) {
            int top = view.getTop();
            if (Math.abs(top - this.a.c) < Math.abs(top - this.a.d)) {
                g = this.a.c;
            } else {
                g = this.a.d;
                i = 4;
            }
        } else {
            g = this.a.d;
            i = 4;
        }
        if (this.a.g.a(view.getLeft(), g)) {
            this.a.a(2);
            bq.a(view, new j(this.a, view, i));
            return;
        }
        this.a.a(i);
    }

    public final void a(View view, int i, int i2, int i3, int i4) {
        this.a.b();
    }

    public final boolean a(View view, int i) {
        if (this.a.f == 1) {
            return false;
        }
        if (this.a.q) {
            return false;
        }
        if (this.a.f == 3 && this.a.o == i) {
            View view2 = (View) this.a.m.get();
            if (view2 != null && bq.b(view2, -1)) {
                return false;
            }
        }
        return this.a.l != null && this.a.l.get() == view;
    }

    public final int b(View view, int i) {
        return ao.a(i, this.a.c, this.a.e ? this.a.k : this.a.d);
    }

    public final int c(View view, int i) {
        return view.getLeft();
    }
}
