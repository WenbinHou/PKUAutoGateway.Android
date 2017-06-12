package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class dk {
    public static final dt b;
    public WeakReference<View> a;
    private Runnable c = null;
    private Runnable d = null;
    private int e = -1;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            b = new ds();
        } else if (i >= 19) {
            b = new dr();
        } else if (i >= 18) {
            b = new dp();
        } else if (i >= 16) {
            b = new dq();
        } else if (i >= 14) {
            b = new dn();
        } else {
            b = new dl();
        }
    }

    dk(View view) {
        this.a = new WeakReference(view);
    }

    public final dk a(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            b.a(this, view, f);
        }
        return this;
    }

    public final dk a(long j) {
        View view = (View) this.a.get();
        if (view != null) {
            b.a(view, j);
        }
        return this;
    }

    public final dk a(ea eaVar) {
        View view = (View) this.a.get();
        if (view != null) {
            b.a(this, view, eaVar);
        }
        return this;
    }

    public final dk a(ec ecVar) {
        View view = (View) this.a.get();
        if (view != null) {
            b.a(view, ecVar);
        }
        return this;
    }

    public final dk a(Interpolator interpolator) {
        View view = (View) this.a.get();
        if (view != null) {
            b.a(view, interpolator);
        }
        return this;
    }

    public final void a() {
        View view = (View) this.a.get();
        if (view != null) {
            b.a(this, view);
        }
    }

    public final dk b(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            b.b(this, view, f);
        }
        return this;
    }

    public final dk b(long j) {
        View view = (View) this.a.get();
        if (view != null) {
            b.b(view, j);
        }
        return this;
    }

    public final void b() {
        View view = (View) this.a.get();
        if (view != null) {
            b.b(this, view);
        }
    }

    public final dk c(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            b.c(this, view, f);
        }
        return this;
    }
}
