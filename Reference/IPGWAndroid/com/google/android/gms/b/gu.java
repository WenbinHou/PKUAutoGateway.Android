package com.google.android.gms.b;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.overlay.o;
import com.google.android.gms.common.internal.c;

@fd
public final class gu {
    final gv a;
    final Context b;
    final ViewGroup c;
    o d;

    public gu(Context context, ViewGroup viewGroup, gv gvVar) {
        this(context, viewGroup, gvVar, (byte) 0);
    }

    private gu(Context context, ViewGroup viewGroup, gv gvVar, byte b) {
        this.b = context;
        this.c = viewGroup;
        this.a = gvVar;
        this.d = null;
    }

    public final o a() {
        c.a("getAdVideoUnderlay must be called from the UI thread.");
        return this.d;
    }
}
