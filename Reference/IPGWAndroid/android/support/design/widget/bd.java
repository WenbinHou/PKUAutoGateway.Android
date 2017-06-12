package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class bd {
    private static bd d;
    final Object a = new Object();
    bg b;
    bg c;
    private final Handler e = new Handler(Looper.getMainLooper(), new be(this));

    private bd() {
    }

    static bd a() {
        if (d == null) {
            d = new bd();
        }
        return d;
    }

    public final void a(bf bfVar) {
        synchronized (this.a) {
            if (d(bfVar)) {
                this.e.removeCallbacksAndMessages(this.b);
            }
        }
    }

    final boolean a(bg bgVar) {
        if (((bf) bgVar.a.get()) == null) {
            return false;
        }
        this.e.removeCallbacksAndMessages(bgVar);
        return true;
    }

    public final void b(bf bfVar) {
        synchronized (this.a) {
            if (d(bfVar)) {
                b(this.b);
            }
        }
    }

    final void b(bg bgVar) {
        if (bgVar.b != -2) {
            int i = 2750;
            if (bgVar.b > 0) {
                i = bgVar.b;
            } else if (bgVar.b == -1) {
                i = 1500;
            }
            this.e.removeCallbacksAndMessages(bgVar);
            this.e.sendMessageDelayed(Message.obtain(this.e, 0, bgVar), (long) i);
        }
    }

    public final boolean c(bf bfVar) {
        boolean z;
        synchronized (this.a) {
            z = d(bfVar) || e(bfVar);
        }
        return z;
    }

    final boolean d(bf bfVar) {
        return this.b != null && this.b.a(bfVar);
    }

    final boolean e(bf bfVar) {
        return this.c != null && this.c.a(bfVar);
    }
}
