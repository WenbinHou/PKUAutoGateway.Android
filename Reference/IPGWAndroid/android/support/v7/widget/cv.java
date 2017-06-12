package android.support.v7.widget;

import android.view.View;

final class cv implements Runnable {
    final /* synthetic */ cu a;

    cv(cu cuVar) {
        this.a = cuVar;
    }

    public final void run() {
        View view = this.a.l;
        if (view != null && view.getWindowToken() != null) {
            this.a.b();
        }
    }
}
