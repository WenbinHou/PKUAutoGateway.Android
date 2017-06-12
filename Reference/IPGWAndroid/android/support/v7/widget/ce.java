package android.support.v7.widget;

final class ce {
    public eq a;
    public eq b;
    public int c;
    public int d;
    public int e;
    public int f;

    private ce(eq eqVar, eq eqVar2) {
        this.a = eqVar;
        this.b = eqVar2;
    }

    private ce(eq eqVar, eq eqVar2, int i, int i2, int i3, int i4) {
        this(eqVar, eqVar2);
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
    }

    public final String toString() {
        return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
    }
}
