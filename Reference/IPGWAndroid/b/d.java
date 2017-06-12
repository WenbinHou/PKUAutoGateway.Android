package b;

import b.a.b;
import b.a.g;
import java.io.Closeable;
import java.io.Flushable;

public final class d implements Closeable, Flushable {
    final g a;
    private final b b;

    public final void close() {
        this.b.close();
    }

    public final void flush() {
        this.b.flush();
    }
}
