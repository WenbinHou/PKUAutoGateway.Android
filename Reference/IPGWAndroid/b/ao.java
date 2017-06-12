package b;

import b.a.b.t;

public final class ao {
    aa a;
    String b;
    z c;
    ap d;
    Object e;

    public ao() {
        this.b = "GET";
        this.c = new z();
    }

    private ao(an anVar) {
        this.a = anVar.a;
        this.b = anVar.b;
        this.d = anVar.d;
        this.e = anVar.e;
        this.c = anVar.c.a();
    }

    public final an a() {
        if (this.a != null) {
            return new an();
        }
        throw new IllegalStateException("url == null");
    }

    public final ao a(aa aaVar) {
        if (aaVar == null) {
            throw new IllegalArgumentException("url == null");
        }
        this.a = aaVar;
        return this;
    }

    public final ao a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("url == null");
        }
        if (str.regionMatches(true, 0, "ws:", 0, 3)) {
            str = "http:" + str.substring(3);
        } else {
            if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
        }
        aa d = aa.d(str);
        if (d != null) {
            return a(d);
        }
        throw new IllegalArgumentException("unexpected url: " + str);
    }

    public final ao a(String str, ap apVar) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("method == null || method.length() == 0");
        } else if (apVar != null && !t.b(str)) {
            throw new IllegalArgumentException("method " + str + " must not have a request body.");
        } else if (apVar == null && t.a(str)) {
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        } else {
            this.b = str;
            this.d = apVar;
            return this;
        }
    }

    public final ao a(String str, String str2) {
        this.c.c(str, str2);
        return this;
    }

    public final ao b(String str) {
        this.c.a(str);
        return this;
    }
}
