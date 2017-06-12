package android.support.v7.widget;

import android.view.View;
import android.view.View.MeasureSpec;

final class dl extends dk {
    dl(eb ebVar) {
        super(ebVar);
    }

    public final int a(View view) {
        return eb.e(view) - ((ed) view.getLayoutParams()).leftMargin;
    }

    public final void a(int i) {
        this.a.e(i);
    }

    public final int b() {
        return this.a.m();
    }

    public final int b(View view) {
        ed edVar = (ed) view.getLayoutParams();
        return edVar.rightMargin + eb.g(view);
    }

    public final int c() {
        return MeasureSpec.getSize(this.a.w) - this.a.o();
    }

    public final int c(View view) {
        ed edVar = (ed) view.getLayoutParams();
        return edVar.rightMargin + (eb.c(view) + edVar.leftMargin);
    }

    public final int d() {
        return MeasureSpec.getSize(this.a.w);
    }

    public final int d(View view) {
        ed edVar = (ed) view.getLayoutParams();
        return edVar.bottomMargin + (eb.d(view) + edVar.topMargin);
    }

    public final int e() {
        return (MeasureSpec.getSize(this.a.w) - this.a.m()) - this.a.o();
    }

    public final int f() {
        return this.a.o();
    }

    public final int g() {
        return MeasureSpec.getMode(this.a.w);
    }

    public final int h() {
        return MeasureSpec.getMode(this.a.x);
    }
}
