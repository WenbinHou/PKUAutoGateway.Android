package com.google.android.gms.b;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.concurrent.Callable;

@fd
public final class gp {
    public static <T> T a(Callable<T> callable) {
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        T call;
        try {
            StrictMode.setThreadPolicy(new Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            call = callable.call();
            return call;
        } catch (Throwable th) {
            call = th;
            b.b("Unexpected exception.", call);
            f.f().a((Throwable) call, true);
            return null;
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
