package com.a.a;

import android.content.Context;
import com.google.gson.Gson;

public final class o {
    public static o a;
    public final ac b;
    public final l c;
    public final m d;
    final int e;

    o(p pVar) {
        this.b = pVar.a();
        if (pVar.d == null) {
            if (pVar.e == null) {
                pVar.e = new n(new Gson());
            }
            pVar.d = new s(pVar.e);
        }
        this.c = pVar.d;
        this.d = pVar.f;
        if (pVar.b == 0) {
            pVar.b = y.a;
        }
        this.e = pVar.b;
    }

    public static p a(Context context) {
        x.a("Context", (Object) context);
        a = null;
        return new p(context);
    }

    public static <T> T a(String str) {
        x.a("Key", (Object) str);
        x.a();
        String str2 = (String) a.b.a(str);
        if (str2 == null) {
            return null;
        }
        j a = i.a(str2);
        byte[] a2 = a.d.a(a.b);
        if (a2 == null) {
            return null;
        }
        try {
            return a.c.a(a2, a);
        } catch (Exception e) {
            z.a(3, e.getMessage());
            return null;
        }
    }

    public static boolean a() {
        return a != null;
    }
}
