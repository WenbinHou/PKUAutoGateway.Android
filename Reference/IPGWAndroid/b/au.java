package b;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class au {
    public final a a;
    public final Proxy b;
    public final InetSocketAddress c;

    public au(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        } else {
            this.a = aVar;
            this.b = proxy;
            this.c = inetSocketAddress;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof au)) {
            return false;
        }
        au auVar = (au) obj;
        return this.a.equals(auVar.a) && this.b.equals(auVar.b) && this.c.equals(auVar.c);
    }

    public final int hashCode() {
        return ((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }
}
