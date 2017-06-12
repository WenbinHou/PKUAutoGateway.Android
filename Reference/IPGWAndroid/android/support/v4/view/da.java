package android.support.v4.view;

import android.database.DataSetObserver;

final class da extends DataSetObserver {
    final /* synthetic */ ViewPager a;

    private da(ViewPager viewPager) {
        this.a = viewPager;
    }

    public final void onChanged() {
        this.a.a();
    }

    public final void onInvalidated() {
        this.a.a();
    }
}
