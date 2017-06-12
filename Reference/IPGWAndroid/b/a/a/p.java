package b.a.a;

import b.a.h;
import b.a.o;
import b.aj;
import c.i;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

final class p extends h implements c {
    final b a;
    final /* synthetic */ e c;

    private p(e eVar, b bVar) {
        this.c = eVar;
        super("OkHttp %s", eVar.o);
        this.a = bVar;
    }

    public final void a(int i, long j) {
        if (i == 0) {
            synchronized (this.c) {
                e eVar = this.c;
                eVar.d += j;
                this.c.notifyAll();
            }
            return;
        }
        t a = this.c.a(i);
        if (a != null) {
            synchronized (a) {
                a.a(j);
            }
        }
    }

    public final void a(int i, a aVar) {
        if (e.a(this.c, i)) {
            e.a(this.c, i, aVar);
            return;
        }
        t b = this.c.b(i);
        if (b != null) {
            b.c(aVar);
        }
    }

    public final void a(int i, i iVar) {
        byte[] bArr = iVar.c;
        synchronized (this.c) {
            t[] tVarArr = (t[]) this.c.n.values().toArray(new t[this.c.n.size()]);
            this.c.r = true;
        }
        for (t tVar : tVarArr) {
            if (tVar.c > i && tVar.b()) {
                tVar.c(a.REFUSED_STREAM);
                this.c.b(tVar.c);
            }
        }
    }

    public final void a(int i, List<x> list) {
        e.a(this.c, i, (List) list);
    }

    public final void a(boolean z, int i, int i2) {
        if (z) {
            am c = this.c.c(i);
            if (c == null) {
                return;
            }
            if (c.c != -1 || c.b == -1) {
                throw new IllegalStateException();
            }
            c.c = System.nanoTime();
            c.a.countDown();
            return;
        }
        e.a(this.c, i, i2);
    }

    public final void a(boolean z, int i, c.h hVar, int i2) {
        if (e.a(this.c, i)) {
            e.a(this.c, i, hVar, i2, z);
            return;
        }
        t a = this.c.a(i);
        if (a == null) {
            this.c.a(i, a.INVALID_STREAM);
            hVar.f((long) i2);
        } else if (t.j || !Thread.holdsLock(a)) {
            a.f.a(hVar, (long) i2);
            if (z) {
                a.e();
            }
        } else {
            throw new AssertionError();
        }
    }

    public final void a(boolean z, ap apVar) {
        t[] tVarArr;
        long j;
        synchronized (this.c) {
            int i;
            int b = this.c.f.b();
            if (z) {
                ap apVar2 = this.c.f;
                apVar2.c = 0;
                apVar2.b = 0;
                apVar2.a = 0;
                Arrays.fill(apVar2.d, 0);
            }
            ap apVar3 = this.c.f;
            for (i = 0; i < 10; i++) {
                if (apVar.a(i)) {
                    apVar3.a(i, apVar.b(i), apVar.d[i]);
                }
            }
            if (this.c.a == aj.HTTP_2) {
                e.l.execute(new s(this, "OkHttp %s ACK Settings", new Object[]{this.c.o}, apVar));
            }
            i = this.c.f.b();
            if (i == -1 || i == b) {
                tVarArr = null;
                j = 0;
            } else {
                long j2 = (long) (i - b);
                if (!this.c.x) {
                    e eVar = this.c;
                    eVar.d += j2;
                    if (j2 > 0) {
                        eVar.notifyAll();
                    }
                    this.c.x = true;
                }
                if (this.c.n.isEmpty()) {
                    j = j2;
                    tVarArr = null;
                } else {
                    j = j2;
                    tVarArr = (t[]) this.c.n.values().toArray(new t[this.c.n.size()]);
                }
            }
            e.l.execute(new r(this, "OkHttp %s settings", this.c.o));
        }
        if (tVarArr != null && j != 0) {
            for (t tVar : tVarArr) {
                synchronized (tVar) {
                    tVar.a(j);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean z, boolean z2, int i, List<x> list, y yVar) {
        boolean z3 = false;
        boolean z4 = true;
        if (e.a(this.c, i)) {
            e.a(this.c, i, (List) list, z2);
            return;
        }
        synchronized (this.c) {
            if (this.c.r) {
                return;
            }
            t a = this.c.a(i);
            if (a == null) {
                if (yVar == y.SPDY_REPLY || yVar == y.SPDY_HEADERS) {
                    z3 = true;
                }
                if (z3) {
                    this.c.a(i, a.INVALID_STREAM);
                } else if (i <= this.c.p) {
                } else if (i % 2 == this.c.q % 2) {
                } else {
                    t tVar = new t(i, this.c, z, z2, list);
                    this.c.p = i;
                    this.c.n.put(Integer.valueOf(i), tVar);
                    e.l.execute(new q(this, "OkHttp %s stream %d", new Object[]{this.c.o, Integer.valueOf(i)}, tVar));
                }
            }
        }
    }

    protected final void b() {
        a aVar;
        Throwable th;
        a aVar2 = a.INTERNAL_ERROR;
        a aVar3 = a.INTERNAL_ERROR;
        try {
            if (!this.c.b) {
                this.a.a();
            }
            do {
            } while (this.a.a(this));
            try {
                this.c.a(a.NO_ERROR, a.CANCEL);
            } catch (IOException e) {
            }
            o.a(this.a);
        } catch (IOException e2) {
            aVar = a.PROTOCOL_ERROR;
            try {
                this.c.a(aVar, a.PROTOCOL_ERROR);
            } catch (IOException e3) {
            }
            o.a(this.a);
        } catch (Throwable th2) {
            th = th2;
            this.c.a(aVar, aVar3);
            o.a(this.a);
            throw th;
        }
    }
}
