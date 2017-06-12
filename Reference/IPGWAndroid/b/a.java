package b;

import b.a.o;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class a {
    public final aa a;
    public final v b;
    public final SocketFactory c;
    public final b d;
    public final List<aj> e;
    public final List<p> f;
    public final ProxySelector g;
    public final Proxy h;
    public final SSLSocketFactory i;
    public final HostnameVerifier j;
    public final i k;

    public a(String str, int i, v vVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, i iVar, b bVar, Proxy proxy, List<aj> list, List<p> list2, ProxySelector proxySelector) {
        ab abVar = new ab();
        String str2 = sSLSocketFactory != null ? "https" : "http";
        if (str2.equalsIgnoreCase("http")) {
            abVar.a = "http";
        } else if (str2.equalsIgnoreCase("https")) {
            abVar.a = "https";
        } else {
            throw new IllegalArgumentException("unexpected scheme: " + str2);
        }
        if (str == null) {
            throw new IllegalArgumentException("host == null");
        }
        str2 = ab.a(str, 0, str.length());
        if (str2 == null) {
            throw new IllegalArgumentException("unexpected host: " + str);
        }
        abVar.d = str2;
        if (i <= 0 || i > 65535) {
            throw new IllegalArgumentException("unexpected port: " + i);
        }
        abVar.e = i;
        this.a = abVar.b();
        if (vVar == null) {
            throw new IllegalArgumentException("dns == null");
        }
        this.b = vVar;
        if (socketFactory == null) {
            throw new IllegalArgumentException("socketFactory == null");
        }
        this.c = socketFactory;
        if (bVar == null) {
            throw new IllegalArgumentException("proxyAuthenticator == null");
        }
        this.d = bVar;
        if (list == null) {
            throw new IllegalArgumentException("protocols == null");
        }
        this.e = o.a((List) list);
        if (list2 == null) {
            throw new IllegalArgumentException("connectionSpecs == null");
        }
        this.f = o.a((List) list2);
        if (proxySelector == null) {
            throw new IllegalArgumentException("proxySelector == null");
        }
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = iVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a.equals(aVar.a) && this.b.equals(aVar.b) && this.d.equals(aVar.d) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.g.equals(aVar.g) && o.a(this.h, aVar.h) && o.a(this.i, aVar.i) && o.a(this.j, aVar.j) && o.a(this.k, aVar.k);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.j != null ? this.j.hashCode() : 0) + (((this.i != null ? this.i.hashCode() : 0) + (((this.h != null ? this.h.hashCode() : 0) + ((((((((((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31)) * 31)) * 31)) * 31;
        if (this.k != null) {
            i = this.k.hashCode();
        }
        return hashCode + i;
    }
}
