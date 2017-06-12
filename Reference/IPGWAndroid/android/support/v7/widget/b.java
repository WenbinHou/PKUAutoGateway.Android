package android.support.v7.widget;

import android.support.v4.view.dk;
import android.support.v4.view.ea;
import android.view.View;

public final class b implements ea {
    int a;
    final /* synthetic */ a b;
    private boolean c = false;

    protected b(a aVar) {
        this.b = aVar;
    }

    public final b a(dk dkVar, int i) {
        this.b.f = dkVar;
        this.a = i;
        return this;
    }

    public final void a(View view) {
        super.setVisibility(0);
        this.c = false;
    }

    public final void b(View view) {
        if (!this.c) {
            this.b.f = null;
            super.setVisibility(this.a);
        }
    }

    public final void c(View view) {
        this.c = true;
    }
}
