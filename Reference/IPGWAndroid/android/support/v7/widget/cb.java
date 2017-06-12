package android.support.v7.widget;

import android.support.v4.view.bq;
import android.support.v4.view.dk;
import android.view.View;

final class cb extends cg {
    final /* synthetic */ eq a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ dk d;
    final /* synthetic */ bv e;

    cb(bv bvVar, eq eqVar, int i, int i2, dk dkVar) {
        this.e = bvVar;
        this.a = eqVar;
        this.b = i;
        this.c = i2;
        this.d = dkVar;
        super();
    }

    public final void a(View view) {
    }

    public final void b(View view) {
        this.d.a(null);
        this.e.e(this.a);
        this.e.e.remove(this.a);
        this.e.c();
    }

    public final void c(View view) {
        if (this.b != 0) {
            bq.a(view, 0.0f);
        }
        if (this.c != 0) {
            bq.b(view, 0.0f);
        }
    }
}
