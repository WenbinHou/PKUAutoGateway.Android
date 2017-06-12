package android.support.v7.a;

import android.support.v4.view.bq;
import android.support.v4.view.eb;
import android.view.View;

final class aj extends eb {
    final /* synthetic */ ac a;

    aj(ac acVar) {
        this.a = acVar;
    }

    public final void a(View view) {
        this.a.r.setVisibility(0);
        this.a.r.sendAccessibilityEvent(32);
        if (this.a.r.getParent() != null) {
            bq.u((View) this.a.r.getParent());
        }
    }

    public final void b(View view) {
        bq.c(this.a.r, 1.0f);
        this.a.u.a(null);
        this.a.u = null;
    }
}
