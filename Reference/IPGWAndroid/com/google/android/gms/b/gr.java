package com.google.android.gms.b;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@fd
public class gr<T> implements gs<T> {
    private final Object a = new Object();
    final gt b = new gt();
    private T c = null;
    private boolean d = false;
    private boolean e = false;

    public final void b(T t) {
        synchronized (this.a) {
            if (this.e) {
            } else if (this.d) {
                throw new IllegalStateException("Provided CallbackFuture with multiple values.");
            } else {
                this.d = true;
                this.c = t;
                this.a.notifyAll();
                this.b.a();
            }
        }
    }

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.a) {
            if (this.d) {
                return false;
            }
            this.e = true;
            this.d = true;
            this.a.notifyAll();
            this.b.a();
            return true;
        }
    }

    public T get() {
        T t;
        synchronized (this.a) {
            if (!this.d) {
                try {
                    this.a.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.e) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.c;
        }
        return t;
    }

    public T get(long j, TimeUnit timeUnit) {
        T t;
        synchronized (this.a) {
            if (!this.d) {
                try {
                    long toMillis = timeUnit.toMillis(j);
                    if (toMillis != 0) {
                        this.a.wait(toMillis);
                    }
                } catch (InterruptedException e) {
                }
            }
            if (!this.d) {
                throw new TimeoutException("CallbackFuture timed out.");
            } else if (this.e) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.c;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.a) {
            z = this.e;
        }
        return z;
    }

    public boolean isDone() {
        boolean z;
        synchronized (this.a) {
            z = this.d;
        }
        return z;
    }
}
