package android.support.design.widget;

import android.support.v4.view.bq;
import android.support.v4.widget.bp;
import android.view.View;
import android.view.ViewParent;

final class bk extends bp {
    final /* synthetic */ SwipeDismissBehavior a;
    private int b;

    bk(SwipeDismissBehavior swipeDismissBehavior) {
        this.a = swipeDismissBehavior;
    }

    public final void a(int i) {
        if (this.a.b != null) {
            this.a.b.a(i);
        }
    }

    public final void a(View view) {
        this.b = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public final void a(View view, float f, float f2) {
        boolean z;
        int i;
        boolean z2 = true;
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int width = view.getWidth();
        if (f != 0.0f) {
            z = bq.h(view) == 1;
            z = this.a.c == 2 ? true : this.a.c == 0 ? z ? f < 0.0f : f > 0.0f : this.a.c == 1 ? z ? f > 0.0f : f < 0.0f : false;
        } else {
            z = Math.abs(view.getLeft() - this.b) >= Math.round(((float) view.getWidth()) * this.a.i);
        }
        if (z) {
            i = view.getLeft() < this.b ? this.b - width : this.b + width;
        } else {
            i = this.b;
            z2 = false;
        }
        if (this.a.a.a(i, view.getTop())) {
            bq.a(view, new bm(this.a, view, z2));
        } else if (z2 && this.a.b != null) {
            this.a.b.a(view);
        }
    }

    public final void a(View view, int i, int i2, int i3, int i4) {
        float width = ((float) this.b) + (((float) view.getWidth()) * this.a.d);
        float width2 = ((float) this.b) + (((float) view.getWidth()) * this.a.e);
        if (((float) i) <= width) {
            bq.c(view, 1.0f);
        } else if (((float) i) >= width2) {
            bq.c(view, 0.0f);
        } else {
            bq.c(view, SwipeDismissBehavior.a(1.0f - SwipeDismissBehavior.a(width, width2, (float) i)));
        }
    }

    public final boolean a(View view, int i) {
        return this.a.b(view);
    }

    public final int b(View view) {
        return view.getWidth();
    }

    public final int b(View view, int i) {
        return view.getTop();
    }

    public final int c(View view, int i) {
        int width;
        int i2;
        Object obj = bq.h(view) == 1 ? 1 : null;
        if (this.a.c == 0) {
            if (obj != null) {
                width = this.b - view.getWidth();
                i2 = this.b;
            } else {
                width = this.b;
                i2 = this.b + view.getWidth();
            }
        } else if (this.a.c != 1) {
            width = this.b - view.getWidth();
            i2 = this.b + view.getWidth();
        } else if (obj != null) {
            width = this.b;
            i2 = this.b + view.getWidth();
        } else {
            width = this.b - view.getWidth();
            i2 = this.b;
        }
        return Math.min(Math.max(width, i), i2);
    }
}
