package b.a.a;

import b.a.o;
import b.aj;
import c.f;
import c.h;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class e implements Closeable {
    static final /* synthetic */ boolean k = (!e.class.desiredAssertionStatus());
    private static final ExecutorService l = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), o.a("OkHttp FramedConnection", true));
    public final aj a;
    final boolean b;
    long c;
    long d;
    public ap e;
    final ap f;
    final at g;
    final Socket h;
    public final d i;
    final p j;
    private final n m;
    private final Map<Integer, t> n;
    private final String o;
    private int p;
    private int q;
    private boolean r;
    private long s;
    private final ExecutorService t;
    private Map<Integer, am> u;
    private final an v;
    private int w;
    private boolean x;
    private final Set<Integer> y;

    private e(m mVar) {
        int i = 2;
        this.n = new HashMap();
        this.s = System.nanoTime();
        this.c = 0;
        this.e = new ap();
        this.f = new ap();
        this.x = false;
        this.y = new LinkedHashSet();
        this.a = mVar.f;
        this.v = mVar.g;
        this.b = mVar.h;
        this.m = mVar.e;
        this.q = mVar.h ? 1 : 2;
        if (mVar.h && this.a == aj.HTTP_2) {
            this.q += 2;
        }
        if (mVar.h) {
            i = 1;
        }
        this.w = i;
        if (mVar.h) {
            this.e.a(7, 0, 16777216);
        }
        this.o = mVar.b;
        if (this.a == aj.HTTP_2) {
            this.g = new ac();
            this.t = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), o.a(String.format("OkHttp %s Push Observer", new Object[]{this.o}), true));
            this.f.a(7, 0, 65535);
            this.f.a(5, 0, 16384);
        } else if (this.a == aj.SPDY_3) {
            this.g = new aq();
            this.t = null;
        } else {
            throw new AssertionError(this.a);
        }
        this.d = (long) this.f.b();
        this.h = mVar.a;
        this.i = this.g.a(mVar.d, this.b);
        this.j = new p(this, this.g.a(mVar.c, this.b));
        new Thread(this.j).start();
    }

    private void a(a aVar, a aVar2) {
        if (k || !Thread.holdsLock(this)) {
            IOException iOException;
            t[] tVarArr;
            IOException iOException2;
            am[] amVarArr;
            try {
                synchronized (this.i) {
                    synchronized (this) {
                        if (this.r) {
                            iOException = null;
                        } else {
                            this.r = true;
                            this.i.a(this.p, aVar, o.a);
                            iOException = null;
                        }
                    }
                    if (tVarArr != null) {
                        iOException2 = iOException;
                        for (t a : tVarArr) {
                            try {
                                a.a(aVar2);
                            } catch (IOException iOException3) {
                                if (iOException2 != null) {
                                    iOException2 = iOException3;
                                }
                            }
                        }
                        iOException3 = iOException2;
                    }
                    if (amVarArr != null) {
                        for (am amVar : amVarArr) {
                            if (amVar.c == -1 || amVar.b == -1) {
                                throw new IllegalStateException();
                            }
                            amVar.c = amVar.b - 1;
                            amVar.a.countDown();
                        }
                    }
                    this.i.close();
                    iOException2 = iOException3;
                    this.h.close();
                    if (iOException2 != null) {
                        throw iOException2;
                    }
                    return;
                }
            } catch (IOException iOException22) {
                iOException3 = iOException22;
            }
            synchronized (this) {
                if (this.n.isEmpty()) {
                    tVarArr = null;
                } else {
                    t[] tVarArr2 = (t[]) this.n.values().toArray(new t[this.n.size()]);
                    this.n.clear();
                    a(false);
                    tVarArr = tVarArr2;
                }
                if (this.u != null) {
                    am[] amVarArr2 = (am[]) this.u.values().toArray(new am[this.u.size()]);
                    this.u = null;
                    amVarArr = amVarArr2;
                } else {
                    amVarArr = null;
                }
            }
            if (tVarArr != null) {
                iOException22 = iOException3;
                while (r2 < r6) {
                    a.a(aVar2);
                }
                iOException3 = iOException22;
            }
            if (amVarArr != null) {
                while (r0 < r2) {
                    if (amVar.c == -1) {
                    }
                    throw new IllegalStateException();
                }
            }
            try {
                this.i.close();
                iOException22 = iOException3;
            } catch (IOException e) {
                iOException22 = e;
                if (iOException3 != null) {
                    iOException22 = iOException3;
                }
            }
            try {
                this.h.close();
            } catch (IOException e2) {
                iOException22 = e2;
            }
            if (iOException22 != null) {
                throw iOException22;
            }
            return;
        }
        throw new AssertionError();
    }

    static /* synthetic */ void a(e eVar, int i, int i2) {
        e eVar2 = eVar;
        l.execute(new h(eVar2, "OkHttp %s ping %08x%08x", new Object[]{eVar.o, Integer.valueOf(i), Integer.valueOf(i2)}, i, i2));
    }

    static /* synthetic */ void a(e eVar, int i, a aVar) {
        e eVar2 = eVar;
        eVar.t.execute(new l(eVar2, "OkHttp %s Push Reset[%s]", new Object[]{eVar.o, Integer.valueOf(i)}, i, aVar));
    }

    static /* synthetic */ void a(e eVar, int i, h hVar, int i2, boolean z) {
        f fVar = new f();
        hVar.a((long) i2);
        hVar.a(fVar, (long) i2);
        if (fVar.b != ((long) i2)) {
            throw new IOException(fVar.b + " != " + i2);
        }
        e eVar2 = eVar;
        eVar.t.execute(new k(eVar2, "OkHttp %s Push Data[%s]", new Object[]{eVar.o, Integer.valueOf(i)}, i, fVar, i2, z));
    }

    static /* synthetic */ void a(e eVar, int i, List list) {
        synchronized (eVar) {
            if (eVar.y.contains(Integer.valueOf(i))) {
                eVar.a(i, a.PROTOCOL_ERROR);
                return;
            }
            eVar.y.add(Integer.valueOf(i));
            e eVar2 = eVar;
            eVar.t.execute(new i(eVar2, "OkHttp %s Push Request[%s]", new Object[]{eVar.o, Integer.valueOf(i)}, i, list));
        }
    }

    static /* synthetic */ void a(e eVar, int i, List list, boolean z) {
        e eVar2 = eVar;
        eVar.t.execute(new j(eVar2, "OkHttp %s Push Headers[%s]", new Object[]{eVar.o, Integer.valueOf(i)}, i, list, z));
    }

    static /* synthetic */ void a(e eVar, boolean z, int i, int i2, am amVar) {
        synchronized (eVar.i) {
            if (amVar != null) {
                if (amVar.b != -1) {
                    throw new IllegalStateException();
                }
                amVar.b = System.nanoTime();
            }
            eVar.i.a(z, i, i2);
        }
    }

    private synchronized void a(boolean z) {
        this.s = z ? System.nanoTime() : Long.MAX_VALUE;
    }

    static /* synthetic */ boolean a(e eVar, int i) {
        return eVar.a == aj.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    private synchronized am c(int i) {
        return this.u != null ? (am) this.u.remove(Integer.valueOf(i)) : null;
    }

    public final synchronized int a() {
        ap apVar;
        apVar = this.f;
        return (apVar.a & 16) != 0 ? apVar.d[4] : Integer.MAX_VALUE;
    }

    final synchronized t a(int i) {
        return (t) this.n.get(Integer.valueOf(i));
    }

    public final t a(List<x> list, boolean z) {
        t tVar;
        boolean z2 = false;
        if (!z) {
            z2 = true;
        }
        synchronized (this.i) {
            int i;
            synchronized (this) {
                if (this.r) {
                    throw new IOException("shutdown");
                }
                i = this.q;
                this.q += 2;
                tVar = new t(i, this, z2, false, list);
                if (tVar.a()) {
                    this.n.put(Integer.valueOf(i), tVar);
                    a(false);
                }
            }
            this.i.a(z2, i, (List) list);
        }
        if (!z) {
            this.i.b();
        }
        return tVar;
    }

    final void a(int i, long j) {
        l.execute(new g(this, "OkHttp Window Update %s stream %d", new Object[]{this.o, Integer.valueOf(i)}, i, j));
    }

    final void a(int i, a aVar) {
        l.submit(new f(this, "OkHttp %s stream %d", new Object[]{this.o, Integer.valueOf(i)}, i, aVar));
    }

    public final void a(int i, boolean z, f fVar, long j) {
        if (j == 0) {
            this.i.a(z, i, fVar, 0);
            return;
        }
        while (j > 0) {
            int min;
            synchronized (this) {
                while (this.d <= 0) {
                    try {
                        if (this.n.containsKey(Integer.valueOf(i))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException e) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.d), this.i.c());
                this.d -= (long) min;
            }
            j -= (long) min;
            d dVar = this.i;
            boolean z2 = z && j == 0;
            dVar.a(z2, i, fVar, min);
        }
    }

    final synchronized t b(int i) {
        t tVar;
        tVar = (t) this.n.remove(Integer.valueOf(i));
        if (tVar != null && this.n.isEmpty()) {
            a(true);
        }
        notifyAll();
        return tVar;
    }

    public final void b() {
        this.i.b();
    }

    final void b(int i, a aVar) {
        this.i.a(i, aVar);
    }

    public final void close() {
        a(a.NO_ERROR, a.CANCEL);
    }
}
