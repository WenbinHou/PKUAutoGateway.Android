package b.a.b;

import c.l;
import c.x;
import c.y;

abstract class f implements x {
    protected final l a;
    protected boolean b;
    final /* synthetic */ e c;

    private f(e eVar) {
        this.c = eVar;
        this.a = new l(this.c.b.a());
    }

    public final y a() {
        return this.a;
    }

    protected final void a(boolean z) {
        if (this.c.d != 6) {
            if (this.c.d != 5) {
                throw new IllegalStateException("state: " + this.c.d);
            }
            e.a(this.a);
            this.c.d = 6;
            if (this.c.a != null) {
                this.c.a.a(!z, this.c);
            }
        }
    }
}
