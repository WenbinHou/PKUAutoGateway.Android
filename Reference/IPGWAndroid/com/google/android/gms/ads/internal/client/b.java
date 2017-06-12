package com.google.android.gms.ads.internal.client;

import android.view.ViewGroup;
import com.google.android.gms.ads.a;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.f;
import com.google.android.gms.b.fd;

@fd
public final class b {
    public a a;
    public s b;
    public c[] c;
    public String d;
    public com.google.android.gms.ads.a.a e;
    public com.google.android.gms.ads.purchase.a f;
    public com.google.android.gms.ads.purchase.b g;
    public com.google.android.gms.ads.a.b h;
    public boolean i;
    public f j;
    private a k;
    private ViewGroup l;
    private boolean m;

    public final c a() {
        try {
            if (this.b != null) {
                AdSizeParcel a = this.b.a();
                if (a != null) {
                    return new c(a.f, a.c, a.b);
                }
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to get the current AdSize.", e);
        }
        return this.c != null ? this.c[0] : null;
    }

    public final void a(a aVar) {
        try {
            this.a = aVar;
            if (this.b != null && aVar != null) {
                g gVar = new g(aVar);
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to set the AdListener.", e);
        }
    }

    public final void a(a aVar) {
        try {
            this.k = aVar;
            if (this.b != null && aVar != null) {
                f fVar = new f(aVar);
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to set the AdClickListener.", e);
        }
    }

    public final void a(String str) {
        if (this.d != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.d = str;
    }

    public final void a(c... cVarArr) {
        if (this.c != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        b(cVarArr);
    }

    public final String b() {
        try {
            if (this.b != null) {
                return this.b.b();
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public final void b(c... cVarArr) {
        this.c = cVarArr;
        try {
            if (this.b != null) {
                new AdSizeParcel(this.l.getContext(), this.c).k = this.m;
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to set the ad size.", e);
        }
        this.l.requestLayout();
    }
}
