package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.n;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

class p extends n {
    final ActionProvider c;
    final /* synthetic */ o d;

    public p(o oVar, Context context, ActionProvider actionProvider) {
        this.d = oVar;
        super(context);
        this.c = actionProvider;
    }

    public final View a() {
        return this.c.onCreateActionView();
    }

    public final void a(SubMenu subMenu) {
        this.c.onPrepareSubMenu(this.d.a(subMenu));
    }

    public final boolean d() {
        return this.c.onPerformDefaultAction();
    }

    public final boolean e() {
        return this.c.hasSubMenu();
    }
}
