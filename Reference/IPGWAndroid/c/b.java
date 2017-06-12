package c;

import java.io.IOException;

final class b implements w {
    final /* synthetic */ w a;
    final /* synthetic */ a b;

    b(a aVar, w wVar) {
        this.b = aVar;
        this.a = wVar;
    }

    public final y a() {
        return this.b;
    }

    public final void a_(f fVar, long j) {
        this.b.b_();
        try {
            this.a.a_(fVar, j);
            this.b.a(true);
        } catch (IOException e) {
            throw this.b.b(e);
        } catch (Throwable th) {
            this.b.a(false);
        }
    }

    public final void close() {
        this.b.b_();
        try {
            this.a.close();
            this.b.a(true);
        } catch (IOException e) {
            throw this.b.b(e);
        } catch (Throwable th) {
            this.b.a(false);
        }
    }

    public final void flush() {
        this.b.b_();
        try {
            this.a.flush();
            this.b.a(true);
        } catch (IOException e) {
            throw this.b.b(e);
        } catch (Throwable th) {
            this.b.a(false);
        }
    }

    public final String toString() {
        return "AsyncTimeout.sink(" + this.a + ")";
    }
}
