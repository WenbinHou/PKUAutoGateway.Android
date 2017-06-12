package android.support.v7.widget;

import android.support.v4.view.bq;

final class ej extends dv {
    final /* synthetic */ RecyclerView a;

    private ej(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public final void a() {
        this.a.a(null);
        this.a.y;
        this.a.o.f = true;
        RecyclerView.n(this.a);
        if (!this.a.b.d()) {
            this.a.requestLayout();
        }
    }

    public final void a(int i) {
        int i2 = 1;
        this.a.a(null);
        af afVar = this.a.b;
        afVar.a.add(afVar.a(2, i, 1, null));
        afVar.g |= 2;
        if (afVar.a.size() != 1) {
            i2 = 0;
        }
        if (i2 == 0) {
            return;
        }
        if (this.a.K && this.a.E && this.a.D) {
            bq.a(this.a, this.a.w);
            return;
        }
        this.a.J = true;
        this.a.requestLayout();
    }
}
