package android.support.v7.widget;

import android.support.v4.g.o;
import android.support.v4.g.p;

final class gf {
    static o<gf> d = new p(20);
    int a;
    dz b;
    dz c;

    private gf() {
    }

    static gf a() {
        gf gfVar = (gf) d.a();
        return gfVar == null ? new gf() : gfVar;
    }

    static void a(gf gfVar) {
        gfVar.a = 0;
        gfVar.b = null;
        gfVar.c = null;
        d.a(gfVar);
    }

    static void b() {
        do {
        } while (d.a() != null);
    }
}
