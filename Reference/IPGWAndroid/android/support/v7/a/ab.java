package android.support.v7.a;

import android.view.ActionMode;
import android.view.Window.Callback;

final class ab extends z {
    final /* synthetic */ aa c;

    ab(aa aaVar, Callback callback) {
        this.c = aaVar;
        super(aaVar, callback);
    }

    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        if (this.c.p) {
            switch (i) {
                case 0:
                    return a(callback);
            }
        }
        return super.onWindowStartingActionMode(callback, i);
    }
}
