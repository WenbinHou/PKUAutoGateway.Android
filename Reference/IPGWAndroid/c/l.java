package c;

import java.util.concurrent.TimeUnit;

public final class l extends y {
    public y a;

    public l(y yVar) {
        if (yVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = yVar;
    }

    public final y a(long j) {
        return this.a.a(j);
    }

    public final y a(long j, TimeUnit timeUnit) {
        return this.a.a(j, timeUnit);
    }

    public final long c() {
        return this.a.c();
    }

    public final y d() {
        return this.a.d();
    }

    public final long d_() {
        return this.a.d_();
    }

    public final boolean e_() {
        return this.a.e_();
    }

    public final void f() {
        this.a.f();
    }

    public final y f_() {
        return this.a.f_();
    }
}
