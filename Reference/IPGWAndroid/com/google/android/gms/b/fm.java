package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@fd
public final class fm {
    private static final ExecutorService a = Executors.newFixedThreadPool(10, a("Default"));
    private static final ExecutorService b = Executors.newFixedThreadPool(5, a("Loader"));

    public static gs<Void> a(int i, Runnable runnable) {
        return i == 1 ? a(b, new fn(runnable)) : a(a, new fo(runnable));
    }

    public static gs<Void> a(Runnable runnable) {
        return a(0, runnable);
    }

    private static <T> gs<T> a(ExecutorService executorService, Callable<T> callable) {
        Object grVar = new gr();
        try {
            Runnable fqVar = new fq(grVar, executorService.submit(new fp(grVar, callable)));
            gt gtVar = grVar.b;
            synchronized (gtVar.a) {
                if (gtVar.c) {
                    gt.a(fqVar);
                } else {
                    gtVar.b.add(fqVar);
                }
            }
        } catch (Throwable e) {
            b.c("Thread execution is rejected.", e);
            grVar.cancel(true);
        }
        return grVar;
    }

    private static ThreadFactory a(String str) {
        return new fr(str);
    }
}
