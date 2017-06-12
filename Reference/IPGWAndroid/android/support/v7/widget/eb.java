package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.ae;
import android.support.v4.view.a.f;
import android.support.v4.view.a.q;
import android.support.v4.view.bq;
import android.support.v7.d.b;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public abstract class eb {
    bp p;
    RecyclerView q;
    el r;
    boolean s = false;
    boolean t = false;
    boolean u = false;
    boolean v = true;
    int w;
    int x;

    public static int a(int i, int i2, int i3) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(size, Math.max(i2, i3));
            case 1073741824:
                return size;
            default:
                return Math.max(i2, i3);
        }
    }

    public static int a(int i, int i2, int i3, int i4, boolean z) {
        int i5 = 0;
        int max = Math.max(0, i - i3);
        if (z) {
            if (i4 >= 0) {
                i5 = 1073741824;
                max = i4;
            } else if (i4 == -1) {
                switch (i2) {
                    case Integer.MIN_VALUE:
                    case 1073741824:
                        i5 = i2;
                        break;
                    default:
                        max = 0;
                        break;
                }
            } else {
                if (i4 == -2) {
                    max = 0;
                }
                max = 0;
            }
        } else if (i4 >= 0) {
            i5 = 1073741824;
            max = i4;
        } else if (i4 == -1) {
            i5 = i2;
        } else {
            if (i4 == -2) {
                if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                    i5 = Integer.MIN_VALUE;
                }
            }
            max = 0;
        }
        return MeasureSpec.makeMeasureSpec(max, i5);
    }

    public static int a(View view) {
        return ((ed) view.getLayoutParams()).c.c();
    }

    public static ec a(Context context, AttributeSet attributeSet, int i, int i2) {
        ec ecVar = new ec();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.RecyclerView, i, i2);
        ecVar.a = obtainStyledAttributes.getInt(b.RecyclerView_android_orientation, 1);
        ecVar.b = obtainStyledAttributes.getInt(b.RecyclerView_spanCount, 1);
        ecVar.c = obtainStyledAttributes.getBoolean(b.RecyclerView_reverseLayout, false);
        ecVar.d = obtainStyledAttributes.getBoolean(b.RecyclerView_stackFromEnd, false);
        obtainStyledAttributes.recycle();
        return ecVar;
    }

    static /* synthetic */ void a(eb ebVar, el elVar) {
        if (ebVar.r == elVar) {
            ebVar.r = null;
        }
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        Rect rect = ((ed) view.getLayoutParams()).d;
        view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
    }

    static boolean b(int i, int i2, int i3) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        switch (mode) {
            case Integer.MIN_VALUE:
                return size >= i;
            case 0:
                return true;
            case 1073741824:
                return size == i;
            default:
                return false;
        }
    }

    public static int c(View view) {
        Rect rect = ((ed) view.getLayoutParams()).d;
        return rect.right + (view.getMeasuredWidth() + rect.left);
    }

    private void c(int i) {
        if (d(i) != null) {
            bp bpVar = this.p;
            int a = bpVar.a(i);
            View b = bpVar.a.b(a);
            if (b != null) {
                if (bpVar.b.d(a)) {
                    bpVar.b(b);
                }
                bpVar.a.a(a);
            }
        }
    }

    public static int d(View view) {
        Rect rect = ((ed) view.getLayoutParams()).d;
        return rect.bottom + (view.getMeasuredHeight() + rect.top);
    }

    public static int e(View view) {
        return view.getLeft() - ((ed) view.getLayoutParams()).d.left;
    }

    public static int f(View view) {
        return view.getTop() - ((ed) view.getLayoutParams()).d.top;
    }

    public static int g(View view) {
        return ((ed) view.getLayoutParams()).d.right + view.getRight();
    }

    public static int h(View view) {
        return ((ed) view.getLayoutParams()).d.bottom + view.getBottom();
    }

    private void h(int i) {
        d(i);
        this.p.d(i);
    }

    public int a(int i, eh ehVar, en enVar) {
        return 0;
    }

    public int a(eh ehVar, en enVar) {
        return (this.q == null || this.q.y == null || !f()) ? 1 : this.q.y.a();
    }

    public int a(en enVar) {
        return 0;
    }

    public ed a(Context context, AttributeSet attributeSet) {
        return new ed(context, attributeSet);
    }

    public ed a(LayoutParams layoutParams) {
        return layoutParams instanceof ed ? new ed((ed) layoutParams) : layoutParams instanceof MarginLayoutParams ? new ed((MarginLayoutParams) layoutParams) : new ed(layoutParams);
    }

    public View a(int i) {
        int l = l();
        for (int i2 = 0; i2 < l; i2++) {
            View d = d(i2);
            eq b = RecyclerView.b(d);
            if (b != null && b.c() == i && !b.b() && (this.q.o.g || !b.m())) {
                return d;
            }
        }
        return null;
    }

    public View a(View view, int i, eh ehVar, en enVar) {
        return null;
    }

    public void a() {
    }

    public void a(int i, int i2) {
    }

    public final void a(int i, eh ehVar) {
        View d = d(i);
        c(i);
        ehVar.a(d);
    }

    public void a(Rect rect, int i, int i2) {
        h(a(i, (rect.width() + m()) + o(), bq.p(this.q)), a(i2, (rect.height() + n()) + p(), bq.q(this.q)));
    }

    public void a(Parcelable parcelable) {
    }

    final void a(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.q = null;
            this.p = null;
            this.w = MeasureSpec.makeMeasureSpec(0, 1073741824);
            this.x = MeasureSpec.makeMeasureSpec(0, 1073741824);
            return;
        }
        this.q = recyclerView;
        this.p = recyclerView.c;
        this.w = MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824);
        this.x = MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824);
    }

    public void a(RecyclerView recyclerView, eh ehVar) {
    }

    public final void a(eh ehVar) {
        for (int l = l() - 1; l >= 0; l--) {
            View d = d(l);
            eq b = RecyclerView.b(d);
            if (!b.b()) {
                if (!b.j() || b.m() || this.q.y.b) {
                    h(l);
                    ehVar.c(d);
                    this.q.d.c(b);
                } else {
                    c(l);
                    ehVar.a(b);
                }
            }
        }
    }

    public void a(eh ehVar, en enVar, View view, f fVar) {
        fVar.a(q.a(f() ? a(view) : 0, 1, e() ? a(view) : 0, 1, false));
    }

    final void a(View view, int i, boolean z) {
        eq b = RecyclerView.b(view);
        if (z || b.m()) {
            this.q.d.b(b);
        } else {
            this.q.d.c(b);
        }
        ed edVar = (ed) view.getLayoutParams();
        if (b.g() || b.e()) {
            if (b.e()) {
                b.f();
            } else {
                b.h();
            }
            this.p.a(view, i, view.getLayoutParams(), false);
        } else if (view.getParent() == this.q) {
            int c = this.p.c(view);
            if (i == -1) {
                i = this.p.a();
            }
            if (c == -1) {
                throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.q.indexOfChild(view));
            } else if (c != i) {
                eb ebVar = this.q.e;
                View d = ebVar.d(c);
                if (d == null) {
                    throw new IllegalArgumentException("Cannot move a child from non-existing index:" + c);
                }
                ebVar.h(c);
                ed edVar2 = (ed) d.getLayoutParams();
                eq b2 = RecyclerView.b(d);
                if (b2.m()) {
                    ebVar.q.d.b(b2);
                } else {
                    ebVar.q.d.c(b2);
                }
                ebVar.p.a(d, i, edVar2, b2.m());
            }
        } else {
            this.p.a(view, i, false);
            edVar.e = true;
            if (this.r != null && this.r.c) {
                el elVar = this.r;
                if (RecyclerView.c(view) == elVar.a) {
                    elVar.d = view;
                }
            }
        }
        if (edVar.f) {
            b.a.invalidate();
            edVar.f = false;
        }
    }

    public final void a(View view, Rect rect) {
        if (this.q == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(this.q.d(view));
        }
    }

    final void a(View view, f fVar) {
        eq b = RecyclerView.b(view);
        if (b != null && !b.m() && !this.p.d(b.a)) {
            a(this.q.a, this.q.o, view, fVar);
        }
    }

    public final void a(View view, eh ehVar) {
        bp bpVar = this.p;
        int a = bpVar.a.a(view);
        if (a >= 0) {
            if (bpVar.b.d(a)) {
                bpVar.b(view);
            }
            bpVar.a.a(a);
        }
        ehVar.a(view);
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        boolean z = true;
        eh ehVar = this.q.a;
        en enVar = this.q.o;
        ae a = a.a(accessibilityEvent);
        if (this.q != null) {
            if (!(bq.b(this.q, 1) || bq.b(this.q, -1) || bq.a(this.q, -1) || bq.a(this.q, 1))) {
                z = false;
            }
            a.a(z);
            if (this.q.y != null) {
                a.a(this.q.y.a());
            }
        }
    }

    public void a(String str) {
        if (this.q != null) {
            this.q.a(str);
        }
    }

    public boolean a(ed edVar) {
        return edVar != null;
    }

    final boolean a(View view, int i, int i2, ed edVar) {
        return (!view.isLayoutRequested() && this.v && b(view.getWidth(), i, edVar.width) && b(view.getHeight(), i2, edVar.height)) ? false : true;
    }

    public final boolean a(Runnable runnable) {
        return this.q != null ? this.q.removeCallbacks(runnable) : false;
    }

    public int b(int i, eh ehVar, en enVar) {
        return 0;
    }

    public int b(eh ehVar, en enVar) {
        return (this.q == null || this.q.y == null || !e()) ? 1 : this.q.y.a();
    }

    public int b(en enVar) {
        return 0;
    }

    public abstract ed b();

    public final View b(View view) {
        if (this.q == null) {
            return null;
        }
        View view2;
        ViewParent viewParent = this.q;
        ViewParent parent = view.getParent();
        View view3 = view;
        while (parent != null && parent != viewParent && (parent instanceof View)) {
            view2 = (View) parent;
            view3 = view2;
            parent = view2.getParent();
        }
        view2 = parent == viewParent ? view3 : null;
        return view2 == null ? null : this.p.d(view2) ? null : view2;
    }

    public void b(int i) {
    }

    public void b(int i, int i2) {
    }

    final void b(RecyclerView recyclerView) {
        e(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    final void b(RecyclerView recyclerView, eh ehVar) {
        this.t = false;
        a(recyclerView, ehVar);
    }

    final void b(eh ehVar) {
        int size = ehVar.a.size();
        for (int i = size - 1; i >= 0; i--) {
            View view = ((eq) ehVar.a.get(i)).a;
            eq b = RecyclerView.b(view);
            if (!b.b()) {
                b.a(false);
                if (b.n()) {
                    this.q.removeDetachedView(view, false);
                }
                if (this.q.m != null) {
                    this.q.m.c(b);
                }
                b.a(true);
                ehVar.b(view);
            }
        }
        ehVar.a.clear();
        if (ehVar.b != null) {
            ehVar.b.clear();
        }
        if (size > 0) {
            this.q.invalidate();
        }
    }

    public int c(en enVar) {
        return 0;
    }

    public void c(int i, int i2) {
    }

    public final void c(eh ehVar) {
        for (int l = l() - 1; l >= 0; l--) {
            if (!RecyclerView.b(d(l)).b()) {
                a(l, ehVar);
            }
        }
    }

    public void c(eh ehVar, en enVar) {
        Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }

    public boolean c() {
        return false;
    }

    public int d(en enVar) {
        return 0;
    }

    public Parcelable d() {
        return null;
    }

    public final View d(int i) {
        return this.p != null ? this.p.b(i) : null;
    }

    public void d(int i, int i2) {
    }

    public int e(en enVar) {
        return 0;
    }

    public void e(int i) {
        if (this.q != null) {
            RecyclerView recyclerView = this.q;
            int a = recyclerView.c.a();
            for (int i2 = 0; i2 < a; i2++) {
                recyclerView.c.b(i2).offsetLeftAndRight(i);
            }
        }
    }

    final void e(int i, int i2) {
        this.w = i;
        this.x = i2;
    }

    public boolean e() {
        return false;
    }

    public int f(en enVar) {
        return 0;
    }

    public void f(int i) {
        if (this.q != null) {
            RecyclerView recyclerView = this.q;
            int a = recyclerView.c.a();
            for (int i2 = 0; i2 < a; i2++) {
                recyclerView.c.b(i2).offsetTopAndBottom(i);
            }
        }
    }

    final void f(int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        int l = l();
        if (l == 0) {
            this.q.a(i, i2);
            return;
        }
        int i5 = 0;
        int i6 = Integer.MIN_VALUE;
        int i7 = Integer.MAX_VALUE;
        while (i5 < l) {
            View d = d(i5);
            ed edVar = (ed) d.getLayoutParams();
            int e = e(d) - edVar.leftMargin;
            int g = edVar.rightMargin + g(d);
            int f = f(d) - edVar.topMargin;
            int h = edVar.bottomMargin + h(d);
            if (e >= i7) {
                e = i7;
            }
            if (g <= i6) {
                g = i6;
            }
            if (f >= i3) {
                f = i3;
            }
            if (h <= i4) {
                h = i4;
            }
            i5++;
            i6 = g;
            i3 = f;
            i7 = e;
            i4 = h;
        }
        this.q.x.set(i7, i3, i6, i4);
        a(this.q.x, i, i2);
    }

    public boolean f() {
        return false;
    }

    public void g(int i) {
    }

    public final void g(int i, int i2) {
        this.q.a(i, i2);
    }

    public final void h(int i, int i2) {
        this.q.setMeasuredDimension(i, i2);
    }

    boolean i() {
        return false;
    }

    public final void j() {
        if (this.q != null) {
            this.q.requestLayout();
        }
    }

    public final boolean k() {
        return this.r != null && this.r.c;
    }

    public final int l() {
        return this.p != null ? this.p.a() : 0;
    }

    public final int m() {
        return this.q != null ? this.q.getPaddingLeft() : 0;
    }

    public final int n() {
        return this.q != null ? this.q.getPaddingTop() : 0;
    }

    public final int o() {
        return this.q != null ? this.q.getPaddingRight() : 0;
    }

    public final int p() {
        return this.q != null ? this.q.getPaddingBottom() : 0;
    }

    final void q() {
        if (this.r != null) {
            this.r.a();
        }
    }
}
