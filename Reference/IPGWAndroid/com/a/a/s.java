package com.a.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class s implements l {
    private final aa a;

    public s(aa aaVar) {
        if (aaVar == null) {
            throw new NullPointerException("Parser should not be null");
        }
        this.a = aaVar;
    }

    private <T> T a(String str, Class<?> cls) {
        if (cls == null) {
            return new ArrayList();
        }
        List list = (List) this.a.a(str, new t(this).getType());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.set(i, this.a.a(this.a.a(list.get(i)), cls));
        }
        return list;
    }

    private <K, V, T> T a(String str, Class<?> cls, Class<?> cls2) {
        T hashMap = new HashMap();
        if (cls == null || cls2 == null) {
            return hashMap;
        }
        for (Entry entry : ((Map) this.a.a(str, new v(this).getType())).entrySet()) {
            hashMap.put(this.a.a(this.a.a(entry.getKey()), cls), this.a.a(this.a.a(entry.getValue()), cls2));
        }
        return hashMap;
    }

    private <T> T b(String str, Class<?> cls) {
        T hashSet = new HashSet();
        if (cls == null) {
            return hashSet;
        }
        for (Object a : (Set) this.a.a(str, new u(this).getType())) {
            hashSet.add(this.a.a(this.a.a(a), cls));
        }
        return hashSet;
    }

    public final <T> T a(byte[] bArr, j jVar) {
        if (bArr == null) {
            return null;
        }
        x.a("data info", (Object) jVar);
        String str = new String(bArr);
        Class cls = jVar.c;
        Class cls2 = jVar.d;
        switch (w.a[jVar.a.ordinal()]) {
            case 1:
                return this.a.a(str, cls);
            case 2:
                return a(str, cls);
            case 3:
                return a(str, cls, cls2);
            case 4:
                return b(str, cls);
            default:
                return null;
        }
    }

    public final <T> byte[] a(T t) {
        return t == null ? null : this.a.a(t).getBytes();
    }
}
