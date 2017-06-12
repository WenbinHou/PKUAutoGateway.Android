package b.a.c;

import b.a.a;
import b.a.a.e;
import b.a.a.n;
import b.a.a.t;
import b.a.b.aa;
import b.a.b.ad;
import b.a.b.v;
import b.a.d.d;
import b.a.j;
import b.aj;
import b.an;
import b.ao;
import b.ar;
import b.as;
import b.au;
import b.i;
import b.m;
import b.p;
import b.x;
import c.g;
import c.h;
import c.o;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class c extends n implements m {
    public final au b;
    public Socket c;
    public x d;
    public volatile e e;
    public int f;
    public h g;
    public g h;
    public int i;
    public final List<Reference<ad>> j = new ArrayList();
    public boolean k;
    public long l = Long.MAX_VALUE;
    private Socket m;
    private aj n;

    public c(au auVar) {
        this.b = auVar;
    }

    public final au a() {
        return this.b;
    }

    public final void a(int i, int i2, int i3, List<p> list, boolean z) {
        IOException iOException;
        IOException e;
        aa aaVar;
        Throwable th;
        AssertionError assertionError;
        if (this.n != null) {
            throw new IllegalStateException("already connected");
        }
        a aVar = new a(list);
        Proxy proxy = this.b.b;
        b.a aVar2 = this.b.a;
        if (this.b.a.i == null) {
            if (!list.contains(p.c)) {
                throw new aa(new UnknownServiceException("CLEARTEXT communication not supported: " + list));
            }
        }
        aa aaVar2 = null;
        while (this.n == null) {
            Socket socket;
            Socket createSocket = (proxy.type() == Type.DIRECT || proxy.type() == Type.HTTP) ? aVar2.c.createSocket() : new Socket(proxy);
            this.m = createSocket;
            this.m.setSoTimeout(i2);
            j.a().a(this.m, this.b.c, i);
            this.g = o.a(o.b(this.m));
            this.h = o.a(o.a(this.m));
            if (this.b.a.i != null) {
                String str;
                au auVar = this.b;
                Object obj = (auVar.a.i == null || auVar.b.type() != Type.HTTP) ? null : 1;
                if (obj != null) {
                    an a = new ao().a(this.b.a.a).a("Host", b.a.o.a(this.b.a.a, true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", "okhttp/3.2.0").a();
                    str = "CONNECT " + b.a.o.a(a.a, true) + " HTTP/1.1";
                    b.a.b.e eVar = new b.a.b.e(null, this.g, this.h);
                    this.g.a().a((long) i2, TimeUnit.MILLISECONDS);
                    this.h.a().a((long) i3, TimeUnit.MILLISECONDS);
                    eVar.a(a.c, str);
                    eVar.b();
                    as c = eVar.c();
                    c.a = a;
                    ar a2 = c.a();
                    long a3 = v.a(a2);
                    if (a3 == -1) {
                        a3 = 0;
                    }
                    c.x a4 = eVar.a(a3);
                    b.a.o.a(a4, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
                    a4.close();
                    switch (a2.c) {
                        case 200:
                            if (!(this.g.b().d() && this.h.b().d())) {
                                throw new IOException("TLS tunnel buffered too many bytes!");
                            }
                        case 407:
                            this.b.a.d.a();
                            throw new IOException("Failed to authenticate with proxy");
                        default:
                            throw new IOException("Unexpected response code for CONNECT: " + a2.c);
                    }
                }
                b.a aVar3 = this.b.a;
                socket = null;
                try {
                    createSocket = (SSLSocket) aVar3.i.createSocket(this.m, aVar3.a.b, aVar3.a.c, true);
                    p a5 = aVar.a(createSocket);
                    if (a5.e) {
                        j.a().a((SSLSocket) createSocket, aVar3.a.b, aVar3.e);
                    }
                    createSocket.startHandshake();
                    x a6 = x.a(createSocket.getSession());
                    if (aVar3.j.verify(aVar3.a.b, createSocket.getSession())) {
                        aVar3.k.a(aVar3.a.b, a6.b);
                        str = a5.e ? j.a().b(createSocket) : null;
                        try {
                            this.c = createSocket;
                            this.g = o.a(o.b(this.c));
                            this.h = o.a(o.a(this.c));
                            this.d = a6;
                            this.n = str != null ? aj.a(str) : aj.HTTP_1_1;
                            if (createSocket != null) {
                                try {
                                    j.a().a((SSLSocket) createSocket);
                                } catch (ConnectException e2) {
                                    throw new ConnectException("Failed to connect to " + this.b.c);
                                } catch (IOException e3) {
                                    iOException = e3;
                                    b.a.o.a(this.c);
                                    b.a.o.a(this.m);
                                    this.c = null;
                                    this.m = null;
                                    this.g = null;
                                    this.h = null;
                                    this.d = null;
                                    this.n = null;
                                    if (aaVar2 == null) {
                                        aaVar = new aa(iOException);
                                    } else {
                                        e3 = aaVar2.b;
                                        if (aa.a != null) {
                                            try {
                                                aa.a.invoke(iOException, new Object[]{e3});
                                            } catch (InvocationTargetException e4) {
                                            } catch (IllegalAccessException e5) {
                                            }
                                        }
                                        aaVar2.b = iOException;
                                        aaVar = aaVar2;
                                    }
                                    if (z) {
                                        aVar.b = true;
                                        Object obj2 = (!aVar.a || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException) || (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException) || !((iOException instanceof SSLHandshakeException) || (iOException instanceof SSLProtocolException)))) ? null : 1;
                                        if (obj2 != null) {
                                            aaVar2 = aaVar;
                                        }
                                    }
                                    throw aaVar;
                                }
                            }
                        } catch (Throwable e6) {
                            th = e6;
                            socket = createSocket;
                            assertionError = th;
                        } catch (Throwable e62) {
                            th = e62;
                            socket = createSocket;
                            Throwable th2 = th;
                        }
                    } else {
                        Certificate certificate = (X509Certificate) a6.b.get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + aVar3.a.b + " not verified:\n    certificate: " + i.a(certificate) + "\n    DN: " + certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + d.a(certificate));
                    }
                } catch (AssertionError e7) {
                    assertionError = e7;
                }
            } else {
                this.n = aj.HTTP_1_1;
                this.c = this.m;
            }
            if (this.n == aj.SPDY_3 || this.n == aj.HTTP_2) {
                this.c.setSoTimeout(0);
                b.a.a.m mVar = new b.a.a.m();
                socket = this.c;
                String str2 = this.b.a.a.b;
                h hVar = this.g;
                g gVar = this.h;
                mVar.a = socket;
                mVar.b = str2;
                mVar.c = hVar;
                mVar.d = gVar;
                mVar.f = this.n;
                mVar.e = this;
                e eVar2 = new e(mVar);
                eVar2.i.a();
                eVar2.i.b(eVar2.e);
                int b = eVar2.e.b();
                if (b != 65536) {
                    eVar2.i.a(0, (long) (b - 65536));
                }
                this.i = eVar2.a();
                this.e = eVar2;
            } else {
                this.i = 1;
            }
        }
        return;
        try {
            if (b.a.o.a(assertionError)) {
                throw new IOException(assertionError);
            }
            throw assertionError;
        } catch (Throwable th3) {
            th2 = th3;
        }
        if (socket != null) {
            j.a().a((SSLSocket) socket);
        }
        b.a.o.a(socket);
        throw th2;
    }

    public final void a(e eVar) {
        this.i = eVar.a();
    }

    public final void a(t tVar) {
        tVar.a(b.a.a.a.REFUSED_STREAM);
    }

    public final boolean a(boolean z) {
        if (this.c.isClosed() || this.c.isInputShutdown() || this.c.isOutputShutdown()) {
            return false;
        }
        if (this.e != null || !z) {
            return true;
        }
        int soTimeout;
        try {
            soTimeout = this.c.getSoTimeout();
            this.c.setSoTimeout(1);
            if (this.g.d()) {
                this.c.setSoTimeout(soTimeout);
                return false;
            }
            this.c.setSoTimeout(soTimeout);
            return true;
        } catch (SocketTimeoutException e) {
            return true;
        } catch (IOException e2) {
            return false;
        } catch (Throwable th) {
            this.c.setSoTimeout(soTimeout);
        }
    }

    public final String toString() {
        return "Connection{" + this.b.a.a.b + ":" + this.b.a.a.c + ", proxy=" + this.b.b + " hostAddress=" + this.b.c + " cipherSuite=" + (this.d != null ? this.d.a : "none") + " protocol=" + this.n + '}';
    }
}
