package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.ak;
import com.google.android.gms.b.ef;
import com.google.android.gms.b.fd;
import com.google.android.gms.b.gv;
import com.google.android.gms.b.hd;
import com.google.android.gms.b.he;
import java.util.Collections;

@fd
public final class c extends ef implements u {
    static final int a = Color.argb(0, 0, 0, 0);
    public final Activity b;
    AdOverlayInfoParcel c;
    gv d;
    g e;
    public r f;
    public boolean g = false;
    public FrameLayout h;
    public CustomViewCallback i;
    boolean j = false;
    boolean k = false;
    public RelativeLayout l;
    public boolean m = false;
    int n = 0;
    p o;
    public boolean p;
    private boolean q = false;
    private boolean r = true;

    public c(Activity activity) {
        this.b = activity;
        this.o = new t();
    }

    private void b(boolean z) {
        q qVar = null;
        boolean z2 = false;
        if (!this.p) {
            this.b.requestWindowFeature(1);
        }
        Window window = this.b.getWindow();
        if (window == null) {
            throw new e("Invalid activity, no window available.");
        }
        if (!this.k || (this.c.q != null && this.c.q.c)) {
            window.setFlags(1024, 1024);
        }
        boolean a = this.c.e.i().a();
        this.m = false;
        if (a) {
            if (this.c.k == f.e().a()) {
                if (this.b.getResources().getConfiguration().orientation == 1) {
                    z2 = true;
                }
                this.m = z2;
            } else if (this.c.k == f.e().b()) {
                if (this.b.getResources().getConfiguration().orientation == 2) {
                    z2 = true;
                }
                this.m = z2;
            }
        }
        b.a("Delay onShow to next orientation change: " + this.m);
        a(this.c.k);
        if (f.e().a(window)) {
            b.a("Hardware acceleration on the AdActivity window enabled.");
        }
        if (this.k) {
            this.l.setBackgroundColor(a);
        } else {
            this.l.setBackgroundColor(-16777216);
        }
        this.b.setContentView(this.l);
        this.p = true;
        if (z) {
            f.d();
            gv hdVar = new hd(he.a(this.b, this.c.e.h(), this.c.n, this.c.e.e()));
            hdVar.setWebViewClient(f.e().a(hdVar, a));
            hdVar.setWebChromeClient(f.e().a(hdVar));
            this.d = hdVar;
            this.d.i().a(this.c.f, this.c.j, this.c.o, this.c.e.i().n);
            this.d.i().f = new d(this);
            if (this.c.m != null) {
                this.d.loadUrl(this.c.m);
            } else if (this.c.i != null) {
                this.d.loadDataWithBaseURL(this.c.g, this.c.i, "text/html", "UTF-8", null);
            } else {
                throw new e("No URL or HTML to display in ad overlay.");
            }
            if (this.c.e != null) {
                this.c.e.b(this);
            }
        } else {
            this.d = this.c.e;
            this.d.setContext(this.b);
        }
        this.d.a(this);
        ViewParent parent = this.d.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.d.getView());
        }
        if (this.k) {
            this.d.setBackgroundColor(a);
        }
        this.l.addView(this.d.getView(), -1, -1);
        if (!(z || this.m)) {
            m();
        }
        a(a);
        if (this.d.j()) {
            a(a, true);
        }
        com.google.android.gms.ads.internal.b e = this.d.e();
        if (e != null) {
            qVar = e.c;
        }
        if (qVar != null) {
            this.o = qVar.a();
        } else {
            b.d("Appstreaming controller is null.");
        }
    }

    private void n() {
        if (this.b.isFinishing() && !this.q) {
            this.q = true;
            if (this.d != null) {
                this.d.a(this.n);
                this.l.removeView(this.d.getView());
                if (this.e != null) {
                    this.d.setContext(this.e.d);
                    this.d.a(false);
                    this.e.c.addView(this.d.getView(), this.e.a, this.e.b);
                    this.e = null;
                } else if (this.b.getApplicationContext() != null) {
                    this.d.setContext(this.b.getApplicationContext());
                }
                this.d = null;
            }
            if (this.c != null && this.c.d != null) {
                this.c.d.a();
            }
        }
    }

    public final void a() {
        this.n = 2;
        this.b.finish();
    }

    public final void a(int i) {
        this.b.setRequestedOrientation(i);
    }

    public final void a(Bundle bundle) {
        boolean z = false;
        if (bundle != null) {
            z = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.j = z;
        try {
            this.c = AdOverlayInfoParcel.a(this.b.getIntent());
            if (this.c == null) {
                throw new e("Could not get info for ad overlay.");
            }
            if (this.c.n.d > 7500000) {
                this.n = 3;
            }
            if (this.b.getIntent() != null) {
                this.r = this.b.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.c.q != null) {
                this.k = this.c.q.b;
            } else {
                this.k = false;
            }
            if (((Boolean) f.i().a(ak.aE)).booleanValue() && this.k && this.c.q.d != null) {
                new h().b();
            }
            if (bundle == null) {
                if (this.c.d != null && this.r) {
                    this.c.d.b();
                }
                if (!(this.c.l == 1 || this.c.c == null)) {
                    a aVar = this.c.c;
                }
            }
            this.l = new f(this.b, this.c.p);
            this.l.setId(1000);
            switch (this.c.l) {
                case 1:
                    b(false);
                    return;
                case 2:
                    this.e = new g(this.c.e);
                    b(false);
                    return;
                case 3:
                    b(true);
                    return;
                case 4:
                    if (this.j) {
                        this.n = 3;
                        this.b.finish();
                        return;
                    }
                    f.a();
                    Context context = this.b;
                    AdLauncherIntentInfoParcel adLauncherIntentInfoParcel = this.c.b;
                    s sVar = this.c.j;
                    if (!a.a(context, adLauncherIntentInfoParcel)) {
                        this.n = 3;
                        this.b.finish();
                        return;
                    }
                    return;
                default:
                    throw new e("Could not determine ad overlay type.");
            }
        } catch (e e) {
            b.d(e.getMessage());
            this.n = 3;
            this.b.finish();
        }
    }

    public final void a(boolean z) {
        this.f = new r(this.b, z ? 50 : 32, this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.f.a(z, this.c.h);
        this.l.addView(this.f, layoutParams);
    }

    public final void a(boolean z, boolean z2) {
        if (this.f != null) {
            this.f.a(z, z2);
        }
    }

    public final void b() {
        if (this.c != null && this.g) {
            a(this.c.k);
        }
        if (this.h != null) {
            this.b.setContentView(this.l);
            this.p = true;
            this.h.removeAllViews();
            this.h = null;
        }
        if (this.i != null) {
            this.i.onCustomViewHidden();
            this.i = null;
        }
        this.g = false;
    }

    public final void b(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.j);
    }

    public final void c() {
        this.n = 1;
        this.b.finish();
    }

    public final void d() {
        this.n = 0;
    }

    public final boolean e() {
        boolean z = true;
        this.n = 0;
        if (this.d != null) {
            if (!this.d.p()) {
                z = false;
            }
            if (!z) {
                this.d.a("onbackblocked", Collections.emptyMap());
            }
        }
        return z;
    }

    public final void f() {
    }

    public final void g() {
    }

    public final void h() {
        if (this.c != null && this.c.l == 4) {
            if (this.j) {
                this.n = 3;
                this.b.finish();
            } else {
                this.j = true;
            }
        }
        if (this.c.d != null) {
            l lVar = this.c.d;
        }
        if (this.d == null || this.d.n()) {
            b.d("The webview does not exit. Ignoring action.");
            return;
        }
        f.e();
        gv gvVar = this.d;
        if (gvVar != null) {
            gvVar.onResume();
        }
    }

    public final void i() {
        b();
        if (this.c.d != null) {
            l lVar = this.c.d;
        }
        if (this.d != null && (!this.b.isFinishing() || this.e == null)) {
            f.e();
            gv gvVar = this.d;
            if (gvVar != null) {
                gvVar.onPause();
            }
        }
        n();
    }

    public final void j() {
        n();
    }

    public final void k() {
        if (this.d != null) {
            this.l.removeView(this.d.getView());
        }
        n();
    }

    public final void l() {
        this.p = true;
    }

    public final void m() {
        this.d.b();
    }
}
