package android.support.v4.view.a;

import java.util.ArrayList;
import java.util.List;

final class w implements ad {
    final /* synthetic */ r a;
    final /* synthetic */ v b;

    w(v vVar, r rVar) {
        this.b = vVar;
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

    public final Object d() {
        r.d();
        return null;
    }
}
