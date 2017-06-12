package b.a.a;

import b.a.f;
import b.a.h;
import java.io.IOException;
import java.util.logging.Level;

final class q extends h {
    final /* synthetic */ t a;
    final /* synthetic */ p c;

    q(p pVar, String str, Object[] objArr, t tVar) {
        this.c = pVar;
        this.a = tVar;
        super(str, objArr);
    }

    public final void b() {
        try {
            this.c.c.m.a(this.a);
        } catch (Throwable e) {
            f.a.log(Level.INFO, "FramedConnection.Listener failure for " + this.c.c.o, e);
            try {
                this.a.a(a.PROTOCOL_ERROR);
            } catch (IOException e2) {
            }
        }
    }
}
