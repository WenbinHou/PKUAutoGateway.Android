package android.support.v7.widget;

import android.database.DataSetObserver;

final class dc extends DataSetObserver {
    final /* synthetic */ cu a;

    private dc(cu cuVar) {
        this.a = cuVar;
    }

    public final void onChanged() {
        if (this.a.c.isShowing()) {
            this.a.b();
        }
    }

    public final void onInvalidated() {
        this.a.d();
    }
}
