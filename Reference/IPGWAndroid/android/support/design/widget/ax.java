package android.support.design.widget;

import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.view.bq;
import android.support.v4.view.eb;
import android.view.View;

final class ax extends eb {
    final /* synthetic */ Snackbar a;

    ax(Snackbar snackbar) {
        this.a = snackbar;
    }

    public final void a(View view) {
        if (!this.a.e.isEnabled()) {
            SnackbarLayout e = this.a.b;
            bq.c(e.a, 0.0f);
            bq.r(e.a).a(1.0f).a(180).b(70).b();
            if (e.b.getVisibility() == 0) {
                bq.c(e.b, 0.0f);
                bq.r(e.b).a(1.0f).a(180).b(70).b();
            }
        }
    }

    public final void b(View view) {
        Snackbar.g(this.a);
    }
}
