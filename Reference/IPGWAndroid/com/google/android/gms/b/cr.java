package com.google.android.gms.b;

import android.os.Handler;
import java.util.concurrent.Executor;

final class cr implements Executor {
    final /* synthetic */ Handler a;
    final /* synthetic */ cq b;

    cr(cq cqVar, Handler handler) {
        this.b = cqVar;
        this.a = handler;
    }

    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
