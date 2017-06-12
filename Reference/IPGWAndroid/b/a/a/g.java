package b.a.a;

import b.a.h;
import java.io.IOException;

final class g extends h {
    final /* synthetic */ int a;
    final /* synthetic */ long c;
    final /* synthetic */ e d;

    g(e eVar, String str, Object[] objArr, int i, long j) {
        this.d = eVar;
        this.a = i;
        this.c = j;
        super(str, objArr);
    }

    public final void b() {
        try {
            this.d.i.a(this.a, this.c);
        } catch (IOException e) {
        }
    }
}
