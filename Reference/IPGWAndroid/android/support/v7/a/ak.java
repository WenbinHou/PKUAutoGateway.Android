package android.support.v7.a;

import android.support.v7.view.menu.i;
import android.support.v7.view.menu.y;
import android.view.Window.Callback;

final class ak implements y {
    final /* synthetic */ ac a;

    private ak(ac acVar) {
        this.a = acVar;
    }

    public final void a(i iVar, boolean z) {
        this.a.b(iVar);
    }

    public final boolean a(i iVar) {
        Callback callback = this.a.c.getCallback();
        if (callback != null) {
            callback.onMenuOpened(108, iVar);
        }
        return true;
    }
}
