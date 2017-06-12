package com.google.android.gms.b;

import java.util.concurrent.Callable;

final class fn implements Callable<Void> {
    final /* synthetic */ Runnable a;

    fn(Runnable runnable) {
        this.a = runnable;
    }

    public final /* synthetic */ Object call() {
        this.a.run();
        return null;
    }
}
