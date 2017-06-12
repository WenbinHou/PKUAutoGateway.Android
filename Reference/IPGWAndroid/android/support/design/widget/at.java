package android.support.design.widget;

import android.view.View;

final class at implements bl {
    final /* synthetic */ Snackbar a;

    at(Snackbar snackbar) {
        this.a = snackbar;
    }

    public final void a(int i) {
        switch (i) {
            case 0:
                bd.a().b(this.a.c);
                return;
            case 1:
            case 2:
                bd.a().a(this.a.c);
                return;
            default:
                return;
        }
    }

    public final void a(View view) {
        view.setVisibility(8);
        Snackbar.a(this.a);
    }
}
