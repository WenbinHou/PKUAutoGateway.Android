package b.a.a;

import b.a.h;
import java.io.IOException;
import java.util.List;

final class j extends h {
    final /* synthetic */ int a;
    final /* synthetic */ List c;
    final /* synthetic */ boolean d;
    final /* synthetic */ e e;

    j(e eVar, String str, Object[] objArr, int i, List list, boolean z) {
        this.e = eVar;
        this.a = i;
        this.c = list;
        this.d = z;
        super(str, objArr);
    }

    public final void b() {
        this.e.v.b();
        try {
            this.e.i.a(this.a, a.CANCEL);
            synchronized (this.e) {
                this.e.y.remove(Integer.valueOf(this.a));
            }
        } catch (IOException e) {
        }
    }
}
