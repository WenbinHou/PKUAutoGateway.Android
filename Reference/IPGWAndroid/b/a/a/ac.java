package b.a.a;

import c.g;
import c.h;
import c.i;
import java.io.IOException;
import java.util.logging.Logger;

public final class ac implements at {
    private static final Logger a = Logger.getLogger(ae.class.getName());
    private static final i b = i.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    static /* synthetic */ int a(int i, byte b, short s) {
        if ((b & 8) != 0) {
            short s2 = i - 1;
        }
        if (s <= s2) {
            return (short) (s2 - s);
        }
        throw c("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(s2));
    }

    static /* synthetic */ void a(g gVar, int i) {
        gVar.h((i >>> 16) & 255);
        gVar.h((i >>> 8) & 255);
        gVar.h(i & 255);
    }

    static /* synthetic */ IllegalArgumentException b(String str, Object[] objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    private static IOException c(String str, Object... objArr) {
        throw new IOException(String.format(str, objArr));
    }

    public final b a(h hVar, boolean z) {
        return new af(hVar, z);
    }

    public final d a(g gVar, boolean z) {
        return new ag(gVar, z);
    }
}
