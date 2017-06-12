package com.alipay.e.a.a.a;

import com.alipay.f.a.a.b.a.b;
import com.alipay.f.a.a.b.b.d;

final class c implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ b b;

    c(b bVar, b bVar2) {
        this.b = bVar;
        this.a = bVar2;
    }

    public final void run() {
        try {
            b.g = this.b.d.a();
        } catch (Throwable th) {
            b.g = new d();
            b.g.c = false;
            b.g.d = "static data rpc upload error, " + com.alipay.e.a.a.b.c.b(th);
            com.alipay.e.a.a.b.c.b(th);
        }
    }
}
