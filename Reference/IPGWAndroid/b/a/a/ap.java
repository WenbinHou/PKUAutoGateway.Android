package b.a.a;

public final class ap {
    int a;
    int b;
    int c;
    final int[] d = new int[10];

    final int a() {
        return (this.a & 2) != 0 ? this.d[1] : -1;
    }

    final ap a(int i, int i2, int i3) {
        if (i < this.d.length) {
            int i4 = 1 << i;
            this.a |= i4;
            if ((i2 & 1) != 0) {
                this.b |= i4;
            } else {
                this.b &= i4 ^ -1;
            }
            if ((i2 & 2) != 0) {
                this.c = i4 | this.c;
            } else {
                this.c = (i4 ^ -1) & this.c;
            }
            this.d[i] = i3;
        }
        return this;
    }

    final boolean a(int i) {
        return ((1 << i) & this.a) != 0;
    }

    public final int b() {
        return (this.a & 128) != 0 ? this.d[7] : 65536;
    }

    final int b(int i) {
        int i2 = 0;
        int i3 = (((1 << i) & this.c) != 0 ? 1 : 0) != 0 ? 2 : 0;
        if (((1 << i) & this.b) != 0) {
            i2 = 1;
        }
        return i2 != 0 ? i3 | 1 : i3;
    }
}
