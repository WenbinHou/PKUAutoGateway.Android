package c;

final class s implements g {
    public final f a;
    public final w b;
    private boolean c;

    public s(w wVar) {
        this(wVar, new f());
    }

    private s(w wVar, f fVar) {
        if (wVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.a = fVar;
        this.b = wVar;
    }

    public final long a(x xVar) {
        if (xVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a = xVar.a(this.a, 2048);
            if (a == -1) {
                return j;
            }
            j += a;
            p();
        }
    }

    public final y a() {
        return this.b.a();
    }

    public final void a_(f fVar, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a_(fVar, j);
        p();
    }

    public final f b() {
        return this.a;
    }

    public final g b(i iVar) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(iVar);
        return p();
    }

    public final g b(String str) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(str);
        return p();
    }

    public final g b(byte[] bArr) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(bArr);
        return p();
    }

    public final g b(byte[] bArr, int i, int i2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(bArr, i, i2);
        return p();
    }

    public final g c() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long j = this.a.b;
        if (j > 0) {
            this.b.a_(this.a, j);
        }
        return this;
    }

    public final void close() {
        if (!this.c) {
            Throwable th = null;
            try {
                if (this.a.b > 0) {
                    this.b.a_(this.a, this.a.b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.c = true;
            if (th != null) {
                aa.a(th);
            }
        }
    }

    public final g f(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.d(i);
        return p();
    }

    public final void flush() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.b > 0) {
            this.b.a_(this.a, this.a.b);
        }
        this.b.flush();
    }

    public final g g(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.c(i);
        return p();
    }

    public final g h(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(i);
        return p();
    }

    public final g i(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.h(j);
        return p();
    }

    public final g j(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.g(j);
        return p();
    }

    public final g p() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        f fVar = this.a;
        long j = fVar.b;
        if (j == 0) {
            j = 0;
        } else {
            u uVar = fVar.a.g;
            if (uVar.c < 2048 && uVar.e) {
                j -= (long) (uVar.c - uVar.b);
            }
        }
        if (j > 0) {
            this.b.a_(this.a, j);
        }
        return this;
    }

    public final String toString() {
        return "buffer(" + this.b + ")";
    }
}
