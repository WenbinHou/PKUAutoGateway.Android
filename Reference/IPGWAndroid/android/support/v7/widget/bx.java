package android.support.v7.widget;

import android.support.v4.view.bq;
import android.support.v4.view.dk;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

final class bx implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ bv b;

    bx(bv bvVar, ArrayList arrayList) {
        this.b = bvVar;
        this.a = arrayList;
    }

    public final void run() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ce ceVar = (ce) it.next();
            dx dxVar = this.b;
            eq eqVar = ceVar.a;
            View view = eqVar == null ? null : eqVar.a;
            eq eqVar2 = ceVar.b;
            View view2 = eqVar2 != null ? eqVar2.a : null;
            if (view != null) {
                dk a = bq.r(view).a(dxVar.l);
                dxVar.g.add(ceVar.a);
                a.b((float) (ceVar.e - ceVar.c));
                a.c((float) (ceVar.f - ceVar.d));
                a.a(0.0f).a(new cc(dxVar, ceVar, a)).b();
            }
            if (view2 != null) {
                a = bq.r(view2);
                dxVar.g.add(ceVar.b);
                a.b(0.0f).c(0.0f).a(dxVar.l).a(1.0f).a(new cd(dxVar, ceVar, a, view2)).b();
            }
        }
        this.a.clear();
        this.b.c.remove(this.a);
    }
}
