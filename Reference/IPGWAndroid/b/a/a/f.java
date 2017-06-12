package b.a.a;

import b.a.h;
import java.io.IOException;

final class f extends h {
    final /* synthetic */ int a;
    final /* synthetic */ a c;
    final /* synthetic */ e d;

    f(e eVar, String str, Object[] objArr, int i, a aVar) {
        this.d = eVar;
        this.a = i;
        this.c = aVar;
        super(str, objArr);
    }

    public final void b() {
        try {
            this.d.b(this.a, this.c);
        } catch (IOException e) {
        }
    }
}
