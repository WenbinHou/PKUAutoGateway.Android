package android.support.v7.widget;

import android.util.Log;
import android.view.View;

public abstract class el {
    int a;
    boolean b;
    boolean c;
    View d;
    private RecyclerView e;
    private eb f;
    private final em g;

    static /* synthetic */ void a(el elVar) {
        boolean z = false;
        RecyclerView recyclerView = elVar.e;
        if (!elVar.c || elVar.a == -1 || recyclerView == null) {
            elVar.a();
        }
        elVar.b = false;
        if (elVar.d != null) {
            if (RecyclerView.c(elVar.d) == elVar.a) {
                en enVar = recyclerView.o;
                em.a(elVar.g, recyclerView);
                elVar.a();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                elVar.d = null;
            }
        }
        if (elVar.c) {
            enVar = recyclerView.o;
            if (elVar.g.a >= 0) {
                z = true;
            }
            em.a(elVar.g, recyclerView);
            if (!z) {
                return;
            }
            if (elVar.c) {
                elVar.b = true;
                recyclerView.n.a();
                return;
            }
            elVar.a();
        }
    }

    protected final void a() {
        if (this.c) {
            this.e.o.a = -1;
            this.d = null;
            this.a = -1;
            this.b = false;
            this.c = false;
            eb.a(this.f, this);
            this.f = null;
            this.e = null;
        }
    }
}
