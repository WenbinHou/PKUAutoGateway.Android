package android.support.v7.a;

import android.support.v7.view.menu.i;
import android.support.v7.view.menu.j;
import android.view.MenuItem;

final class av implements j {
    final /* synthetic */ at a;

    private av(at atVar) {
        this.a = atVar;
    }

    public final void a(i iVar) {
        if (this.a.b == null) {
            return;
        }
        if (this.a.a.i()) {
            this.a.b.onPanelClosed(108, iVar);
        } else if (this.a.b.onPreparePanel(0, null, iVar)) {
            this.a.b.onMenuOpened(108, iVar);
        }
    }

    public final boolean a(i iVar, MenuItem menuItem) {
        return false;
    }
}
