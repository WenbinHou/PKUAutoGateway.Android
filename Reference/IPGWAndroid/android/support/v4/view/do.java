package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;

final class do implements ea {
    dk a;
    boolean b;

    do(dk dkVar) {
        this.a = dkVar;
    }

    public final void a(View view) {
        this.b = false;
        if (this.a.e >= 0) {
            bq.a(view, 2, null);
        }
        if (this.a.c != null) {
            Runnable c = this.a.c;
            this.a.c = null;
            c.run();
        }
        Object tag = view.getTag(2113929216);
        ea eaVar = tag instanceof ea ? (ea) tag : null;
        if (eaVar != null) {
            eaVar.a(view);
        }
    }

    public final void b(View view) {
        if (this.a.e >= 0) {
            bq.a(view, this.a.e, null);
            this.a.e = -1;
        }
        if (VERSION.SDK_INT >= 16 || !this.b) {
            if (this.a.d != null) {
                Runnable d = this.a.d;
                this.a.d = null;
                d.run();
            }
            Object tag = view.getTag(2113929216);
            ea eaVar = tag instanceof ea ? (ea) tag : null;
            if (eaVar != null) {
                eaVar.b(view);
            }
            this.b = true;
        }
    }

    public final void c(View view) {
        Object tag = view.getTag(2113929216);
        ea eaVar = tag instanceof ea ? (ea) tag : null;
        if (eaVar != null) {
            eaVar.c(view);
        }
    }
}
