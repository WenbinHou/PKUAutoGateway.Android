package android.support.v7.widget;

import android.view.View;

final class cq {
    int a;
    int b;
    boolean c;
    final /* synthetic */ LinearLayoutManager d;

    cq(LinearLayoutManager linearLayoutManager) {
        this.d = linearLayoutManager;
    }

    final void a() {
        this.b = this.c ? this.d.j.c() : this.d.j.b();
    }

    public final void a(View view) {
        if (this.c) {
            this.b = this.d.j.b(view) + this.d.j.a();
        } else {
            this.b = this.d.j.a(view);
        }
        this.a = eb.a(view);
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.a + ", mCoordinate=" + this.b + ", mLayoutFromEnd=" + this.c + '}';
    }
}
