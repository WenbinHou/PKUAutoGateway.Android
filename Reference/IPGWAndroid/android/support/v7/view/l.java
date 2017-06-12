package android.support.v7.view;

import android.support.v4.view.dk;
import android.support.v4.view.ea;
import android.support.v4.view.eb;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class l {
    public final ArrayList<dk> a = new ArrayList();
    ea b;
    boolean c;
    private long d = -1;
    private Interpolator e;
    private final eb f = new m(this);

    public final l a(dk dkVar) {
        if (!this.c) {
            this.a.add(dkVar);
        }
        return this;
    }

    public final l a(ea eaVar) {
        if (!this.c) {
            this.b = eaVar;
        }
        return this;
    }

    public final l a(Interpolator interpolator) {
        if (!this.c) {
            this.e = interpolator;
        }
        return this;
    }

    public final void a() {
        if (!this.c) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                dk dkVar = (dk) it.next();
                if (this.d >= 0) {
                    dkVar.a(this.d);
                }
                if (this.e != null) {
                    dkVar.a(this.e);
                }
                if (this.b != null) {
                    dkVar.a(this.f);
                }
                dkVar.b();
            }
            this.c = true;
        }
    }

    public final void b() {
        if (this.c) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((dk) it.next()).a();
            }
            this.c = false;
        }
    }

    public final l c() {
        if (!this.c) {
            this.d = 250;
        }
        return this;
    }
}
