package b;

public final class an {
    public final aa a;
    public final String b;
    public final y c;
    public final ap d;
    final Object e;
    private volatile e f;

    private an(ao aoVar) {
        Object obj;
        this.a = aoVar.a;
        this.b = aoVar.b;
        this.c = aoVar.c.a();
        this.d = aoVar.d;
        if (aoVar.e != null) {
            obj = aoVar.e;
        } else {
            an anVar = this;
        }
        this.e = obj;
    }

    public final ao a() {
        return new ao();
    }

    public final String a(String str) {
        return this.c.a(str);
    }

    public final e b() {
        e eVar = this.f;
        if (eVar != null) {
            return eVar;
        }
        eVar = e.a(this.c);
        this.f = eVar;
        return eVar;
    }

    public final boolean c() {
        return this.a.a.equals("https");
    }

    public final String toString() {
        return "Request{method=" + this.b + ", url=" + this.a + ", tag=" + (this.e != this ? this.e : null) + '}';
    }
}
