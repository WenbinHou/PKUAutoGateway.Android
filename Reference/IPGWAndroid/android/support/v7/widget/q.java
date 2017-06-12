package android.support.v7.widget;

import android.content.Context;
import android.support.v7.b.b;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.v;
import android.view.View;

final class q extends v {
    final /* synthetic */ k g;

    public q(k kVar, Context context, i iVar, View view) {
        this.g = kVar;
        super(context, iVar, view, true, b.actionOverflowMenuStyle);
        this.d = kVar.r;
    }

    public final void onDismiss() {
        super.onDismiss();
        if (this.g.c != null) {
            this.g.c.close();
        }
        this.g.o = null;
    }
}
