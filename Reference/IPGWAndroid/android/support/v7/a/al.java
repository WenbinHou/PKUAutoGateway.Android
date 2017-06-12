package android.support.v7.a;

import android.support.v4.view.bq;
import android.support.v7.view.b;
import android.support.v7.view.c;
import android.view.Menu;
import android.view.MenuItem;

final class al implements c {
    final /* synthetic */ ac a;
    private c b;

    public al(ac acVar, c cVar) {
        this.a = acVar;
        this.b = cVar;
    }

    public final void a(b bVar) {
        this.b.a(bVar);
        if (this.a.s != null) {
            this.a.c.getDecorView().removeCallbacks(this.a.t);
        }
        if (this.a.r != null) {
            this.a.l();
            this.a.u = bq.r(this.a.r).a(0.0f);
            this.a.u.a(new am(this));
        }
        this.a.q = null;
    }

    public final boolean a(b bVar, Menu menu) {
        return this.b.a(bVar, menu);
    }

    public final boolean a(b bVar, MenuItem menuItem) {
        return this.b.a(bVar, menuItem);
    }

    public final boolean b(b bVar, Menu menu) {
        return this.b.b(bVar, menu);
    }
}
