package android.support.v7.widget;

final class do implements Runnable {
    final /* synthetic */ RecyclerView a;

    do(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final void run() {
        if (this.a.m != null) {
            this.a.m.a();
        }
        this.a.af = false;
    }
}
