package android.support.v7.widget;

import android.support.v4.e.e;
import android.support.v4.view.bq;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class eh {
    final ArrayList<eq> a = new ArrayList();
    ArrayList<eq> b = null;
    final ArrayList<eq> c = new ArrayList();
    final List<eq> d = Collections.unmodifiableList(this.a);
    int e = 2;
    eg f;
    eo g;
    final /* synthetic */ RecyclerView h;

    public eh(RecyclerView recyclerView) {
        this.h = recyclerView;
    }

    private void a(ViewGroup viewGroup, boolean z) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, true);
            }
        }
        if (!z) {
            return;
        }
        if (viewGroup.getVisibility() == 4) {
            viewGroup.setVisibility(0);
            viewGroup.setVisibility(4);
            return;
        }
        int visibility = viewGroup.getVisibility();
        viewGroup.setVisibility(4);
        viewGroup.setVisibility(visibility);
    }

    private void c(eq eqVar) {
        bq.a(eqVar.a, null);
        if (this.h.z != null) {
            this.h.z;
        }
        if (this.h.y != null) {
            this.h.y;
        }
        if (this.h.o != null) {
            this.h.d.d(eqVar);
        }
        eqVar.k = null;
        eg c = c();
        int i = eqVar.e;
        ArrayList arrayList = (ArrayList) c.a.get(i);
        if (arrayList == null) {
            arrayList = new ArrayList();
            c.a.put(i, arrayList);
            if (c.b.indexOfKey(i) < 0) {
                c.b.put(i, 5);
            }
        }
        if (c.b.get(i) > arrayList.size()) {
            eqVar.q();
            arrayList.add(eqVar);
        }
    }

    private eq d() {
        int size;
        for (size = this.a.size() - 1; size >= 0; size--) {
            eq eqVar = (eq) this.a.get(size);
            if (eqVar.d == -1 && !eqVar.g()) {
                if (eqVar.e == 0) {
                    eqVar.b(32);
                    if (!eqVar.m() || this.h.o.g) {
                        return eqVar;
                    }
                    eqVar.a(2, 14);
                    return eqVar;
                }
                this.a.remove(size);
                this.h.removeDetachedView(eqVar.a, false);
                b(eqVar.a);
            }
        }
        for (size = this.c.size() - 1; size >= 0; size--) {
            eqVar = (eq) this.c.get(size);
            if (eqVar.d == -1) {
                if (eqVar.e == 0) {
                    this.c.remove(size);
                    return eqVar;
                }
                c(size);
            }
        }
        return null;
    }

    private eq d(int i) {
        int i2 = 0;
        if (this.b != null) {
            int size = this.b.size();
            if (size != 0) {
                eq eqVar;
                int i3 = 0;
                while (i3 < size) {
                    eqVar = (eq) this.b.get(i3);
                    if (eqVar.g() || eqVar.c() != i) {
                        i3++;
                    } else {
                        eqVar.b(32);
                        return eqVar;
                    }
                }
                if (this.h.y.b) {
                    int a = this.h.b.a(i, 0);
                    if (a > 0 && a < this.h.y.a()) {
                        this.h.y;
                        while (i2 < size) {
                            eqVar = (eq) this.b.get(i2);
                            if (eqVar.g() || eqVar.d != -1) {
                                i2++;
                            } else {
                                eqVar.b(32);
                                return eqVar;
                            }
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }

    private eq e(int i) {
        View view;
        int i2 = 0;
        int size = this.a.size();
        int i3 = 0;
        while (i3 < size) {
            eq eqVar = (eq) this.a.get(i3);
            if (eqVar.g() || eqVar.c() != i || eqVar.j() || (!this.h.o.g && eqVar.m())) {
                i3++;
            } else {
                eqVar.b(32);
                return eqVar;
            }
        }
        bp bpVar = this.h.c;
        int size2 = bpVar.c.size();
        for (i3 = 0; i3 < size2; i3++) {
            View view2 = (View) bpVar.c.get(i3);
            eq b = bpVar.a.b(view2);
            if (b.c() == i && !b.j() && !b.m()) {
                view = view2;
                break;
            }
        }
        view = null;
        if (view != null) {
            eqVar = RecyclerView.b(view);
            bp bpVar2 = this.h.c;
            i2 = bpVar2.a.a(view);
            if (i2 < 0) {
                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
            } else if (bpVar2.b.c(i2)) {
                bpVar2.b.b(i2);
                bpVar2.b(view);
                int c = this.h.c.c(view);
                if (c == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + eqVar);
                }
                this.h.c.d(c);
                c(view);
                eqVar.b(8224);
                return eqVar;
            } else {
                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
            }
        }
        i3 = this.c.size();
        while (i2 < i3) {
            eqVar = (eq) this.c.get(i2);
            if (eqVar.j() || eqVar.c() != i) {
                i2++;
            } else {
                this.c.remove(i2);
                return eqVar;
            }
        }
        return null;
    }

    public final int a(int i) {
        if (i >= 0 && i < this.h.o.a()) {
            return !this.h.o.g ? i : this.h.b.b(i);
        } else {
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + this.h.o.a());
        }
    }

    public final void a() {
        this.a.clear();
        b();
    }

    final void a(eq eqVar) {
        boolean z = true;
        int i = 0;
        if (eqVar.e() || eqVar.a.getParent() != null) {
            StringBuilder append = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(eqVar.e()).append(" isAttached:");
            if (eqVar.a.getParent() == null) {
                z = false;
            }
            throw new IllegalArgumentException(append.append(z).toString());
        } else if (eqVar.n()) {
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + eqVar);
        } else if (eqVar.b()) {
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        } else {
            boolean c = eq.c(eqVar);
            if (this.h.y != null && c) {
                this.h.y;
            }
            if (eqVar.r()) {
                boolean z2;
                if (!eqVar.a(14)) {
                    int size = this.c.size();
                    if (size == this.e && size > 0) {
                        c(0);
                    }
                    if (size < this.e) {
                        this.c.add(eqVar);
                        z2 = true;
                        if (z2) {
                            c(eqVar);
                            i = 1;
                            z = z2;
                        } else {
                            z = z2;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    z = z2;
                } else {
                    c(eqVar);
                    i = 1;
                    z = z2;
                }
            } else {
                z = false;
            }
            this.h.d.d(eqVar);
            if (!z && r1 == 0 && c) {
                eqVar.k = null;
            }
        }
    }

    public final void a(View view) {
        eq b = RecyclerView.b(view);
        if (b.n()) {
            this.h.removeDetachedView(view, false);
        }
        if (b.e()) {
            b.f();
        } else if (b.g()) {
            b.h();
        }
        a(b);
    }

    public final View b(int i) {
        boolean z = true;
        if (i < 0 || i >= this.h.o.a()) {
            throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.h.o.a());
        }
        boolean z2;
        eq eqVar;
        boolean z3;
        int i2;
        boolean z4;
        eq eqVar2;
        ed edVar;
        if (this.h.o.g) {
            eq d = d(i);
            eq eqVar3 = d;
            z2 = d != null;
            eqVar = eqVar3;
        } else {
            eqVar = null;
            z2 = false;
        }
        if (eqVar == null) {
            eqVar = e(i);
            if (eqVar != null) {
                if (eqVar.m()) {
                    z3 = this.h.o.g;
                } else if (eqVar.b < 0 || eqVar.b >= this.h.y.a()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + eqVar);
                } else {
                    if (!this.h.o.g) {
                        this.h.y;
                        i2 = eqVar.b;
                        if (eqVar.e != 0) {
                            z3 = false;
                        }
                    }
                    if (this.h.y.b) {
                        long j = eqVar.d;
                        this.h.y;
                        i2 = eqVar.b;
                        if (j != -1) {
                            z3 = false;
                        }
                    }
                    z3 = true;
                }
                if (z3) {
                    z2 = true;
                } else {
                    eqVar.b(4);
                    if (eqVar.e()) {
                        this.h.removeDetachedView(eqVar.a, false);
                        eqVar.f();
                    } else if (eqVar.g()) {
                        eqVar.h();
                    }
                    a(eqVar);
                    eqVar = null;
                }
            }
        }
        if (eqVar == null) {
            i2 = this.h.b.b(i);
            if (i2 < 0 || i2 >= this.h.y.a()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + i2 + ").state:" + this.h.o.a());
            }
            View a;
            ArrayList arrayList;
            dt h;
            ViewGroup viewGroup;
            this.h.y;
            if (this.h.y.b) {
                this.h.y;
                eqVar = d();
                if (eqVar != null) {
                    eqVar.b = i2;
                    z3 = true;
                    if (eqVar == null && this.g != null) {
                        a = this.g.a();
                        if (a != null) {
                            eqVar = this.h.a(a);
                            if (eqVar == null) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                            } else if (eqVar.b()) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                            }
                        }
                    }
                    if (eqVar == null) {
                        arrayList = (ArrayList) c().a.get(0);
                        if (arrayList != null || arrayList.isEmpty()) {
                            d = null;
                        } else {
                            int size = arrayList.size() - 1;
                            d = (eq) arrayList.get(size);
                            arrayList.remove(size);
                        }
                        if (d != null) {
                            d.q();
                            if (RecyclerView.r && (d.a instanceof ViewGroup)) {
                                a((ViewGroup) d.a, false);
                            }
                        }
                        eqVar = d;
                    }
                    if (eqVar != null) {
                        h = this.h.y;
                        viewGroup = this.h;
                        e.a("RV CreateView");
                        eqVar = h.a(viewGroup);
                        eqVar.e = 0;
                        e.a();
                        z4 = z3;
                        eqVar2 = eqVar;
                    } else {
                        z4 = z3;
                        eqVar2 = eqVar;
                    }
                }
            }
            z3 = z2;
            a = this.g.a();
            if (a != null) {
                eqVar = this.h.a(a);
                if (eqVar == null) {
                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                } else if (eqVar.b()) {
                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                }
            }
            if (eqVar == null) {
                arrayList = (ArrayList) c().a.get(0);
                if (arrayList != null) {
                }
                d = null;
                if (d != null) {
                    d.q();
                    a((ViewGroup) d.a, false);
                }
                eqVar = d;
            }
            if (eqVar != null) {
                z4 = z3;
                eqVar2 = eqVar;
            } else {
                h = this.h.y;
                viewGroup = this.h;
                e.a("RV CreateView");
                eqVar = h.a(viewGroup);
                eqVar.e = 0;
                e.a();
                z4 = z3;
                eqVar2 = eqVar;
            }
        } else {
            eqVar2 = eqVar;
            z4 = z2;
        }
        if (z4 && !this.h.o.g && eqVar2.a(8192)) {
            eqVar2.a(0, 8192);
            if (this.h.o.h) {
                dx.d(eqVar2);
                dx dxVar = this.h.m;
                en enVar = this.h.o;
                eqVar2.p();
                this.h.a(eqVar2, new dz().a(eqVar2));
            }
        }
        int i3;
        if (this.h.o.g && eqVar2.l()) {
            eqVar2.f = i;
            i3 = 0;
        } else if (!eqVar2.l() || eqVar2.k() || eqVar2.j()) {
            int b = this.h.b.b(i);
            eqVar2.k = this.h;
            dt h2 = this.h.y;
            eqVar2.b = b;
            if (h2.b) {
                eqVar2.d = -1;
            }
            eqVar2.a(1, 519);
            e.a("RV OnBindView");
            eqVar2.p();
            h2.a(eqVar2, b);
            eqVar2.o();
            e.a();
            View view = eqVar2.a;
            if (this.h.f()) {
                if (bq.e(view) == 0) {
                    bq.c(view, 1);
                }
                if (!bq.b(view)) {
                    bq.a(view, this.h.ag.c);
                }
            }
            if (this.h.o.g) {
                eqVar2.f = i;
            }
            z2 = true;
        } else {
            i3 = 0;
        }
        LayoutParams layoutParams = eqVar2.a.getLayoutParams();
        if (layoutParams == null) {
            edVar = (ed) this.h.generateDefaultLayoutParams();
            eqVar2.a.setLayoutParams(edVar);
        } else if (this.h.checkLayoutParams(layoutParams)) {
            edVar = (ed) layoutParams;
        } else {
            edVar = (ed) this.h.generateLayoutParams(layoutParams);
            eqVar2.a.setLayoutParams(edVar);
        }
        edVar.c = eqVar2;
        if (!z4 || r1 == 0) {
            z = false;
        }
        edVar.f = z;
        return eqVar2.a;
    }

    final void b() {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            c(size);
        }
        this.c.clear();
    }

    final void b(eq eqVar) {
        if (eqVar.p) {
            this.b.remove(eqVar);
        } else {
            this.a.remove(eqVar);
        }
        eqVar.o = null;
        eqVar.p = false;
        eqVar.h();
    }

    final void b(View view) {
        eq b = RecyclerView.b(view);
        b.o = null;
        b.p = false;
        b.h();
        a(b);
    }

    final eg c() {
        if (this.f == null) {
            this.f = new eg();
        }
        return this.f;
    }

    final void c(int i) {
        c((eq) this.c.get(i));
        this.c.remove(i);
    }

    final void c(View view) {
        eq b = RecyclerView.b(view);
        if (!b.a(12) && b.s() && !RecyclerView.a(this.h, b)) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            b.a(this, true);
            this.b.add(b);
        } else if (!b.j() || b.m() || this.h.y.b) {
            b.a(this, false);
            this.a.add(b);
        } else {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        }
    }
}
