package b;

import b.a.b.a;
import b.a.b.aa;
import b.a.b.b;
import b.a.b.c;
import b.a.b.p;
import b.a.b.r;
import b.a.b.s;
import b.a.b.t;
import b.a.b.v;
import b.a.b.z;
import b.a.f;
import b.a.g;
import b.a.o;
import c.w;
import c.x;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;

final class ak implements g {
    final ag a;
    volatile boolean b;
    an c;
    p d;
    private boolean e;

    protected ak(ag agVar, an anVar) {
        this.a = agVar;
        this.c = anVar;
    }

    static /* synthetic */ String a(ak akVar) {
        return (akVar.b ? "canceled call" : "call") + " to " + akVar.c.a.c("/...");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final ar a(an anVar, boolean z) {
        ao a;
        long b;
        an a2;
        p a3;
        Object obj;
        Throwable th;
        ap apVar = anVar.d;
        if (apVar != null) {
            a = anVar.a();
            af a4 = apVar.a();
            if (a4 != null) {
                a.a("Content-Type", a4.toString());
            }
            b = apVar.b();
            if (b != -1) {
                a.a("Content-Length", Long.toString(b));
                a.b("Transfer-Encoding");
            } else {
                a.a("Transfer-Encoding", "chunked");
                a.b("Content-Length");
            }
            a2 = a.a();
        } else {
            a2 = anVar;
        }
        this.d = new p(this.a, a2, false, false, z, null, null);
        int i = 0;
        while (!this.b) {
            ar a5;
            try {
                g a6;
                String str;
                Object obj2;
                p pVar = this.d;
                if (pVar.r == null) {
                    if (pVar.e != null) {
                        throw new IllegalStateException();
                    }
                    b bVar;
                    long max;
                    an anVar2 = pVar.i;
                    a = anVar2.a();
                    if (anVar2.a("Host") == null) {
                        a.a("Host", o.a(anVar2.a, false));
                    }
                    if (anVar2.a("Connection") == null) {
                        a.a("Connection", "Keep-Alive");
                    }
                    if (anVar2.a("Accept-Encoding") == null) {
                        pVar.g = true;
                        a.a("Accept-Encoding", "gzip");
                    }
                    List b2 = pVar.b.h.b();
                    if (!b2.isEmpty()) {
                        a.a("Cookie", p.a(b2));
                    }
                    if (anVar2.a("User-Agent") == null) {
                        a.a("User-Agent", "okhttp/3.2.0");
                    }
                    an a7 = a.a();
                    a6 = f.b.a(pVar.b);
                    a5 = a6 != null ? a6.a() : null;
                    c cVar = new c(System.currentTimeMillis(), a7, a5);
                    if (cVar.c == null) {
                        bVar = new b(cVar.b, null);
                    } else if (cVar.b.c() && cVar.c.e == null) {
                        bVar = new b(cVar.b, null);
                    } else if (b.a(cVar.c, cVar.b)) {
                        e b3 = cVar.b.b();
                        if (b3.c || c.a(cVar.b)) {
                            bVar = new b(cVar.b, null);
                        } else {
                            max = cVar.d != null ? Math.max(0, cVar.j - cVar.d.getTime()) : 0;
                            if (cVar.l != -1) {
                                max = Math.max(max, TimeUnit.SECONDS.toMillis((long) cVar.l));
                            }
                            long j = (max + (cVar.j - cVar.i)) + (cVar.a - cVar.j);
                            e c = cVar.c.c();
                            if (c.e != -1) {
                                max = TimeUnit.SECONDS.toMillis((long) c.e);
                            } else if (cVar.h != null) {
                                max = cVar.h.getTime() - (cVar.d != null ? cVar.d.getTime() : cVar.j);
                                if (max <= 0) {
                                    max = 0;
                                }
                            } else {
                                if (cVar.f != null) {
                                    aa aaVar = cVar.c.a.a;
                                    if (aaVar.d == null) {
                                        str = null;
                                    } else {
                                        StringBuilder stringBuilder = new StringBuilder();
                                        aa.b(stringBuilder, aaVar.d);
                                        str = stringBuilder.toString();
                                    }
                                    if (str == null) {
                                        max = (cVar.d != null ? cVar.d.getTime() : cVar.i) - cVar.f.getTime();
                                        max = max > 0 ? max / 10 : 0;
                                    }
                                }
                                max = 0;
                            }
                            long min = b3.e != -1 ? Math.min(max, TimeUnit.SECONDS.toMillis((long) b3.e)) : max;
                            b = b3.j != -1 ? TimeUnit.SECONDS.toMillis((long) b3.j) : 0;
                            max = 0;
                            e c2 = cVar.c.c();
                            if (!(c2.h || b3.i == -1)) {
                                max = TimeUnit.SECONDS.toMillis((long) b3.i);
                            }
                            if (c2.c || j + b >= r2 + min) {
                                ao a8 = cVar.b.a();
                                if (cVar.k != null) {
                                    a8.a("If-None-Match", cVar.k);
                                } else if (cVar.f != null) {
                                    a8.a("If-Modified-Since", cVar.g);
                                } else if (cVar.d != null) {
                                    a8.a("If-Modified-Since", cVar.e);
                                }
                                an a9 = a8.a();
                                bVar = c.a(a9) ? new b(a9, cVar.c) : new b(a9, null);
                            } else {
                                as b4 = cVar.c.b();
                                if (b + j >= min) {
                                    b4.b("Warning", "110 HttpURLConnection \"Response is stale\"");
                                }
                                if (j > 86400000) {
                                    obj2 = (cVar.c.c().e == -1 && cVar.h == null) ? 1 : null;
                                    if (obj2 != null) {
                                        b4.b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                                    }
                                }
                                bVar = new b(null, b4.a());
                            }
                        }
                    } else {
                        bVar = new b(cVar.b, null);
                    }
                    if (bVar.a != null && cVar.b.b().k) {
                        bVar = new b(null, null);
                    }
                    pVar.r = bVar;
                    pVar.j = pVar.r.a;
                    pVar.k = pVar.r.b;
                    if (a5 != null && pVar.k == null) {
                        o.a(a5.g);
                    }
                    as asVar;
                    if (pVar.j == null && pVar.k == null) {
                        asVar = new as();
                        asVar.a = pVar.i;
                        asVar = asVar.c(p.a(pVar.d));
                        asVar.b = aj.HTTP_1_1;
                        asVar.c = 504;
                        asVar.d = "Unsatisfiable Request (only-if-cached)";
                        asVar.g = p.a;
                        pVar.l = asVar.a();
                    } else if (pVar.j == null) {
                        asVar = pVar.k.b();
                        asVar.a = pVar.i;
                        pVar.l = asVar.c(p.a(pVar.d)).b(p.a(pVar.k)).a();
                        pVar.l = pVar.b(pVar.l);
                    } else {
                        pVar.e = pVar.c.a(pVar.b.w, pVar.b.x, pVar.b.y, pVar.b.v, !pVar.j.b.equals("GET"));
                        pVar.e.a(pVar);
                        obj2 = (pVar.o && p.a(pVar.j) && pVar.m == null) ? 1 : null;
                        if (obj2 != null) {
                            max = v.a(a7);
                            if (!pVar.h) {
                                pVar.e.a(pVar.j);
                                pVar.m = pVar.e.a(pVar.j, max);
                            } else if (max > 2147483647L) {
                                throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                            } else if (max != -1) {
                                pVar.e.a(pVar.j);
                                pVar.m = new z((int) max);
                            } else {
                                pVar.m = new z();
                            }
                        }
                    }
                }
                p pVar2 = this.d;
                if (pVar2.l == null) {
                    if (pVar2.j == null && pVar2.k == null) {
                        throw new IllegalStateException("call sendRequest() first!");
                    } else if (pVar2.j != null) {
                        ar a10;
                        as b5;
                        a aVar;
                        w a11;
                        x rVar;
                        if (pVar2.p) {
                            pVar2.e.a(pVar2.j);
                        } else if (pVar2.o) {
                            if (pVar2.n != null && pVar2.n.b().b > 0) {
                                pVar2.n.c();
                            }
                            if (pVar2.f == -1) {
                                if (v.a(pVar2.j) == -1 && (pVar2.m instanceof z)) {
                                    pVar2.j = pVar2.j.a().a("Content-Length", Long.toString(((z) pVar2.m).a.b)).a();
                                }
                                pVar2.e.a(pVar2.j);
                            }
                            if (pVar2.m != null) {
                                if (pVar2.n != null) {
                                    pVar2.n.close();
                                } else {
                                    pVar2.m.close();
                                }
                                if (pVar2.m instanceof z) {
                                    pVar2.e.a((z) pVar2.m);
                                }
                            }
                        } else {
                            a10 = new s(pVar2, 0, pVar2.j).a(pVar2.j);
                            pVar2.a(a10.f);
                            if (pVar2.k != null) {
                                if (p.a(pVar2.k, a10)) {
                                    o.a(pVar2.k.g);
                                } else {
                                    b5 = pVar2.k.b();
                                    b5.a = pVar2.i;
                                    pVar2.l = b5.c(p.a(pVar2.d)).a(p.a(pVar2.k.f, a10.f)).b(p.a(pVar2.k)).a(p.a(a10)).a();
                                    a10.g.close();
                                    pVar2.c.b();
                                    f.b.a(pVar2.b);
                                    p.a(pVar2.l);
                                    pVar2.l = pVar2.b(pVar2.l);
                                }
                            }
                            b5 = a10.b();
                            b5.a = pVar2.i;
                            pVar2.l = b5.c(p.a(pVar2.d)).b(p.a(pVar2.k)).a(p.a(a10)).a();
                            if (p.c(pVar2.l)) {
                                a6 = f.b.a(pVar2.b);
                                if (a6 != null) {
                                    if (b.a(pVar2.l, pVar2.j)) {
                                        str = pVar2.j.b;
                                        if (!(str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE"))) {
                                            str.equals("MOVE");
                                        }
                                    } else {
                                        p.a(pVar2.l);
                                        pVar2.q = a6.b();
                                    }
                                }
                                aVar = pVar2.q;
                                a10 = pVar2.l;
                                if (aVar != null) {
                                    a11 = aVar.a();
                                    if (a11 != null) {
                                        rVar = new r(pVar2, a10.g.c(), aVar, c.o.a(a11));
                                        b5 = a10.b();
                                        b5.g = new b.a.b.w(a10.f, c.o.a(rVar));
                                        a10 = b5.a();
                                    }
                                }
                                pVar2.l = pVar2.b(a10);
                            }
                        }
                        a10 = pVar2.c();
                        pVar2.a(a10.f);
                        if (pVar2.k != null) {
                            if (p.a(pVar2.k, a10)) {
                                o.a(pVar2.k.g);
                            } else {
                                b5 = pVar2.k.b();
                                b5.a = pVar2.i;
                                pVar2.l = b5.c(p.a(pVar2.d)).a(p.a(pVar2.k.f, a10.f)).b(p.a(pVar2.k)).a(p.a(a10)).a();
                                a10.g.close();
                                pVar2.c.b();
                                f.b.a(pVar2.b);
                                p.a(pVar2.l);
                                pVar2.l = pVar2.b(pVar2.l);
                            }
                        }
                        b5 = a10.b();
                        b5.a = pVar2.i;
                        pVar2.l = b5.c(p.a(pVar2.d)).b(p.a(pVar2.k)).a(p.a(a10)).a();
                        if (p.c(pVar2.l)) {
                            a6 = f.b.a(pVar2.b);
                            if (a6 != null) {
                                if (b.a(pVar2.l, pVar2.j)) {
                                    p.a(pVar2.l);
                                    pVar2.q = a6.b();
                                } else {
                                    str = pVar2.j.b;
                                    str.equals("MOVE");
                                }
                            }
                            aVar = pVar2.q;
                            a10 = pVar2.l;
                            if (aVar != null) {
                                a11 = aVar.a();
                                if (a11 != null) {
                                    rVar = new r(pVar2, a10.g.c(), aVar, c.o.a(a11));
                                    b5 = a10.b();
                                    b5.g = new b.a.b.w(a10.f, c.o.a(rVar));
                                    a10 = b5.a();
                                }
                            }
                            pVar2.l = pVar2.b(a10);
                        }
                    }
                }
                p pVar3 = this.d;
                if (pVar3.l != null) {
                    ar arVar = pVar3.l;
                    pVar2 = this.d;
                    if (pVar2.l != null) {
                        m a12 = pVar2.c.a();
                        au a13 = a12 != null ? a12.a() : null;
                        int i2 = pVar2.l.c;
                        String str2 = pVar2.i.b;
                        switch (i2) {
                            case 307:
                            case 308:
                                if (!str2.equals("GET")) {
                                    break;
                                }
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                if (pVar2.b.u) {
                                    str = pVar2.l.a("Location");
                                    if (str != null) {
                                        aa c3 = pVar2.i.a.c(str);
                                        if (c3 != null && (c3.a.equals(pVar2.i.a.a) || pVar2.b.t)) {
                                            ao a14 = pVar2.i.a();
                                            if (t.b(str2)) {
                                                if ((!str2.equals("PROPFIND") ? 1 : null) != null) {
                                                    a14.a("GET", null);
                                                } else {
                                                    a14.a(str2, null);
                                                }
                                                a14.b("Transfer-Encoding");
                                                a14.b("Content-Length");
                                                a14.b("Content-Type");
                                            }
                                            if (!pVar2.a(c3)) {
                                                a14.b("Authorization");
                                            }
                                            a2 = a14.a(c3).a();
                                            break;
                                        }
                                    }
                                }
                            case 401:
                                break;
                            case 407:
                                if ((a13 != null ? a13.b : pVar2.b.b).type() != Type.HTTP) {
                                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                                }
                                break;
                            case 408:
                                obj2 = (pVar2.m == null || (pVar2.m instanceof z)) ? 1 : null;
                                if (!(pVar2.o && obj2 == null)) {
                                    a2 = pVar2.i;
                                    break;
                                }
                                break;
                        }
                    }
                    throw new IllegalStateException();
                }
                throw new IllegalStateException();
            } catch (b.a.b.x e) {
                throw e.a();
            } catch (aa e2) {
                a3 = this.d.a(e2.b);
                if (a3 != null) {
                    obj = null;
                    this.d = a3;
                } else {
                    throw e2.b;
                }
            } catch (IOException e3) {
                a3 = this.d.a(e3);
                if (a3 != null) {
                    obj = null;
                    this.d = a3;
                } else {
                    throw e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        this.d.c.a(false, true, false);
        throw new IOException("Canceled");
        if (obj != null) {
            this.d.b().a(false, true, false);
        }
        throw th;
    }

    public final void a(h hVar) {
        synchronized (this) {
            if (this.e) {
                throw new IllegalStateException("Already Executed");
            }
            this.e = true;
        }
        this.a.a.a(new am(this, hVar));
    }
}
