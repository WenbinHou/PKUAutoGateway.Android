package android.support.v4.widget;

import android.database.DataSetObserver;

final class n extends DataSetObserver {
    final /* synthetic */ l a;

    private n(l lVar) {
        this.a = lVar;
    }

    public final void onChanged() {
        this.a.a = true;
        this.a.notifyDataSetChanged();
    }

    public final void onInvalidated() {
        this.a.a = false;
        this.a.notifyDataSetInvalidated();
    }
}
