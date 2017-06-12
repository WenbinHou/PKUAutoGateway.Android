package c;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public final class o {
    private static final Logger a = Logger.getLogger(o.class.getName());

    private o() {
    }

    public static g a(w wVar) {
        if (wVar != null) {
            return new s(wVar);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static h a(x xVar) {
        if (xVar != null) {
            return new t(xVar);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static w a(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        y c = c(socket);
        OutputStream outputStream = socket.getOutputStream();
        if (outputStream != null) {
            return new b(c, new p(c, outputStream));
        }
        throw new IllegalArgumentException("out == null");
    }

    public static x b(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        y c = c(socket);
        InputStream inputStream = socket.getInputStream();
        if (inputStream != null) {
            return new c(c, new q(c, inputStream));
        }
        throw new IllegalArgumentException("in == null");
    }

    private static a c(Socket socket) {
        return new r(socket);
    }
}
