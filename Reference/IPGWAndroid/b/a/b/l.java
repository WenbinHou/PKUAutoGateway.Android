package b.a.b;

import b.a.a.e;
import b.a.a.t;
import b.a.a.x;
import b.a.o;
import b.aj;
import b.an;
import b.ar;
import b.as;
import b.at;
import b.y;
import b.z;
import c.i;
import c.w;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class l implements u {
    private static final i a = i.a("connection");
    private static final i b = i.a("host");
    private static final i c = i.a("keep-alive");
    private static final i d = i.a("proxy-connection");
    private static final i e = i.a("transfer-encoding");
    private static final i f = i.a("te");
    private static final i g = i.a("encoding");
    private static final i h = i.a("upgrade");
    private static final List<i> i = o.a(a, b, c, d, e, x.b, x.c, x.d, x.e, x.f, x.g);
    private static final List<i> j = o.a(a, b, c, d, e);
    private static final List<i> k = o.a(a, b, c, d, f, e, g, h, x.b, x.c, x.d, x.e, x.f, x.g);
    private static final List<i> l = o.a(a, b, c, d, f, e, g, h);
    private final ad m;
    private final e n;
    private p o;
    private t p;

    public l(ad adVar, e eVar) {
        this.m = adVar;
        this.n = eVar;
    }

    private static as a(List<x> list) {
        String str = null;
        String str2 = "HTTP/1.1";
        z zVar = new z();
        int size = list.size();
        int i = 0;
        while (i < size) {
            i iVar = ((x) list.get(i)).h;
            String a = ((x) list.get(i)).i.a();
            String str3 = str2;
            int i2 = 0;
            while (i2 < a.length()) {
                int indexOf = a.indexOf(0, i2);
                if (indexOf == -1) {
                    indexOf = a.length();
                }
                str2 = a.substring(i2, indexOf);
                if (!iVar.equals(x.a)) {
                    if (iVar.equals(x.g)) {
                        str3 = str2;
                        str2 = str;
                    } else {
                        if (!j.contains(iVar)) {
                            zVar.a(iVar.a(), str2);
                        }
                        str2 = str;
                    }
                }
                str = str2;
                i2 = indexOf + 1;
            }
            i++;
            str2 = str3;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        ac a2 = ac.a(str2 + " " + str);
        as asVar = new as();
        asVar.b = aj.SPDY_3;
        asVar.c = a2.b;
        asVar.d = a2.c;
        return asVar.a(zVar.a());
    }

    private static List<x> b(an anVar) {
        y yVar = anVar.c;
        List<x> arrayList = new ArrayList((yVar.a.length / 2) + 5);
        arrayList.add(new x(x.b, anVar.b));
        arrayList.add(new x(x.c, y.a(anVar.a)));
        arrayList.add(new x(x.g, "HTTP/1.1"));
        arrayList.add(new x(x.f, o.a(anVar.a, false)));
        arrayList.add(new x(x.d, anVar.a.a));
        Set linkedHashSet = new LinkedHashSet();
        int length = yVar.a.length / 2;
        for (int i = 0; i < length; i++) {
            i a = i.a(yVar.a(i).toLowerCase(Locale.US));
            if (!i.contains(a)) {
                String b = yVar.b(i);
                if (linkedHashSet.add(a)) {
                    arrayList.add(new x(a, b));
                } else {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (((x) arrayList.get(i2)).h.equals(a)) {
                            arrayList.set(i2, new x(a, new StringBuilder(((x) arrayList.get(i2)).i.a()).append('\u0000').append(b).toString()));
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final as a() {
        if (this.n.a != aj.HTTP_2) {
            return a(this.p.c());
        }
        List c = this.p.c();
        String str = null;
        z zVar = new z();
        int size = c.size();
        int i = 0;
        while (i < size) {
            i iVar = ((x) c.get(i)).h;
            String a = ((x) c.get(i)).i.a();
            if (!iVar.equals(x.a)) {
                if (!l.contains(iVar)) {
                    zVar.a(iVar.a(), a);
                }
                a = str;
            }
            i++;
            str = a;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        ac a2 = ac.a("HTTP/1.1 " + str);
        as asVar = new as();
        asVar.b = aj.HTTP_2;
        asVar.c = a2.b;
        asVar.d = a2.c;
        return asVar.a(zVar.a());
    }

    public final at a(ar arVar) {
        return new w(arVar.f, c.o.a(new m(this, this.p.f)));
    }

    public final w a(an anVar, long j) {
        return this.p.d();
    }

    public final void a(p pVar) {
        this.o = pVar;
    }

    public final void a(z zVar) {
        zVar.a(this.p.d());
    }

    public final void a(an anVar) {
        int i = 0;
        if (this.p == null) {
            List arrayList;
            this.o.a();
            boolean a = p.a(anVar);
            if (this.n.a == aj.HTTP_2) {
                y yVar = anVar.c;
                arrayList = new ArrayList((yVar.a.length / 2) + 4);
                arrayList.add(new x(x.b, anVar.b));
                arrayList.add(new x(x.c, y.a(anVar.a)));
                arrayList.add(new x(x.e, o.a(anVar.a, false)));
                arrayList.add(new x(x.d, anVar.a.a));
                int length = yVar.a.length / 2;
                while (i < length) {
                    i a2 = i.a(yVar.a(i).toLowerCase(Locale.US));
                    if (!k.contains(a2)) {
                        arrayList.add(new x(a2, yVar.b(i)));
                    }
                    i++;
                }
            } else {
                arrayList = b(anVar);
            }
            this.p = this.n.a(arrayList, a);
            this.p.h.a((long) this.o.b.x, TimeUnit.MILLISECONDS);
            this.p.i.a((long) this.o.b.y, TimeUnit.MILLISECONDS);
        }
    }

    public final void b() {
        this.p.d().close();
    }
}
