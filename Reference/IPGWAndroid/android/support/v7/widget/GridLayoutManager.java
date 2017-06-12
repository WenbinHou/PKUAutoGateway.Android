package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.f;
import android.support.v4.view.a.q;
import android.support.v4.view.bq;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean a = false;
    int b = -1;
    int[] c;
    View[] d;
    final SparseIntArray e = new SparseIntArray();
    final SparseIntArray f = new SparseIntArray();
    cm g = new ck();
    final Rect h = new Rect();

    public GridLayoutManager(Context context, int i) {
        super(context);
        i(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        i(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        i(eb.a(context, attributeSet, i, i2).b);
    }

    private int a(eh ehVar, en enVar, int i) {
        if (!enVar.g) {
            return cm.c(i, this.b);
        }
        int a = ehVar.a(i);
        if (a != -1) {
            return cm.c(a, this.b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private void a(eh ehVar, en enVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i2 = 1;
            i3 = 0;
        } else {
            i3 = i - 1;
            i2 = -1;
            i = -1;
        }
        if (this.i == 1 && g()) {
            i4 = -1;
            i5 = this.b - 1;
            i6 = i3;
        } else {
            i4 = 1;
            i5 = 0;
            i6 = i3;
        }
        while (i6 != i) {
            View view = this.d[i6];
            cl clVar = (cl) view.getLayoutParams();
            clVar.b = c(ehVar, enVar, eb.a(view));
            if (i4 != -1 || clVar.b <= 1) {
                clVar.a = i5;
            } else {
                clVar.a = i5 - (clVar.b - 1);
            }
            i5 += clVar.b * i4;
            i6 += i2;
        }
    }

    private void a(View view, int i, int i2, boolean z, boolean z2) {
        a(view, this.h);
        ed edVar = (ed) view.getLayoutParams();
        if (z || this.i == 1) {
            i = c(i, edVar.leftMargin + this.h.left, edVar.rightMargin + this.h.right);
        }
        if (z || this.i == 0) {
            i2 = c(i2, edVar.topMargin + this.h.top, edVar.bottomMargin + this.h.bottom);
        }
        boolean a = z2 ? (this.v && eb.b(view.getMeasuredWidth(), i, edVar.width) && eb.b(view.getMeasuredHeight(), i2, edVar.height)) ? false : true : a(view, i, i2, edVar);
        if (a) {
            view.measure(i, i2);
        }
    }

    private int b(eh ehVar, en enVar, int i) {
        if (!enVar.g) {
            return this.g.b(i, this.b);
        }
        int i2 = this.f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = ehVar.a(i);
        if (i2 != -1) {
            return this.g.b(i2, this.b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private static int c(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private int c(eh ehVar, en enVar, int i) {
        if (!enVar.g) {
            return 1;
        }
        int i2 = this.e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        if (ehVar.a(i) != -1) {
            return 1;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private void h(int i) {
        int i2 = 0;
        int[] iArr = this.c;
        int i3 = this.b;
        if (!(iArr != null && iArr.length == i3 + 1 && iArr[iArr.length - 1] == i)) {
            iArr = new int[(i3 + 1)];
        }
        iArr[0] = 0;
        int i4 = i / i3;
        int i5 = i % i3;
        int i6 = 0;
        for (int i7 = 1; i7 <= i3; i7++) {
            int i8;
            i2 += i5;
            if (i2 <= 0 || i3 - i2 >= i5) {
                i8 = i4;
            } else {
                i8 = i4 + 1;
                i2 -= i3;
            }
            i6 += i8;
            iArr[i7] = i6;
        }
        this.c = iArr;
    }

    private void i(int i) {
        if (i != this.b) {
            this.a = true;
            if (i <= 0) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.b = i;
            this.g.a.clear();
        }
    }

    private void r() {
        h(this.i == 1 ? (MeasureSpec.getSize(this.w) - o()) - m() : (MeasureSpec.getSize(this.x) - p()) - n());
    }

    private void s() {
        if (this.d == null || this.d.length != this.b) {
            this.d = new View[this.b];
        }
    }

    public final int a(int i, eh ehVar, en enVar) {
        r();
        s();
        return super.a(i, ehVar, enVar);
    }

    public final int a(eh ehVar, en enVar) {
        return this.i == 0 ? this.b : enVar.a() <= 0 ? 0 : a(ehVar, enVar, enVar.a() - 1) + 1;
    }

    public final ed a(Context context, AttributeSet attributeSet) {
        return new cl(context, attributeSet);
    }

    public final ed a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new cl((MarginLayoutParams) layoutParams) : new cl(layoutParams);
    }

    final View a(eh ehVar, en enVar, int i, int i2, int i3) {
        View view = null;
        h();
        int b = this.j.b();
        int c = this.j.c();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View d = d(i);
            int a = eb.a(d);
            if (a >= 0 && a < i3 && b(ehVar, enVar, a) == 0) {
                if (((ed) d.getLayoutParams()).c.m()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = d;
                    }
                } else if (this.j.a(d) < c && this.j.b(d) >= b) {
                    return d;
                } else {
                    if (view == null) {
                        view3 = d;
                        d = view2;
                        i += i4;
                        view = view3;
                        view2 = d;
                    }
                }
            }
            view3 = view;
            d = view2;
            i += i4;
            view = view3;
            view2 = d;
        }
        return view != null ? view : view2;
    }

    public final View a(View view, int i, eh ehVar, en enVar) {
        View b = b(view);
        if (b == null) {
            return null;
        }
        cl clVar = (cl) b.getLayoutParams();
        int a = clVar.a;
        int a2 = clVar.a + clVar.b;
        if (super.a(view, i, ehVar, enVar) == null) {
            return null;
        }
        int l;
        int i2;
        int i3;
        if (((c(i) == 1) != this.k ? 1 : null) != null) {
            l = l() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            l = 0;
            i2 = 1;
            i3 = l();
        }
        Object obj = (this.i == 1 && g()) ? 1 : null;
        View view2 = null;
        int i4 = -1;
        int i5 = 0;
        int i6 = l;
        while (i6 != i3) {
            View d = d(i6);
            if (d == b) {
                break;
            }
            View view3;
            if (d.isFocusable()) {
                clVar = (cl) d.getLayoutParams();
                int a3 = clVar.a;
                int a4 = clVar.a + clVar.b;
                if (a3 == a && a4 == a2) {
                    return d;
                }
                Object obj2 = null;
                if (view2 == null) {
                    obj2 = 1;
                } else {
                    int min = Math.min(a4, a2) - Math.max(a3, a);
                    if (min > i5) {
                        obj2 = 1;
                    } else if (min == i5) {
                        if (obj == (a3 > i4 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
                if (obj2 != null) {
                    i5 = clVar.a;
                    l = Math.min(a4, a2) - Math.max(a3, a);
                    view3 = d;
                    view2 = view3;
                    i6 += i2;
                    i4 = i5;
                    i5 = l;
                }
            }
            l = i5;
            i5 = i4;
            view3 = view2;
            view2 = view3;
            i6 += i2;
            i4 = i5;
            i5 = l;
        }
        return view2;
    }

    public final void a() {
        this.g.a.clear();
    }

    public final void a(int i, int i2) {
        this.g.a.clear();
    }

    public final void a(Rect rect, int i, int i2) {
        if (this.c == null) {
            super.a(rect, i, i2);
        }
        int o = o() + m();
        int n = n() + p();
        if (this.i == 1) {
            n = eb.a(i2, n + rect.height(), bq.q(this.q));
            o = eb.a(i, o + this.c[this.c.length - 1], bq.p(this.q));
        } else {
            o = eb.a(i, o + rect.width(), bq.p(this.q));
            n = eb.a(i2, n + this.c[this.c.length - 1], bq.q(this.q));
        }
        h(o, n);
    }

    final void a(eh ehVar, en enVar, cq cqVar, int i) {
        Object obj = 1;
        super.a(ehVar, enVar, cqVar, i);
        r();
        if (enVar.a() > 0 && !enVar.g) {
            if (i != 1) {
                obj = null;
            }
            int b = b(ehVar, enVar, cqVar.a);
            if (obj != null) {
                while (b > 0 && cqVar.a > 0) {
                    cqVar.a--;
                    b = b(ehVar, enVar, cqVar.a);
                }
            } else {
                int a = enVar.a() - 1;
                int i2 = cqVar.a;
                while (i2 < a) {
                    int b2 = b(ehVar, enVar, i2 + 1);
                    if (b2 <= b) {
                        break;
                    }
                    i2++;
                    b = b2;
                }
                cqVar.a = i2;
            }
        }
        s();
    }

    final void a(eh ehVar, en enVar, cs csVar, cr crVar) {
        int i;
        int h = this.j.h();
        Object obj = h != 1073741824 ? 1 : null;
        int i2 = l() > 0 ? this.c[this.b] : 0;
        if (obj != null) {
            r();
        }
        boolean z = csVar.e == 1;
        int i3 = this.b;
        if (z) {
            i = 0;
        } else {
            i3 = b(ehVar, enVar, csVar.d) + c(ehVar, enVar, csVar.d);
            i = 0;
        }
        while (i < this.b && csVar.a(enVar) && i3 > 0) {
            View a;
            int i4 = csVar.d;
            int c = c(ehVar, enVar, i4);
            if (c <= this.b) {
                i3 -= c;
                if (i3 < 0) {
                    break;
                }
                a = csVar.a(ehVar);
                if (a == null) {
                    break;
                }
                this.d[i] = a;
                i++;
            } else {
                throw new IllegalArgumentException("Item at position " + i4 + " requires " + c + " spans but GridLayoutManager has only " + this.b + " spans.");
            }
        }
        if (i == 0) {
            crVar.b = true;
            return;
        }
        int a2;
        int i5;
        int i6;
        int i7 = 0;
        float f = 0.0f;
        a(ehVar, enVar, i, z);
        int i8 = 0;
        while (i8 < i) {
            a = this.d[i8];
            if (csVar.k == null) {
                if (z) {
                    super.a(a, -1, false);
                } else {
                    super.a(a, 0, false);
                }
            } else if (z) {
                super.a(a, -1, true);
            } else {
                super.a(a, 0, true);
            }
            cl clVar = (cl) a.getLayoutParams();
            c = eb.a(this.c[clVar.a + clVar.b] - this.c[clVar.a], h, 0, this.i == 0 ? clVar.height : clVar.width, false);
            a2 = eb.a(this.j.e(), this.j.g(), 0, this.i == 1 ? clVar.height : clVar.width, true);
            if (this.i == 1) {
                a(a, c, a2, clVar.height == -1, false);
            } else {
                a(a, a2, c, clVar.width == -1, false);
            }
            i3 = this.j.c(a);
            if (i3 <= i7) {
                i3 = i7;
            }
            float d = (((float) this.j.d(a)) * 1.0f) / ((float) clVar.b);
            if (d <= f) {
                d = f;
            }
            i8++;
            f = d;
            i7 = i3;
        }
        if (obj != null) {
            h(Math.max(Math.round(((float) this.b) * f), i2));
            i5 = 0;
            i6 = 0;
            while (i6 < i) {
                a = this.d[i6];
                cl clVar2 = (cl) a.getLayoutParams();
                c = eb.a(this.c[clVar2.a + clVar2.b] - this.c[clVar2.a], 1073741824, 0, this.i == 0 ? clVar2.height : clVar2.width, false);
                a2 = eb.a(this.j.e(), this.j.g(), 0, this.i == 1 ? clVar2.height : clVar2.width, true);
                if (this.i == 1) {
                    a(a, c, a2, false, true);
                } else {
                    a(a, a2, c, false, true);
                }
                i3 = this.j.c(a);
                if (i3 <= i5) {
                    i3 = i5;
                }
                i6++;
                i5 = i3;
            }
        } else {
            i5 = i7;
        }
        a2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        for (i6 = 0; i6 < i; i6++) {
            a = this.d[i6];
            if (this.j.c(a) != i5) {
                clVar2 = (cl) a.getLayoutParams();
                c = eb.a(this.c[clVar2.a + clVar2.b] - this.c[clVar2.a], 1073741824, 0, this.i == 0 ? clVar2.height : clVar2.width, false);
                if (this.i == 1) {
                    a(a, c, a2, true, true);
                } else {
                    a(a, a2, c, true, true);
                }
            }
        }
        crVar.a = i5;
        a2 = 0;
        c = 0;
        i4 = 0;
        i3 = 0;
        if (this.i == 1) {
            if (csVar.f == -1) {
                i3 = csVar.b;
                i4 = i3 - i5;
            } else {
                i4 = csVar.b;
                i3 = i4 + i5;
            }
        } else if (csVar.f == -1) {
            c = csVar.b;
            a2 = c - i5;
        } else {
            a2 = csVar.b;
            c = a2 + i5;
        }
        int i9 = a2;
        a2 = c;
        c = i4;
        i4 = i3;
        for (int i10 = 0; i10 < i; i10++) {
            View view = this.d[i10];
            clVar2 = (cl) view.getLayoutParams();
            if (this.i != 1) {
                c = this.c[clVar2.a] + n();
                i4 = this.j.d(view) + c;
            } else if (g()) {
                a2 = m() + this.c[clVar2.a + clVar2.b];
                i9 = a2 - this.j.d(view);
            } else {
                i9 = this.c[clVar2.a] + m();
                a2 = this.j.d(view) + i9;
            }
            eb.a(view, clVar2.leftMargin + i9, clVar2.topMargin + c, a2 - clVar2.rightMargin, i4 - clVar2.bottomMargin);
            if (clVar2.c.m() || clVar2.c.s()) {
                crVar.c = true;
            }
            crVar.d |= view.isFocusable();
        }
        Arrays.fill(this.d, null);
    }

    public final void a(eh ehVar, en enVar, View view, f fVar) {
        boolean z = false;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof cl) {
            cl clVar = (cl) layoutParams;
            int a = a(ehVar, enVar, clVar.c.c());
            int i;
            int i2;
            if (this.i == 0) {
                i = clVar.a;
                i2 = clVar.b;
                boolean z2 = this.b > 1 && clVar.b == this.b;
                fVar.a(q.a(i, i2, a, 1, z2));
                return;
            }
            i = clVar.a;
            i2 = clVar.b;
            if (this.b > 1 && clVar.b == this.b) {
                z = true;
            }
            fVar.a(q.a(a, 1, i, i2, z));
            return;
        }
        super.a(view, fVar);
    }

    public final void a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.a(false);
    }

    public final boolean a(ed edVar) {
        return edVar instanceof cl;
    }

    public final int b(int i, eh ehVar, en enVar) {
        r();
        s();
        return super.b(i, ehVar, enVar);
    }

    public final int b(eh ehVar, en enVar) {
        return this.i == 1 ? this.b : enVar.a() <= 0 ? 0 : a(ehVar, enVar, enVar.a() - 1) + 1;
    }

    public final ed b() {
        return this.i == 0 ? new cl(-2, -1) : new cl(-1, -2);
    }

    public final void b(int i, int i2) {
        this.g.a.clear();
    }

    public final void c(int i, int i2) {
        this.g.a.clear();
    }

    public final void c(eh ehVar, en enVar) {
        if (enVar.g) {
            int l = l();
            for (int i = 0; i < l; i++) {
                cl clVar = (cl) d(i).getLayoutParams();
                int c = clVar.c.c();
                this.e.put(c, clVar.b);
                this.f.put(c, clVar.a);
            }
        }
        super.c(ehVar, enVar);
        this.e.clear();
        this.f.clear();
        if (!enVar.g) {
            this.a = false;
        }
    }

    public final boolean c() {
        return this.n == null && !this.a;
    }

    public final void d(int i, int i2) {
        this.g.a.clear();
    }
}
