package android.support.design.widget;

import android.database.DataSetObserver;

final class bq extends DataSetObserver {
    final /* synthetic */ TabLayout a;

    private bq(TabLayout tabLayout) {
        this.a = tabLayout;
    }

    public final void onChanged() {
        this.a.c();
    }

    public final void onInvalidated() {
        this.a.c();
    }
}
