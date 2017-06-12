package b.a.a;

import b.a.h;
import c.f;
import java.io.IOException;

final class k extends h {
    final /* synthetic */ int a;
    final /* synthetic */ f c;
    final /* synthetic */ int d;
    final /* synthetic */ boolean e;
    final /* synthetic */ e f;

    k(e eVar, String str, Object[] objArr, int i, f fVar, int i2, boolean z) {
        this.f = eVar;
        this.a = i;
        this.c = fVar;
        this.d = i2;
        this.e = z;
        super(str, objArr);
    }

    public final void b() {
        try {
            this.f.v.a(this.c, this.d);
            this.f.i.a(this.a, a.CANCEL);
            synchronized (this.f) {
                this.f.y.remove(Integer.valueOf(this.a));
            }
        } catch (IOException e) {
        }
    }
}
