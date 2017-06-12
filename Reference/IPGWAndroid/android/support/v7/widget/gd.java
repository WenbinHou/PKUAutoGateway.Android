package android.support.v7.widget;

import android.support.v4.view.eb;
import android.view.View;

final class gd extends eb {
    final /* synthetic */ int a;
    final /* synthetic */ gb b;
    private boolean c = false;

    gd(gb gbVar, int i) {
        this.b = gbVar;
        this.a = i;
    }

    public final void a(View view) {
        this.b.a.setVisibility(0);
    }

    public final void b(View view) {
        if (!this.c) {
            this.b.a.setVisibility(this.a);
        }
    }

    public final void c(View view) {
        this.c = true;
    }
}
