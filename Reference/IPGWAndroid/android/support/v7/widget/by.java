package android.support.v7.widget;

import android.support.v4.view.bq;
import android.support.v4.view.dk;
import java.util.ArrayList;
import java.util.Iterator;

final class by implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ bv b;

    by(bv bvVar, ArrayList arrayList) {
        this.b = bvVar;
        this.a = arrayList;
    }

    public final void run() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            eq eqVar = (eq) it.next();
            dx dxVar = this.b;
            dk r = bq.r(eqVar.a);
            dxVar.d.add(eqVar);
            r.a(1.0f).a(dxVar.i).a(new ca(dxVar, eqVar, r)).b();
        }
        this.a.clear();
        this.b.a.remove(this.a);
    }
}
