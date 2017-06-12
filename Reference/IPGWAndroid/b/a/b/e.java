package b.a.b;

import b.a.f;
import b.an;
import b.ar;
import b.as;
import b.at;
import b.z;
import c.g;
import c.h;
import c.l;
import c.o;
import c.w;
import c.x;
import c.y;
import java.io.IOException;
import java.net.Proxy.Type;

public final class e implements u {
    final ad a;
    final h b;
    final g c;
    int d = 0;
    private p e;

    public e(ad adVar, h hVar, g gVar) {
        this.a = adVar;
        this.b = hVar;
        this.c = gVar;
    }

    static /* synthetic */ void a(l lVar) {
        y yVar = lVar.a;
        y yVar2 = y.b;
        if (yVar2 == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        lVar.a = yVar2;
        yVar.f_();
        yVar.d();
    }

    public final as a() {
        return c();
    }

    public final at a(ar arVar) {
        x a;
        if (!p.c(arVar)) {
            a = a(0);
        } else if ("chunked".equalsIgnoreCase(arVar.a("Transfer-Encoding"))) {
            p pVar = this.e;
            if (this.d != 4) {
                throw new IllegalStateException("state: " + this.d);
            }
            this.d = 5;
            a = new h(this, pVar);
        } else {
            long a2 = v.a(arVar);
            if (a2 != -1) {
                a = a(a2);
            } else if (this.d != 4) {
                throw new IllegalStateException("state: " + this.d);
            } else if (this.a == null) {
                throw new IllegalStateException("streamAllocation == null");
            } else {
                this.d = 5;
                this.a.a(true, false, false);
                a = new k();
            }
        }
        return new w(arVar.f, o.a(a));
    }

    public final w a(an anVar, long j) {
        if ("chunked".equalsIgnoreCase(anVar.a("Transfer-Encoding"))) {
            if (this.d != 1) {
                throw new IllegalStateException("state: " + this.d);
            }
            this.d = 2;
            return new g();
        } else if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        } else if (this.d != 1) {
            throw new IllegalStateException("state: " + this.d);
        } else {
            this.d = 2;
            return new i(this, j);
        }
    }

    public final x a(long j) {
        if (this.d != 4) {
            throw new IllegalStateException("state: " + this.d);
        }
        this.d = 5;
        return new j(this, j);
    }

    public final void a(p pVar) {
        this.e = pVar;
    }

    public final void a(z zVar) {
        if (this.d != 1) {
            throw new IllegalStateException("state: " + this.d);
        }
        this.d = 3;
        zVar.a(this.c);
    }

    public final void a(an anVar) {
        this.e.a();
        Type type = this.e.c.a().a().b.type();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(anVar.b);
        stringBuilder.append(' ');
        Object obj = (anVar.c() || type != Type.HTTP) ? null : 1;
        if (obj != null) {
            stringBuilder.append(anVar.a);
        } else {
            stringBuilder.append(y.a(anVar.a));
        }
        stringBuilder.append(" HTTP/1.1");
        a(anVar.c, stringBuilder.toString());
    }

    public final void a(b.y yVar, String str) {
        if (this.d != 0) {
            throw new IllegalStateException("state: " + this.d);
        }
        this.c.b(str).b("\r\n");
        int length = yVar.a.length / 2;
        for (int i = 0; i < length; i++) {
            this.c.b(yVar.a(i)).b(": ").b(yVar.b(i)).b("\r\n");
        }
        this.c.b("\r\n");
        this.d = 1;
    }

    public final void b() {
        this.c.flush();
    }

    public final as c() {
        if (this.d == 1 || this.d == 3) {
            as asVar;
            ac a;
            do {
                try {
                    a = ac.a(this.b.m());
                    asVar = new as();
                    asVar.b = a.a;
                    asVar.c = a.b;
                    asVar.d = a.c;
                    asVar = asVar.a(d());
                } catch (Throwable e) {
                    IOException iOException = new IOException("unexpected end of stream on " + this.a);
                    iOException.initCause(e);
                    throw iOException;
                }
            } while (a.b == 100);
            this.d = 4;
            return asVar;
        }
        throw new IllegalStateException("state: " + this.d);
    }

    public final b.y d() {
        z zVar = new z();
        while (true) {
            String m = this.b.m();
            if (m.length() == 0) {
                return zVar.a();
            }
            f.b.a(zVar, m);
        }
    }
}
