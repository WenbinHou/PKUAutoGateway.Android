package android.support.v7.widget;

import android.support.v4.g.a;
import android.support.v4.g.f;

final class ge {
    final a<eq, gf> a = new a();
    final f<eq> b = new f();

    ge() {
    }

    final dz a(eq eqVar, int i) {
        dz dzVar = null;
        int a = this.a.a((Object) eqVar);
        if (a >= 0) {
            gf gfVar = (gf) this.a.c(a);
            if (!(gfVar == null || (gfVar.a & i) == 0)) {
                gfVar.a &= i ^ -1;
                if (i == 4) {
                    dzVar = gfVar.b;
                } else if (i == 8) {
                    dzVar = gfVar.c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((gfVar.a & 12) == 0) {
                    this.a.d(a);
                    gf.a(gfVar);
                }
            }
        }
        return dzVar;
    }

    final void a() {
        this.a.clear();
        f fVar = this.b;
        int i = fVar.e;
        Object[] objArr = fVar.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        fVar.e = 0;
        fVar.b = false;
    }

    final void a(long j, eq eqVar) {
        this.b.a(j, eqVar);
    }

    final void a(eq eqVar, dz dzVar) {
        gf gfVar = (gf) this.a.get(eqVar);
        if (gfVar == null) {
            gfVar = gf.a();
            this.a.put(eqVar, gfVar);
        }
        gfVar.b = dzVar;
        gfVar.a |= 4;
    }

    final void a(gg ggVar) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            eq eqVar = (eq) this.a.b(size);
            gf gfVar = (gf) this.a.d(size);
            if ((gfVar.a & 3) == 3) {
                ggVar.a(eqVar);
            } else if ((gfVar.a & 1) != 0) {
                if (gfVar.b == null) {
                    ggVar.a(eqVar);
                } else {
                    ggVar.a(eqVar, gfVar.b, gfVar.c);
                }
            } else if ((gfVar.a & 14) == 14) {
                ggVar.b(eqVar, gfVar.b, gfVar.c);
            } else if ((gfVar.a & 12) == 12) {
                ggVar.c(eqVar, gfVar.b, gfVar.c);
            } else if ((gfVar.a & 4) != 0) {
                ggVar.a(eqVar, gfVar.b, null);
            } else if ((gfVar.a & 8) != 0) {
                ggVar.b(eqVar, gfVar.b, gfVar.c);
            } else {
                int i = gfVar.a;
            }
            gf.a(gfVar);
        }
    }

    final boolean a(eq eqVar) {
        gf gfVar = (gf) this.a.get(eqVar);
        return (gfVar == null || (gfVar.a & 1) == 0) ? false : true;
    }

    final void b(eq eqVar) {
        gf gfVar = (gf) this.a.get(eqVar);
        if (gfVar == null) {
            gfVar = gf.a();
            this.a.put(eqVar, gfVar);
        }
        r0.a |= 1;
    }

    final void b(eq eqVar, dz dzVar) {
        gf gfVar = (gf) this.a.get(eqVar);
        if (gfVar == null) {
            gfVar = gf.a();
            this.a.put(eqVar, gfVar);
        }
        gfVar.c = dzVar;
        gfVar.a |= 8;
    }

    final void c(eq eqVar) {
        gf gfVar = (gf) this.a.get(eqVar);
        if (gfVar != null) {
            gfVar.a &= -2;
        }
    }

    final void d(eq eqVar) {
        gf gfVar;
        for (int a = this.b.a() - 1; a >= 0; a--) {
            if (eqVar == this.b.a(a)) {
                f fVar = this.b;
                if (fVar.d[a] != f.a) {
                    fVar.d[a] = f.a;
                    fVar.b = true;
                }
                gfVar = (gf) this.a.remove(eqVar);
                if (gfVar != null) {
                    gf.a(gfVar);
                }
            }
        }
        gfVar = (gf) this.a.remove(eqVar);
        if (gfVar != null) {
            gf.a(gfVar);
        }
    }
}
