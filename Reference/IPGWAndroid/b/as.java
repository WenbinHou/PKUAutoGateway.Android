package b;

public final class as {
    public an a;
    public aj b;
    public int c;
    public String d;
    public x e;
    z f;
    public at g;
    ar h;
    ar i;
    ar j;

    public as() {
        this.c = -1;
        this.f = new z();
    }

    private as(ar arVar) {
        this.c = -1;
        this.a = arVar.a;
        this.b = arVar.b;
        this.c = arVar.c;
        this.d = arVar.d;
        this.e = arVar.e;
        this.f = arVar.f.a();
        this.g = arVar.g;
        this.h = arVar.h;
        this.i = arVar.i;
        this.j = arVar.j;
    }

    private static void a(String str, ar arVar) {
        if (arVar.g != null) {
            throw new IllegalArgumentException(str + ".body != null");
        } else if (arVar.h != null) {
            throw new IllegalArgumentException(str + ".networkResponse != null");
        } else if (arVar.i != null) {
            throw new IllegalArgumentException(str + ".cacheResponse != null");
        } else if (arVar.j != null) {
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }
    }

    public final ar a() {
        if (this.a == null) {
            throw new IllegalStateException("request == null");
        } else if (this.b == null) {
            throw new IllegalStateException("protocol == null");
        } else if (this.c >= 0) {
            return new ar();
        } else {
            throw new IllegalStateException("code < 0: " + this.c);
        }
    }

    public final as a(ar arVar) {
        if (arVar != null) {
            a("networkResponse", arVar);
        }
        this.h = arVar;
        return this;
    }

    public final as a(y yVar) {
        this.f = yVar.a();
        return this;
    }

    public final as a(String str, String str2) {
        this.f.c(str, str2);
        return this;
    }

    public final as b(ar arVar) {
        if (arVar != null) {
            a("cacheResponse", arVar);
        }
        this.i = arVar;
        return this;
    }

    public final as b(String str, String str2) {
        this.f.a(str, str2);
        return this;
    }

    public final as c(ar arVar) {
        if (arVar == null || arVar.g == null) {
            this.j = arVar;
            return this;
        }
        throw new IllegalArgumentException("priorResponse.body != null");
    }
}
