package b;

import b.a.f;
import b.a.h;
import java.io.IOException;
import java.util.logging.Level;

final class am extends h {
    final /* synthetic */ ak a;
    private final h c;
    private final boolean d;

    private am(ak akVar, h hVar) {
        this.a = akVar;
        super("OkHttp %s", akVar.c.a.toString());
        this.c = hVar;
        this.d = false;
    }

    final String a() {
        return this.a.c.a.b;
    }

    protected final void b() {
        Throwable e;
        Object obj = 1;
        Object obj2 = null;
        try {
            ak akVar = this.a;
            ar a = new al(akVar, 0, akVar.c, this.d).a(akVar.c);
            if (this.a.b) {
                try {
                    h hVar = this.c;
                    IOException iOException = new IOException("Canceled");
                    hVar.a();
                } catch (IOException e2) {
                    e = e2;
                    if (obj == null) {
                        try {
                            f.a.log(Level.INFO, "Callback failure for " + ak.a(this.a), e);
                        } catch (Throwable th) {
                            this.a.a.a.b(this);
                        }
                    } else {
                        this.c.a();
                    }
                    this.a.a.a.b(this);
                }
            }
            this.c.a(a);
            this.a.a.a.b(this);
        } catch (IOException e3) {
            e = e3;
            obj = obj2;
            if (obj == null) {
                this.c.a();
            } else {
                f.a.log(Level.INFO, "Callback failure for " + ak.a(this.a), e);
            }
            this.a.a.a.b(this);
        }
    }
}
