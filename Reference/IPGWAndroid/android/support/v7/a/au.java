package android.support.v7.a;

import android.support.v7.view.menu.i;
import android.support.v7.view.menu.y;

final class au implements y {
    final /* synthetic */ at a;
    private boolean b;

    private au(at atVar) {
        this.a = atVar;
    }

    public final void a(i iVar, boolean z) {
        if (!this.b) {
            this.b = true;
            this.a.a.n();
            if (this.a.b != null) {
                this.a.b.onPanelClosed(108, iVar);
            }
            this.b = false;
        }
    }

    public final boolean a(i iVar) {
        if (this.a.b == null) {
            return false;
        }
        this.a.b.onMenuOpened(108, iVar);
        return true;
    }
}
