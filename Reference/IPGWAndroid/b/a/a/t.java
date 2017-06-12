package b.a.a;

import c.w;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.List;

public final class t {
    static final /* synthetic */ boolean j = (!t.class.desiredAssertionStatus());
    long a = 0;
    long b;
    final int c;
    final e d;
    List<x> e;
    public final v f;
    final u g;
    public final w h = new w(this);
    public final w i = new w(this);
    private final List<x> k;
    private a l = null;

    t(int i, e eVar, boolean z, boolean z2, List<x> list) {
        if (eVar == null) {
            throw new NullPointerException("connection == null");
        } else if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        } else {
            this.c = i;
            this.d = eVar;
            this.b = (long) eVar.f.b();
            this.f = new v(this, (long) eVar.e.b());
            this.g = new u(this);
            this.f.g = z2;
            this.g.e = z;
            this.k = list;
        }
    }

    private boolean d(a aVar) {
        if (j || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.l != null) {
                    return false;
                } else if (this.f.g && this.g.e) {
                    return false;
                } else {
                    this.l = aVar;
                    notifyAll();
                    this.d.b(this.c);
                    return true;
                }
            }
        }
        throw new AssertionError();
    }

    private void f() {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
    }

    static /* synthetic */ void f(t tVar) {
        if (j || !Thread.holdsLock(tVar)) {
            Object obj;
            boolean a;
            synchronized (tVar) {
                obj = (!tVar.f.g && tVar.f.f && (tVar.g.e || tVar.g.d)) ? 1 : null;
                a = tVar.a();
            }
            if (obj != null) {
                tVar.a(a.CANCEL);
                return;
            } else if (!a) {
                tVar.d.b(tVar.c);
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    static /* synthetic */ void h(t tVar) {
        if (tVar.g.d) {
            throw new IOException("stream closed");
        } else if (tVar.g.e) {
            throw new IOException("stream finished");
        } else if (tVar.l != null) {
            throw new IOException("stream was reset: " + tVar.l);
        }
    }

    final void a(long j) {
        this.b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public final void a(a aVar) {
        if (d(aVar)) {
            this.d.b(this.c, aVar);
        }
    }

    public final synchronized boolean a() {
        boolean z = false;
        synchronized (this) {
            if (this.l == null) {
                if (!(this.f.g || this.f.f) || (!(this.g.e || this.g.d) || this.e == null)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final void b(a aVar) {
        if (d(aVar)) {
            this.d.a(this.c, aVar);
        }
    }

    public final boolean b() {
        return this.d.b == ((this.c & 1) == 1);
    }

    public final synchronized List<x> c() {
        this.h.b_();
        while (this.e == null && this.l == null) {
            try {
                f();
            } catch (Throwable th) {
                this.h.b();
            }
        }
        this.h.b();
        if (this.e != null) {
        } else {
            throw new IOException("stream was reset: " + this.l);
        }
        return this.e;
    }

    final synchronized void c(a aVar) {
        if (this.l == null) {
            this.l = aVar;
            notifyAll();
        }
    }

    public final w d() {
        synchronized (this) {
            if (this.e != null || b()) {
            } else {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.g;
    }

    final void e() {
        if (j || !Thread.holdsLock(this)) {
            boolean a;
            synchronized (this) {
                this.f.g = true;
                a = a();
                notifyAll();
            }
            if (!a) {
                this.d.b(this.c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }
}
