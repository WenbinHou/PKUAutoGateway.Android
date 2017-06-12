package b.a.b;

import c.f;

final class k extends f {
    final /* synthetic */ e d;
    private boolean e;

    private k(e eVar) {
        this.d = eVar;
        super(eVar);
    }

    public final long a(f fVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.b) {
            throw new IllegalStateException("closed");
        } else if (this.e) {
            return -1;
        } else {
            long a = this.d.b.a(fVar, j);
            if (a != -1) {
                return a;
            }
            this.e = true;
            a(true);
            return -1;
        }
    }

    public final void close() {
        if (!this.b) {
            if (!this.e) {
                a(false);
            }
            this.b = true;
        }
    }
}
