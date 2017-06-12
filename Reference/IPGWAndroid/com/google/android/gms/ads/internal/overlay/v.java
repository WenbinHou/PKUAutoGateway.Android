package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.b.fd;
import com.google.android.gms.b.fs;

@fd
public final class v implements Runnable {
    public boolean a = false;
    private o b;

    v(o oVar) {
        this.b = oVar;
    }

    public final void a() {
        fs.a.postDelayed(this, 250);
    }

    public final void run() {
        if (!this.a) {
            o oVar = this.b;
            if (oVar.d != null) {
                long currentPosition = (long) oVar.d.getCurrentPosition();
                if (oVar.h != currentPosition && currentPosition > 0) {
                    if (oVar.c()) {
                        oVar.b.removeView(oVar.g);
                    }
                    float f = ((float) currentPosition) / 1000.0f;
                    oVar.a("timeupdate", "time", String.valueOf(f));
                    oVar.h = currentPosition;
                }
            }
            a();
        }
    }
}
