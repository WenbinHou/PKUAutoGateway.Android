package c;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

final class r extends a {
    final /* synthetic */ Socket a;

    r(Socket socket) {
        this.a = socket;
    }

    protected final IOException a(IOException iOException) {
        IOException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    protected final void a() {
        try {
            this.a.close();
        } catch (Throwable e) {
            o.a.log(Level.WARNING, "Failed to close timed out socket " + this.a, e);
        } catch (Throwable e2) {
            if (e2.getCause() == null || e2.getMessage() == null || !e2.getMessage().contains("getsockname failed")) {
                throw e2;
            }
            o.a.log(Level.WARNING, "Failed to close timed out socket " + this.a, e2);
        }
    }
}
