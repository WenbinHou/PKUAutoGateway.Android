package com.chauthai.swipereveallayout;

import android.support.v4.view.bq;
import android.support.v4.widget.bp;
import android.view.View;

final class d extends bp {
    final /* synthetic */ SwipeRevealLayout a;

    d(SwipeRevealLayout swipeRevealLayout) {
        this.a = swipeRevealLayout;
    }

    public final void a(int i) {
        super.a(i);
        int p = this.a.m;
        switch (i) {
            case 0:
                if (this.a.q != 1 && this.a.q != 2) {
                    if (this.a.c.getTop() != this.a.e.top) {
                        this.a.m = 2;
                        break;
                    } else {
                        this.a.m = 0;
                        break;
                    }
                } else if (this.a.c.getLeft() != this.a.e.left) {
                    this.a.m = 2;
                    break;
                } else {
                    this.a.m = 0;
                    break;
                }
                break;
            case 1:
                this.a.m = 4;
                break;
        }
        if (this.a.s != null && !this.a.a && p != this.a.m) {
            this.a.s.a(this.a.m);
        }
    }

    public final void a(int i, int i2) {
        Object obj = 1;
        super.a(i, i2);
        if (!this.a.k) {
            Object obj2 = (this.a.q == 2 && i == 1) ? 1 : null;
            Object obj3 = (this.a.q == 1 && i == 2) ? 1 : null;
            Object obj4 = (this.a.q == 8 && i == 4) ? 1 : null;
            if (!(this.a.q == 4 && i == 8)) {
                obj = null;
            }
            if (obj2 != null || obj3 != null || obj4 != null || r1 != null) {
                this.a.b.a(this.a.c, i2);
            }
        }
    }

    public final void a(View view, float f, float f2) {
        boolean z = false;
        boolean z2 = ((int) (((float) ((int) f)) / (((float) this.a.getContext().getResources().getDisplayMetrics().densityDpi) / 160.0f))) >= this.a.l;
        boolean z3 = ((int) (((float) ((int) f)) / (((float) this.a.getContext().getResources().getDisplayMetrics().densityDpi) / 160.0f))) <= (-this.a.l);
        boolean z4 = ((int) (((float) ((int) f2)) / (((float) this.a.getContext().getResources().getDisplayMetrics().densityDpi) / 160.0f))) <= (-this.a.l);
        if (((int) (((float) ((int) f2)) / (((float) this.a.getContext().getResources().getDisplayMetrics().densityDpi) / 160.0f))) >= this.a.l) {
            z = true;
        }
        int i = this.a.getHalfwayPivotHorizontal();
        int j = this.a.getHalfwayPivotVertical();
        switch (this.a.q) {
            case 1:
                if (z2) {
                    this.a.a(true);
                    return;
                } else if (!z3 && this.a.c.getLeft() >= i) {
                    this.a.a(true);
                    return;
                }
            case 2:
                if (!z2) {
                    if (z3) {
                        this.a.a(true);
                        return;
                    } else if (this.a.c.getRight() < i) {
                        this.a.a(true);
                        return;
                    } else {
                        this.a.b(true);
                        return;
                    }
                }
                break;
            case 4:
                if (!z4) {
                    if (z) {
                        this.a.a(true);
                        return;
                    } else if (this.a.c.getTop() >= j) {
                        this.a.a(true);
                        return;
                    }
                }
                break;
            case 8:
                if (z4) {
                    this.a.a(true);
                    return;
                } else if (!z && this.a.c.getBottom() < j) {
                    this.a.a(true);
                    return;
                }
            default:
                return;
        }
        this.a.b(true);
    }

    public final void a(View view, int i, int i2, int i3, int i4) {
        Object obj = 1;
        super.a(view, i, i2, i3, i4);
        if (this.a.n == 1) {
            if (this.a.q == 1 || this.a.q == 2) {
                this.a.d.offsetLeftAndRight(i3);
            } else {
                this.a.d.offsetTopAndBottom(i4);
            }
        }
        if (this.a.c.getLeft() == this.a.o && this.a.c.getTop() == this.a.p) {
            obj = null;
        }
        if (!(this.a.t == null || r0 == null || ((this.a.c.getLeft() == this.a.e.left && this.a.c.getTop() == this.a.e.top) || (this.a.c.getLeft() == this.a.f.left && this.a.c.getTop() == this.a.f.top)))) {
            int i5;
            switch (this.a.q) {
                case 1:
                    this.a.c.getLeft();
                    i5 = this.a.e.left;
                    this.a.d.getWidth();
                    break;
                case 2:
                    i5 = this.a.e.left;
                    this.a.c.getLeft();
                    this.a.d.getWidth();
                    break;
                case 4:
                    this.a.c.getTop();
                    i5 = this.a.e.top;
                    this.a.d.getHeight();
                    break;
                case 8:
                    i5 = this.a.e.top;
                    this.a.c.getTop();
                    this.a.d.getHeight();
                    break;
            }
        }
        this.a.o = this.a.c.getLeft();
        this.a.p = this.a.c.getTop();
        bq.d(this.a);
    }

    public final boolean a(View view, int i) {
        this.a.a = false;
        if (!this.a.k) {
            this.a.b.a(this.a.c, i);
        }
        return false;
    }

    public final int b(View view, int i) {
        switch (this.a.q) {
            case 4:
                return Math.max(Math.min(i, this.a.e.top + this.a.d.getHeight()), this.a.e.top);
            case 8:
                return Math.max(Math.min(i, this.a.e.top), this.a.e.top - this.a.d.getHeight());
            default:
                return view.getTop();
        }
    }

    public final int c(View view, int i) {
        switch (this.a.q) {
            case 1:
                return Math.max(Math.min(i, this.a.e.left + this.a.d.getWidth()), this.a.e.left);
            case 2:
                return Math.max(Math.min(i, this.a.e.left), this.a.e.left - this.a.d.getWidth());
            default:
                return view.getLeft();
        }
    }
}
