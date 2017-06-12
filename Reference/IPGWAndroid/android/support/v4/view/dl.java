package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class dl implements dt {
    WeakHashMap<View, Runnable> a = null;

    dl() {
    }

    private void d(dk dkVar, View view) {
        Runnable runnable = null;
        if (this.a != null) {
            runnable = (Runnable) this.a.get(view);
        }
        if (runnable == null) {
            runnable = new dm(this, dkVar, view);
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            this.a.put(view, runnable);
        }
        view.removeCallbacks(runnable);
        view.post(runnable);
    }

    public long a(View view) {
        return 0;
    }

    public void a(dk dkVar, View view) {
        d(dkVar, view);
    }

    public void a(dk dkVar, View view, float f) {
        d(dkVar, view);
    }

    public void a(dk dkVar, View view, ea eaVar) {
        view.setTag(2113929216, eaVar);
    }

    public void a(View view, long j) {
    }

    public void a(View view, ec ecVar) {
    }

    public void a(View view, Interpolator interpolator) {
    }

    public void b(dk dkVar, View view) {
        if (this.a != null) {
            Runnable runnable = (Runnable) this.a.get(view);
            if (runnable != null) {
                view.removeCallbacks(runnable);
            }
        }
        c(dkVar, view);
    }

    public void b(dk dkVar, View view, float f) {
        d(dkVar, view);
    }

    public void b(View view, long j) {
    }

    final void c(dk dkVar, View view) {
        Object tag = view.getTag(2113929216);
        ea eaVar = tag instanceof ea ? (ea) tag : null;
        Runnable c = dkVar.c;
        Runnable d = dkVar.d;
        dkVar.c = null;
        dkVar.d = null;
        if (c != null) {
            c.run();
        }
        if (eaVar != null) {
            eaVar.a(view);
            eaVar.b(view);
        }
        if (d != null) {
            d.run();
        }
        if (this.a != null) {
            this.a.remove(view);
        }
    }

    public void c(dk dkVar, View view, float f) {
        d(dkVar, view);
    }
}
