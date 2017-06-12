package android.support.v7.widget;

import android.view.View;
import android.view.View.MeasureSpec;

final class dm extends dk {
    dm(eb ebVar) {
        super(ebVar);
    }

    public final int a(View view) {
        return eb.f(view) - ((ed) view.getLayoutParams()).topMargin;
    }

    public final void a(int i) {
        this.a.f(i);
    }

    public final int b() {
        return this.a.n();
    }

    public final int b(View view) {
        ed edVar = (ed) view.getLayoutParams();
        return edVar.bottomMargin + eb.h(view);
    }

    public final int c() {
        return MeasureSpec.getSize(this.a.x) - this.a.p();
    }

    public final int c(View view) {
        ed edVar = (ed) view.getLayoutParams();
        return edVar.bottomMargin + (eb.d(view) + edVar.topMargin);
    }

    public final int d() {
        return MeasureSpec.getSize(this.a.x);
    }

    public final int d(View view) {
        ed edVar = (ed) view.getLayoutParams();
        return edVar.rightMargin + (eb.c(view) + edVar.leftMargin);
    }

    public final int e() {
        return (MeasureSpec.getSize(this.a.x) - this.a.n()) - this.a.p();
    }

    public final int f() {
        return this.a.p();
    }

    public final int g() {
        return MeasureSpec.getMode(this.a.x);
    }

    public final int h() {
        return MeasureSpec.getMode(this.a.w);
    }
}
