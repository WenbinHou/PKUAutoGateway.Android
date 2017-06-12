package c;

import java.io.OutputStream;

final class p implements w {
    final /* synthetic */ y a;
    final /* synthetic */ OutputStream b;

    p(y yVar, OutputStream outputStream) {
        this.a = yVar;
        this.b = outputStream;
    }

    public final y a() {
        return this.a;
    }

    public final void a_(f fVar, long j) {
        aa.a(fVar.b, 0, j);
        while (j > 0) {
            this.a.f();
            u uVar = fVar.a;
            int min = (int) Math.min(j, (long) (uVar.c - uVar.b));
            this.b.write(uVar.a, uVar.b, min);
            uVar.b += min;
            j -= (long) min;
            fVar.b -= (long) min;
            if (uVar.b == uVar.c) {
                fVar.a = uVar.a();
                v.a(uVar);
            }
        }
    }

    public final void close() {
        this.b.close();
    }

    public final void flush() {
        this.b.flush();
    }

    public final String toString() {
        return "sink(" + this.b + ")";
    }
}
