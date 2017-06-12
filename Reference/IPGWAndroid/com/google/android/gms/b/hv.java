package com.google.android.gms.b;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class hv {
    final Map<String, Queue<hs<?>>> a;
    final Set<hs<?>> b;
    final PriorityBlockingQueue<hs<?>> c;
    List<Object> d;
    private AtomicInteger e;
    private final PriorityBlockingQueue<hs<?>> f;
    private final h g;
    private final de h;
    private final ic i;
    private ek[] j;
    private at k;

    private hv(h hVar, de deVar) {
        this(hVar, deVar, new cq(new Handler(Looper.getMainLooper())));
    }

    public hv(h hVar, de deVar, byte b) {
        this(hVar, deVar);
    }

    private hv(h hVar, de deVar, ic icVar) {
        this.e = new AtomicInteger();
        this.a = new HashMap();
        this.b = new HashSet();
        this.c = new PriorityBlockingQueue();
        this.f = new PriorityBlockingQueue();
        this.d = new ArrayList();
        this.g = hVar;
        this.h = deVar;
        this.j = new ek[4];
        this.i = icVar;
    }

    public final <T> hs<T> a(hs<T> hsVar) {
        hsVar.h = this;
        synchronized (this.b) {
            this.b.add(hsVar);
        }
        hsVar.g = Integer.valueOf(this.e.incrementAndGet());
        hsVar.a("add-to-queue");
        if (hsVar.i) {
            synchronized (this.a) {
                String str = hsVar.d;
                if (this.a.containsKey(str)) {
                    Queue queue = (Queue) this.a.get(str);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(hsVar);
                    this.a.put(str, queue);
                    if (im.b) {
                        im.a("Request for cacheKey=%s is in flight, putting on hold.", str);
                    }
                } else {
                    this.a.put(str, null);
                    this.c.add(hsVar);
                }
            }
        } else {
            this.f.add(hsVar);
        }
        return hsVar;
    }

    public final void a() {
        int i = 0;
        if (this.k != null) {
            at atVar = this.k;
            atVar.a = true;
            atVar.interrupt();
        }
        for (int i2 = 0; i2 < this.j.length; i2++) {
            if (this.j[i2] != null) {
                ek ekVar = this.j[i2];
                ekVar.a = true;
                ekVar.interrupt();
            }
        }
        this.k = new at(this.c, this.f, this.g, this.i);
        this.k.start();
        while (i < this.j.length) {
            ek ekVar2 = new ek(this.f, this.h, this.g, this.i);
            this.j[i] = ekVar2;
            ekVar2.start();
            i++;
        }
    }
}
