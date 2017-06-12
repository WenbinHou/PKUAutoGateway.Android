package b.a.b;

import b.a;
import b.ad;
import b.ae;
import b.an;
import b.ar;
import c.g;
import c.o;
import java.net.ProtocolException;

public final class s implements ae {
    final /* synthetic */ p a;
    private final int b;
    private final an c;
    private int d;

    public s(p pVar, int i, an anVar) {
        this.a = pVar;
        this.b = i;
        this.c = anVar;
    }

    public final ar a(an anVar) {
        ad adVar;
        this.d++;
        if (this.b > 0) {
            adVar = (ad) this.a.b.f.get(this.b - 1);
            a aVar = this.a.c.a().a().a;
            if (!anVar.a.b.equals(aVar.a.b) || anVar.a.c != aVar.a.c) {
                throw new IllegalStateException("network interceptor " + adVar + " must retain the same host and port");
            } else if (this.d > 1) {
                throw new IllegalStateException("network interceptor " + adVar + " must call proceed() exactly once");
            }
        }
        if (this.b < this.a.b.f.size()) {
            s sVar = new s(this.a, this.b + 1, anVar);
            adVar = (ad) this.a.b.f.get(this.b);
            ar a = adVar.a();
            if (sVar.d != 1) {
                throw new IllegalStateException("network interceptor " + adVar + " must call proceed() exactly once");
            } else if (a != null) {
                return a;
            } else {
                throw new NullPointerException("network interceptor " + adVar + " returned null");
            }
        }
        this.a.e.a(anVar);
        this.a.j = anVar;
        if (p.a(anVar) && anVar.d != null) {
            g a2 = o.a(this.a.e.a(anVar, anVar.d.b()));
            anVar.d.a(a2);
            a2.close();
        }
        ar b = this.a.c();
        int i = b.c;
        if ((i != 204 && i != 205) || b.g.b() <= 0) {
            return b;
        }
        throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + b.g.b());
    }
}
