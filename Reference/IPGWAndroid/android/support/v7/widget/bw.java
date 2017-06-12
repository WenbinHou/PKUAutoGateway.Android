package android.support.v7.widget;

import android.support.v4.view.bq;
import android.support.v4.view.dk;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

final class bw implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ bv b;

    bw(bv bvVar, ArrayList arrayList) {
        this.b = bvVar;
        this.a = arrayList;
    }

    public final void run() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            cf cfVar = (cf) it.next();
            dx dxVar = this.b;
            eq eqVar = cfVar.a;
            int i = cfVar.b;
            int i2 = cfVar.c;
            int i3 = cfVar.d;
            int i4 = cfVar.e;
            View view = eqVar.a;
            i = i3 - i;
            i2 = i4 - i2;
            if (i != 0) {
                bq.r(view).b(0.0f);
            }
            if (i2 != 0) {
                bq.r(view).c(0.0f);
            }
            dk r = bq.r(view);
            dxVar.e.add(eqVar);
            r.a(dxVar.k).a(new cb(dxVar, eqVar, i, i2, r)).b();
        }
        this.a.clear();
        this.b.b.remove(this.a);
    }
}
