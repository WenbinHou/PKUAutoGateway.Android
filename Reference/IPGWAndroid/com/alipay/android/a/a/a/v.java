package com.alipay.android.a.a.a;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

public final class v implements f {
    private static v g = null;
    private static final ThreadFactory i = new x();
    Context a;
    i b = i.a("android");
    long c;
    long d;
    long e;
    int f;
    private ThreadPoolExecutor h = new ThreadPoolExecutor(10, 11, 3, TimeUnit.SECONDS, new ArrayBlockingQueue(20), i, new CallerRunsPolicy());

    private v(Context context) {
        this.a = context;
        try {
            this.h.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
        }
        CookieSyncManager.createInstance(this.a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    public static final v a(Context context) {
        return g != null ? g : b(context);
    }

    private static final synchronized v b(Context context) {
        v vVar;
        synchronized (v.class) {
            if (g != null) {
                vVar = g;
            } else {
                vVar = new v(context);
                g = vVar;
            }
        }
        return vVar;
    }

    public final Future<ae> a(ad adVar) {
        long j = 0;
        if (ac.a(this.a)) {
            String str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(this.h.getActiveCount());
            objArr[1] = Long.valueOf(this.h.getCompletedTaskCount());
            objArr[2] = Long.valueOf(this.h.getTaskCount());
            objArr[3] = Long.valueOf(this.e == 0 ? 0 : ((this.c * 1000) / this.e) >> 10);
            if (this.f != 0) {
                j = this.d / ((long) this.f);
            }
            objArr[4] = Long.valueOf(j);
            objArr[5] = Long.valueOf(this.c);
            objArr[6] = Long.valueOf(this.d);
            objArr[7] = Long.valueOf(this.e);
            objArr[8] = Integer.valueOf(this.f);
            String.format(str, objArr);
        }
        Object aaVar = new aa(this, (y) adVar);
        Object wVar = new w(this, aaVar, aaVar);
        this.h.execute(wVar);
        return wVar;
    }
}
