package android.support.design.widget;

import android.support.design.widget.AppBarLayout.Behavior;

final class d implements ce {
    final /* synthetic */ CoordinatorLayout a;
    final /* synthetic */ AppBarLayout b;
    final /* synthetic */ Behavior c;

    d(Behavior behavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.c = behavior;
        this.a = coordinatorLayout;
        this.b = appBarLayout;
    }

    public final void a(bz bzVar) {
        this.c.a_(this.a, this.b, bzVar.a.c());
    }
}
