package c;

import java.io.IOException;
import java.io.InterruptedIOException;

public class a extends y {
    private static a a;
    private boolean c;
    private a d;
    private long e;

    private static synchronized void a(a aVar, long j, boolean z) {
        synchronized (a.class) {
            if (a == null) {
                a = new a();
                new d().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                aVar.e = Math.min(j, aVar.c() - nanoTime) + nanoTime;
            } else if (j != 0) {
                aVar.e = nanoTime + j;
            } else if (z) {
                aVar.e = aVar.c();
            } else {
                throw new AssertionError();
            }
            long j2 = aVar.e - nanoTime;
            a aVar2 = a;
            while (aVar2.d != null && j2 >= aVar2.d.e - nanoTime) {
                aVar2 = aVar2.d;
            }
            aVar.d = aVar2.d;
            aVar2.d = aVar;
            if (aVar2 == a) {
                a.class.notify();
            }
        }
    }

    private static synchronized boolean a(a aVar) {
        boolean z;
        synchronized (a.class) {
            for (a aVar2 = a; aVar2 != null; aVar2 = aVar2.d) {
                if (aVar2.d == aVar) {
                    aVar2.d = aVar.d;
                    aVar.d = null;
                    z = false;
                    break;
                }
            }
            z = true;
        }
        return z;
    }

    private static synchronized a g() {
        a aVar = null;
        synchronized (a.class) {
            a aVar2 = a.d;
            if (aVar2 == null) {
                a.class.wait();
            } else {
                long nanoTime = aVar2.e - System.nanoTime();
                if (nanoTime > 0) {
                    long j = nanoTime / 1000000;
                    a.class.wait(j, (int) (nanoTime - (1000000 * j)));
                } else {
                    a.d = aVar2.d;
                    aVar2.d = null;
                    aVar = aVar2;
                }
            }
        }
        return aVar;
    }

    public IOException a(IOException iOException) {
        IOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void a() {
    }

    final void a(boolean z) {
        if (c_() && z) {
            throw a(null);
        }
    }

    final IOException b(IOException iOException) {
        return !c_() ? iOException : a(iOException);
    }

    public final void b_() {
        if (this.c) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long d_ = d_();
        boolean e_ = e_();
        if (d_ != 0 || e_) {
            this.c = true;
            a(this, d_, e_);
        }
    }

    public final boolean c_() {
        if (!this.c) {
            return false;
        }
        this.c = false;
        return a(this);
    }
}
