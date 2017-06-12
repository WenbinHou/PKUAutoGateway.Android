package com.alipay.b.b;

public final class c implements Runnable {
    final /* synthetic */ b a;

    public c(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        try {
            this.a.a();
        } catch (Throwable th) {
            com.alipay.e.a.a.b.c.a(th);
        }
    }
}
