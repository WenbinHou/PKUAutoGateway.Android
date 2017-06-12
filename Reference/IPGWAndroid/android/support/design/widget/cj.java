package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

final class cj extends cg {
    private static final Handler a = new Handler(Looper.getMainLooper());
    private long b;
    private boolean c;
    private final int[] d = new int[2];
    private final float[] e = new float[2];
    private int f = 200;
    private Interpolator g;
    private ch h;
    private ci i;
    private float j;
    private final Runnable k = new ck(this);

    cj() {
    }

    static /* synthetic */ void a(cj cjVar) {
        if (cjVar.c) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - cjVar.b)) / ((float) cjVar.f);
            if (cjVar.g != null) {
                uptimeMillis = cjVar.g.getInterpolation(uptimeMillis);
            }
            cjVar.j = uptimeMillis;
            if (cjVar.i != null) {
                cjVar.i.a();
            }
            if (SystemClock.uptimeMillis() >= cjVar.b + ((long) cjVar.f)) {
                cjVar.c = false;
                if (cjVar.h != null) {
                    cjVar.h.a();
                }
            }
        }
        if (cjVar.c) {
            a.postDelayed(cjVar.k, 10);
        }
    }

    public final void a() {
        if (!this.c) {
            if (this.g == null) {
                this.g = new AccelerateDecelerateInterpolator();
            }
            this.b = SystemClock.uptimeMillis();
            this.c = true;
            a.postDelayed(this.k, 10);
        }
    }

    public final void a(float f, float f2) {
        this.e[0] = f;
        this.e[1] = f2;
    }

    public final void a(int i) {
        this.f = i;
    }

    public final void a(int i, int i2) {
        this.d[0] = i;
        this.d[1] = i2;
    }

    public final void a(ch chVar) {
        this.h = chVar;
    }

    public final void a(ci ciVar) {
        this.i = ciVar;
    }

    public final void a(Interpolator interpolator) {
        this.g = interpolator;
    }

    public final boolean b() {
        return this.c;
    }

    public final int c() {
        return a.a(this.d[0], this.d[1], this.j);
    }

    public final float d() {
        return a.a(this.e[0], this.e[1], this.j);
    }

    public final void e() {
        this.c = false;
        a.removeCallbacks(this.k);
    }

    public final float f() {
        return this.j;
    }

    public final long g() {
        return (long) this.f;
    }
}
