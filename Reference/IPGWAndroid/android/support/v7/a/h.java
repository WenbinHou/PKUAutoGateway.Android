package android.support.v7.a;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class h implements OnScrollListener {
    final /* synthetic */ View a;
    final /* synthetic */ View b;
    final /* synthetic */ d c;

    h(d dVar, View view, View view2) {
        this.c = dVar;
        this.a = view;
        this.b = view2;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        d.a(absListView, this.a, this.b);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
