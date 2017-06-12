package b.a.a;

import c.h;
import c.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

final class af implements b {
    final aa a = new aa(this.c);
    private final h b;
    private final ad c = new ad(this.b);
    private final boolean d;

    af(h hVar, boolean z) {
        this.b = hVar;
        this.d = z;
    }

    private List<x> a(int i, short s, byte b, int i2) {
        ad adVar = this.c;
        this.c.d = i;
        adVar.a = i;
        this.c.e = s;
        this.c.b = b;
        this.c.c = i2;
        aa aaVar = this.a;
        while (!aaVar.b.d()) {
            int e = aaVar.b.e() & 255;
            if (e == 128) {
                throw new IOException("index == 0");
            } else if ((e & 128) == 128) {
                e = aaVar.a(e, 127) - 1;
                if (aa.c(e)) {
                    aaVar.a.add(z.a[e]);
                } else {
                    int a = aaVar.a(e - z.a.length);
                    if (a < 0 || a > aaVar.e.length - 1) {
                        throw new IOException("Header index too large " + (e + 1));
                    }
                    aaVar.a.add(aaVar.e[a]);
                }
            } else if (e == 64) {
                aaVar.a(new x(z.a(aaVar.b()), aaVar.b()));
            } else if ((e & 64) == 64) {
                aaVar.a(new x(aaVar.b(aaVar.a(e, 63) - 1), aaVar.b()));
            } else if ((e & 32) == 32) {
                aaVar.d = aaVar.a(e, 31);
                if (aaVar.d < 0 || aaVar.d > aaVar.c) {
                    throw new IOException("Invalid dynamic table size update " + aaVar.d);
                }
                aaVar.a();
            } else if (e == 16 || e == 0) {
                aaVar.a.add(new x(z.a(aaVar.b()), aaVar.b()));
            } else {
                aaVar.a.add(new x(aaVar.b(aaVar.a(e, 15) - 1), aaVar.b()));
            }
        }
        aaVar = this.a;
        List arrayList = new ArrayList(aaVar.a);
        aaVar.a.clear();
        return arrayList;
    }

    private void b() {
        this.b.g();
        this.b.e();
    }

    public final void a() {
        if (!this.d) {
            i c = this.b.c((long) ac.b.c.length);
            if (ac.a.isLoggable(Level.FINE)) {
                ac.a.fine(String.format("<< CONNECTION %s", new Object[]{c.b()}));
            }
            if (!ac.b.equals(c)) {
                throw ac.c("Expected a connection header but was %s", c.a());
            }
        }
    }

    public final boolean a(c cVar) {
        boolean z = false;
        try {
            this.b.a(9);
            int a = ((((this.b.e() & 255) << 16) | ((this.b.e() & 255) << 8)) | (this.b.e() & 255));
            if (a < 0 || a > 16384) {
                throw ac.c("FRAME_SIZE_ERROR: %s", Integer.valueOf(a));
            }
            byte e = (byte) (this.b.e() & 255);
            byte e2 = (byte) (this.b.e() & 255);
            int g = this.b.g() & Integer.MAX_VALUE;
            if (ac.a.isLoggable(Level.FINE)) {
                ac.a.fine(ae.a(true, g, a, e, e2));
            }
            short e3;
            int f;
            switch (e) {
                case (byte) 0:
                    boolean z2 = (e2 & 1) != 0;
                    if ((e2 & 32) != 0) {
                        throw ac.c("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
                    }
                    if ((e2 & 8) != 0) {
                        e3 = (short) (this.b.e() & 255);
                    }
                    cVar.a(z2, g, this.b, ac.a(a, e2, e3));
                    this.b.f((long) e3);
                    return true;
                case (byte) 1:
                    if (g == 0) {
                        throw ac.c("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
                    }
                    boolean z3 = (e2 & 1) != 0;
                    short e4 = (e2 & 8) != 0 ? (short) (this.b.e() & 255) : (short) 0;
                    if ((e2 & 32) != 0) {
                        b();
                        a -= 5;
                    }
                    cVar.a(false, z3, g, a(ac.a(a, e2, e4), e4, e2, g), y.HTTP_20_HEADERS);
                    return true;
                case (byte) 2:
                    if (a != 5) {
                        throw ac.c("TYPE_PRIORITY length: %d != 5", Integer.valueOf(a));
                    } else if (g == 0) {
                        throw ac.c("TYPE_PRIORITY streamId == 0", new Object[0]);
                    } else {
                        b();
                        return true;
                    }
                case (byte) 3:
                    if (a != 4) {
                        throw ac.c("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(a));
                    } else if (g == 0) {
                        throw ac.c("TYPE_RST_STREAM streamId == 0", new Object[0]);
                    } else {
                        a b = a.b(this.b.g());
                        if (b == null) {
                            throw ac.c("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(a));
                        }
                        cVar.a(g, b);
                        return true;
                    }
                case (byte) 4:
                    if (g != 0) {
                        throw ac.c("TYPE_SETTINGS streamId != 0", new Object[0]);
                    } else if ((e2 & 1) != 0) {
                        if (a == 0) {
                            return true;
                        }
                        throw ac.c("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                    } else if (a % 6 != 0) {
                        throw ac.c("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(a));
                    } else {
                        ap apVar = new ap();
                        for (g = 0; g < a; g += 6) {
                            f = this.b.f();
                            int g2 = this.b.g();
                            switch (f) {
                                case 2:
                                    if (!(g2 == 0 || g2 == 1)) {
                                        throw ac.c("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                                    }
                                case 3:
                                    f = 4;
                                    break;
                                case 4:
                                    f = 7;
                                    if (g2 >= 0) {
                                        break;
                                    }
                                    throw ac.c("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                case 5:
                                    if (g2 >= 16384 && g2 <= 16777215) {
                                        break;
                                    }
                                    throw ac.c("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(g2));
                                default:
                                    break;
                            }
                            apVar.a(f, 0, g2);
                        }
                        cVar.a(false, apVar);
                        if (apVar.a() < 0) {
                            return true;
                        }
                        aa aaVar = this.a;
                        int a2 = apVar.a();
                        aaVar.c = a2;
                        aaVar.d = a2;
                        aaVar.a();
                        return true;
                    }
                case (byte) 5:
                    if (g == 0) {
                        throw ac.c("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
                    }
                    if ((e2 & 8) != 0) {
                        e3 = (short) (this.b.e() & 255);
                    }
                    cVar.a(this.b.g() & Integer.MAX_VALUE, a(ac.a(a - 4, e2, e3), e3, e2, g));
                    return true;
                case (byte) 6:
                    if (a != 8) {
                        throw ac.c("TYPE_PING length != 8: %s", Integer.valueOf(a));
                    } else if (g != 0) {
                        throw ac.c("TYPE_PING streamId != 0", new Object[0]);
                    } else {
                        a = this.b.g();
                        f = this.b.g();
                        if ((e2 & 1) != 0) {
                            z = true;
                        }
                        cVar.a(z, a, f);
                        return true;
                    }
                case (byte) 7:
                    if (a < 8) {
                        throw ac.c("TYPE_GOAWAY length < 8: %s", Integer.valueOf(a));
                    } else if (g != 0) {
                        throw ac.c("TYPE_GOAWAY streamId != 0", new Object[0]);
                    } else {
                        f = this.b.g();
                        int i = a - 8;
                        if (a.b(this.b.g()) == null) {
                            throw ac.c("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(this.b.g()));
                        }
                        i iVar = i.b;
                        if (i > 0) {
                            iVar = this.b.c((long) i);
                        }
                        cVar.a(f, iVar);
                        return true;
                    }
                case (byte) 8:
                    if (a != 4) {
                        throw ac.c("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(a));
                    }
                    long g3 = ((long) this.b.g()) & 2147483647L;
                    if (g3 == 0) {
                        throw ac.c("windowSizeIncrement was 0", Long.valueOf(g3));
                    }
                    cVar.a(g, g3);
                    return true;
                default:
                    this.b.f((long) a);
                    return true;
            }
        } catch (IOException e5) {
            return false;
        }
    }

    public final void close() {
        this.b.close();
    }
}
