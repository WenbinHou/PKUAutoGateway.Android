package b.a.a;

import c.f;
import c.h;
import c.x;
import c.y;
import java.util.logging.Level;

final class ad implements x {
    int a;
    byte b;
    int c;
    int d;
    short e;
    private final h f;

    public ad(h hVar) {
        this.f = hVar;
    }

    public final long a(f fVar, long j) {
        while (this.d == 0) {
            this.f.f((long) this.e);
            this.e = (short) 0;
            if ((this.b & 4) != 0) {
                return -1;
            }
            int i = this.c;
            int a = ((((this.f.e() & 255) << 16) | ((this.f.e() & 255) << 8)) | (this.f.e() & 255));
            this.d = a;
            this.a = a;
            byte e = (byte) (this.f.e() & 255);
            this.b = (byte) (this.f.e() & 255);
            if (ac.a.isLoggable(Level.FINE)) {
                ac.a.fine(ae.a(true, this.c, this.a, e, this.b));
            }
            this.c = this.f.g() & Integer.MAX_VALUE;
            if (e != (byte) 9) {
                throw ac.c("%s != TYPE_CONTINUATION", Byte.valueOf(e));
            } else if (this.c != i) {
                throw ac.c("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
        long a2 = this.f.a(fVar, Math.min(j, (long) this.d));
        if (a2 == -1) {
            return -1;
        }
        this.d = (int) (((long) this.d) - a2);
        return a2;
    }

    public final y a() {
        return this.f.a();
    }

    public final void close() {
    }
}
