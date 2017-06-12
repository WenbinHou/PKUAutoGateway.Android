package c;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class y {
    public static final y b = new z();
    private boolean a;
    private long c;
    private long d;

    public y a(long j) {
        this.a = true;
        this.c = j;
        return this;
    }

    public y a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            this.d = timeUnit.toNanos(j);
            return this;
        }
    }

    public long c() {
        if (this.a) {
            return this.c;
        }
        throw new IllegalStateException("No deadline");
    }

    public y d() {
        this.d = 0;
        return this;
    }

    public long d_() {
        return this.d;
    }

    public boolean e_() {
        return this.a;
    }

    public void f() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.a && this.c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public y f_() {
        this.a = false;
        return this;
    }
}
