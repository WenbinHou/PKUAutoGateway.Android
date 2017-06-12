package b.a.b;

import b.a.o;
import c.f;
import c.x;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

final class h extends f {
    final /* synthetic */ e d;
    private long e = -1;
    private boolean f = true;
    private final p g;

    h(e eVar, p pVar) {
        this.d = eVar;
        super(eVar);
        this.g = pVar;
    }

    public final long a(f fVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.b) {
            throw new IllegalStateException("closed");
        } else if (!this.f) {
            return -1;
        } else {
            if (this.e == 0 || this.e == -1) {
                if (this.e != -1) {
                    this.d.b.m();
                }
                try {
                    this.e = this.d.b.j();
                    String trim = this.d.b.m().trim();
                    if (this.e < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                        throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.e + trim + "\"");
                    }
                    if (this.e == 0) {
                        this.f = false;
                        this.g.a(this.d.d());
                        a(true);
                    }
                    if (!this.f) {
                        return -1;
                    }
                } catch (NumberFormatException e) {
                    throw new ProtocolException(e.getMessage());
                }
            }
            long a = this.d.b.a(fVar, Math.min(j, this.e));
            if (a == -1) {
                a(false);
                throw new ProtocolException("unexpected end of stream");
            }
            this.e -= a;
            return a;
        }
    }

    public final void close() {
        if (!this.b) {
            if (this.f && !o.a((x) this, TimeUnit.MILLISECONDS)) {
                a(false);
            }
            this.b = true;
        }
    }
}
