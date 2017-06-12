package b;

import b.a.o;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class x {
    public final l a;
    public final List<Certificate> b;
    private final av c;
    private final List<Certificate> d;

    private x(av avVar, l lVar, List<Certificate> list, List<Certificate> list2) {
        this.c = avVar;
        this.a = lVar;
        this.b = list;
        this.d = list2;
    }

    public static x a(SSLSession sSLSession) {
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        l a = l.a(cipherSuite);
        cipherSuite = sSLSession.getProtocol();
        if (cipherSuite == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        Object[] peerCertificates;
        av a2 = av.a(cipherSuite);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            peerCertificates = null;
        }
        List a3 = peerCertificates != null ? o.a(peerCertificates) : Collections.emptyList();
        Object[] localCertificates = sSLSession.getLocalCertificates();
        return new x(a2, a, a3, localCertificates != null ? o.a(localCertificates) : Collections.emptyList());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return o.a(this.a, xVar.a) && this.a.equals(xVar.a) && this.b.equals(xVar.b) && this.d.equals(xVar.d);
    }

    public final int hashCode() {
        return (((((((this.c != null ? this.c.hashCode() : 0) + 527) * 31) + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.d.hashCode();
    }
}
