package b.a.b;

import b.a;
import b.a.c.c;
import b.a.f;
import b.a.o;
import b.au;
import b.n;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Proxy.Type;
import java.util.concurrent.TimeUnit;

public final class ad {
    public final a a;
    ab b;
    c c;
    private au d;
    private final n e;
    private boolean f;
    private boolean g;
    private u h;

    public ad(n nVar, a aVar) {
        this.e = nVar;
        this.a = aVar;
        this.b = new ab(aVar, c());
    }

    private c a(int i, int i2, int i3, boolean z) {
        c cVar;
        synchronized (this.e) {
            if (this.f) {
                throw new IllegalStateException("released");
            } else if (this.h != null) {
                throw new IllegalStateException("stream != null");
            } else if (this.g) {
                throw new IOException("Canceled");
            } else {
                cVar = this.c;
                if (cVar == null || cVar.k) {
                    cVar = f.b.a(this.e, this.a, this);
                    if (cVar != null) {
                        this.c = cVar;
                    } else {
                        au auVar;
                        au auVar2 = this.d;
                        if (auVar2 == null) {
                            auVar2 = this.b.a();
                            synchronized (this.e) {
                                this.d = auVar2;
                            }
                            auVar = auVar2;
                        } else {
                            auVar = auVar2;
                        }
                        cVar = new c(auVar);
                        a(cVar);
                        synchronized (this.e) {
                            f.b.b(this.e, cVar);
                            this.c = cVar;
                            if (this.g) {
                                throw new IOException("Canceled");
                            }
                        }
                        cVar.a(i, i2, i3, this.a.f, z);
                        c().b(cVar.b);
                    }
                }
            }
        }
        return cVar;
    }

    private c b(int i, int i2, int i3, boolean z, boolean z2) {
        c a;
        while (true) {
            a = a(i, i2, i3, z);
            synchronized (this.e) {
                if (a.f != 0) {
                    if (a.a(z2)) {
                        break;
                    }
                    a(new IOException());
                } else {
                    break;
                }
            }
        }
        return a;
    }

    private b.a.n c() {
        return f.b.a(this.e);
    }

    public final u a(int i, int i2, int i3, boolean z, boolean z2) {
        try {
            u lVar;
            c b = b(i, i2, i3, z, z2);
            if (b.e != null) {
                lVar = new l(this, b.e);
            } else {
                b.c.setSoTimeout(i2);
                b.g.a().a((long) i2, TimeUnit.MILLISECONDS);
                b.h.a().a((long) i3, TimeUnit.MILLISECONDS);
                lVar = new e(this, b.g, b.h);
            }
            synchronized (this.e) {
                this.h = lVar;
            }
            return lVar;
        } catch (IOException e) {
            throw new aa(e);
        }
    }

    public final synchronized c a() {
        return this.c;
    }

    public final void a(c cVar) {
        cVar.j.add(new WeakReference(this));
    }

    public final void a(IOException iOException) {
        synchronized (this.e) {
            if (this.c != null && this.c.f == 0) {
                if (!(this.d == null || iOException == null)) {
                    ab abVar = this.b;
                    au auVar = this.d;
                    if (!(auVar.b.type() == Type.DIRECT || abVar.a.g == null)) {
                        abVar.a.g.connectFailed(abVar.a.a.a(), auVar.b.address(), iOException);
                    }
                    abVar.b.a(auVar);
                }
                this.d = null;
            }
        }
        a(true, false, true);
    }

    public final void a(boolean z, u uVar) {
        synchronized (this.e) {
            if (uVar != null) {
                if (uVar == this.h) {
                    if (!z) {
                        c cVar = this.c;
                        cVar.f++;
                    }
                }
            }
            throw new IllegalStateException("expected " + this.h + " but was " + uVar);
        }
        a(z, false, true);
    }

    public final void a(boolean z, boolean z2, boolean z3) {
        c cVar;
        synchronized (this.e) {
            if (z3) {
                this.h = null;
            }
            if (z2) {
                this.f = true;
            }
            if (this.c != null) {
                if (z) {
                    this.c.k = true;
                }
                if (this.h == null && (this.f || this.c.k)) {
                    c cVar2 = this.c;
                    int size = cVar2.j.size();
                    int i = 0;
                    while (i < size) {
                        if (((Reference) cVar2.j.get(i)).get() == this) {
                            cVar2.j.remove(i);
                            if (this.c.j.isEmpty()) {
                                this.c.l = System.nanoTime();
                                if (f.b.a(this.e, this.c)) {
                                    cVar = this.c;
                                    this.c = null;
                                }
                            }
                            cVar = null;
                            this.c = null;
                        } else {
                            i++;
                        }
                    }
                    throw new IllegalStateException();
                }
            }
            cVar = null;
        }
        if (cVar != null) {
            o.a(cVar.c);
        }
    }

    public final void b() {
        a(false, true, false);
    }

    public final String toString() {
        return this.a.toString();
    }
}
