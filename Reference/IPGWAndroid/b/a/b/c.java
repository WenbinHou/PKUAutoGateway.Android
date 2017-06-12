package b.a.b;

import b.an;
import b.ar;
import b.y;
import java.util.Date;

public final class c {
    public final long a;
    public final an b;
    public final ar c;
    public Date d;
    public String e;
    public Date f;
    public String g;
    public Date h;
    public long i;
    public long j;
    public String k;
    public int l = -1;

    public c(long j, an anVar, ar arVar) {
        this.a = j;
        this.b = anVar;
        this.c = arVar;
        if (arVar != null) {
            y yVar = arVar.f;
            int length = yVar.a.length / 2;
            for (int i = 0; i < length; i++) {
                String a = yVar.a(i);
                String b = yVar.b(i);
                if ("Date".equalsIgnoreCase(a)) {
                    this.d = n.a(b);
                    this.e = b;
                } else if ("Expires".equalsIgnoreCase(a)) {
                    this.h = n.a(b);
                } else if ("Last-Modified".equalsIgnoreCase(a)) {
                    this.f = n.a(b);
                    this.g = b;
                } else if ("ETag".equalsIgnoreCase(a)) {
                    this.k = b;
                } else if ("Age".equalsIgnoreCase(a)) {
                    this.l = d.a(b, -1);
                } else if (v.b.equalsIgnoreCase(a)) {
                    this.i = Long.parseLong(b);
                } else if (v.c.equalsIgnoreCase(a)) {
                    this.j = Long.parseLong(b);
                }
            }
        }
    }

    public static boolean a(an anVar) {
        return (anVar.a("If-Modified-Since") == null && anVar.a("If-None-Match") == null) ? false : true;
    }
}
