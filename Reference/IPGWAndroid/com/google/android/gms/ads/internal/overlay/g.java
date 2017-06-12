package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.google.android.gms.b.fd;
import com.google.android.gms.b.gv;

@fd
public final class g {
    public final int a;
    public final LayoutParams b;
    public final ViewGroup c;
    public final Context d;

    public g(gv gvVar) {
        this.b = gvVar.getLayoutParams();
        ViewParent parent = gvVar.getParent();
        this.d = gvVar.d();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new e("Could not get the parent of the WebView for an overlay.");
        }
        this.c = (ViewGroup) parent;
        this.a = this.c.indexOfChild(gvVar.getView());
        this.c.removeView(gvVar.getView());
        gvVar.a(true);
    }
}
