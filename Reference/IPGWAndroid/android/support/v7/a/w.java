package android.support.v7.a;

import android.support.v7.view.menu.i;
import android.support.v7.view.n;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;

class w extends n {
    final /* synthetic */ v a;

    w(v vVar, Callback callback) {
        this.a = vVar;
        super(callback);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.a.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent) || this.a.a(keyEvent.getKeyCode(), keyEvent);
    }

    public void onContentChanged() {
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return (i != 0 || (menu instanceof i)) ? super.onCreatePanelMenu(i, menu) : false;
    }

    public boolean onMenuOpened(int i, Menu menu) {
        super.onMenuOpened(i, menu);
        this.a.e(i);
        return true;
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
        this.a.d(i);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        i iVar = menu instanceof i ? (i) menu : null;
        if (i == 0 && iVar == null) {
            return false;
        }
        if (iVar != null) {
            iVar.k = true;
        }
        boolean onPreparePanel = super.onPreparePanel(i, view, menu);
        if (iVar == null) {
            return onPreparePanel;
        }
        iVar.k = false;
        return onPreparePanel;
    }
}
