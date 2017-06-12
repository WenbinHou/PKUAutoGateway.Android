package com.google.android.gms.b;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class at extends Thread {
    private static final boolean b = im.b;
    volatile boolean a = false;
    private final BlockingQueue<hs<?>> c;
    private final BlockingQueue<hs<?>> d;
    private final h e;
    private final ic f;

    public at(BlockingQueue<hs<?>> blockingQueue, BlockingQueue<hs<?>> blockingQueue2, h hVar, ic icVar) {
        this.c = blockingQueue;
        this.d = blockingQueue2;
        this.e = hVar;
        this.f = icVar;
    }

    public final void run() {
        if (b) {
            im.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.e.a();
        while (true) {
            try {
                hs hsVar = (hs) this.c.take();
                hsVar.a("cache-queue-take");
                if (hsVar.j) {
                    hsVar.b("cache-discard-canceled");
                } else {
                    i a = this.e.a(hsVar.d);
                    if (a == null) {
                        hsVar.a("cache-miss");
                        this.d.put(hsVar);
                    } else {
                        if ((a.e < System.currentTimeMillis() ? 1 : 0) != 0) {
                            hsVar.a("cache-hit-expired");
                            hsVar.m = a;
                            this.d.put(hsVar);
                        } else {
                            hsVar.a("cache-hit");
                            hw a2 = hsVar.a(new ff(a.a, a.g));
                            hsVar.a("cache-hit-parsed");
                            if ((a.f < System.currentTimeMillis() ? 1 : 0) == 0) {
                                this.f.a(hsVar, a2);
                            } else {
                                hsVar.a("cache-hit-refresh-needed");
                                hsVar.m = a;
                                a2.d = true;
                                this.f.a(hsVar, a2, new au(this, hsVar));
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.a) {
                    return;
                }
            }
        }
    }
}
