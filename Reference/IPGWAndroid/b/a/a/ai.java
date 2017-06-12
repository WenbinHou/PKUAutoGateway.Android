package b.a.a;

final class ai {
    final ai[] a;
    final int b;
    final int c;

    ai() {
        this.a = new ai[256];
        this.b = 0;
        this.c = 0;
    }

    ai(int i, int i2) {
        this.a = null;
        this.b = i;
        int i3 = i2 & 7;
        if (i3 == 0) {
            i3 = 8;
        }
        this.c = i3;
    }
}
