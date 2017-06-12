package android.support.v7.widget;

final class et {
    int a = 0;
    int b = 0;
    int c = Integer.MIN_VALUE;
    int d = Integer.MIN_VALUE;
    int e = 0;
    int f = 0;
    boolean g = false;
    boolean h = false;

    et() {
    }

    public final void a(int i, int i2) {
        this.c = i;
        this.d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.b = i2;
        }
    }
}
