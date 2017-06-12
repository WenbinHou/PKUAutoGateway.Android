package b.a.b;

import b.a;
import b.a.o;
import b.aa;
import b.ag;
import b.an;
import b.ar;
import b.as;
import b.at;
import b.i;
import b.n;
import b.r;
import b.s;
import b.y;
import b.z;
import c.g;
import c.m;
import c.w;
import c.x;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class p {
    public static final at a = new q();
    public final ag b;
    public final ad c;
    public final ar d;
    public u e;
    public long f = -1;
    public boolean g;
    public final boolean h;
    public final an i;
    public an j;
    public ar k;
    public ar l;
    public w m;
    public g n;
    public final boolean o;
    public final boolean p;
    public a q;
    public b r;

    public p(ag agVar, an anVar, boolean z, boolean z2, boolean z3, ad adVar, ar arVar) {
        this.b = agVar;
        this.i = anVar;
        this.h = z;
        this.o = z2;
        this.p = z3;
        if (adVar == null) {
            n nVar = agVar.r;
            SSLSocketFactory sSLSocketFactory = null;
            HostnameVerifier hostnameVerifier = null;
            i iVar = null;
            if (anVar.c()) {
                sSLSocketFactory = agVar.l;
                hostnameVerifier = agVar.n;
                iVar = agVar.o;
            }
            ad adVar2 = new ad(nVar, new a(anVar.a.b, anVar.a.c, agVar.s, agVar.k, sSLSocketFactory, hostnameVerifier, iVar, agVar.p, agVar.b, agVar.c, agVar.d, agVar.g));
        }
        this.c = adVar;
        this.m = null;
        this.d = arVar;
    }

    public static ar a(ar arVar) {
        if (arVar == null || arVar.g == null) {
            return arVar;
        }
        as b = arVar.b();
        b.g = null;
        return b.a();
    }

    public static y a(y yVar, y yVar2) {
        int i;
        int i2 = 0;
        z zVar = new z();
        int length = yVar.a.length / 2;
        for (i = 0; i < length; i++) {
            String a = yVar.a(i);
            String b = yVar.b(i);
            if (!("Warning".equalsIgnoreCase(a) && b.startsWith("1")) && (!v.a(a) || yVar2.a(a) == null)) {
                zVar.a(a, b);
            }
        }
        i = yVar2.a.length / 2;
        while (i2 < i) {
            String a2 = yVar2.a(i2);
            if (!"Content-Length".equalsIgnoreCase(a2) && v.a(a2)) {
                zVar.a(a2, yVar2.b(i2));
            }
            i2++;
        }
        return zVar.a();
    }

    public static String a(List<r> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append("; ");
            }
            r rVar = (r) list.get(i);
            stringBuilder.append(rVar.a).append('=').append(rVar.b);
        }
        return stringBuilder.toString();
    }

    public static boolean a(an anVar) {
        return t.b(anVar.b);
    }

    public static boolean a(ar arVar, ar arVar2) {
        if (arVar2.c == 304) {
            return true;
        }
        Date b = arVar.f.b("Last-Modified");
        if (b != null) {
            Date b2 = arVar2.f.b("Last-Modified");
            if (b2 != null && b2.getTime() < b.getTime()) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(ar arVar) {
        if (arVar.a.b.equals("HEAD")) {
            return false;
        }
        int i = arVar.c;
        return ((i >= 100 && i < 200) || i == 204 || i == 304) ? v.a(arVar) != -1 || "chunked".equalsIgnoreCase(arVar.a("Transfer-Encoding")) : true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final p a(IOException iOException) {
        Object obj = 1;
        ad adVar = this.c;
        if (adVar.c != null) {
            adVar.a(iOException);
        }
        if (adVar.b != null) {
            ab abVar = adVar.b;
            Object obj2 = (abVar.c() || abVar.b() || abVar.d()) ? 1 : null;
        }
        boolean z = iOException instanceof ProtocolException ? false : iOException instanceof InterruptedIOException ? iOException instanceof SocketTimeoutException : ((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) ? false : !(iOException instanceof SSLPeerUnverifiedException);
    }

    public final void a() {
        if (this.f != -1) {
            throw new IllegalStateException();
        }
        this.f = System.currentTimeMillis();
    }

    public final void a(y yVar) {
        if (this.b.h != s.a && !r.a(this.i.a, yVar).isEmpty()) {
            this.b.h.a();
        }
    }

    public final boolean a(aa aaVar) {
        aa aaVar2 = this.i.a;
        return aaVar2.b.equals(aaVar.b) && aaVar2.c == aaVar.c && aaVar2.a.equals(aaVar.a);
    }

    public final ad b() {
        if (this.n != null) {
            o.a(this.n);
        } else if (this.m != null) {
            o.a(this.m);
        }
        if (this.l != null) {
            o.a(this.l.g);
        } else {
            this.c.a(null);
        }
        return this.c;
    }

    public final ar b(ar arVar) {
        if (!this.g || !"gzip".equalsIgnoreCase(this.l.a("Content-Encoding")) || arVar.g == null) {
            return arVar;
        }
        x mVar = new m(arVar.g.c());
        y a = arVar.f.a().a("Content-Encoding").a("Content-Length").a();
        as a2 = arVar.b().a(a);
        a2.g = new w(a, c.o.a(mVar));
        return a2.a();
    }

    public final ar c() {
        this.e.b();
        as a = this.e.a();
        a.a = this.j;
        a.e = this.c.a().d;
        ar a2 = a.a(v.b, Long.toString(this.f)).a(v.c, Long.toString(System.currentTimeMillis())).a();
        if (!this.p) {
            as b = a2.b();
            b.g = this.e.a(a2);
            a2 = b.a();
        }
        if ("close".equalsIgnoreCase(a2.a.a("Connection")) || "close".equalsIgnoreCase(a2.a("Connection"))) {
            this.c.a(true, false, false);
        }
        return a2;
    }
}
