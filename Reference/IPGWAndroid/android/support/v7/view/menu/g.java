package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.a.r;
import android.support.v7.b.i;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

public final class g implements x, OnItemClickListener {
    Context a;
    public LayoutInflater b;
    i c;
    public ExpandedMenuView d;
    int e;
    int f;
    public y g;
    public h h;
    private int i;

    private g(int i) {
        this.f = i;
        this.e = 0;
    }

    public g(Context context, int i) {
        this(i);
        this.a = context;
        this.b = LayoutInflater.from(this.a);
    }

    public final void a(Context context, i iVar) {
        if (this.e != 0) {
            this.a = new ContextThemeWrapper(context, this.e);
            this.b = LayoutInflater.from(this.a);
        } else if (this.a != null) {
            this.a = context;
            if (this.b == null) {
                this.b = LayoutInflater.from(this.a);
            }
        }
        this.c = iVar;
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    public final void a(i iVar, boolean z) {
        if (this.g != null) {
            this.g.a(iVar, z);
        }
    }

    public final boolean a() {
        return false;
    }

    public final boolean a(ad adVar) {
        if (!adVar.hasVisibleItems()) {
            return false;
        }
        l lVar = new l(adVar);
        i iVar = lVar.a;
        r rVar = new r(iVar.a);
        lVar.c = new g(rVar.a.a, i.abc_list_menu_item_layout);
        lVar.c.g = lVar;
        lVar.a.a(lVar.c);
        rVar.a.t = lVar.c.b();
        rVar.a.u = lVar;
        View view = iVar.h;
        if (view != null) {
            rVar.a.g = view;
        } else {
            rVar.a.d = iVar.g;
            rVar.a(iVar.f);
        }
        rVar.a.r = lVar;
        lVar.b = rVar.a();
        lVar.b.setOnDismissListener(lVar);
        LayoutParams attributes = lVar.b.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        lVar.b.show();
        if (this.g != null) {
            this.g.a(adVar);
        }
        return true;
    }

    public final ListAdapter b() {
        if (this.h == null) {
            this.h = new h(this);
        }
        return this.h;
    }

    public final void b(boolean z) {
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    public final boolean b(m mVar) {
        return false;
    }

    public final boolean c(m mVar) {
        return false;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.c.a(this.h.a(i), (x) this, 0);
    }
}
