package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

final class i implements Runnable {
    final /* synthetic */ Drawable a;
    final /* synthetic */ h b;

    i(h hVar, Drawable drawable) {
        this.b = hVar;
        this.a = drawable;
    }

    public final void run() {
        this.b.a.b.getWindow().setBackgroundDrawable(this.a);
    }
}
