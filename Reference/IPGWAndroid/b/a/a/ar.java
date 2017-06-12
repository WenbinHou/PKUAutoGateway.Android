package b.a.a;

import c.h;
import c.i;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;

final class ar implements b {
    private final h a;
    private final boolean b;
    private final aj c = new aj(this.a);

    ar(h hVar, boolean z) {
        this.a = hVar;
        this.b = z;
    }

    private static IOException a(String str, Object... objArr) {
        throw new IOException(String.format(str, objArr));
    }

    private void a(c cVar, int i, int i2) {
        boolean z = true;
        int g = this.a.g();
        if (i2 != (g * 8) + 4) {
            throw a("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i2), Integer.valueOf(g));
        }
        ap apVar = new ap();
        for (int i3 = 0; i3 < g; i3++) {
            int g2 = this.a.g();
            int i4 = (-16777216 & g2) >>> 24;
            apVar.a(g2 & 16777215, i4, this.a.g());
        }
        if ((i & 1) == 0) {
            z = false;
        }
        cVar.a(z, apVar);
    }

    public final void a() {
    }

    public final boolean a(c cVar) {
        boolean z = false;
        try {
            int g = this.a.g();
            int g2 = this.a.g();
            int i = (-16777216 & g2) >>> 24;
            int i2 = 16777215 & g2;
            int i3;
            if ((Integer.MIN_VALUE & g) != 0) {
                i3 = (2147418112 & g) >>> 16;
                g &= 65535;
                if (i3 != 3) {
                    throw new ProtocolException("version != 3: " + i3);
                }
                switch (g) {
                    case 1:
                        i3 = this.a.g();
                        this.a.g();
                        g2 = i3 & Integer.MAX_VALUE;
                        this.a.f();
                        List a = this.c.a(i2 - 10);
                        boolean z2 = (i & 1) != 0;
                        if ((i & 2) != 0) {
                            z = true;
                        }
                        cVar.a(z, z2, g2, a, y.SPDY_SYN_STREAM);
                        return true;
                    case 2:
                        cVar.a(false, (i & 1) != 0, this.a.g() & Integer.MAX_VALUE, this.c.a(i2 - 4), y.SPDY_REPLY);
                        return true;
                    case 3:
                        if (i2 != 8) {
                            throw a("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i2));
                        }
                        i3 = this.a.g() & Integer.MAX_VALUE;
                        a a2 = a.a(this.a.g());
                        if (a2 == null) {
                            throw a("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(g));
                        }
                        cVar.a(i3, a2);
                        return true;
                    case 4:
                        a(cVar, i, i2);
                        return true;
                    case 6:
                        if (i2 != 4) {
                            throw a("TYPE_PING length: %d != 4", Integer.valueOf(i2));
                        }
                        g = this.a.g();
                        cVar.a(this.b == ((g & 1) == 1), g, 0);
                        return true;
                    case 7:
                        if (i2 != 8) {
                            throw a("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i2));
                        }
                        i3 = this.a.g() & Integer.MAX_VALUE;
                        if (a.c(this.a.g()) == null) {
                            throw a("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(this.a.g()));
                        }
                        cVar.a(i3, i.b);
                        return true;
                    case 8:
                        cVar.a(false, false, this.a.g() & Integer.MAX_VALUE, this.c.a(i2 - 4), y.SPDY_HEADERS);
                        return true;
                    case 9:
                        if (i2 != 8) {
                            throw a("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i2));
                        }
                        i3 = this.a.g() & Integer.MAX_VALUE;
                        long g3 = (long) (this.a.g() & Integer.MAX_VALUE);
                        if (g3 == 0) {
                            throw a("windowSizeIncrement was 0", Long.valueOf(g3));
                        }
                        cVar.a(i3, g3);
                        return true;
                    default:
                        this.a.f((long) i2);
                        return true;
                }
            }
            i3 = g & Integer.MAX_VALUE;
            if ((i & 1) != 0) {
                z = true;
            }
            cVar.a(z, i3, this.a, i2);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public final void close() {
        this.c.b.close();
    }
}
