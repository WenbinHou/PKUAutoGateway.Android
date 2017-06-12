package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.v4.view.bq;
import android.view.View;
import android.view.ViewParent;

final class cu {
    final View a;
    int b;
    int c;
    int d;
    int e;

    public cu(View view) {
        this.a = view;
    }

    private static void a(View view) {
        float o = bq.o(view);
        bq.b(view, 1.0f + o);
        bq.b(view, o);
    }

    final void a() {
        bq.d(this.a, this.d - (this.a.getTop() - this.b));
        bq.e(this.a, this.e - (this.a.getLeft() - this.c));
        if (VERSION.SDK_INT < 23) {
            a(this.a);
            ViewParent parent = this.a.getParent();
            if (parent instanceof View) {
                a((View) parent);
            }
        }
    }

    public final boolean a(int i) {
        if (this.d == i) {
            return false;
        }
        this.d = i;
        a();
        return true;
    }
}
