package b.a;

import b.a.c.a;
import c.g;
import c.w;
import java.io.Closeable;
import java.io.Flushable;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

public final class b implements Closeable, Flushable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    static final /* synthetic */ boolean b = (!b.class.desiredAssertionStatus());
    private static final w o = new c();
    private final a c;
    private long d;
    private final int e;
    private long f;
    private g g;
    private final LinkedHashMap<String, e> h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private final Executor m;
    private final Runnable n;

    private synchronized void a(d dVar) {
        e eVar = dVar.a;
        if (eVar.f != dVar) {
            throw new IllegalStateException();
        }
        for (int i = 0; i < this.e; i++) {
            this.c.a(eVar.d[i]);
        }
        this.i++;
        eVar.f = null;
        if ((eVar.e | 0) != 0) {
            eVar.e = true;
            this.g.b("CLEAN").h(32);
            this.g.b(eVar.a);
            eVar.a(this.g);
            this.g.h(10);
        } else {
            this.h.remove(eVar.a);
            this.g.b("REMOVE").h(32);
            this.g.b(eVar.a);
            this.g.h(10);
        }
        this.g.flush();
        if (this.f > this.d || a()) {
            this.m.execute(this.n);
        }
    }

    private boolean a() {
        return this.i >= 2000 && this.i >= this.h.size();
    }

    private synchronized boolean b() {
        return this.k;
    }

    private synchronized void c() {
        if (b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void d() {
        while (this.f > this.d) {
            e eVar = (e) this.h.values().iterator().next();
            if (eVar.f != null) {
                eVar.f.b = true;
            }
            for (int i = 0; i < this.e; i++) {
                this.c.a(eVar.c[i]);
                this.f -= eVar.b[i];
                eVar.b[i] = 0;
            }
            this.i++;
            this.g.b("REMOVE").h(32).b(eVar.a).h(10);
            this.h.remove(eVar.a);
            if (a()) {
                this.m.execute(this.n);
            }
        }
        this.l = false;
    }

    public final synchronized void close() {
        if (!this.j || this.k) {
            this.k = true;
        } else {
            for (e eVar : (e[]) this.h.values().toArray(new e[this.h.size()])) {
                if (eVar.f != null) {
                    d dVar = eVar.f;
                    synchronized (dVar.c) {
                        dVar.c.a(dVar);
                    }
                }
            }
            d();
            this.g.close();
            this.g = null;
            this.k = true;
        }
    }

    public final synchronized void flush() {
        if (this.j) {
            c();
            d();
            this.g.flush();
        }
    }
}
