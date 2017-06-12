package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.a.d;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.b.bk;
import com.google.android.gms.b.fd;

@fd
public final class n {
    private static final Object a = new Object();
    private static n b;
    private final a c = new a();
    private final h d = new h();
    private final l e = new l();
    private final c f = new c();
    private final bk g = new bk();
    private final d h = new d();

    static {
        n nVar = new n();
        synchronized (a) {
            b = nVar;
        }
    }

    protected n() {
    }

    public static a a() {
        return c().c;
    }

    public static l b() {
        return c().e;
    }

    private static n c() {
        n nVar;
        synchronized (a) {
            nVar = b;
        }
        return nVar;
    }
}
