package android.support.v7.widget;

import android.content.Context;
import android.support.v7.view.d;
import android.support.v7.view.menu.ad;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.x;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

final class fx implements x {
    i a;
    m b;
    final /* synthetic */ Toolbar c;

    private fx(Toolbar toolbar) {
        this.c = toolbar;
    }

    public final void a(Context context, i iVar) {
        if (!(this.a == null || this.b == null)) {
            this.a.b(this.b);
        }
        this.a = iVar;
    }

    public final void a(i iVar, boolean z) {
    }

    public final boolean a() {
        return false;
    }

    public final boolean a(ad adVar) {
        return false;
    }

    public final void b(boolean z) {
        Object obj = null;
        if (this.b != null) {
            if (this.a != null) {
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    if (this.a.getItem(i) == this.b) {
                        obj = 1;
                        break;
                    }
                }
            }
            if (obj == null) {
                c(this.b);
            }
        }
    }

    public final boolean b(m mVar) {
        Toolbar.b(this.c);
        if (this.c.s.getParent() != this.c) {
            this.c.addView(this.c.s);
        }
        this.c.d = mVar.getActionView();
        this.b = mVar;
        if (this.c.d.getParent() != this.c) {
            LayoutParams e = Toolbar.e();
            e.a = 8388611 | (this.c.t & 112);
            e.b = 2;
            this.c.d.setLayoutParams(e);
            this.c.addView(this.c.d);
        }
        Toolbar toolbar = this.c;
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (!(((fy) childAt.getLayoutParams()).b == 2 || childAt == toolbar.a)) {
                toolbar.removeViewAt(childCount);
                toolbar.j.add(childAt);
            }
        }
        this.c.requestLayout();
        mVar.d(true);
        if (this.c.d instanceof d) {
            ((d) this.c.d).a();
        }
        return true;
    }

    public final boolean c(m mVar) {
        if (this.c.d instanceof d) {
            ((d) this.c.d).b();
        }
        this.c.removeView(this.c.d);
        this.c.removeView(this.c.s);
        this.c.d = null;
        Toolbar toolbar = this.c;
        for (int size = toolbar.j.size() - 1; size >= 0; size--) {
            toolbar.addView((View) toolbar.j.get(size));
        }
        toolbar.j.clear();
        this.b = null;
        this.c.requestLayout();
        mVar.d(false);
        return true;
    }
}
