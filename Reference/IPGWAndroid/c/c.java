package c;

import java.io.IOException;

final class c implements x {
    final /* synthetic */ x a;
    final /* synthetic */ a b;

    c(a aVar, x xVar) {
        this.b = aVar;
        this.a = xVar;
    }

    public final long a(f fVar, long j) {
        this.b.b_();
        try {
            long a = this.a.a(fVar, j);
            this.b.a(true);
            return a;
        } catch (IOException e) {
            throw this.b.b(e);
        } catch (Throwable th) {
            this.b.a(false);
        }
    }

    public final y a() {
        return this.b;
    }

    public final void close() {
        try {
            this.a.close();
            this.b.a(true);
        } catch (IOException e) {
            throw this.b.b(e);
        } catch (Throwable th) {
            this.b.a(false);
        }
    }

    public final String toString() {
        return "AsyncTimeout.source(" + this.a + ")";
    }
}
