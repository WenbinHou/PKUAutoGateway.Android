package b;

import b.a.o;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class u {
    private int a = 64;
    private int b = 5;
    private ExecutorService c;
    private final Deque<am> d = new ArrayDeque();
    private final Deque<am> e = new ArrayDeque();
    private final Deque<ak> f = new ArrayDeque();

    private synchronized ExecutorService a() {
        if (this.c == null) {
            this.c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), o.a("OkHttp Dispatcher", false));
        }
        return this.c;
    }

    private void b() {
        if (this.e.size() < this.a && !this.d.isEmpty()) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                am amVar = (am) it.next();
                if (c(amVar) < this.b) {
                    it.remove();
                    this.e.add(amVar);
                    a().execute(amVar);
                }
                if (this.e.size() >= this.a) {
                    return;
                }
            }
        }
    }

    private int c(am amVar) {
        int i = 0;
        for (am a : this.e) {
            i = a.a().equals(amVar.a()) ? i + 1 : i;
        }
        return i;
    }

    final synchronized void a(am amVar) {
        if (this.e.size() >= this.a || c(amVar) >= this.b) {
            this.d.add(amVar);
        } else {
            this.e.add(amVar);
            a().execute(amVar);
        }
    }

    final synchronized void b(am amVar) {
        if (this.e.remove(amVar)) {
            b();
        } else {
            throw new AssertionError("AsyncCall wasn't running!");
        }
    }
}
