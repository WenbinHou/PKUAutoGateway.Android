package com.google.android.gms.b;

import java.util.Iterator;
import java.util.List;

@fd
public final class k {
    final Object a;
    int b;
    List<j> c;

    public final boolean a(j jVar) {
        boolean z;
        synchronized (this.a) {
            if (this.c.contains(jVar)) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean b(j jVar) {
        boolean z;
        synchronized (this.a) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                j jVar2 = (j) it.next();
                if (jVar != jVar2 && jVar2.e.equals(jVar.e)) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }
}
