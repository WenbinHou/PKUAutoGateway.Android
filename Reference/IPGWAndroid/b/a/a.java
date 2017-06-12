package b.a;

import b.p;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class a {
    public boolean a;
    public boolean b;
    private final List<p> c;
    private int d = 0;

    public a(List<p> list) {
        this.c = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i = this.d; i < this.c.size(); i++) {
            if (((p) this.c.get(i)).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public final p a(SSLSocket sSLSocket) {
        p pVar;
        int i = this.d;
        int size = this.c.size();
        for (int i2 = i; i2 < size; i2++) {
            pVar = (p) this.c.get(i2);
            if (pVar.a(sSLSocket)) {
                this.d = i2 + 1;
                break;
            }
        }
        pVar = null;
        if (pVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.b + ", modes=" + this.c + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.a = b(sSLSocket);
        f.b.a(pVar, sSLSocket, this.b);
        return pVar;
    }
}
