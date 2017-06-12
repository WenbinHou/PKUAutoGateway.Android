package android.support.v7.widget;

import android.view.View;
import java.util.List;

final class cs {
    boolean a = true;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h = 0;
    boolean i = false;
    int j;
    List<eq> k = null;
    boolean l;

    cs() {
    }

    final View a(eh ehVar) {
        if (this.k != null) {
            int size = this.k.size();
            int i = 0;
            while (i < size) {
                View view = ((eq) this.k.get(i)).a;
                ed edVar = (ed) view.getLayoutParams();
                if (edVar.c.m() || this.d != edVar.c.c()) {
                    i++;
                } else {
                    a(view);
                    return view;
                }
            }
            return null;
        }
        View b = ehVar.b(this.d);
        this.d += this.e;
        return b;
    }

    public final void a(View view) {
        View view2;
        int size = this.k.size();
        View view3 = null;
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        while (i2 < size) {
            int c;
            View view4;
            view2 = ((eq) this.k.get(i2)).a;
            ed edVar = (ed) view2.getLayoutParams();
            if (!(view2 == view || edVar.c.m())) {
                c = (edVar.c.c() - this.d) * this.e;
                if (c >= 0 && c < i) {
                    if (c == 0) {
                        break;
                    }
                    view4 = view2;
                    i2++;
                    view3 = view4;
                    i = c;
                }
            }
            c = i;
            view4 = view3;
            i2++;
            view3 = view4;
            i = c;
        }
        view2 = view3;
        if (view2 == null) {
            this.d = -1;
        } else {
            this.d = ((ed) view2.getLayoutParams()).c.c();
        }
    }

    final boolean a(en enVar) {
        return this.d >= 0 && this.d < enVar.a();
    }
}
