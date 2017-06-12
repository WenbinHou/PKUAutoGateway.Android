package b.a;

import b.a.d.a;
import b.a.d.f;
import b.aj;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

final class k extends j {
    private final Class<?> a;
    private final i<Socket> b;
    private final i<Socket> c;
    private final i<Socket> d;
    private final i<Socket> e;

    public k(Class<?> cls, i<Socket> iVar, i<Socket> iVar2, i<Socket> iVar3, i<Socket> iVar4) {
        this.a = cls;
        this.b = iVar;
        this.c = iVar2;
        this.d = iVar3;
        this.e = iVar4;
    }

    public final f a(X509TrustManager x509TrustManager) {
        f a = a.a(x509TrustManager);
        return a != null ? a : super.a(x509TrustManager);
    }

    public final X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        Object a;
        Object a2 = j.a((Object) sSLSocketFactory, this.a, "sslParameters");
        if (a2 == null) {
            try {
                a = j.a((Object) sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException e) {
                return super.a(sSLSocketFactory);
            }
        }
        a = a2;
        X509TrustManager x509TrustManager = (X509TrustManager) j.a(a, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) j.a(a, X509TrustManager.class, "trustManager");
    }

    public final void a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (o.a(e)) {
                throw new IOException(e);
            }
            throw e;
        } catch (Throwable e2) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        }
    }

    public final void a(SSLSocket sSLSocket, String str, List<aj> list) {
        if (str != null) {
            this.b.a(sSLSocket, Boolean.valueOf(true));
            this.c.a(sSLSocket, str);
        }
        if (this.e != null && this.e.a((Object) sSLSocket)) {
            Object[] objArr = new Object[1];
            c.f fVar = new c.f();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                aj ajVar = (aj) list.get(i);
                if (ajVar != aj.HTTP_1_0) {
                    fVar.b(ajVar.toString().length());
                    fVar.a(ajVar.toString());
                }
            }
            objArr[0] = fVar.n();
            this.e.b(sSLSocket, objArr);
        }
    }

    public final String b(SSLSocket sSLSocket) {
        if (this.d == null) {
            return null;
        }
        if (!this.d.a((Object) sSLSocket)) {
            return null;
        }
        byte[] bArr = (byte[]) this.d.b(sSLSocket, new Object[0]);
        return bArr != null ? new String(bArr, o.c) : null;
    }
}
