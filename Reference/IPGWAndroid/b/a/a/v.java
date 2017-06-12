package b.a.a;

import c.f;
import c.h;
import c.x;
import c.y;
import java.io.EOFException;
import java.io.IOException;

final class v implements x {
    static final /* synthetic */ boolean a = (!t.class.desiredAssertionStatus());
    final /* synthetic */ t b;
    private final f c;
    private final f d;
    private final long e;
    private boolean f;
    private boolean g;

    private v(t tVar, long j) {
        this.b = tVar;
        this.c = new f();
        this.d = new f();
        this.e = j;
    }

    private void b() {
        this.b.h.b_();
        while (this.d.b == 0 && !this.g && !this.f && this.b.l == null) {
            try {
                this.b.f();
            } catch (Throwable th) {
                this.b.h.b();
            }
        }
        this.b.h.b();
    }

    public final long a(f fVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        long j2;
        synchronized (this.b) {
            b();
            if (this.f) {
                throw new IOException("stream closed");
            } else if (this.b.l != null) {
                throw new IOException("stream was reset: " + this.b.l);
            } else if (this.d.b == 0) {
                j2 = -1;
            } else {
                j2 = this.d.a(fVar, Math.min(j, this.d.b));
                t tVar = this.b;
                tVar.a += j2;
                if (this.b.a >= ((long) (this.b.d.e.b() / 2))) {
                    this.b.d.a(this.b.c, this.b.a);
                    this.b.a = 0;
                }
                synchronized (this.b.d) {
                    e a = this.b.d;
                    a.c += j2;
                    if (this.b.d.c >= ((long) (this.b.d.e.b() / 2))) {
                        this.b.d.a(0, this.b.d.c);
                        this.b.d.c = 0;
                    }
                }
            }
        }
        return j2;
    }

    public final y a() {
        return this.b.h;
    }

    final void a(h hVar, long j) {
        if (a || !Thread.holdsLock(this.b)) {
            while (j > 0) {
                boolean z;
                Object obj;
                synchronized (this.b) {
                    z = this.g;
                    obj = this.d.b + j > this.e ? 1 : null;
                }
                if (obj != null) {
                    hVar.f(j);
                    this.b.b(a.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    hVar.f(j);
                    return;
                } else {
                    long a = hVar.a(this.c, j);
                    if (a == -1) {
                        throw new EOFException();
                    }
                    j -= a;
                    synchronized (this.b) {
                        obj = this.d.b == 0 ? 1 : null;
                        this.d.a(this.c);
                        if (obj != null) {
                            this.b.notifyAll();
                        }
                    }
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public final void close() {
        synchronized (this.b) {
            this.f = true;
            this.d.o();
            this.b.notifyAll();
        }
        t.f(this.b);
    }
}
