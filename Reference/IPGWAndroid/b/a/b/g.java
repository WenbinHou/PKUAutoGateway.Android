package b.a.b;

import c.f;
import c.l;
import c.w;
import c.y;

final class g implements w {
    final /* synthetic */ e a;
    private final l b;
    private boolean c;

    private g(e eVar) {
        this.a = eVar;
        this.b = new l(this.a.c.a());
    }

    public final y a() {
        return this.b;
    }

    public final void a_(f fVar, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        } else if (j != 0) {
            this.a.c.i(j);
            this.a.c.b("\r\n");
            this.a.c.a_(fVar, j);
            this.a.c.b("\r\n");
        }
    }

    public final synchronized void close() {
        if (!this.c) {
            this.c = true;
            this.a.c.b("0\r\n\r\n");
            e.a(this.b);
            this.a.d = 3;
        }
    }

    public final synchronized void flush() {
        if (!this.c) {
            this.a.c.flush();
        }
    }
}
