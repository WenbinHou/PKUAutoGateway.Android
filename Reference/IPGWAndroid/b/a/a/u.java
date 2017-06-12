package b.a.a;

import c.f;
import c.w;
import c.y;

final class u implements w {
    static final /* synthetic */ boolean a = (!t.class.desiredAssertionStatus());
    final /* synthetic */ t b;
    private final f c = new f();
    private boolean d;
    private boolean e;

    u(t tVar) {
        this.b = tVar;
    }

    private void a(boolean z) {
        synchronized (this.b) {
            this.b.i.b_();
            while (this.b.b <= 0 && !this.e && !this.d && this.b.l == null) {
                try {
                    this.b.f();
                } catch (Throwable th) {
                    this.b.i.b();
                }
            }
            this.b.i.b();
            t.h(this.b);
            long min = Math.min(this.b.b, this.c.b);
            t tVar = this.b;
            tVar.b -= min;
        }
        this.b.i.b_();
        try {
            e a = this.b.d;
            int b = this.b.c;
            boolean z2 = z && min == this.c.b;
            a.a(b, z2, this.c, min);
        } finally {
            this.b.i.b();
        }
    }

    public final y a() {
        return this.b.i;
    }

    public final void a_(f fVar, long j) {
        if (a || !Thread.holdsLock(this.b)) {
            this.c.a_(fVar, j);
            while (this.c.b >= 16384) {
                a(false);
            }
            return;
        }
        throw new AssertionError();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        if (a || !Thread.holdsLock(this.b)) {
            synchronized (this.b) {
                if (this.d) {
                    return;
                }
            }
        }
        throw new AssertionError();
    }

    public final void flush() {
        if (a || !Thread.holdsLock(this.b)) {
            synchronized (this.b) {
                t.h(this.b);
            }
            while (this.c.b > 0) {
                a(false);
                this.b.d.b();
            }
            return;
        }
        throw new AssertionError();
    }
}
