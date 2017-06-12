package android.support.v7.widget;

import java.util.ArrayList;
import java.util.List;

public abstract class dx {
    private ArrayList<Object> a = new ArrayList();
    dy h = null;
    long i = 120;
    long j = 120;
    long k = 250;
    long l = 250;

    static int d(eq eqVar) {
        int h = eqVar.l & 14;
        if (eqVar.j()) {
            return 4;
        }
        if ((h & 4) != 0) {
            return h;
        }
        int i = eqVar.c;
        int d = eqVar.d();
        return (i == -1 || d == -1 || i == d) ? h : h | 2048;
    }

    public abstract void a();

    public abstract boolean a(eq eqVar, dz dzVar, dz dzVar2);

    public abstract boolean a(eq eqVar, eq eqVar2, dz dzVar, dz dzVar2);

    public boolean a(eq eqVar, List<Object> list) {
        return f(eqVar);
    }

    public abstract boolean b();

    public abstract boolean b(eq eqVar, dz dzVar, dz dzVar2);

    public abstract void c(eq eqVar);

    public abstract boolean c(eq eqVar, dz dzVar, dz dzVar2);

    public abstract void d();

    public final void e() {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            this.a.get(i);
        }
        this.a.clear();
    }

    public final void e(eq eqVar) {
        if (this.h != null) {
            this.h.a(eqVar);
        }
    }

    public boolean f(eq eqVar) {
        return true;
    }
}
