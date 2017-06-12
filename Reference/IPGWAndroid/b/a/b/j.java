package b.a.b;

import b.a.o;
import c.f;
import c.x;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

final class j extends f {
    final /* synthetic */ e d;
    private long e;

    public j(e eVar, long j) {
        this.d = eVar;
        super(eVar);
        this.e = j;
        if (this.e == 0) {
            a(true);
        }
    }

    public final long a(f fVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.b) {
            throw new IllegalStateException("closed");
        } else if (this.e == 0) {
            return -1;
        } else {
            long a = this.d.b.a(fVar, Math.min(this.e, j));
            if (a == -1) {
                a(false);
                throw new ProtocolException("unexpected end of stream");
            }
            this.e -= a;
            if (this.e == 0) {
                a(true);
            }
            return a;
        }
    }

    public final void close() {
        if (!this.b) {
            if (!(this.e == 0 || o.a((x) this, TimeUnit.MILLISECONDS))) {
                a(false);
            }
            this.b = true;
        }
    }
}
