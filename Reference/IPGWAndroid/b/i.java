package b;

import b.a.d.b;
import b.a.d.f;
import b.a.o;
import c.e;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class i {
    public static final i a = new j().a();
    private final List<k> b;
    private final f c;

    private i(j jVar) {
        this.b = o.a(jVar.a);
        this.c = jVar.b;
    }

    private static c.i a(X509Certificate x509Certificate) {
        return o.b(c.i.a(x509Certificate.getPublicKey().getEncoded()));
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + e.a(a((X509Certificate) certificate).c);
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public final void a(String str, List<Certificate> list) {
        int i = 0;
        List emptyList = Collections.emptyList();
        for (k kVar : this.b) {
            int i2;
            List arrayList;
            if (kVar.a.equals(str)) {
                i2 = 1;
            } else {
                i2 = str.indexOf(46);
                if (kVar.a.startsWith("*.")) {
                    if (str.regionMatches(false, i2 + 1, kVar.a, 2, kVar.a.length() - 2)) {
                        i2 = 1;
                    }
                }
                i2 = 0;
            }
            if (i2 != 0) {
                arrayList = emptyList.isEmpty() ? new ArrayList() : emptyList;
                arrayList.add(kVar);
            } else {
                arrayList = emptyList;
            }
            emptyList = arrayList;
        }
        if (!emptyList.isEmpty()) {
            List a;
            int i3;
            if (this.c != null) {
                a = new b(this.c).a(list);
            }
            int size = a.size();
            for (int i4 = 0; i4 < size; i4++) {
                X509Certificate x509Certificate = (X509Certificate) a.get(i4);
                int size2 = emptyList.size();
                int i5 = 0;
                Object obj = null;
                Object obj2 = null;
                while (i5 < size2) {
                    k kVar2 = (k) emptyList.get(i5);
                    if (kVar2.b.equals("sha256/")) {
                        if (obj == null) {
                            obj = a(x509Certificate);
                        }
                        if (kVar2.c.equals(obj)) {
                            return;
                        }
                    } else if (kVar2.b.equals("sha1/")) {
                        if (obj2 == null) {
                            obj2 = o.a(c.i.a(x509Certificate.getPublicKey().getEncoded()));
                        }
                        if (kVar2.c.equals(obj2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
                    i5++;
                    obj2 = obj2;
                    obj = obj;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
            int size3 = a.size();
            for (i3 = 0; i3 < size3; i3++) {
                Certificate certificate = (X509Certificate) a.get(i3);
                stringBuilder.append("\n    ").append(a(certificate)).append(": ").append(certificate.getSubjectDN().getName());
            }
            stringBuilder.append("\n  Pinned certificates for ").append(str).append(":");
            i3 = emptyList.size();
            while (i < i3) {
                stringBuilder.append("\n    ").append((k) emptyList.get(i));
                i++;
            }
            throw new SSLPeerUnverifiedException(stringBuilder.toString());
        }
    }
}
