package android.support.v7.widget;

final class ea implements dy {
    final /* synthetic */ RecyclerView a;

    private ea(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final void a(eq eqVar) {
        eqVar.a(true);
        if (eqVar.g != null && eqVar.h == null) {
            eqVar.g = null;
        }
        eqVar.h = null;
        if (!eq.g(eqVar) && !RecyclerView.c(this.a, eqVar.a) && eqVar.n()) {
            this.a.removeDetachedView(eqVar.a, false);
        }
    }
}
