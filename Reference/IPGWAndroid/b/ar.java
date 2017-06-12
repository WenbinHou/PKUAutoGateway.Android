package b;

public final class ar {
    public final an a;
    final aj b;
    public final int c;
    final String d;
    public final x e;
    public final y f;
    public final at g;
    ar h;
    ar i;
    final ar j;
    private volatile e k;

    private ar(as asVar) {
        this.a = asVar.a;
        this.b = asVar.b;
        this.c = asVar.c;
        this.d = asVar.d;
        this.e = asVar.e;
        this.f = asVar.f.a();
        this.g = asVar.g;
        this.h = asVar.h;
        this.i = asVar.i;
        this.j = asVar.j;
    }

    public final String a(String str) {
        String a = this.f.a(str);
        return a != null ? a : null;
    }

    public final boolean a() {
        return this.c >= 200 && this.c < 300;
    }

    public final as b() {
        return new as();
    }

    public final e c() {
        e eVar = this.k;
        if (eVar != null) {
            return eVar;
        }
        eVar = e.a(this.f);
        this.k = eVar;
        return eVar;
    }

    public final String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.a + '}';
    }
}
