package android.support.v7.a;

import android.support.v4.view.bq;
import android.support.v4.view.eb;
import android.view.View;

final class am extends eb {
    final /* synthetic */ al a;

    am(al alVar) {
        this.a = alVar;
    }

    public final void b(View view) {
        this.a.a.r.setVisibility(8);
        if (this.a.a.s != null) {
            this.a.a.s.dismiss();
        } else if (this.a.a.r.getParent() instanceof View) {
            bq.u((View) this.a.a.r.getParent());
        }
        this.a.a.r.removeAllViews();
        this.a.a.u.a(null);
        this.a.a.u = null;
    }
}
