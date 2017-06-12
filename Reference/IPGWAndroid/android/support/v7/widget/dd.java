package android.support.v7.widget;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class dd implements OnScrollListener {
    final /* synthetic */ cu a;

    private dd(cu cuVar) {
        this.a = cuVar;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1 && !this.a.g() && this.a.c.getContentView() != null) {
            this.a.C.removeCallbacks(this.a.x);
            this.a.x.run();
        }
    }
}
