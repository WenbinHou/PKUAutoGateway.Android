package com.b.a.b.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class g implements c {
    final /* synthetic */ f a;
    private final Map<String, Object> b = new HashMap();
    private boolean c = false;

    public g(f fVar) {
        this.a = fVar;
    }

    public final c a() {
        synchronized (this) {
            this.c = true;
        }
        return this;
    }

    public final c a(String str) {
        synchronized (this) {
            this.b.put(str, this);
        }
        return this;
    }

    public final c a(String str, float f) {
        synchronized (this) {
            this.b.put(str, Float.valueOf(f));
        }
        return this;
    }

    public final c a(String str, int i) {
        synchronized (this) {
            this.b.put(str, Integer.valueOf(i));
        }
        return this;
    }

    public final c a(String str, long j) {
        synchronized (this) {
            this.b.put(str, Long.valueOf(j));
        }
        return this;
    }

    public final c a(String str, String str2) {
        synchronized (this) {
            this.b.put(str, str2);
        }
        return this;
    }

    public final c a(String str, boolean z) {
        synchronized (this) {
            this.b.put(str, Boolean.valueOf(z));
        }
        return this;
    }

    public final boolean b() {
        Set hashSet;
        boolean c;
        synchronized (e.c) {
            List list;
            Object obj = this.a.g.size() > 0 ? 1 : null;
            if (obj != null) {
                ArrayList arrayList = new ArrayList();
                hashSet = new HashSet(this.a.g.keySet());
                list = arrayList;
            } else {
                hashSet = null;
                list = null;
            }
            synchronized (this) {
                if (this.c) {
                    this.a.a.clear();
                    this.c = false;
                }
                for (Entry entry : this.b.entrySet()) {
                    String str = (String) entry.getKey();
                    g value = entry.getValue();
                    if (value == this) {
                        this.a.a.remove(str);
                    } else {
                        this.a.a.put(str, value);
                    }
                    if (obj != null) {
                        list.add(str);
                    }
                }
                this.b.clear();
            }
            c = this.a.e();
            if (c) {
                f fVar = this.a;
                synchronized (fVar) {
                    fVar.b = true;
                }
            }
        }
        if (obj != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                list.get(size);
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
        return c;
    }
}
