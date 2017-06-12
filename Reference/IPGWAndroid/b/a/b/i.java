package b.a.b;

import b.a.o;
import c.f;
import c.l;
import c.w;
import c.y;
import java.net.ProtocolException;

final class i implements w {
    final /* synthetic */ e a;
    private final l b;
    private boolean c;
    private long d;

    private i(e eVar, long j) {
        this.a = eVar;
        this.b = new l(this.a.c.a());
        this.d = j;
    }

    public final y a() {
        return this.b;
    }

    public final void a_(f fVar, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        o.a(fVar.b, j);
        if (j > this.d) {
            throw new ProtocolException("expected " + this.d + " bytes but received " + j);
        }
        this.a.c.a_(fVar, j);
        this.d -= j;
    }

    public final void close() {
        if (!this.c) {
            this.c = true;
            if (this.d > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            e.a(this.b);
            this.a.d = 3;
        }
    }

    public final void flush() {
        if (!this.c) {
            this.a.c.flush();
        }
    }
}
