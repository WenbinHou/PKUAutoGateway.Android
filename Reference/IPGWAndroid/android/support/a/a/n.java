package android.support.a.a;

import android.graphics.Matrix;
import android.support.v4.g.a;
import java.util.ArrayList;

final class n {
    final Matrix a = new Matrix();
    final ArrayList<Object> b = new ArrayList();
    float c = 0.0f;
    float d = 0.0f;
    float e = 0.0f;
    float f = 1.0f;
    float g = 1.0f;
    float h = 0.0f;
    float i = 0.0f;
    final Matrix j = new Matrix();
    int k;
    int[] l;
    String m = null;

    public n(n nVar, a<String, Object> aVar) {
        this.c = nVar.c;
        this.d = nVar.d;
        this.e = nVar.e;
        this.f = nVar.f;
        this.g = nVar.g;
        this.h = nVar.h;
        this.i = nVar.i;
        this.l = nVar.l;
        this.m = nVar.m;
        this.k = nVar.k;
        if (this.m != null) {
            aVar.put(this.m, this);
        }
        this.j.set(nVar.j);
        ArrayList arrayList = nVar.b;
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof n) {
                this.b.add(new n((n) obj, aVar));
            } else {
                o mVar;
                if (obj instanceof m) {
                    mVar = new m((m) obj);
                } else if (obj instanceof l) {
                    mVar = new l((l) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.b.add(mVar);
                if (mVar.n != null) {
                    aVar.put(mVar.n, mVar);
                }
            }
        }
    }
}
