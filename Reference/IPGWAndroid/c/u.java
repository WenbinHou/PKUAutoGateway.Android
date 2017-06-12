package c;

final class u {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    u f;
    u g;

    u() {
        this.a = new byte[2048];
        this.e = true;
        this.d = false;
    }

    u(u uVar) {
        this(uVar.a, uVar.b, uVar.c);
        uVar.d = true;
    }

    private u(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.e = false;
        this.d = true;
    }

    public final u a() {
        u uVar = this.f != this ? this.f : null;
        this.g.f = this.f;
        this.f.g = this.g;
        this.f = null;
        this.g = null;
        return uVar;
    }

    public final u a(u uVar) {
        uVar.g = this;
        uVar.f = this.f;
        this.f.g = uVar;
        this.f = uVar;
        return uVar;
    }

    public final void a(u uVar, int i) {
        if (uVar.e) {
            if (uVar.c + i > 2048) {
                if (uVar.d) {
                    throw new IllegalArgumentException();
                } else if ((uVar.c + i) - uVar.b > 2048) {
                    throw new IllegalArgumentException();
                } else {
                    System.arraycopy(uVar.a, uVar.b, uVar.a, 0, uVar.c - uVar.b);
                    uVar.c -= uVar.b;
                    uVar.b = 0;
                }
            }
            System.arraycopy(this.a, this.b, uVar.a, uVar.c, i);
            uVar.c += i;
            this.b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
