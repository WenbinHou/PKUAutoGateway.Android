package b;

import b.a.o;
import c.h;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class at implements Closeable {
    private byte[] e() {
        long b = b();
        if (b > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + b);
        }
        Closeable c = c();
        try {
            byte[] n = c.n();
            if (b == -1 || b == ((long) n.length)) {
                return n;
            }
            throw new IOException("Content-Length and stream length disagree");
        } finally {
            o.a(c);
        }
    }

    public abstract af a();

    public abstract long b();

    public abstract h c();

    public void close() {
        o.a(c());
    }

    public final String d() {
        Charset charset;
        byte[] e = e();
        af a = a();
        if (a != null) {
            charset = o.c;
            if (a.a != null) {
                charset = Charset.forName(a.a);
            }
        } else {
            charset = o.c;
        }
        return new String(e, charset.name());
    }
}
