package com.alipay.a.a;

import com.alipay.a.b.a;
import d.a.a.b;
import d.a.a.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class f {
    private static List<j> a;

    static {
        List arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(new l());
        a.add(new d());
        a.add(new c());
        a.add(new h());
        a.add(new b());
        a.add(new a());
        a.add(new g());
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object b = b(obj);
        if (a.a(b.getClass())) {
            return c.b(b.toString());
        }
        if (Collection.class.isAssignableFrom(b.getClass())) {
            return new b((List) b).toString();
        }
        if (Map.class.isAssignableFrom(b.getClass())) {
            return new c((Map) b).toString();
        }
        throw new IllegalArgumentException("Unsupported Class : " + b.getClass());
    }

    public static Object b(Object obj) {
        if (obj == null) {
            return null;
        }
        for (j jVar : a) {
            if (jVar.a(obj.getClass())) {
                Object a = jVar.a(obj);
                if (a != null) {
                    return a;
                }
            }
        }
        throw new IllegalArgumentException("Unsupported Class : " + obj.getClass());
    }
}
