package com.b.a.c;

import android.content.Context;
import com.b.a.a.a.g;
import com.b.a.a.a.h;
import java.util.zip.Adler32;

public final class b {
    static String a = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";
    static final Object b = new Object();
    private static a c = null;

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (b.class) {
            if (c != null) {
                aVar = c;
            } else if (context != null) {
                aVar = b(context);
                c = aVar;
            } else {
                aVar = null;
            }
        }
        return aVar;
    }

    private static a b(Context context) {
        if (context != null) {
            a aVar = new a();
            synchronized (b) {
                String a = c.a(context).a();
                if (!h.a(a)) {
                    String substring = a.endsWith("\n") ? a.substring(0, a.length() - 1) : a;
                    aVar = new a();
                    long currentTimeMillis = System.currentTimeMillis();
                    String a2 = g.a(context);
                    String b = g.b(context);
                    aVar.c = a2;
                    aVar.a = a2;
                    aVar.e = currentTimeMillis;
                    aVar.b = b;
                    aVar.d = substring;
                    substring = String.format("%s%s%s%s%s", new Object[]{aVar.d, aVar.c, Long.valueOf(aVar.e), aVar.b, aVar.a});
                    if (h.a(substring)) {
                        currentTimeMillis = 0;
                    } else {
                        Adler32 adler32 = new Adler32();
                        adler32.reset();
                        adler32.update(substring.getBytes());
                        currentTimeMillis = adler32.getValue();
                    }
                    aVar.f = currentTimeMillis;
                    return aVar;
                }
            }
        }
        return null;
    }
}
