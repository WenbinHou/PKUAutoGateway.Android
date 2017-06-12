package b;

final class al implements ae {
    final /* synthetic */ ak a;
    private final int b;
    private final an c;
    private final boolean d;

    al(ak akVar, int i, an anVar, boolean z) {
        this.a = akVar;
        this.b = i;
        this.c = anVar;
        this.d = z;
    }

    public final ar a(an anVar) {
        if (this.b >= this.a.a.e.size()) {
            return this.a.a(anVar, this.d);
        }
        al alVar = new al(this.a, this.b + 1, anVar, this.d);
        ad adVar = (ad) this.a.a.e.get(this.b);
        ar a = adVar.a();
        if (a != null) {
            return a;
        }
        throw new NullPointerException("application interceptor " + adVar + " returned null");
    }
}
