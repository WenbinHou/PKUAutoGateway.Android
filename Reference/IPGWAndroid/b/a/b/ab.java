package b.a.b;

import b.a;
import b.a.n;
import b.aa;
import b.au;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class ab {
    final a a;
    final n b;
    private Proxy c;
    private InetSocketAddress d;
    private List<Proxy> e = Collections.emptyList();
    private int f;
    private List<InetSocketAddress> g = Collections.emptyList();
    private int h;
    private final List<au> i = new ArrayList();

    public ab(a aVar, n nVar) {
        this.a = aVar;
        this.b = nVar;
        aa aaVar = aVar.a;
        Proxy proxy = aVar.h;
        if (proxy != null) {
            this.e = Collections.singletonList(proxy);
        } else {
            this.e = new ArrayList();
            Collection select = this.a.g.select(aaVar.a());
            if (select != null) {
                this.e.addAll(select);
            }
            this.e.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.e.add(Proxy.NO_PROXY);
        }
        this.f = 0;
    }

    private void a(Proxy proxy) {
        String str;
        int i;
        this.g = new ArrayList();
        if (proxy.type() == Type.DIRECT || proxy.type() == Type.SOCKS) {
            str = this.a.a.b;
            i = this.a.a.c;
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                InetAddress address2 = inetSocketAddress.getAddress();
                str = address2 == null ? inetSocketAddress.getHostName() : address2.getHostAddress();
                i = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i <= 0 || i > 65535) {
            throw new SocketException("No route to " + str + ":" + i + "; port is out of range");
        }
        if (proxy.type() == Type.SOCKS) {
            this.g.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            List a = this.a.b.a(str);
            int size = a.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.g.add(new InetSocketAddress((InetAddress) a.get(i2), i));
            }
        }
        this.h = 0;
    }

    public final au a() {
        while (true) {
            if (!c()) {
                if (!b()) {
                    break;
                } else if (b()) {
                    List list = this.e;
                    int i = this.f;
                    this.f = i + 1;
                    Proxy proxy = (Proxy) list.get(i);
                    a(proxy);
                    this.c = proxy;
                } else {
                    throw new SocketException("No route to " + this.a.a.b + "; exhausted proxy configurations: " + this.e);
                }
            }
            if (c()) {
                list = this.g;
                i = this.h;
                this.h = i + 1;
                this.d = (InetSocketAddress) list.get(i);
                au auVar = new au(this.a, this.c, this.d);
                if (!this.b.c(auVar)) {
                    return auVar;
                }
                this.i.add(auVar);
            } else {
                throw new SocketException("No route to " + this.a.a.b + "; exhausted inet socket addresses: " + this.g);
            }
        }
        if (d()) {
            return (au) this.i.remove(0);
        }
        throw new NoSuchElementException();
    }

    final boolean b() {
        return this.f < this.e.size();
    }

    final boolean c() {
        return this.h < this.g.size();
    }

    final boolean d() {
        return !this.i.isEmpty();
    }
}
