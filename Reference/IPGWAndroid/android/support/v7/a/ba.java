package android.support.v7.a;

import android.support.v4.view.bq;
import android.support.v4.view.eb;
import android.view.View;

final class ba extends eb {
    final /* synthetic */ az a;

    ba(az azVar) {
        this.a = azVar;
    }

    public final void b(View view) {
        if (this.a.C && this.a.t != null) {
            bq.b(this.a.t, 0.0f);
            bq.b(this.a.q, 0.0f);
        }
        this.a.q.setVisibility(8);
        this.a.q.setTransitioning(false);
        this.a.H = null;
        az azVar = this.a;
        if (azVar.c != null) {
            azVar.c.a(azVar.b);
            azVar.b = null;
            azVar.c = null;
        }
        if (this.a.p != null) {
            bq.u(this.a.p);
        }
    }
}
