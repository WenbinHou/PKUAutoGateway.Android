package android.support.v4.app;

import android.support.v4.g.a;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;

final class g implements OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ Object b;
    final /* synthetic */ ArrayList c;
    final /* synthetic */ j d;
    final /* synthetic */ boolean e;
    final /* synthetic */ n f;
    final /* synthetic */ n g;
    final /* synthetic */ e h;

    g(e eVar, View view, Object obj, ArrayList arrayList, j jVar, boolean z, n nVar, n nVar2) {
        this.h = eVar;
        this.a = view;
        this.b = obj;
        this.c = arrayList;
        this.d = jVar;
        this.e = z;
        this.f = nVar;
        this.g = nVar2;
    }

    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.b != null) {
            aj.a(this.b, this.c);
            this.c.clear();
            a a = e.a(this.h, this.d, this.e, this.f);
            aj.a(this.b, this.d.d, a, this.c);
            e.a(this.h, a, this.d);
            e.a(this.f, this.g, this.e, a);
        }
        return true;
    }
}
