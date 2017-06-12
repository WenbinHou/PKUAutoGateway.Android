package com.google.android.gms.ads.internal;

import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.a.a;
import com.google.android.gms.ads.internal.overlay.j;
import com.google.android.gms.ads.internal.purchase.g;
import com.google.android.gms.b.ag;
import com.google.android.gms.b.ah;
import com.google.android.gms.b.ai;
import com.google.android.gms.b.am;
import com.google.android.gms.b.cl;
import com.google.android.gms.b.cp;
import com.google.android.gms.b.cu;
import com.google.android.gms.b.fa;
import com.google.android.gms.b.fd;
import com.google.android.gms.b.fe;
import com.google.android.gms.b.fg;
import com.google.android.gms.b.fs;
import com.google.android.gms.b.fu;
import com.google.android.gms.b.fv;
import com.google.android.gms.b.fw;
import com.google.android.gms.b.fy;
import com.google.android.gms.b.fz;
import com.google.android.gms.b.ga;
import com.google.android.gms.b.gb;
import com.google.android.gms.b.gc;
import com.google.android.gms.b.gm;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.ia;
import com.google.android.gms.b.ib;

@fd
public final class f {
    private static final Object a = new Object();
    private static f b;
    private final a c = new a();
    private final com.google.android.gms.ads.internal.overlay.a d = new com.google.android.gms.ads.internal.overlay.a();
    private final j e = new j();
    private final fa f = new fa();
    private final fs g = new fs();
    private final hc h = new hc();
    private final fu i;
    private final fg j;
    private final ia k;
    private final am l;
    private final fe m;
    private final ah n;
    private final ag o;
    private final ai p;
    private final g q;
    private final cp r;
    private final gm s;
    private final cu t;
    private final e u;
    private final cl v;

    static {
        f fVar = new f();
        synchronized (a) {
            b = fVar;
        }
    }

    protected f() {
        int i = VERSION.SDK_INT;
        fu gcVar = i >= 19 ? new gc() : i >= 18 ? new ga() : i >= 17 ? new fz() : i >= 16 ? new gb() : i >= 14 ? new fy() : i >= 11 ? new fw() : i >= 9 ? new fv() : new fu();
        this.i = gcVar;
        this.j = new fg();
        this.k = new ib();
        this.l = new am();
        this.m = new fe();
        this.n = new ah();
        this.o = new ag();
        this.p = new ai();
        this.q = new g();
        this.r = new cp();
        this.s = new gm();
        this.t = new cu();
        this.u = new e();
        this.v = new cl();
    }

    public static com.google.android.gms.ads.internal.overlay.a a() {
        return l().d;
    }

    public static j b() {
        return l().e;
    }

    public static fs c() {
        return l().g;
    }

    public static hc d() {
        return l().h;
    }

    public static fu e() {
        return l().i;
    }

    public static fg f() {
        return l().j;
    }

    public static ia g() {
        return l().k;
    }

    public static ag h() {
        return l().o;
    }

    public static ai i() {
        return l().p;
    }

    public static g j() {
        return l().q;
    }

    public static cl k() {
        return l().v;
    }

    private static f l() {
        f fVar;
        synchronized (a) {
            fVar = b;
        }
        return fVar;
    }
}
