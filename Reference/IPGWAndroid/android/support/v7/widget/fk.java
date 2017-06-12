package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

final class fk {
    ArrayList<View> a;
    int b;
    int c;
    int d;
    final int e;
    final /* synthetic */ StaggeredGridLayoutManager f;

    private fk(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.f = staggeredGridLayoutManager;
        this.a = new ArrayList();
        this.b = Integer.MIN_VALUE;
        this.c = Integer.MIN_VALUE;
        this.d = 0;
        this.e = i;
    }

    private void f() {
        View view = (View) this.a.get(0);
        fh fhVar = (fh) view.getLayoutParams();
        this.b = this.f.a.a(view);
        if (fhVar.b) {
            FullSpanItem d = this.f.f.d(fhVar.c.c());
            if (d != null && d.b == -1) {
                this.b -= d.a(this.e);
            }
        }
    }

    private void g() {
        View view = (View) this.a.get(this.a.size() - 1);
        fh fhVar = (fh) view.getLayoutParams();
        this.c = this.f.a.b(view);
        if (fhVar.b) {
            FullSpanItem d = this.f.f.d(fhVar.c.c());
            if (d != null && d.b == 1) {
                this.c = d.a(this.e) + this.c;
            }
        }
    }

    final int a() {
        if (this.b != Integer.MIN_VALUE) {
            return this.b;
        }
        f();
        return this.b;
    }

    final int a(int i) {
        if (this.b != Integer.MIN_VALUE) {
            return this.b;
        }
        if (this.a.size() == 0) {
            return i;
        }
        f();
        return this.b;
    }

    public final View a(int i, int i2) {
        View view = null;
        int size;
        View view2;
        if (i2 == -1) {
            size = this.a.size();
            int i3 = 0;
            while (i3 < size) {
                view2 = (View) this.a.get(i3);
                if (!view2.isFocusable()) {
                    break;
                }
                if ((eb.a(view2) > i) != this.f.l) {
                    break;
                }
                i3++;
                view = view2;
            }
            return view;
        }
        for (size = this.a.size() - 1; size >= 0; size--) {
            view2 = (View) this.a.get(size);
            if (!view2.isFocusable()) {
                break;
            }
            if ((eb.a(view2) > i ? 1 : null) != (!this.f.l ? 1 : null)) {
                break;
            }
            view = view2;
        }
        return view;
    }

    final void a(View view) {
        fh fhVar = (fh) view.getLayoutParams();
        fhVar.a = this;
        this.a.add(0, view);
        this.b = Integer.MIN_VALUE;
        if (this.a.size() == 1) {
            this.c = Integer.MIN_VALUE;
        }
        if (fhVar.c.m() || fhVar.c.s()) {
            this.d += this.f.a.c(view);
        }
    }

    final int b() {
        if (this.c != Integer.MIN_VALUE) {
            return this.c;
        }
        g();
        return this.c;
    }

    final int b(int i) {
        if (this.c != Integer.MIN_VALUE) {
            return this.c;
        }
        if (this.a.size() == 0) {
            return i;
        }
        g();
        return this.c;
    }

    final void b(View view) {
        fh fhVar = (fh) view.getLayoutParams();
        fhVar.a = this;
        this.a.add(view);
        this.c = Integer.MIN_VALUE;
        if (this.a.size() == 1) {
            this.b = Integer.MIN_VALUE;
        }
        if (fhVar.c.m() || fhVar.c.s()) {
            this.d += this.f.a.c(view);
        }
    }

    final void c() {
        this.a.clear();
        this.b = Integer.MIN_VALUE;
        this.c = Integer.MIN_VALUE;
        this.d = 0;
    }

    final void c(int i) {
        this.b = i;
        this.c = i;
    }

    final void d() {
        int size = this.a.size();
        View view = (View) this.a.remove(size - 1);
        fh fhVar = (fh) view.getLayoutParams();
        fhVar.a = null;
        if (fhVar.c.m() || fhVar.c.s()) {
            this.d -= this.f.a.c(view);
        }
        if (size == 1) {
            this.b = Integer.MIN_VALUE;
        }
        this.c = Integer.MIN_VALUE;
    }

    final void d(int i) {
        if (this.b != Integer.MIN_VALUE) {
            this.b += i;
        }
        if (this.c != Integer.MIN_VALUE) {
            this.c += i;
        }
    }

    final void e() {
        View view = (View) this.a.remove(0);
        fh fhVar = (fh) view.getLayoutParams();
        fhVar.a = null;
        if (this.a.size() == 0) {
            this.c = Integer.MIN_VALUE;
        }
        if (fhVar.c.m() || fhVar.c.s()) {
            this.d -= this.f.a.c(view);
        }
        this.b = Integer.MIN_VALUE;
    }
}
