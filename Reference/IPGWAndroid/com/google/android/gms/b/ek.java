package com.google.android.gms.b;

import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public final class ek extends Thread {
    volatile boolean a = false;
    private final BlockingQueue<hs<?>> b;
    private final de c;
    private final h d;
    private final ic e;

    public ek(BlockingQueue<hs<?>> blockingQueue, de deVar, h hVar, ic icVar) {
        this.b = blockingQueue;
        this.c = deVar;
        this.d = hVar;
        this.e = icVar;
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                hs hsVar = (hs) this.b.take();
                try {
                    hsVar.a("network-queue-take");
                    if (hsVar.j) {
                        hsVar.b("network-discard-cancelled");
                    } else {
                        if (VERSION.SDK_INT >= 14) {
                            TrafficStats.setThreadStatsTag(hsVar.e);
                        }
                        ff a = this.c.a(hsVar);
                        hsVar.a("network-http-complete");
                        if (a.d && hsVar.k) {
                            hsVar.b("not-modified");
                        } else {
                            hw a2 = hsVar.a(a);
                            hsVar.a("network-parse-complete");
                            if (hsVar.i && a2.b != null) {
                                this.d.a(hsVar.d, a2.b);
                                hsVar.a("network-cache-written");
                            }
                            hsVar.k = true;
                            this.e.a(hsVar, a2);
                        }
                    }
                } catch (il e) {
                    e.b = SystemClock.elapsedRealtime() - elapsedRealtime;
                    this.e.a(hsVar, hs.a(e));
                } catch (Throwable e2) {
                    im.a(e2, "Unhandled exception %s", e2.toString());
                    il ilVar = new il(e2);
                    ilVar.b = SystemClock.elapsedRealtime() - elapsedRealtime;
                    this.e.a(hsVar, ilVar);
                }
            } catch (InterruptedException e3) {
                if (this.a) {
                    return;
                }
            }
        }
    }
}
