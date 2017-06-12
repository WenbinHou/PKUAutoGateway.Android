package b.a.a;

import c.f;
import c.g;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

final class ag implements d {
    private final g a;
    private final boolean b;
    private final f c = new f();
    private final ab d = new ab(this.c);
    private int e = 16384;
    private boolean f;

    ag(g gVar, boolean z) {
        this.a = gVar;
        this.b = z;
    }

    private void a(int i, int i2, byte b, byte b2) {
        if (ac.a.isLoggable(Level.FINE)) {
            ac.a.fine(ae.a(false, i, i2, b, b2));
        }
        if (i2 > this.e) {
            throw ac.b("FRAME_SIZE_ERROR length > %d: %d", new Object[]{Integer.valueOf(this.e), Integer.valueOf(i2)});
        } else if ((Integer.MIN_VALUE & i) != 0) {
            throw ac.b("reserved bit set: %s", new Object[]{Integer.valueOf(i)});
        } else {
            ac.a(this.a, i2);
            this.a.h(b & 255);
            this.a.h(b2 & 255);
            this.a.f(Integer.MAX_VALUE & i);
        }
    }

    private void b(int i, long j) {
        while (j > 0) {
            int min = (int) Math.min((long) this.e, j);
            j -= (long) min;
            a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.a.a_(this.c, (long) min);
        }
    }

    public final synchronized void a() {
        if (this.f) {
            throw new IOException("closed");
        } else if (this.b) {
            if (ac.a.isLoggable(Level.FINE)) {
                ac.a.fine(String.format(">> CONNECTION %s", new Object[]{ac.b.b()}));
            }
            this.a.b(ac.b.d());
            this.a.flush();
        }
    }

    public final synchronized void a(int i, long j) {
        if (this.f) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw ac.b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[]{Long.valueOf(j)});
        } else {
            a(i, 4, (byte) 8, (byte) 0);
            this.a.f((int) j);
            this.a.flush();
        }
    }

    public final synchronized void a(int i, a aVar) {
        if (this.f) {
            throw new IOException("closed");
        } else if (aVar.s == -1) {
            throw new IllegalArgumentException();
        } else {
            a(i, 4, (byte) 3, (byte) 0);
            this.a.f(aVar.s);
            this.a.flush();
        }
    }

    public final synchronized void a(int i, a aVar, byte[] bArr) {
        if (this.f) {
            throw new IOException("closed");
        } else if (aVar.s == -1) {
            throw ac.b("errorCode.httpCode == -1", new Object[0]);
        } else {
            a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.a.f(i);
            this.a.f(aVar.s);
            if (bArr.length > 0) {
                this.a.b(bArr);
            }
            this.a.flush();
        }
    }

    public final synchronized void a(ap apVar) {
        if (this.f) {
            throw new IOException("closed");
        }
        int i = this.e;
        if ((apVar.a & 32) != 0) {
            i = apVar.d[5];
        }
        this.e = i;
        a(0, 0, (byte) 4, (byte) 1);
        this.a.flush();
    }

    public final synchronized void a(boolean z, int i, int i2) {
        byte b = (byte) 0;
        synchronized (this) {
            if (this.f) {
                throw new IOException("closed");
            }
            if (z) {
                b = (byte) 1;
            }
            a(0, 8, (byte) 6, b);
            this.a.f(i);
            this.a.f(i2);
            this.a.flush();
        }
    }

    public final synchronized void a(boolean z, int i, f fVar, int i2) {
        byte b = (byte) 0;
        synchronized (this) {
            if (this.f) {
                throw new IOException("closed");
            }
            if (z) {
                b = (byte) 1;
            }
            a(i, i2, (byte) 0, b);
            if (i2 > 0) {
                this.a.a_(fVar, (long) i2);
            }
        }
    }

    public final synchronized void a(boolean z, int i, List<x> list) {
        if (this.f) {
            throw new IOException("closed");
        } else if (this.f) {
            throw new IOException("closed");
        } else {
            this.d.a((List) list);
            long j = this.c.b;
            int min = (int) Math.min((long) this.e, j);
            byte b = j == ((long) min) ? (byte) 4 : (byte) 0;
            if (z) {
                b = (byte) (b | 1);
            }
            a(i, min, (byte) 1, b);
            this.a.a_(this.c, (long) min);
            if (j > ((long) min)) {
                b(i, j - ((long) min));
            }
        }
    }

    public final synchronized void b() {
        if (this.f) {
            throw new IOException("closed");
        }
        this.a.flush();
    }

    public final synchronized void b(ap apVar) {
        int i = 0;
        synchronized (this) {
            if (this.f) {
                throw new IOException("closed");
            }
            a(0, Integer.bitCount(apVar.a) * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (apVar.a(i)) {
                    int i2 = i == 4 ? 3 : i == 7 ? 4 : i;
                    this.a.g(i2);
                    this.a.f(apVar.d[i]);
                }
                i++;
            }
            this.a.flush();
        }
    }

    public final int c() {
        return this.e;
    }

    public final synchronized void close() {
        this.f = true;
        this.a.close();
    }
}
