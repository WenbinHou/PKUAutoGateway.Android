package b.a.b;

import b.a.o;
import c.f;
import c.g;
import c.h;
import c.x;
import c.y;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class r implements x {
    boolean a;
    final /* synthetic */ h b;
    final /* synthetic */ a c;
    final /* synthetic */ g d;
    final /* synthetic */ p e;

    public r(p pVar, h hVar, a aVar, g gVar) {
        this.e = pVar;
        this.b = hVar;
        this.c = aVar;
        this.d = gVar;
    }

    public final long a(f fVar, long j) {
        try {
            long a = this.b.a(fVar, j);
            if (a == -1) {
                if (!this.a) {
                    this.a = true;
                    this.d.close();
                }
                return -1;
            }
            fVar.a(this.d.b(), fVar.b - a, a);
            this.d.p();
            return a;
        } catch (IOException e) {
            if (!this.a) {
                this.a = true;
            }
            throw e;
        }
    }

    public final y a() {
        return this.b.a();
    }

    public final void close() {
        if (!(this.a || o.a((x) this, TimeUnit.MILLISECONDS))) {
            this.a = true;
        }
        this.b.close();
    }
}
