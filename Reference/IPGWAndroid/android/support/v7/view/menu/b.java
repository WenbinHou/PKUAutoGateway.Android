package android.support.v7.view.menu;

import android.support.v7.widget.cu;
import android.support.v7.widget.cy;

final class b extends cy {
    final /* synthetic */ ActionMenuItemView a;

    public b(ActionMenuItemView actionMenuItemView) {
        this.a = actionMenuItemView;
        super(actionMenuItemView);
    }

    public final cu a() {
        return this.a.f != null ? this.a.f.a() : null;
    }

    protected final boolean b() {
        if (this.a.d == null || !this.a.d.a(this.a.a)) {
            return false;
        }
        cu a = a();
        return a != null && a.c.isShowing();
    }
}
