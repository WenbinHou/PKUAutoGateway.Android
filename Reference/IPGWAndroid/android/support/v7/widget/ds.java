package android.support.v7.widget;

import android.view.View;

final class ds implements ag {
    final /* synthetic */ RecyclerView a;

    ds(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    private void c(ah ahVar) {
        switch (ahVar.a) {
            case 1:
                this.a.e.a(ahVar.b, ahVar.d);
                return;
            case 2:
                this.a.e.b(ahVar.b, ahVar.d);
                return;
            case 4:
                this.a.e.c(ahVar.b, ahVar.d);
                return;
            case 8:
                this.a.e.d(ahVar.b, ahVar.d);
                return;
            default:
                return;
        }
    }

    public final eq a(int i) {
        eq b;
        RecyclerView recyclerView = this.a;
        int b2 = recyclerView.c.b();
        for (int i2 = 0; i2 < b2; i2++) {
            b = RecyclerView.b(recyclerView.c.c(i2));
            if (b != null && !b.m() && b.b == i) {
                break;
            }
        }
        b = null;
        return (b == null || this.a.c.d(b.a)) ? null : b;
    }

    public final void a(int i, int i2) {
        this.a.a(i, i2, true);
        this.a.p = true;
        en enVar = this.a.o;
        enVar.e += i2;
    }

    public final void a(int i, int i2, Object obj) {
        int i3;
        RecyclerView recyclerView = this.a;
        int b = recyclerView.c.b();
        int i4 = i + i2;
        for (i3 = 0; i3 < b; i3++) {
            View c = recyclerView.c.c(i3);
            eq b2 = RecyclerView.b(c);
            if (b2 != null && !b2.b() && b2.b >= i && b2.b < i4) {
                b2.b(2);
                b2.a(obj);
                ((ed) c.getLayoutParams()).e = true;
            }
        }
        eh ehVar = recyclerView.a;
        b = i + i2;
        for (i3 = ehVar.c.size() - 1; i3 >= 0; i3--) {
            eq eqVar = (eq) ehVar.c.get(i3);
            if (eqVar != null) {
                i4 = eqVar.c();
                if (i4 >= i && i4 < b) {
                    eqVar.b(2);
                    ehVar.c(i3);
                }
            }
        }
        this.a.q = true;
    }

    public final void a(ah ahVar) {
        c(ahVar);
    }

    public final void b(int i, int i2) {
        this.a.a(i, i2, false);
        this.a.p = true;
    }

    public final void b(ah ahVar) {
        c(ahVar);
    }

    public final void c(int i, int i2) {
        int i3;
        RecyclerView recyclerView = this.a;
        int b = recyclerView.c.b();
        for (i3 = 0; i3 < b; i3++) {
            eq b2 = RecyclerView.b(recyclerView.c.c(i3));
            if (!(b2 == null || b2.b() || b2.b < i)) {
                b2.a(i2, false);
                recyclerView.o.f = true;
            }
        }
        eh ehVar = recyclerView.a;
        int size = ehVar.c.size();
        for (i3 = 0; i3 < size; i3++) {
            eq eqVar = (eq) ehVar.c.get(i3);
            if (eqVar != null && eqVar.b >= i) {
                eqVar.a(i2, true);
            }
        }
        recyclerView.requestLayout();
        this.a.p = true;
    }

    public final void d(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = -1;
        RecyclerView recyclerView = this.a;
        int b = recyclerView.c.b();
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (i6 = 0; i6 < b; i6++) {
            eq b2 = RecyclerView.b(recyclerView.c.c(i6));
            if (b2 != null && b2.b >= r4 && b2.b <= r3) {
                if (b2.b == i) {
                    b2.a(i2 - i, false);
                } else {
                    b2.a(i3, false);
                }
                recyclerView.o.f = true;
            }
        }
        eh ehVar = recyclerView.a;
        if (i < i2) {
            i4 = i2;
            i5 = i;
        } else {
            i7 = 1;
            i4 = i;
            i5 = i2;
        }
        int size = ehVar.c.size();
        for (i6 = 0; i6 < size; i6++) {
            eq eqVar = (eq) ehVar.c.get(i6);
            if (eqVar != null && eqVar.b >= r4 && eqVar.b <= r3) {
                if (eqVar.b == i) {
                    eqVar.a(i2 - i, false);
                } else {
                    eqVar.a(i7, false);
                }
            }
        }
        recyclerView.requestLayout();
        this.a.p = true;
    }
}
