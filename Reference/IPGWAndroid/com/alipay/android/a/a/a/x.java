package com.alipay.android.a.a.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class x implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    x() {
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "com.alipay.mobile.common.transport.http.HttpManager.HttpWorker #" + this.a.getAndIncrement());
        thread.setPriority(4);
        return thread;
    }
}
