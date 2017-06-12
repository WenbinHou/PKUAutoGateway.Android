package b.a.a;

import c.f;
import c.g;
import c.i;
import c.j;
import c.o;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;

final class as implements d {
    private final g a;
    private final f b = new f();
    private final g c;
    private final boolean d;
    private boolean e;

    as(g gVar, boolean z) {
        this.a = gVar;
        this.d = z;
        Deflater deflater = new Deflater();
        deflater.setDictionary(aq.a);
        this.c = o.a(new j(this.b, deflater));
    }

    private void a(List<x> list) {
        this.c.f(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            i iVar = ((x) list.get(i)).h;
            this.c.f(iVar.c.length);
            this.c.b(iVar);
            iVar = ((x) list.get(i)).i;
            this.c.f(iVar.c.length);
            this.c.b(iVar);
        }
        this.c.flush();
    }

    public final synchronized void a() {
    }

    public final synchronized void a(int i, long j) {
        if (this.e) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j);
        } else {
            this.a.f(-2147287031);
            this.a.f(8);
            this.a.f(i);
            this.a.f((int) j);
            this.a.flush();
        }
    }

    public final synchronized void a(int i, a aVar) {
        if (this.e) {
            throw new IOException("closed");
        } else if (aVar.t == -1) {
            throw new IllegalArgumentException();
        } else {
            this.a.f(-2147287037);
            this.a.f(8);
            this.a.f(Integer.MAX_VALUE & i);
            this.a.f(aVar.t);
            this.a.flush();
        }
    }

    public final synchronized void a(int i, a aVar, byte[] bArr) {
        if (this.e) {
            throw new IOException("closed");
        } else if (aVar.u == -1) {
            throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
        } else {
            this.a.f(-2147287033);
            this.a.f(8);
            this.a.f(i);
            this.a.f(aVar.u);
            this.a.flush();
        }
    }

    public final void a(ap apVar) {
    }

    public final synchronized void a(boolean z, int i, int i2) {
        boolean z2 = true;
        synchronized (this) {
            if (this.e) {
                throw new IOException("closed");
            }
            if (this.d == ((i & 1) == 1)) {
                z2 = false;
            }
            if (z != z2) {
                throw new IllegalArgumentException("payload != reply");
            }
            this.a.f(-2147287034);
            this.a.f(4);
            this.a.f(i);
            this.a.flush();
        }
    }

    public final synchronized void a(boolean z, int i, f fVar, int i2) {
        int i3 = z ? 1 : 0;
        if (this.e) {
            throw new IOException("closed");
        } else if (((long) i2) > 16777215) {
            throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + i2);
        } else {
            this.a.f(Integer.MAX_VALUE & i);
            this.a.f(((i3 & 255) << 24) | (16777215 & i2));
            if (i2 > 0) {
                this.a.a_(fVar, (long) i2);
            }
        }
    }

    public final synchronized void a(boolean z, int i, List<x> list) {
        int i2 = 0;
        synchronized (this) {
            if (this.e) {
                throw new IOException("closed");
            }
            a((List) list);
            int i3 = (int) (10 + this.b.b);
            if (z) {
                i2 = 1;
            }
            i2 |= 0;
            this.a.f(-2147287039);
            this.a.f(((i2 & 255) << 24) | (i3 & 16777215));
            this.a.f(Integer.MAX_VALUE & i);
            this.a.f(0);
            this.a.g(0);
            this.a.a(this.b);
            this.a.flush();
        }
    }

    public final synchronized void b() {
        if (this.e) {
            throw new IOException("closed");
        }
        this.a.flush();
    }

    public final synchronized void b(ap apVar) {
        if (this.e) {
            throw new IOException("closed");
        }
        int bitCount = Integer.bitCount(apVar.a);
        int i = (bitCount * 8) + 4;
        this.a.f(-2147287036);
        this.a.f((i & 16777215) | 0);
        this.a.f(bitCount);
        for (bitCount = 0; bitCount <= 10; bitCount++) {
            if (apVar.a(bitCount)) {
                this.a.f(((apVar.b(bitCount) & 255) << 24) | (bitCount & 16777215));
                this.a.f(apVar.d[bitCount]);
            }
        }
        this.a.flush();
    }

    public final int c() {
        return 16383;
    }

    public final synchronized void close() {
        this.e = true;
        b.a.o.a(this.a, this.c);
    }
}
