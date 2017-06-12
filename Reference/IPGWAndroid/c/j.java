package c;

import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class j implements w {
    private final g a;
    private final Deflater b;
    private boolean c;

    private j(g gVar, Deflater deflater) {
        if (gVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.a = gVar;
            this.b = deflater;
        }
    }

    public j(w wVar, Deflater deflater) {
        this(o.a(wVar), deflater);
    }

    @IgnoreJRERequirement
    private void a(boolean z) {
        f b = this.a.b();
        while (true) {
            u e = b.e(1);
            int deflate = z ? this.b.deflate(e.a, e.c, 2048 - e.c, 2) : this.b.deflate(e.a, e.c, 2048 - e.c);
            if (deflate > 0) {
                e.c += deflate;
                b.b += (long) deflate;
                this.a.p();
            } else if (this.b.needsInput()) {
                break;
            }
        }
        if (e.b == e.c) {
            b.a = e.a();
            v.a(e);
        }
    }

    public final y a() {
        return this.a.a();
    }

    public final void a_(f fVar, long j) {
        aa.a(fVar.b, 0, j);
        while (j > 0) {
            u uVar = fVar.a;
            int min = (int) Math.min(j, (long) (uVar.c - uVar.b));
            this.b.setInput(uVar.a, uVar.b, min);
            a(false);
            fVar.b -= (long) min;
            uVar.b += min;
            if (uVar.b == uVar.c) {
                fVar.a = uVar.a();
                v.a(uVar);
            }
            j -= (long) min;
        }
    }

    public final void close() {
        Throwable th;
        if (!this.c) {
            Throwable th2 = null;
            try {
                this.b.finish();
                a(false);
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.b.end();
                th3 = th2;
            } catch (Throwable th4) {
                th3 = th4;
                if (th2 != null) {
                    th3 = th2;
                }
            }
            try {
                this.a.close();
            } catch (Throwable th22) {
                if (th3 == null) {
                    th3 = th22;
                }
            }
            this.c = true;
            if (th3 != null) {
                aa.a(th3);
            }
        }
    }

    public final void flush() {
        a(true);
        this.a.flush();
    }

    public final String toString() {
        return "DeflaterSink(" + this.a + ")";
    }
}
