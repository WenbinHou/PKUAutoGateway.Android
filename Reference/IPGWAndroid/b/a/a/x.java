package b.a.a;

import c.i;

public final class x {
    public static final i a = i.a(":status");
    public static final i b = i.a(":method");
    public static final i c = i.a(":path");
    public static final i d = i.a(":scheme");
    public static final i e = i.a(":authority");
    public static final i f = i.a(":host");
    public static final i g = i.a(":version");
    public final i h;
    public final i i;
    final int j;

    public x(i iVar, i iVar2) {
        this.h = iVar;
        this.i = iVar2;
        this.j = (iVar.c.length + 32) + iVar2.c.length;
    }

    public x(i iVar, String str) {
        this(iVar, i.a(str));
    }

    public x(String str, String str2) {
        this(i.a(str), i.a(str2));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.h.equals(xVar.h) && this.i.equals(xVar.i);
    }

    public final int hashCode() {
        return ((this.h.hashCode() + 527) * 31) + this.i.hashCode();
    }

    public final String toString() {
        return String.format("%s: %s", new Object[]{this.h.a(), this.i.a()});
    }
}
