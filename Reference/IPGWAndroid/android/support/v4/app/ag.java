package android.support.v4.app;

import android.support.v4.view.bj;
import android.view.View;
import android.view.ViewGroup;

public abstract class ag extends bj {
    private final x b;
    private ai c = null;
    private n d = null;

    public ag(x xVar) {
        this.b = xVar;
    }

    private static String a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public abstract n a(int i);

    public Object a(ViewGroup viewGroup, int i) {
        if (this.c == null) {
            this.c = this.b.a();
        }
        long j = (long) i;
        n a = this.b.a(a(viewGroup.getId(), j));
        if (a != null) {
            this.c.b(a);
        } else {
            a = a(i);
            this.c.a(viewGroup.getId(), a, a(viewGroup.getId(), j));
        }
        if (a != this.d) {
            a.a(false);
            a.b(false);
        }
        return a;
    }

    public final void a() {
        if (this.c != null) {
            this.c.a();
            this.c = null;
            this.b.b();
        }
    }

    public final void a(Object obj) {
        if (this.c == null) {
            this.c = this.b.a();
        }
        this.c.a((n) obj);
    }

    public final boolean a(View view, Object obj) {
        return ((n) obj).I == view;
    }

    public final void b(Object obj) {
        n nVar = (n) obj;
        if (nVar != this.d) {
            if (this.d != null) {
                this.d.a(false);
                this.d.b(false);
            }
            if (nVar != null) {
                nVar.a(true);
                nVar.b(true);
            }
            this.d = nVar;
        }
    }
}
