package b.a.a;

import c.a;
import java.io.IOException;
import java.net.SocketTimeoutException;

final class w extends a {
    final /* synthetic */ t a;

    w(t tVar) {
        this.a = tVar;
    }

    protected final IOException a(IOException iOException) {
        IOException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    protected final void a() {
        this.a.b(a.CANCEL);
    }

    public final void b() {
        if (c_()) {
            throw a(null);
        }
    }
}
