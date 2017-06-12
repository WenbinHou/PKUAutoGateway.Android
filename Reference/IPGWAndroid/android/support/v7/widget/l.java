package android.support.v7.widget;

import android.content.Context;
import android.support.v7.b.b;
import android.support.v7.view.menu.ad;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.v;
import android.view.MenuItem;
import android.view.View;

final class l extends v {
    final /* synthetic */ k g;
    private ad h;

    public l(k kVar, Context context, ad adVar) {
        boolean z = false;
        this.g = kVar;
        super(context, adVar, null, false, b.actionOverflowMenuStyle);
        this.h = adVar;
        if (!((m) adVar.getItem()).f()) {
            this.b = kVar.i == null ? (View) kVar.g : kVar.i;
        }
        this.d = kVar.r;
        int size = adVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = adVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        this.e = z;
    }

    public final void onDismiss() {
        super.onDismiss();
        this.g.p = null;
        this.g.s = 0;
    }
}
