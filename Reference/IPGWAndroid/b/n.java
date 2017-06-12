package b;

import b.a.c.c;
import b.a.f;
import b.a.o;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class n {
    static final Executor a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), o.a("OkHttp ConnectionPool", true));
    static final /* synthetic */ boolean g = (!n.class.desiredAssertionStatus());
    final int b;
    final Runnable c;
    final Deque<c> d;
    final b.a.n e;
    boolean f;
    private final long h;

    public n() {
        this(TimeUnit.MINUTES);
    }

    private n(TimeUnit timeUnit) {
        this.c = new o(this);
        this.d = new ArrayDeque();
        this.e = new b.a.n();
        this.b = 5;
        this.h = timeUnit.toNanos(5);
        if (5 <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: 5");
        }
    }

    final long a(long j) {
        c cVar = null;
        long j2 = Long.MIN_VALUE;
        synchronized (this) {
            int i = 0;
            int i2 = 0;
            for (c cVar2 : this.d) {
                int i3;
                long j3;
                List list = cVar2.j;
                int i4 = 0;
                while (i4 < list.size()) {
                    if (((Reference) list.get(i4)).get() != null) {
                        i4++;
                    } else {
                        f.a.warning("A connection to " + cVar2.b.a.a + " was leaked. Did you forget to close a response body?");
                        list.remove(i4);
                        cVar2.k = true;
                        if (list.isEmpty()) {
                            cVar2.l = j - this.h;
                            i3 = 0;
                            break;
                        }
                    }
                }
                i3 = list.size();
                if (i3 > 0) {
                    i2++;
                } else {
                    c cVar3;
                    int i5 = i + 1;
                    long j4 = j - cVar2.l;
                    if (j4 > j2) {
                        long j5 = j4;
                        cVar3 = cVar2;
                        j3 = j5;
                    } else {
                        j3 = j2;
                        cVar3 = cVar;
                    }
                    j2 = j3;
                    cVar = cVar3;
                    i = i5;
                }
            }
            if (j2 >= this.h || i > this.b) {
                this.d.remove(cVar);
                o.a(cVar.c);
                return 0;
            } else if (i > 0) {
                j3 = this.h - j2;
                return j3;
            } else if (i2 > 0) {
                j3 = this.h;
                return j3;
            } else {
                this.f = false;
                return -1;
            }
        }
    }
}
