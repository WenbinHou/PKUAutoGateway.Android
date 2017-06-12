package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.bq;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class d implements x {
    public Context a;
    public Context b;
    public i c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    public y f;
    public z g;
    public int h;
    private int i;
    private int j;

    public d(Context context, int i, int i2) {
        this.a = context;
        this.d = LayoutInflater.from(context);
        this.i = i;
        this.j = i2;
    }

    public z a(ViewGroup viewGroup) {
        if (this.g == null) {
            this.g = (z) this.d.inflate(this.i, viewGroup, false);
            this.g.a(this.c);
            b(true);
        }
        return this.g;
    }

    public View a(m mVar, View view, ViewGroup viewGroup) {
        aa aaVar = view instanceof aa ? (aa) view : (aa) this.d.inflate(this.j, viewGroup, false);
        a(mVar, aaVar);
        return (View) aaVar;
    }

    public void a(Context context, i iVar) {
        this.b = context;
        this.e = LayoutInflater.from(this.b);
        this.c = iVar;
    }

    public void a(i iVar, boolean z) {
        if (this.f != null) {
            this.f.a(iVar, z);
        }
    }

    public abstract void a(m mVar, aa aaVar);

    public boolean a() {
        return false;
    }

    public boolean a(ad adVar) {
        return this.f != null ? this.f.a(adVar) : false;
    }

    public boolean a(m mVar) {
        return true;
    }

    public boolean a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public void b(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.g;
        if (viewGroup != null) {
            int i;
            if (this.c != null) {
                this.c.i();
                ArrayList h = this.c.h();
                int size = h.size();
                int i2 = 0;
                i = 0;
                while (i2 < size) {
                    int i3;
                    m mVar = (m) h.get(i2);
                    if (a(mVar)) {
                        View childAt = viewGroup.getChildAt(i);
                        m itemData = childAt instanceof aa ? ((aa) childAt).getItemData() : null;
                        View a = a(mVar, childAt, viewGroup);
                        if (mVar != itemData) {
                            a.setPressed(false);
                            bq.x(a);
                        }
                        if (a != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a);
                            }
                            ((ViewGroup) this.g).addView(a, i);
                        }
                        i3 = i + 1;
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    public final boolean b(m mVar) {
        return false;
    }

    public final boolean c(m mVar) {
        return false;
    }
}
