package android.support.v7.widget;

import android.support.v7.view.menu.i;
import android.support.v7.view.menu.j;
import android.view.MenuItem;

final class v implements j {
    final /* synthetic */ ActionMenuView a;

    private v(ActionMenuView actionMenuView) {
        this.a = actionMenuView;
    }

    public final void a(i iVar) {
        if (this.a.g != null) {
            this.a.g.a(iVar);
        }
    }

    public final boolean a(i iVar, MenuItem menuItem) {
        return this.a.l != null && this.a.l.a();
    }
}
