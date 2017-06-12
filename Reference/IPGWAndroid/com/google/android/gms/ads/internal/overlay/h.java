package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.b.fd;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fs;

@fd
final class h extends fi {
    final /* synthetic */ c a;

    private h(c cVar) {
        this.a = cVar;
    }

    public final void a() {
        f.c();
        Bitmap b = fs.b(this.a.b, this.a.c.q.d);
        if (b != null) {
            fs.a.post(new i(this, f.e().a(this.a.b, b, this.a.c.q.e, this.a.c.q.f)));
        }
    }
}
