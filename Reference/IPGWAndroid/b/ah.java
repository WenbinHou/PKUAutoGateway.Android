package b;

import b.a.b.ad;
import b.a.c.c;
import b.a.f;
import b.a.g;
import b.a.n;
import b.a.o;
import javax.net.ssl.SSLSocket;

final class ah extends f {
    ah() {
    }

    public final c a(n nVar, a aVar, ad adVar) {
        if (n.g || Thread.holdsLock(nVar)) {
            for (c cVar : nVar.d) {
                if (cVar.j.size() < cVar.i && aVar.equals(cVar.b.a) && !cVar.k) {
                    adVar.a(cVar);
                    return cVar;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    public final g a(ag agVar) {
        return agVar.i != null ? agVar.i.a : agVar.j;
    }

    public final n a(n nVar) {
        return nVar.e;
    }

    public final void a(p pVar, SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites = pVar.f != null ? (String[]) o.a(String.class, pVar.f, sSLSocket.getEnabledCipherSuites()) : sSLSocket.getEnabledCipherSuites();
        String[] enabledProtocols = pVar.g != null ? (String[]) o.a(String.class, pVar.g, sSLSocket.getEnabledProtocols()) : sSLSocket.getEnabledProtocols();
        if (z && o.a(sSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
            enabledCipherSuites = o.b(enabledCipherSuites, "TLS_FALLBACK_SCSV");
        }
        p b = new q(pVar).a(enabledCipherSuites).b(enabledProtocols).b();
        if (b.g != null) {
            sSLSocket.setEnabledProtocols(b.g);
        }
        if (b.f != null) {
            sSLSocket.setEnabledCipherSuites(b.f);
        }
    }

    public final void a(z zVar, String str) {
        int indexOf = str.indexOf(":", 1);
        if (indexOf != -1) {
            zVar.b(str.substring(0, indexOf), str.substring(indexOf + 1));
        } else if (str.startsWith(":")) {
            zVar.b("", str.substring(1));
        } else {
            zVar.b("", str);
        }
    }

    public final boolean a(n nVar, c cVar) {
        if (!n.g && !Thread.holdsLock(nVar)) {
            throw new AssertionError();
        } else if (cVar.k || nVar.b == 0) {
            nVar.d.remove(cVar);
            return true;
        } else {
            nVar.notifyAll();
            return false;
        }
    }

    public final void b(n nVar, c cVar) {
        if (n.g || Thread.holdsLock(nVar)) {
            if (!nVar.f) {
                nVar.f = true;
                n.a.execute(nVar.c);
            }
            nVar.d.add(cVar);
            return;
        }
        throw new AssertionError();
    }
}
