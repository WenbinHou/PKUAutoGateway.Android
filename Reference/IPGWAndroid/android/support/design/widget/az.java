package android.support.design.widget;

import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.view.bq;
import android.support.v4.view.eb;
import android.view.View;

final class az extends eb {
    boolean a = false;
    final /* synthetic */ int b;
    final /* synthetic */ Snackbar c;

    az(Snackbar snackbar, int i) {
        this.c = snackbar;
        this.b = i;
    }

    public final void a(View view) {
        if (!this.c.e.isEnabled()) {
            SnackbarLayout e = this.c.b;
            bq.c(e.a, 1.0f);
            bq.r(e.a).a(0.0f).a(180).b(0).b();
            if (e.b.getVisibility() == 0) {
                bq.c(e.b, 1.0f);
                bq.r(e.b).a(0.0f).a(180).b(0).b();
            }
        }
    }

    public final void b(View view) {
        this.c.b();
    }
}
