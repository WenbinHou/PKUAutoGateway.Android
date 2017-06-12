package com.alipay.android.a.a.a;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

final class w extends FutureTask<ae> {
    final /* synthetic */ aa a;
    final /* synthetic */ v b;

    w(v vVar, Callable callable, aa aaVar) {
        this.b = vVar;
        this.a = aaVar;
        super(callable);
    }

    protected final void done() {
        ad a = this.a.a();
        if (a.a() == null) {
            super.done();
            return;
        }
        try {
            get();
            if (isCancelled() || a.f) {
                a.f = true;
                if (!isCancelled() || !isDone()) {
                    cancel(false);
                }
            }
        } catch (InterruptedException e) {
            new StringBuilder().append(e);
        } catch (ExecutionException e2) {
            if (e2.getCause() == null || !(e2.getCause() instanceof a)) {
                new StringBuilder().append(e2);
            } else {
                e2.getCause();
            }
        } catch (CancellationException e3) {
            a.f = true;
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("An error occured while executing http request", th);
        }
    }
}
