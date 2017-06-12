package com.google.android.gms.b;

import android.support.v4.g.a;
import android.support.v4.g.r;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public final class hz<E> extends AbstractSet<E> {
    private final a<E, E> a;

    public hz() {
        this.a = new a();
    }

    private hz(int i) {
        this.a = new a(i);
    }

    public hz(Collection<E> collection) {
        this(collection.size());
        addAll(collection);
    }

    private boolean a(hz<? extends E> hzVar) {
        int size = size();
        r rVar = this.a;
        r rVar2 = hzVar.a;
        int i = rVar2.h;
        rVar.a(rVar.h + i);
        if (rVar.h != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                rVar.put(rVar2.b(i2), rVar2.c(i2));
            }
        } else if (i > 0) {
            System.arraycopy(rVar2.f, 0, rVar.f, 0, i);
            System.arraycopy(rVar2.g, 0, rVar.g, 0, i << 1);
            rVar.h = i;
        }
        return size() > size;
    }

    public final boolean add(E e) {
        if (this.a.containsKey(e)) {
            return false;
        }
        this.a.put(e, e);
        return true;
    }

    public final boolean addAll(Collection<? extends E> collection) {
        return collection instanceof hz ? a((hz) collection) : super.addAll(collection);
    }

    public final void clear() {
        this.a.clear();
    }

    public final boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    public final Iterator<E> iterator() {
        return this.a.keySet().iterator();
    }

    public final boolean remove(Object obj) {
        if (!this.a.containsKey(obj)) {
            return false;
        }
        this.a.remove(obj);
        return true;
    }

    public final int size() {
        return this.a.size();
    }
}
