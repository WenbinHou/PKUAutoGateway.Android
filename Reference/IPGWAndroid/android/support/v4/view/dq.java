package android.support.v4.view;

import android.view.View;

class dq extends dn {
    dq() {
    }

    public final void a(dk dkVar, View view, ea eaVar) {
        if (eaVar != null) {
            view.animate().setListener(new dx(eaVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
