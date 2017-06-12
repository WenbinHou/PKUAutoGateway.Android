package b.a.a;

import b.a.h;
import java.io.IOException;
import java.util.List;

final class i extends h {
    final /* synthetic */ int a;
    final /* synthetic */ List c;
    final /* synthetic */ e d;

    i(e eVar, String str, Object[] objArr, int i, List list) {
        this.d = eVar;
        this.a = i;
        this.c = list;
        super(str, objArr);
    }

    public final void b() {
        this.d.v.a();
        try {
            this.d.i.a(this.a, a.CANCEL);
            synchronized (this.d) {
                this.d.y.remove(Integer.valueOf(this.a));
            }
        } catch (IOException e) {
        }
    }
}
