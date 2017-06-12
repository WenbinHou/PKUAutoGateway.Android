package com.google.android.gms.b;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

public abstract class hs<T> implements Comparable<hs<T>> {
    private final in a;
    private long b;
    final int c;
    final String d;
    final int e;
    final hx f;
    Integer g;
    hv h;
    boolean i;
    boolean j;
    boolean k;
    ie l;
    i m;

    public hs(String str, hx hxVar) {
        int hashCode;
        this.a = in.a ? new in() : null;
        this.i = true;
        this.j = false;
        this.k = false;
        this.b = 0;
        this.m = null;
        this.c = 0;
        this.d = str;
        this.f = hxVar;
        this.l = new bl();
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    hashCode = host.hashCode();
                    this.e = hashCode;
                }
            }
        }
        hashCode = 0;
        this.e = hashCode;
    }

    protected static il a(il ilVar) {
        return ilVar;
    }

    public static String b() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    protected abstract hw<T> a(ff ffVar);

    public Map<String, String> a() {
        return Collections.emptyMap();
    }

    protected abstract void a(T t);

    public final void a(String str) {
        if (in.a) {
            this.a.a(str, Thread.currentThread().getId());
        } else if (this.b == 0) {
            this.b = SystemClock.elapsedRealtime();
        }
    }

    final void b(String str) {
        if (this.h != null) {
            hv hvVar = this.h;
            synchronized (hvVar.b) {
                hvVar.b.remove(this);
            }
            synchronized (hvVar.d) {
                Iterator it = hvVar.d.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
            if (this.i) {
                synchronized (hvVar.a) {
                    Queue queue = (Queue) hvVar.a.remove(this.d);
                    if (queue != null) {
                        if (im.b) {
                            im.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), r3);
                        }
                        hvVar.c.addAll(queue);
                    }
                }
            }
        }
        if (in.a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new ht(this, str, id));
                return;
            }
            this.a.a(str, id);
            this.a.a(toString());
            return;
        }
        if (SystemClock.elapsedRealtime() - this.b >= 3000) {
            im.b("%d ms: %s", Long.valueOf(SystemClock.elapsedRealtime() - this.b), toString());
        }
    }

    public final int c() {
        return this.l.a();
    }

    public /* synthetic */ int compareTo(Object obj) {
        hs hsVar = (hs) obj;
        hu huVar = hu.NORMAL;
        hu huVar2 = hu.NORMAL;
        return huVar == huVar2 ? this.g.intValue() - hsVar.g.intValue() : huVar2.ordinal() - huVar.ordinal();
    }

    public String toString() {
        return (this.j ? "[X] " : "[ ] ") + this.d + " " + ("0x" + Integer.toHexString(this.e)) + " " + hu.NORMAL + " " + this.g;
    }
}
