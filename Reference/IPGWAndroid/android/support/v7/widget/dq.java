package android.support.v7.widget;

final class dq implements gg {
    final /* synthetic */ RecyclerView a;

    dq(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final void a(eq eqVar) {
        this.a.e.a(eqVar.a, this.a.a);
    }

    public final void a(eq eqVar, dz dzVar, dz dzVar2) {
        this.a.a.b(eqVar);
        RecyclerView.a(this.a, eqVar, dzVar, dzVar2);
    }

    public final void b(eq eqVar, dz dzVar, dz dzVar2) {
        RecyclerView.b(this.a, eqVar, dzVar, dzVar2);
    }

    public final void c(eq eqVar, dz dzVar, dz dzVar2) {
        eqVar.a(false);
        if (this.a.h) {
            if (this.a.m.a(eqVar, eqVar, dzVar, dzVar2)) {
                this.a.s();
            }
        } else if (this.a.m.c(eqVar, dzVar, dzVar2)) {
            this.a.s();
        }
    }
}
