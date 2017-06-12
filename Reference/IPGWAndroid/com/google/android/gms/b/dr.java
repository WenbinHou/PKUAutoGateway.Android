package com.google.android.gms.b;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

@fd
public final class dr extends ea {
    static final Set<String> a = Collections.unmodifiableSet(new hz(Arrays.asList(new String[]{"top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"})));
    String b = "top-right";
    boolean c = true;
    int d = 0;
    int e = 0;
    int f = -1;
    int g = 0;
    int h = 0;
    int i = -1;
    final Object j = new Object();
    final gv k;
    final Activity l;
    AdSizeParcel m;
    ImageView n;
    LinearLayout o;
    PopupWindow p;
    RelativeLayout q;
    ViewGroup r;
    private eb t;

    public dr(gv gvVar) {
        super(gvVar, "resize");
        this.k = gvVar;
        this.l = gvVar.c();
        this.t = null;
    }

    public final void a(boolean z) {
        synchronized (this.j) {
            if (this.p != null) {
                this.p.dismiss();
                this.q.removeView(this.k.getView());
                if (this.r != null) {
                    this.r.removeView(this.n);
                    this.r.addView(this.k.getView());
                    this.k.a(this.m);
                }
                if (z) {
                    b("default");
                }
                this.p = null;
                this.q = null;
                this.r = null;
                this.o = null;
            }
        }
    }

    public final boolean a() {
        boolean z;
        synchronized (this.j) {
            z = this.p != null;
        }
        return z;
    }
}
