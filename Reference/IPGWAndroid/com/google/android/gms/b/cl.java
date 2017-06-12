package com.google.android.gms.b;

import com.google.android.gms.ads.internal.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@fd
public final class cl implements Iterable<cj> {
    final List<cj> a = new LinkedList();

    public static boolean a(gv gvVar) {
        return b(gvVar) != null;
    }

    static cj b(gv gvVar) {
        Iterator it = f.k().iterator();
        while (it.hasNext()) {
            cj cjVar = (cj) it.next();
            if (cjVar.a == gvVar) {
                return cjVar;
            }
        }
        return null;
    }

    public final Iterator<cj> iterator() {
        return this.a.iterator();
    }
}
