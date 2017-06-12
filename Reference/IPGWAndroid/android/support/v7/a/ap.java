package android.support.v7.a;

import android.support.v7.view.menu.i;
import android.support.v7.view.menu.y;
import android.view.Menu;
import android.view.Window.Callback;

final class ap implements y {
    final /* synthetic */ ac a;

    private ap(ac acVar) {
        this.a = acVar;
    }

    public final void a(i iVar, boolean z) {
        Menu menu;
        Menu k = iVar.k();
        boolean z2 = k != iVar;
        ac acVar = this.a;
        if (z2) {
            menu = k;
        }
        ao a = acVar.a(menu);
        if (a == null) {
            return;
        }
        if (z2) {
            this.a.a(a.a, a, k);
            this.a.a(a, true);
            return;
        }
        this.a.a(a, z);
    }

    public final boolean a(i iVar) {
        if (iVar == null && this.a.i) {
            Callback callback = this.a.c.getCallback();
            if (!(callback == null || this.a.o)) {
                callback.onMenuOpened(108, iVar);
            }
        }
        return true;
    }
}
