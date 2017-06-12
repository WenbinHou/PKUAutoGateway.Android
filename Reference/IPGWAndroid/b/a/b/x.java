package b.a.b;

import java.io.IOException;

public final class x extends Exception {
    public final IOException a() {
        return (IOException) super.getCause();
    }

    public final /* bridge */ /* synthetic */ Throwable getCause() {
        return (IOException) super.getCause();
    }
}
