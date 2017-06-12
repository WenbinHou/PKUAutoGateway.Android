package c;

import java.io.InputStream;

final class q implements x {
    final /* synthetic */ y a;
    final /* synthetic */ InputStream b;

    q(y yVar, InputStream inputStream) {
        this.a = yVar;
        this.b = inputStream;
    }

    public final long a(f fVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            this.a.f();
            u e = fVar.e(1);
            int read = this.b.read(e.a, e.c, (int) Math.min(j, (long) (2048 - e.c)));
            if (read == -1) {
                return -1;
            }
            e.c += read;
            fVar.b += (long) read;
            return (long) read;
        }
    }

    public final y a() {
        return this.a;
    }

    public final void close() {
        this.b.close();
    }

    public final String toString() {
        return "source(" + this.b + ")";
    }
}
