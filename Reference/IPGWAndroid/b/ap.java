package b;

import b.a.o;
import c.g;
import java.nio.charset.Charset;

public abstract class ap {
    public static ap a(af afVar, String str) {
        Charset charset = o.c;
        if (afVar != null) {
            charset = afVar.a != null ? Charset.forName(afVar.a) : null;
            if (charset == null) {
                charset = o.c;
                afVar = af.a(afVar + "; charset=utf-8");
            }
        }
        byte[] bytes = str.getBytes(charset);
        int length = bytes.length;
        if (bytes == null) {
            throw new NullPointerException("content == null");
        }
        o.a((long) bytes.length, (long) length);
        return new aq(afVar, length, bytes);
    }

    public abstract af a();

    public abstract void a(g gVar);

    public long b() {
        return -1;
    }
}
