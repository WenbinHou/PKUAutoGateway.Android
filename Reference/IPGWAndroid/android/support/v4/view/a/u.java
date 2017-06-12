package android.support.v4.view.a;

import java.util.ArrayList;
import java.util.List;

final class u implements aa {
    final /* synthetic */ r a;
    final /* synthetic */ t b;

    u(t tVar, r rVar) {
        this.b = tVar;
        this.a = rVar;
    }

    public final boolean a() {
        return r.b();
    }

    public final List<Object> b() {
        List list = null;
        r.c();
        List<Object> arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((f) list.get(i)).b);
        }
        return arrayList;
    }

    public final Object c() {
        r.a();
        return null;
    }
}
