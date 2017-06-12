package com.google.android.gms.b;

import java.util.concurrent.Callable;

final class aj implements Callable<T> {
    final /* synthetic */ ab a;
    final /* synthetic */ ai b;

    aj(ai aiVar, ab abVar) {
        this.b = aiVar;
        this.a = abVar;
    }

    public final T call() {
        return this.a.a(this.b.a);
    }
}
