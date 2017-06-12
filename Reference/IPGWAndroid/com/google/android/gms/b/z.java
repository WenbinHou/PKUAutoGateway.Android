package com.google.android.gms.b;

public final class z {
    final long a;
    final String b;
    final int c;

    z(long j, String str, int i) {
        this.a = j;
        this.b = str;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        return (obj == null || !(obj instanceof z)) ? false : ((z) obj).a == this.a && ((z) obj).c == this.c;
    }

    public final int hashCode() {
        return (int) this.a;
    }
}
