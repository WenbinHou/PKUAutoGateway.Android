package android.support.v7.widget;

import android.support.v4.a.a;
import android.support.v4.view.bq;
import android.support.v4.view.dk;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bv extends fe {
    ArrayList<ArrayList<eq>> a = new ArrayList();
    ArrayList<ArrayList<cf>> b = new ArrayList();
    ArrayList<ArrayList<ce>> c = new ArrayList();
    ArrayList<eq> d = new ArrayList();
    ArrayList<eq> e = new ArrayList();
    ArrayList<eq> f = new ArrayList();
    ArrayList<eq> g = new ArrayList();
    private ArrayList<eq> n = new ArrayList();
    private ArrayList<eq> o = new ArrayList();
    private ArrayList<cf> p = new ArrayList();
    private ArrayList<ce> q = new ArrayList();

    private void a(ce ceVar) {
        if (ceVar.a != null) {
            a(ceVar, ceVar.a);
        }
        if (ceVar.b != null) {
            a(ceVar, ceVar.b);
        }
    }

    private static void a(List<eq> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            bq.r(((eq) list.get(size)).a).a();
        }
    }

    private void a(List<ce> list, eq eqVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ce ceVar = (ce) list.get(size);
            if (a(ceVar, eqVar) && ceVar.a == null && ceVar.b == null) {
                list.remove(ceVar);
            }
        }
    }

    private boolean a(ce ceVar, eq eqVar) {
        if (ceVar.b == eqVar) {
            ceVar.b = null;
        } else if (ceVar.a != eqVar) {
            return false;
        } else {
            ceVar.a = null;
        }
        bq.c(eqVar.a, 1.0f);
        bq.a(eqVar.a, 0.0f);
        bq.b(eqVar.a, 0.0f);
        e(eqVar);
        return true;
    }

    private void g(eq eqVar) {
        a.a(eqVar.a);
        c(eqVar);
    }

    public final void a() {
        int i = !this.n.isEmpty() ? 1 : 0;
        int i2 = !this.p.isEmpty() ? 1 : 0;
        int i3 = !this.q.isEmpty() ? 1 : 0;
        int i4 = !this.o.isEmpty() ? 1 : 0;
        if (i != 0 || i2 != 0 || i4 != 0 || i3 != 0) {
            ArrayList arrayList;
            Runnable bwVar;
            Iterator it = this.n.iterator();
            while (it.hasNext()) {
                eq eqVar = (eq) it.next();
                dk r = bq.r(eqVar.a);
                this.f.add(eqVar);
                r.a(this.j).a(0.0f).a(new bz(this, eqVar, r)).b();
            }
            this.n.clear();
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.p);
                this.b.add(arrayList);
                this.p.clear();
                bwVar = new bw(this, arrayList);
                if (i != 0) {
                    bq.a(((cf) arrayList.get(0)).a.a, bwVar, this.j);
                } else {
                    bwVar.run();
                }
            }
            if (i3 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.q);
                this.c.add(arrayList);
                this.q.clear();
                bwVar = new bx(this, arrayList);
                if (i != 0) {
                    bq.a(((ce) arrayList.get(0)).a.a, bwVar, this.j);
                } else {
                    bwVar.run();
                }
            }
            if (i4 != 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.o);
                this.a.add(arrayList2);
                this.o.clear();
                Runnable byVar = new by(this, arrayList2);
                if (i == 0 && i2 == 0 && i3 == 0) {
                    byVar.run();
                } else {
                    bq.a(((eq) arrayList2.get(0)).a, byVar, (i != 0 ? this.j : 0) + Math.max(i2 != 0 ? this.k : 0, i3 != 0 ? this.l : 0));
                }
            }
        }
    }

    public final boolean a(eq eqVar) {
        g(eqVar);
        this.n.add(eqVar);
        return true;
    }

    public final boolean a(eq eqVar, int i, int i2, int i3, int i4) {
        View view = eqVar.a;
        int n = (int) (((float) i) + bq.n(eqVar.a));
        int o = (int) (((float) i2) + bq.o(eqVar.a));
        g(eqVar);
        int i5 = i3 - n;
        int i6 = i4 - o;
        if (i5 == 0 && i6 == 0) {
            e(eqVar);
            return false;
        }
        if (i5 != 0) {
            bq.a(view, (float) (-i5));
        }
        if (i6 != 0) {
            bq.b(view, (float) (-i6));
        }
        this.p.add(new cf(eqVar, n, o, i3, i4));
        return true;
    }

    public final boolean a(eq eqVar, eq eqVar2, int i, int i2, int i3, int i4) {
        if (eqVar == eqVar2) {
            return a(eqVar, i, i2, i3, i4);
        }
        float n = bq.n(eqVar.a);
        float o = bq.o(eqVar.a);
        float f = bq.f(eqVar.a);
        g(eqVar);
        int i5 = (int) (((float) (i3 - i)) - n);
        int i6 = (int) (((float) (i4 - i2)) - o);
        bq.a(eqVar.a, n);
        bq.b(eqVar.a, o);
        bq.c(eqVar.a, f);
        if (eqVar2 != null) {
            g(eqVar2);
            bq.a(eqVar2.a, (float) (-i5));
            bq.b(eqVar2.a, (float) (-i6));
            bq.c(eqVar2.a, 0.0f);
        }
        this.q.add(new ce(eqVar, eqVar2, i, i2, i3, i4));
        return true;
    }

    public final boolean a(eq eqVar, List<Object> list) {
        return !list.isEmpty() || super.a(eqVar, list);
    }

    public final boolean b() {
        return (this.o.isEmpty() && this.q.isEmpty() && this.p.isEmpty() && this.n.isEmpty() && this.e.isEmpty() && this.f.isEmpty() && this.d.isEmpty() && this.g.isEmpty() && this.b.isEmpty() && this.a.isEmpty() && this.c.isEmpty()) ? false : true;
    }

    public final boolean b(eq eqVar) {
        g(eqVar);
        bq.c(eqVar.a, 0.0f);
        this.o.add(eqVar);
        return true;
    }

    final void c() {
        if (!b()) {
            e();
        }
    }

    public final void c(eq eqVar) {
        int size;
        View view = eqVar.a;
        bq.r(view).a();
        for (size = this.p.size() - 1; size >= 0; size--) {
            if (((cf) this.p.get(size)).a == eqVar) {
                bq.b(view, 0.0f);
                bq.a(view, 0.0f);
                e(eqVar);
                this.p.remove(size);
            }
        }
        a(this.q, eqVar);
        if (this.n.remove(eqVar)) {
            bq.c(view, 1.0f);
            e(eqVar);
        }
        if (this.o.remove(eqVar)) {
            bq.c(view, 1.0f);
            e(eqVar);
        }
        for (size = this.c.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.c.get(size);
            a(list, eqVar);
            if (list.isEmpty()) {
                this.c.remove(size);
            }
        }
        for (int size2 = this.b.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.b.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((cf) arrayList.get(size3)).a == eqVar) {
                    bq.b(view, 0.0f);
                    bq.a(view, 0.0f);
                    e(eqVar);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.b.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.a.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.a.get(size);
            if (arrayList.remove(eqVar)) {
                bq.c(view, 1.0f);
                e(eqVar);
                if (arrayList.isEmpty()) {
                    this.a.remove(size);
                }
            }
        }
        this.f.remove(eqVar);
        this.d.remove(eqVar);
        this.g.remove(eqVar);
        this.e.remove(eqVar);
        c();
    }

    public final void d() {
        int size;
        for (size = this.p.size() - 1; size >= 0; size--) {
            cf cfVar = (cf) this.p.get(size);
            View view = cfVar.a.a;
            bq.b(view, 0.0f);
            bq.a(view, 0.0f);
            e(cfVar.a);
            this.p.remove(size);
        }
        for (size = this.n.size() - 1; size >= 0; size--) {
            e((eq) this.n.get(size));
            this.n.remove(size);
        }
        for (size = this.o.size() - 1; size >= 0; size--) {
            eq eqVar = (eq) this.o.get(size);
            bq.c(eqVar.a, 1.0f);
            e(eqVar);
            this.o.remove(size);
        }
        for (size = this.q.size() - 1; size >= 0; size--) {
            a((ce) this.q.get(size));
        }
        this.q.clear();
        if (b()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.b.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.b.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    cf cfVar2 = (cf) arrayList.get(size3);
                    View view2 = cfVar2.a.a;
                    bq.b(view2, 0.0f);
                    bq.a(view2, 0.0f);
                    e(cfVar2.a);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.b.remove(arrayList);
                    }
                }
            }
            for (size2 = this.a.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.a.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    eq eqVar2 = (eq) arrayList.get(size3);
                    bq.c(eqVar2.a, 1.0f);
                    e(eqVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.a.remove(arrayList);
                    }
                }
            }
            for (size2 = this.c.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.c.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    a((ce) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.c.remove(arrayList);
                    }
                }
            }
            a(this.f);
            a(this.e);
            a(this.d);
            a(this.g);
            e();
        }
    }
}
