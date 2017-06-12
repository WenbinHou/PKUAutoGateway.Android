package android.support.v7.widget;

import android.support.v4.view.bq;
import android.support.v4.view.dk;
import android.view.View;

final class cc extends cg {
    final /* synthetic */ ce a;
    final /* synthetic */ dk b;
    final /* synthetic */ bv c;

    cc(bv bvVar, ce ceVar, dk dkVar) {
        this.c = bvVar;
        this.a = ceVar;
        this.b = dkVar;
        super();
    }

    public final void a(View view) {
    }

    public final void b(View view) {
        this.b.a(null);
        bq.c(view, 1.0f);
        bq.a(view, 0.0f);
        bq.b(view, 0.0f);
        this.c.e(this.a.a);
        this.c.g.remove(this.a.a);
        this.c.c();
    }
}
