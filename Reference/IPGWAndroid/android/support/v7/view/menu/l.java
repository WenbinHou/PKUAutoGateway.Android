package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.support.v7.a.q;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;

final class l implements OnClickListener, OnDismissListener, OnKeyListener, y {
    i a;
    q b;
    g c;
    private y d;

    public l(i iVar) {
        this.a = iVar;
    }

    public final void a(i iVar, boolean z) {
        if ((z || iVar == this.a) && this.b != null) {
            this.b.dismiss();
        }
        if (this.d != null) {
            this.d.a(iVar, z);
        }
    }

    public final boolean a(i iVar) {
        return this.d != null ? this.d.a(iVar) : false;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a((m) this.c.b().getItem(i), null, 0);
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.c.a(this.a, true);
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.b.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.b.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.a.a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.a.performShortcut(i, keyEvent, 0);
    }
}
