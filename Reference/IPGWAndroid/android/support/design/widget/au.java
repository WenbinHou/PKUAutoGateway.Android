package android.support.design.widget;

final class au implements bb {
    final /* synthetic */ Snackbar a;

    au(Snackbar snackbar) {
        this.a = snackbar;
    }

    public final void a() {
        if (bd.a().c(this.a.c)) {
            Snackbar.d.post(new av(this));
        }
    }
}
