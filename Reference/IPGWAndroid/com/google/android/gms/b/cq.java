package com.google.android.gms.b;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class cq implements ic {
    private final Executor a;

    public cq(Handler handler) {
        this.a = new cr(this, handler);
    }

    public final void a(hs<?> hsVar, hw<?> hwVar) {
        a(hsVar, hwVar, null);
    }

    public final void a(hs<?> hsVar, hw<?> hwVar, Runnable runnable) {
        hsVar.k = true;
        hsVar.a("post-response");
        this.a.execute(new cs(this, hsVar, hwVar, runnable));
    }

    public final void a(hs<?> hsVar, il ilVar) {
        hsVar.a("post-error");
        this.a.execute(new cs(this, hsVar, new hw(ilVar), null));
    }
}
