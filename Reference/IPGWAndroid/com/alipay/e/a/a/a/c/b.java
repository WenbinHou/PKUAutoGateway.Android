package com.alipay.e.a.a.a.c;

import android.content.Context;
import com.alipay.e.a.a.a.a;
import com.alipay.e.a.a.a.b.c;
import com.alipay.e.a.a.a.b.d;
import java.util.HashMap;

public final class b implements a {
    private static a a = null;
    private static a b = null;

    public static a a(Context context) {
        a aVar = null;
        if (context == null) {
            return null;
        }
        if (a == null) {
            if (context != null) {
                aVar = com.alipay.e.a.a.a.b.a(context);
            }
            b = aVar;
            a = new b();
        }
        return a;
    }

    public final com.alipay.e.a.a.a.b.a a(String str, String str2, String str3, String str4) {
        com.alipay.f.a.a.b.b.b a = b.a(str, str2, str3, str4);
        if (a == null) {
            return null;
        }
        com.alipay.e.a.a.a.b.a aVar = new com.alipay.e.a.a.a.b.a(a.b, a.a);
        aVar.c = a.c;
        aVar.d = a.d;
        return aVar;
    }

    public final c a(d dVar) {
        com.alipay.f.a.a.b.a.b bVar = new com.alipay.f.a.a.b.a.b();
        bVar.a = com.alipay.e.a.a.b.a.b(dVar.a);
        bVar.b = com.alipay.e.a.a.b.a.b(dVar.b);
        bVar.c = com.alipay.e.a.a.b.a.b(dVar.c);
        bVar.d = com.alipay.e.a.a.b.a.b(dVar.d);
        bVar.e = com.alipay.e.a.a.b.a.b(dVar.e);
        bVar.f = com.alipay.e.a.a.b.a.b(dVar.f);
        bVar.g = com.alipay.e.a.a.b.a.b(dVar.g);
        bVar.h = com.alipay.e.a.a.b.a.b(dVar.h);
        bVar.i = dVar.i == null ? new HashMap() : dVar.i;
        com.alipay.f.a.a.b.b.d a = b.a(bVar);
        c cVar = new c();
        if (a == null) {
            return null;
        }
        cVar.c = a.c;
        cVar.d = a.d;
        cVar.a = a.a;
        cVar.b = a.b;
        cVar.e = a.e;
        cVar.f = a.f;
        cVar.g = a.g;
        cVar.h = a.h;
        cVar.i = a.i;
        return cVar;
    }

    public final boolean a(String str) {
        return b.a(str);
    }
}
