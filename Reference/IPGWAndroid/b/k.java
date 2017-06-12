package b;

import c.e;
import c.i;

final class k {
    final String a;
    final String b;
    final i c;

    public final boolean equals(Object obj) {
        return (obj instanceof k) && this.a.equals(((k) obj).a) && this.b.equals(((k) obj).b) && this.c.equals(((k) obj).c);
    }

    public final int hashCode() {
        return ((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return this.b + e.a(this.c.c);
    }
}
