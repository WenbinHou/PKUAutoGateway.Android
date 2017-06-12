package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.p;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

final class u extends p implements VisibilityListener {
    p e;
    final /* synthetic */ t f;

    public u(t tVar, Context context, ActionProvider actionProvider) {
        this.f = tVar;
        super(tVar, context, actionProvider);
    }

    public final View a(MenuItem menuItem) {
        return this.c.onCreateActionView(menuItem);
    }

    public final void a(p pVar) {
        this.e = pVar;
        this.c.setVisibilityListener(this);
    }

    public final boolean b() {
        return this.c.overridesItemVisibility();
    }

    public final boolean c() {
        return this.c.isVisible();
    }

    public final void onActionProviderVisibilityChanged(boolean z) {
        if (this.e != null) {
            this.e.a();
        }
    }
}
