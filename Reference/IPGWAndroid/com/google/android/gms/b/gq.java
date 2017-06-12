package com.google.android.gms.b;

import android.app.Activity;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.f;

@fd
public final class gq {
    Activity a;
    boolean b;
    boolean c;
    private boolean d;
    private OnGlobalLayoutListener e;
    private OnScrollChangedListener f = null;

    public gq(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        this.a = activity;
        this.e = onGlobalLayoutListener;
    }

    final void a() {
        if (this.a != null && !this.d) {
            if (this.e != null) {
                f.c();
                fs.a(this.a, this.e);
            }
            if (this.f != null) {
                f.c();
                fs.a(this.a, this.f);
            }
            this.d = true;
        }
    }

    final void b() {
        if (this.a != null && this.d) {
            if (this.e != null) {
                f.e().a(this.a, this.e);
            }
            if (this.f != null) {
                f.c();
                fs.b(this.a, this.f);
            }
            this.d = false;
        }
    }
}
