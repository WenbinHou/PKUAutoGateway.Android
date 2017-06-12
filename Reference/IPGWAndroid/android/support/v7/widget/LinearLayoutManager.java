package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.a;
import android.support.v4.view.a.ae;
import android.support.v4.view.bq;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends eb {
    private cs a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    int i;
    dk j;
    boolean k;
    int l;
    int m;
    SavedState n;
    final cq o;

    public class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new ct();
        int a;
        int b;
        boolean c;

        SavedState(Parcel parcel) {
            boolean z = true;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.c = z;
        }

        public SavedState(SavedState savedState) {
            this.a = savedState.a;
            this.b = savedState.b;
            this.c = savedState.c;
        }

        final boolean a() {
            return this.a >= 0;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.c = false;
        this.k = false;
        this.d = false;
        this.e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new cq(this);
        h(i);
        b(z);
        this.u = true;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.c = false;
        this.k = false;
        this.d = false;
        this.e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new cq(this);
        ec a = eb.a(context, attributeSet, i, i2);
        h(a.a);
        b(a.c);
        a(a.d);
        this.u = true;
    }

    private int a(int i, eh ehVar, en enVar, boolean z) {
        int c = this.j.c() - i;
        if (c <= 0) {
            return 0;
        }
        c = -c(-c, ehVar, enVar);
        int i2 = i + c;
        if (!z) {
            return c;
        }
        i2 = this.j.c() - i2;
        if (i2 <= 0) {
            return c;
        }
        this.j.a(i2);
        return c + i2;
    }

    private int a(eh ehVar, cs csVar, en enVar, boolean z) {
        int i = csVar.c;
        if (csVar.g != Integer.MIN_VALUE) {
            if (csVar.c < 0) {
                csVar.g += csVar.c;
            }
            a(ehVar, csVar);
        }
        int i2 = csVar.c + csVar.h;
        cr crVar = new cr();
        while (true) {
            if ((!csVar.l && i2 <= 0) || !csVar.a(enVar)) {
                break;
            }
            crVar.a = 0;
            crVar.b = false;
            crVar.c = false;
            crVar.d = false;
            a(ehVar, enVar, csVar, crVar);
            if (!crVar.b) {
                csVar.b += crVar.a * csVar.f;
                if (!(crVar.c && this.a.k == null && enVar.g)) {
                    csVar.c -= crVar.a;
                    i2 -= crVar.a;
                }
                if (csVar.g != Integer.MIN_VALUE) {
                    csVar.g += crVar.a;
                    if (csVar.c < 0) {
                        csVar.g += csVar.c;
                    }
                    a(ehVar, csVar);
                }
                if (z && crVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - csVar.c;
    }

    private View a(int i, int i2, boolean z) {
        h();
        int b = this.j.b();
        int c = this.j.c();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View d = d(i);
            int a = this.j.a(d);
            int b2 = this.j.b(d);
            if (a < c && b2 > b) {
                if (!z) {
                    return d;
                }
                if (a >= b && b2 <= c) {
                    return d;
                }
                if (view == null) {
                    i += i3;
                    view = d;
                }
            }
            d = view;
            i += i3;
            view = d;
        }
        return view;
    }

    private void a(int i, int i2, boolean z, en enVar) {
        int b;
        int i3 = 1;
        this.a.l = this.j.g() == 0;
        this.a.h = g(enVar);
        this.a.f = i;
        View t;
        cs csVar;
        if (i == 1) {
            cs csVar2 = this.a;
            csVar2.h += this.j.f();
            t = t();
            csVar = this.a;
            if (this.k) {
                i3 = -1;
            }
            csVar.e = i3;
            this.a.d = eb.a(t) + this.a.e;
            this.a.b = this.j.b(t);
            b = this.j.b(t) - this.j.c();
        } else {
            t = s();
            csVar = this.a;
            csVar.h += this.j.b();
            csVar = this.a;
            if (!this.k) {
                i3 = -1;
            }
            csVar.e = i3;
            this.a.d = eb.a(t) + this.a.e;
            this.a.b = this.j.a(t);
            b = (-this.j.a(t)) + this.j.b();
        }
        this.a.c = i2;
        if (z) {
            cs csVar3 = this.a;
            csVar3.c -= b;
        }
        this.a.g = b;
    }

    private void a(cq cqVar) {
        i(cqVar.a, cqVar.b);
    }

    private void a(eh ehVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    a(i3, ehVar);
                }
                return;
            }
            while (i > i2) {
                a(i, ehVar);
                i--;
            }
        }
    }

    private void a(eh ehVar, cs csVar) {
        if (csVar.a && !csVar.l) {
            int i;
            int l;
            int d;
            if (csVar.f == -1) {
                i = csVar.g;
                l = l();
                if (i >= 0) {
                    d = this.j.d() - i;
                    if (this.k) {
                        for (i = 0; i < l; i++) {
                            if (this.j.a(d(i)) < d) {
                                a(ehVar, 0, i);
                                return;
                            }
                        }
                        return;
                    }
                    for (i = l - 1; i >= 0; i--) {
                        if (this.j.a(d(i)) < d) {
                            a(ehVar, l - 1, i);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            l = csVar.g;
            if (l >= 0) {
                d = l();
                if (this.k) {
                    for (i = d - 1; i >= 0; i--) {
                        if (this.j.b(d(i)) > l) {
                            a(ehVar, d - 1, i);
                            return;
                        }
                    }
                    return;
                }
                for (i = 0; i < d; i++) {
                    if (this.j.b(d(i)) > l) {
                        a(ehVar, 0, i);
                        return;
                    }
                }
            }
        }
    }

    private int b(int i, eh ehVar, en enVar, boolean z) {
        int b = i - this.j.b();
        if (b <= 0) {
            return 0;
        }
        b = -c(b, ehVar, enVar);
        int i2 = i + b;
        if (!z) {
            return b;
        }
        i2 -= this.j.b();
        if (i2 <= 0) {
            return b;
        }
        this.j.a(-i2);
        return b - i2;
    }

    private void b(cq cqVar) {
        j(cqVar.a, cqVar.b);
    }

    private void b(boolean z) {
        a(null);
        if (z != this.c) {
            this.c = z;
            j();
        }
    }

    private int c(int i, eh ehVar, en enVar) {
        if (l() == 0 || i == 0) {
            return 0;
        }
        this.a.a = true;
        h();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, enVar);
        int a = this.a.g + a(ehVar, this.a, enVar, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.j.a(-i);
        this.a.j = i;
        return i;
    }

    private View c(boolean z) {
        return this.k ? a(l() - 1, -1, z) : a(0, l(), z);
    }

    private View d(eh ehVar, en enVar) {
        return this.k ? f(ehVar, enVar) : g(ehVar, enVar);
    }

    private View d(boolean z) {
        return this.k ? a(0, l(), z) : a(l() - 1, -1, z);
    }

    private View e(eh ehVar, en enVar) {
        return this.k ? g(ehVar, enVar) : f(ehVar, enVar);
    }

    private View f(eh ehVar, en enVar) {
        return a(ehVar, enVar, 0, l(), enVar.a());
    }

    private int g(en enVar) {
        return (enVar.a != -1 ? 1 : 0) != 0 ? this.j.e() : 0;
    }

    private View g(eh ehVar, en enVar) {
        return a(ehVar, enVar, l() - 1, -1, enVar.a());
    }

    private int h(en enVar) {
        boolean z = true;
        if (l() == 0) {
            return 0;
        }
        h();
        dk dkVar = this.j;
        View c = c(!this.e);
        if (this.e) {
            z = false;
        }
        return eu.a(enVar, dkVar, c, d(z), this, this.e, this.k);
    }

    private void h(int i) {
        if (i == 0 || i == 1) {
            a(null);
            if (i != this.i) {
                this.i = i;
                this.j = null;
                j();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    private int i(en enVar) {
        boolean z = true;
        if (l() == 0) {
            return 0;
        }
        h();
        dk dkVar = this.j;
        View c = c(!this.e);
        if (this.e) {
            z = false;
        }
        return eu.a(enVar, dkVar, c, d(z), this, this.e);
    }

    private void i(int i, int i2) {
        this.a.c = this.j.c() - i2;
        this.a.e = this.k ? -1 : 1;
        this.a.d = i;
        this.a.f = 1;
        this.a.b = i2;
        this.a.g = Integer.MIN_VALUE;
    }

    private int j(en enVar) {
        boolean z = true;
        if (l() == 0) {
            return 0;
        }
        h();
        dk dkVar = this.j;
        View c = c(!this.e);
        if (this.e) {
            z = false;
        }
        return eu.b(enVar, dkVar, c, d(z), this, this.e);
    }

    private void j(int i, int i2) {
        this.a.c = i2 - this.j.b();
        this.a.d = i;
        this.a.e = this.k ? 1 : -1;
        this.a.f = -1;
        this.a.b = i2;
        this.a.g = Integer.MIN_VALUE;
    }

    private void r() {
        boolean z = true;
        if (this.i == 1 || !g()) {
            z = this.c;
        } else if (this.c) {
            z = false;
        }
        this.k = z;
    }

    private View s() {
        return d(this.k ? l() - 1 : 0);
    }

    private View t() {
        return d(this.k ? 0 : l() - 1);
    }

    public int a(int i, eh ehVar, en enVar) {
        return this.i == 1 ? 0 : c(i, ehVar, enVar);
    }

    public final int a(en enVar) {
        return h(enVar);
    }

    public final View a(int i) {
        int l = l();
        if (l == 0) {
            return null;
        }
        int a = i - eb.a(d(0));
        if (a >= 0 && a < l) {
            View d = d(a);
            if (eb.a(d) == i) {
                return d;
            }
        }
        return super.a(i);
    }

    View a(eh ehVar, en enVar, int i, int i2, int i3) {
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
            if (a >= 0 && a < i3) {
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

    public View a(View view, int i, eh ehVar, en enVar) {
        r();
        if (l() == 0) {
            return null;
        }
        int c = c(i);
        if (c == Integer.MIN_VALUE) {
            return null;
        }
        h();
        View e = c == -1 ? e(ehVar, enVar) : d(ehVar, enVar);
        if (e == null) {
            return null;
        }
        h();
        a(c, (int) (0.33333334f * ((float) this.j.e())), false, enVar);
        this.a.g = Integer.MIN_VALUE;
        this.a.a = false;
        a(ehVar, this.a, enVar, true);
        View s = c == -1 ? s() : t();
        return (s == e || !s.isFocusable()) ? null : s;
    }

    public final void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.n = (SavedState) parcelable;
            j();
        }
    }

    public final void a(RecyclerView recyclerView, eh ehVar) {
        super.a(recyclerView, ehVar);
        if (this.f) {
            c(ehVar);
            ehVar.a();
        }
    }

    void a(eh ehVar, en enVar, cq cqVar, int i) {
    }

    void a(eh ehVar, en enVar, cs csVar, cr crVar) {
        View a = csVar.a(ehVar);
        if (a == null) {
            crVar.b = true;
            return;
        }
        int size;
        int i;
        ed edVar = (ed) a.getLayoutParams();
        if (csVar.k == null) {
            if (this.k == (csVar.f == -1)) {
                super.a(a, -1, false);
            } else {
                super.a(a, 0, false);
            }
        } else {
            if (this.k == (csVar.f == -1)) {
                super.a(a, -1, true);
            } else {
                super.a(a, 0, true);
            }
        }
        ed edVar2 = (ed) a.getLayoutParams();
        Rect d = this.q.d(a);
        int i2 = (d.left + d.right) + 0;
        int i3 = (d.bottom + d.top) + 0;
        i2 = eb.a(MeasureSpec.getSize(this.w), MeasureSpec.getMode(this.w), i2 + (((m() + o()) + edVar2.leftMargin) + edVar2.rightMargin), edVar2.width, e());
        i3 = eb.a(MeasureSpec.getSize(this.x), MeasureSpec.getMode(this.x), i3 + (((n() + p()) + edVar2.topMargin) + edVar2.bottomMargin), edVar2.height, f());
        if (a(a, i2, i3, edVar2)) {
            a.measure(i2, i3);
        }
        crVar.a = this.j.c(a);
        if (this.i == 1) {
            if (g()) {
                size = MeasureSpec.getSize(this.w) - o();
                i3 = size - this.j.d(a);
            } else {
                i3 = m();
                size = this.j.d(a) + i3;
            }
            if (csVar.f == -1) {
                i2 = csVar.b - crVar.a;
                i = i3;
                i3 = size;
                size = csVar.b;
            } else {
                i2 = csVar.b;
                i = i3;
                i3 = size;
                size = csVar.b + crVar.a;
            }
        } else {
            i2 = n();
            size = this.j.d(a) + i2;
            if (csVar.f == -1) {
                i3 = csVar.b;
                i = csVar.b - crVar.a;
            } else {
                i = csVar.b;
                i3 = csVar.b + crVar.a;
            }
        }
        eb.a(a, i + edVar.leftMargin, i2 + edVar.topMargin, i3 - edVar.rightMargin, size - edVar.bottomMargin);
        if (edVar.c.m() || edVar.c.s()) {
            crVar.c = true;
        }
        crVar.d = a.isFocusable();
    }

    public final void a(AccessibilityEvent accessibilityEvent) {
        int i = -1;
        super.a(accessibilityEvent);
        if (l() > 0) {
            ae a = a.a(accessibilityEvent);
            View a2 = a(0, l(), false);
            a.b(a2 == null ? -1 : eb.a(a2));
            a2 = a(l() - 1, -1, false);
            if (a2 != null) {
                i = eb.a(a2);
            }
            a.c(i);
        }
    }

    public final void a(String str) {
        if (this.n == null) {
            super.a(str);
        }
    }

    public void a(boolean z) {
        a(null);
        if (this.d != z) {
            this.d = z;
            j();
        }
    }

    public int b(int i, eh ehVar, en enVar) {
        return this.i == 0 ? 0 : c(i, ehVar, enVar);
    }

    public final int b(en enVar) {
        return h(enVar);
    }

    public ed b() {
        return new ed(-2, -2);
    }

    public final void b(int i) {
        this.l = i;
        this.m = Integer.MIN_VALUE;
        if (this.n != null) {
            this.n.a = -1;
        }
        j();
    }

    final int c(int i) {
        switch (i) {
            case 1:
                return -1;
            case 2:
                return 1;
            case 17:
                return this.i != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.i != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                return this.i == 0 ? 1 : Integer.MIN_VALUE;
            case 130:
                return this.i == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public final int c(en enVar) {
        return i(enVar);
    }

    public void c(eh ehVar, en enVar) {
        if (!(this.n == null && this.l == -1) && enVar.a() == 0) {
            c(ehVar);
            return;
        }
        Object obj;
        View a;
        int a2;
        int c;
        int b;
        int min;
        int c2;
        if (this.n != null && this.n.a()) {
            this.l = this.n.a;
        }
        h();
        this.a.a = false;
        r();
        cq cqVar = this.o;
        cqVar.a = -1;
        cqVar.b = Integer.MIN_VALUE;
        cqVar.c = false;
        this.o.c = this.k ^ this.d;
        cq cqVar2 = this.o;
        if (enVar.g || this.l == -1) {
            obj = null;
        } else if (this.l < 0 || this.l >= enVar.a()) {
            this.l = -1;
            this.m = Integer.MIN_VALUE;
            obj = null;
        } else {
            cqVar2.a = this.l;
            if (this.n == null || !this.n.a()) {
                if (this.m == Integer.MIN_VALUE) {
                    a = a(this.l);
                    if (a == null) {
                        if (l() > 0) {
                            cqVar2.c = (this.l < eb.a(d(0))) == this.k;
                        }
                        cqVar2.a();
                    } else if (this.j.c(a) > this.j.e()) {
                        cqVar2.a();
                    } else if (this.j.a(a) - this.j.b() < 0) {
                        cqVar2.b = this.j.b();
                        cqVar2.c = false;
                    } else if (this.j.c() - this.j.b(a) < 0) {
                        cqVar2.b = this.j.c();
                        cqVar2.c = true;
                    } else {
                        cqVar2.b = cqVar2.c ? this.j.b(a) + this.j.a() : this.j.a(a);
                    }
                    obj = 1;
                } else {
                    cqVar2.c = this.k;
                    if (this.k) {
                        cqVar2.b = this.j.c() - this.m;
                    } else {
                        cqVar2.b = this.j.b() + this.m;
                    }
                }
                obj = 1;
            } else {
                cqVar2.c = this.n.c;
                if (cqVar2.c) {
                    cqVar2.b = this.j.c() - this.n.b;
                } else {
                    cqVar2.b = this.j.b() + this.n.b;
                }
                obj = 1;
            }
        }
        if (obj == null) {
            if (l() != 0) {
                View view;
                if (this.q == null) {
                    view = null;
                } else {
                    a = this.q.getFocusedChild();
                    view = (a == null || this.p.d(a)) ? null : a;
                }
                if (view != null) {
                    ed edVar = (ed) view.getLayoutParams();
                    obj = (edVar.c.m() || edVar.c.c() < 0 || edVar.c.c() >= enVar.a()) ? null : 1;
                    if (obj != null) {
                        a2 = cqVar2.d.j.a();
                        if (a2 >= 0) {
                            cqVar2.a(view);
                        } else {
                            cqVar2.a = eb.a(view);
                            if (cqVar2.c) {
                                a2 = (cqVar2.d.j.c() - a2) - cqVar2.d.j.b(view);
                                cqVar2.b = cqVar2.d.j.c() - a2;
                                if (a2 > 0) {
                                    c = cqVar2.b - cqVar2.d.j.c(view);
                                    b = cqVar2.d.j.b();
                                    min = c - (Math.min(cqVar2.d.j.a(view) - b, 0) + b);
                                    if (min < 0) {
                                        cqVar2.b = Math.min(a2, -min) + cqVar2.b;
                                    }
                                }
                            } else {
                                c = cqVar2.d.j.a(view);
                                b = c - cqVar2.d.j.b();
                                cqVar2.b = c;
                                if (b > 0) {
                                    a2 = (cqVar2.d.j.c() - Math.min(0, (cqVar2.d.j.c() - a2) - cqVar2.d.j.b(view))) - (c + cqVar2.d.j.c(view));
                                    if (a2 < 0) {
                                        cqVar2.b -= Math.min(b, -a2);
                                    }
                                }
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            cqVar2.a();
                            cqVar2.a = this.d ? enVar.a() - 1 : 0;
                        }
                    }
                }
                if (this.b == this.d) {
                    a = cqVar2.c ? d(ehVar, enVar) : e(ehVar, enVar);
                    if (a != null) {
                        cqVar2.a(a);
                        if (!enVar.g && c()) {
                            obj = (this.j.a(a) >= this.j.c() || this.j.b(a) < this.j.b()) ? 1 : null;
                            if (obj != null) {
                                cqVar2.b = cqVar2.c ? this.j.c() : this.j.b();
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            cqVar2.a();
                            if (this.d) {
                            }
                            cqVar2.a = this.d ? enVar.a() - 1 : 0;
                        }
                    }
                }
            }
            obj = null;
            if (obj == null) {
                cqVar2.a();
                if (this.d) {
                }
                cqVar2.a = this.d ? enVar.a() - 1 : 0;
            }
        }
        a2 = g(enVar);
        if (this.a.j >= 0) {
            min = 0;
        } else {
            min = a2;
            a2 = 0;
        }
        min += this.j.b();
        a2 += this.j.f();
        if (!(!enVar.g || this.l == -1 || this.m == Integer.MIN_VALUE)) {
            View a3 = a(this.l);
            if (a3 != null) {
                c2 = this.k ? (this.j.c() - this.j.b(a3)) - this.m : this.m - (this.j.a(a3) - this.j.b());
                if (c2 > 0) {
                    min += c2;
                } else {
                    a2 -= c2;
                }
            }
        }
        c2 = this.o.c ? this.k ? 1 : -1 : this.k ? -1 : 1;
        a(ehVar, enVar, this.o, c2);
        a(ehVar);
        this.a.l = this.j.g() == 0;
        this.a.i = enVar.g;
        if (this.o.c) {
            b(this.o);
            this.a.h = min;
            a(ehVar, this.a, enVar, false);
            min = this.a.b;
            c = this.a.d;
            if (this.a.c > 0) {
                a2 += this.a.c;
            }
            a(this.o);
            this.a.h = a2;
            cs csVar = this.a;
            csVar.d += this.a.e;
            a(ehVar, this.a, enVar, false);
            c2 = this.a.b;
            if (this.a.c > 0) {
                a2 = this.a.c;
                j(c, min);
                this.a.h = a2;
                a(ehVar, this.a, enVar, false);
                a2 = this.a.b;
            } else {
                a2 = min;
            }
            min = a2;
            a2 = c2;
        } else {
            a(this.o);
            this.a.h = a2;
            a(ehVar, this.a, enVar, false);
            a2 = this.a.b;
            c2 = this.a.d;
            if (this.a.c > 0) {
                min += this.a.c;
            }
            b(this.o);
            this.a.h = min;
            cs csVar2 = this.a;
            csVar2.d += this.a.e;
            a(ehVar, this.a, enVar, false);
            min = this.a.b;
            if (this.a.c > 0) {
                c = this.a.c;
                i(c2, a2);
                this.a.h = c;
                a(ehVar, this.a, enVar, false);
                a2 = this.a.b;
            }
        }
        if (l() <= 0) {
            c2 = min;
            min = a2;
        } else if ((this.k ^ this.d) != 0) {
            c2 = a(a2, ehVar, enVar, true);
            min += c2;
            a2 += c2;
            c2 = b(min, ehVar, enVar, false);
            a2 += c2;
            c2 = min + c2;
            min = a2;
        } else {
            c2 = b(min, ehVar, enVar, true);
            min += c2;
            a2 += c2;
            c2 = a(a2, ehVar, enVar, false);
            a2 += c2;
            c2 = min + c2;
            min = a2;
        }
        if (enVar.i && l() != 0 && !enVar.g && c()) {
            int i = 0;
            b = 0;
            List list = ehVar.d;
            int size = list.size();
            int a4 = eb.a(d(0));
            int i2 = 0;
            while (i2 < size) {
                eq eqVar = (eq) list.get(i2);
                if (eqVar.m()) {
                    a2 = b;
                    c = i;
                } else {
                    if (((eqVar.c() < a4) != this.k ? -1 : 1) == -1) {
                        c = this.j.c(eqVar.a) + i;
                        a2 = b;
                    } else {
                        a2 = this.j.c(eqVar.a) + b;
                        c = i;
                    }
                }
                i = c;
                i2++;
                b = a2;
            }
            this.a.k = list;
            if (i > 0) {
                j(eb.a(s()), c2);
                this.a.h = i;
                this.a.c = 0;
                this.a.a(null);
                a(ehVar, this.a, enVar, false);
            }
            if (b > 0) {
                i(eb.a(t()), min);
                this.a.h = b;
                this.a.c = 0;
                this.a.a(null);
                a(ehVar, this.a, enVar, false);
            }
            this.a.k = null;
        }
        if (!enVar.g) {
            this.l = -1;
            this.m = Integer.MIN_VALUE;
            dk dkVar = this.j;
            dkVar.b = dkVar.e();
        }
        this.b = this.d;
        this.n = null;
    }

    public boolean c() {
        return this.n == null && this.b == this.d;
    }

    public final int d(en enVar) {
        return i(enVar);
    }

    public final Parcelable d() {
        if (this.n != null) {
            return new SavedState(this.n);
        }
        Parcelable savedState = new SavedState();
        if (l() > 0) {
            h();
            boolean z = this.b ^ this.k;
            savedState.c = z;
            View t;
            if (z) {
                t = t();
                savedState.b = this.j.c() - this.j.b(t);
                savedState.a = eb.a(t);
                return savedState;
            }
            t = s();
            savedState.a = eb.a(t);
            savedState.b = this.j.a(t) - this.j.b();
            return savedState;
        }
        savedState.a = -1;
        return savedState;
    }

    public final int e(en enVar) {
        return j(enVar);
    }

    public final boolean e() {
        return this.i == 0;
    }

    public final int f(en enVar) {
        return j(enVar);
    }

    public final boolean f() {
        return this.i == 1;
    }

    protected final boolean g() {
        return bq.h(this.q) == 1;
    }

    final void h() {
        if (this.a == null) {
            this.a = new cs();
        }
        if (this.j == null) {
            this.j = dk.a(this, this.i);
        }
    }

    final boolean i() {
        if (!(MeasureSpec.getMode(this.x) == 1073741824 || MeasureSpec.getMode(this.w) == 1073741824)) {
            boolean z;
            int l = l();
            for (int i = 0; i < l; i++) {
                LayoutParams layoutParams = d(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }
}
