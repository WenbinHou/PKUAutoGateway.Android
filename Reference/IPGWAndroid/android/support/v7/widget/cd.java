package android.support.v7.widget;

import android.support.v4.view.bq;
import android.support.v4.view.dk;
import android.view.View;

final class cd extends cg {
    final /* synthetic */ ce a;
    final /* synthetic */ dk b;
    final /* synthetic */ View c;
    final /* synthetic */ bv d;

    cd(bv bvVar, ce ceVar, dk dkVar, View view) {
        this.d = bvVar;
        this.a = ceVar;
        this.b = dkVar;
        this.c = view;
        super();
    }

    public final void a(View view) {
    }

    public final void b(View view) {
        this.b.a(null);
        bq.c(this.c, 1.0f);
        bq.a(this.c, 0.0f);
        bq.b(this.c, 0.0f);
        this.d.e(this.a.b);
        this.d.g.remove(this.a.b);
        this.d.c();
    }
}
