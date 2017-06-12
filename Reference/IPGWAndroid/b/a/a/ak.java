package b.a.a;

import c.f;
import c.k;
import c.x;

final class ak extends k {
    final /* synthetic */ aj a;

    ak(aj ajVar, x xVar) {
        this.a = ajVar;
        super(xVar);
    }

    public final long a(f fVar, long j) {
        if (this.a.a == 0) {
            return -1;
        }
        long a = super.a(fVar, Math.min(j, (long) this.a.a));
        if (a == -1) {
            return -1;
        }
        this.a.a = (int) (((long) this.a.a) - a);
        return a;
    }
}
