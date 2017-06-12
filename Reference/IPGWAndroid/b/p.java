package b;

import b.a.o;
import java.util.Arrays;
import javax.net.ssl.SSLSocket;

public final class p {
    public static final p a;
    public static final p b = new q(a).a(av.TLS_1_0).a().b();
    public static final p c = new q(false).b();
    private static final l[] h = new l[]{l.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, l.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, l.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, l.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, l.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, l.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, l.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, l.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, l.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, l.TLS_RSA_WITH_AES_128_GCM_SHA256, l.TLS_RSA_WITH_AES_128_CBC_SHA, l.TLS_RSA_WITH_AES_256_CBC_SHA, l.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
    final boolean d;
    public final boolean e;
    final String[] f;
    final String[] g;

    static {
        q qVar = new q(true);
        l[] lVarArr = h;
        if (qVar.a) {
            String[] strArr = new String[lVarArr.length];
            for (int i = 0; i < lVarArr.length; i++) {
                strArr[i] = lVarArr[i].aS;
            }
            a = qVar.a(strArr).a(av.TLS_1_2, av.TLS_1_1, av.TLS_1_0).a().b();
            return;
        }
        throw new IllegalStateException("no cipher suites for cleartext connections");
    }

    private p(q qVar) {
        this.d = qVar.a;
        this.f = qVar.b;
        this.g = qVar.c;
        this.e = qVar.d;
    }

    private static boolean a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String a : strArr) {
            if (o.a(strArr2, a)) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(SSLSocket sSLSocket) {
        return !this.d ? false : (this.g == null || a(this.g, sSLSocket.getEnabledProtocols())) ? this.f == null || a(this.f, sSLSocket.getEnabledCipherSuites()) : false;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        p pVar = (p) obj;
        return this.d == pVar.d ? !this.d || (Arrays.equals(this.f, pVar.f) && Arrays.equals(this.g, pVar.g) && this.e == pVar.e) : false;
    }

    public final int hashCode() {
        if (!this.d) {
            return 17;
        }
        return (this.e ? 0 : 1) + ((((Arrays.hashCode(this.f) + 527) * 31) + Arrays.hashCode(this.g)) * 31);
    }

    public final String toString() {
        Object obj = null;
        int i = 0;
        if (!this.d) {
            return "ConnectionSpec()";
        }
        String obj2;
        String obj3;
        if (this.f != null) {
            Object obj4;
            if (this.f == null) {
                obj4 = null;
            } else {
                Object[] objArr = new l[this.f.length];
                for (int i2 = 0; i2 < this.f.length; i2++) {
                    objArr[i2] = l.a(this.f[i2]);
                }
                obj4 = o.a(objArr);
            }
            obj2 = obj4.toString();
        } else {
            obj2 = "[all enabled]";
        }
        if (this.g != null) {
            if (this.g != null) {
                Object[] objArr2 = new av[this.g.length];
                while (i < this.g.length) {
                    objArr2[i] = av.a(this.g[i]);
                    i++;
                }
                obj = o.a(objArr2);
            }
            obj3 = obj.toString();
        } else {
            obj3 = "[all enabled]";
        }
        return "ConnectionSpec(cipherSuites=" + obj2 + ", tlsVersions=" + obj3 + ", supportsTlsExtensions=" + this.e + ")";
    }
}
