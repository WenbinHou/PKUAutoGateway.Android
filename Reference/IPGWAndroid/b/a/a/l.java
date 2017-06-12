package b.a.a;

import b.a.h;

final class l extends h {
    final /* synthetic */ int a;
    final /* synthetic */ a c;
    final /* synthetic */ e d;

    l(e eVar, String str, Object[] objArr, int i, a aVar) {
        this.d = eVar;
        this.a = i;
        this.c = aVar;
        super(str, objArr);
    }

    public final void b() {
        this.d.v.c();
        synchronized (this.d) {
            this.d.y.remove(Integer.valueOf(this.a));
        }
    }
}
