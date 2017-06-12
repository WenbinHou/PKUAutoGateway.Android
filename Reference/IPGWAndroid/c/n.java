package c;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.Inflater;

public final class n implements x {
    private final h a;
    private final Inflater b;
    private int c;
    private boolean d;

    n(h hVar, Inflater inflater) {
        if (hVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.a = hVar;
            this.b = inflater;
        }
    }

    public n(x xVar, Inflater inflater) {
        this(o.a(xVar), inflater);
    }

    private void c() {
        if (this.c != 0) {
            int remaining = this.c - this.b.getRemaining();
            this.c -= remaining;
            this.a.f((long) remaining);
        }
    }

    public final long a(f fVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            boolean b;
            do {
                b = b();
                try {
                    u e = fVar.e(1);
                    int inflate = this.b.inflate(e.a, e.c, 2048 - e.c);
                    if (inflate > 0) {
                        e.c += inflate;
                        fVar.b += (long) inflate;
                        return (long) inflate;
                    } else if (this.b.finished() || this.b.needsDictionary()) {
                        c();
                        if (e.b == e.c) {
                            fVar.a = e.a();
                            v.a(e);
                        }
                        return -1;
                    }
                } catch (Throwable e2) {
                    throw new IOException(e2);
                }
            } while (!b);
            throw new EOFException("source exhausted prematurely");
        }
    }

    public final y a() {
        return this.a.a();
    }

    public final boolean b() {
        if (!this.b.needsInput()) {
            return false;
        }
        c();
        if (this.b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.a.d()) {
            return true;
        } else {
            u uVar = this.a.b().a;
            this.c = uVar.c - uVar.b;
            this.b.setInput(uVar.a, uVar.b, this.c);
            return false;
        }
    }

    public final void close() {
        if (!this.d) {
            this.b.end();
            this.d = true;
            this.a.close();
        }
    }
}
