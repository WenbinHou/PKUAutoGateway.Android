package com.google.android.gms.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class fr implements ThreadFactory {
    final /* synthetic */ String a;
    private final AtomicInteger b = new AtomicInteger(1);

    fr(String str) {
        this.a = str;
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AdWorker(" + this.a + ") #" + this.b.getAndIncrement());
    }
}
