package b;

import b.a.d.f;
import b.a.g;
import b.a.j;
import b.a.o;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class ag implements Cloneable {
    private static final List<p> A = o.a(p.a, p.b, p.c);
    private static final List<aj> z = o.a(aj.HTTP_2, aj.SPDY_3, aj.HTTP_1_1);
    final u a;
    public final Proxy b;
    public final List<aj> c;
    public final List<p> d;
    final List<ad> e;
    public final List<ad> f;
    public final ProxySelector g;
    public final s h;
    final d i;
    final g j;
    public final SocketFactory k;
    public final SSLSocketFactory l;
    final f m;
    public final HostnameVerifier n;
    public final i o;
    public final b p;
    public final b q;
    public final n r;
    public final v s;
    public final boolean t;
    public final boolean u;
    public final boolean v;
    public final int w;
    public final int x;
    public final int y;

    static {
        b.a.f.b = new ah();
    }

    public ag() {
        this(new ai());
    }

    private ag(ai aiVar) {
        this.a = aiVar.a;
        this.b = aiVar.b;
        this.c = aiVar.c;
        this.d = aiVar.d;
        this.e = o.a(aiVar.e);
        this.f = o.a(aiVar.f);
        this.g = aiVar.g;
        this.h = aiVar.h;
        this.i = aiVar.i;
        this.j = aiVar.j;
        this.k = aiVar.k;
        Object obj = null;
        for (p pVar : this.d) {
            Object obj2 = (obj != null || pVar.d) ? 1 : null;
            obj = obj2;
        }
        if (aiVar.l != null || obj == null) {
            this.l = aiVar.l;
        } else {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, null);
                this.l = instance.getSocketFactory();
            } catch (GeneralSecurityException e) {
                throw new AssertionError();
            }
        }
        if (this.l == null || aiVar.m != null) {
            this.m = aiVar.m;
            this.o = aiVar.o;
        } else {
            X509TrustManager a = j.a().a(this.l);
            if (a == null) {
                throw new IllegalStateException("Unable to extract the trust manager on " + j.a() + ", sslSocketFactory is " + this.l.getClass());
            }
            this.m = j.a().a(a);
            j jVar = new j(aiVar.o);
            jVar.b = this.m;
            this.o = jVar.a();
        }
        this.n = aiVar.n;
        this.p = aiVar.p;
        this.q = aiVar.q;
        this.r = aiVar.r;
        this.s = aiVar.s;
        this.t = aiVar.t;
        this.u = aiVar.u;
        this.v = aiVar.v;
        this.w = aiVar.w;
        this.x = aiVar.x;
        this.y = aiVar.y;
    }

    public final g a(an anVar) {
        return new ak(this, anVar);
    }
}
