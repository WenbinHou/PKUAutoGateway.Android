package android.support.v7.widget;

final class dn implements Runnable {
    final /* synthetic */ RecyclerView a;

    dn(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final void run() {
        if (this.a.f && !this.a.isLayoutRequested()) {
            if (this.a.g) {
                this.a.G = true;
            } else {
                this.a.j();
            }
        }
    }
}
