package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.b.b;
import android.support.v7.b.e;
import android.support.v7.b.i;
import android.support.v7.widget.cu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

public class v implements x, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int a = i.abc_popup_menu_item_layout;
    public View b;
    public cu c;
    public y d;
    public boolean e;
    public int f;
    private final Context g;
    private final LayoutInflater h;
    private final i i;
    private final w j;
    private final boolean k;
    private final int l;
    private final int m;
    private final int n;
    private ViewTreeObserver o;
    private ViewGroup p;
    private boolean q;
    private int r;

    private v(Context context, i iVar, View view) {
        this(context, iVar, view, false, b.popupMenuStyle);
    }

    public v(Context context, i iVar, View view, boolean z, int i) {
        this(context, iVar, view, z, i, (byte) 0);
    }

    private v(Context context, i iVar, View view, boolean z, int i, byte b) {
        this.f = 0;
        this.g = context;
        this.h = LayoutInflater.from(context);
        this.i = iVar;
        this.j = new w(this, this.i);
        this.k = z;
        this.m = i;
        this.n = 0;
        Resources resources = context.getResources();
        this.l = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(e.abc_config_prefDialogWidth));
        this.b = view;
        iVar.a((x) this, context);
    }

    public final void a(Context context, i iVar) {
    }

    public final void a(i iVar, boolean z) {
        if (iVar == this.i) {
            c();
            if (this.d != null) {
                this.d.a(iVar, z);
            }
        }
    }

    public final boolean a() {
        return false;
    }

    public final boolean a(ad adVar) {
        if (adVar.hasVisibleItems()) {
            boolean z;
            v vVar = new v(this.g, adVar, this.b);
            vVar.d = this.d;
            int size = adVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = adVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            vVar.e = z;
            if (vVar.b()) {
                if (this.d == null) {
                    return true;
                }
                this.d.a(adVar);
                return true;
            }
        }
        return false;
    }

    public final void b(boolean z) {
        this.q = false;
        if (this.j != null) {
            this.j.notifyDataSetChanged();
        }
    }

    public final boolean b() {
        int i = 0;
        this.c = new cu(this.g, null, this.m, this.n);
        this.c.a((OnDismissListener) this);
        this.c.m = this;
        this.c.a(this.j);
        this.c.c();
        View view = this.b;
        if (view == null) {
            return false;
        }
        boolean z = this.o == null;
        this.o = view.getViewTreeObserver();
        if (z) {
            this.o.addOnGlobalLayoutListener(this);
        }
        this.c.l = view;
        this.c.i = this.f;
        if (!this.q) {
            ListAdapter listAdapter = this.j;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = listAdapter.getCount();
            int i2 = 0;
            int i3 = 0;
            View view2 = null;
            while (i2 < count) {
                View view3;
                int itemViewType = listAdapter.getItemViewType(i2);
                if (itemViewType != i3) {
                    i3 = itemViewType;
                    view3 = null;
                } else {
                    view3 = view2;
                }
                if (this.p == null) {
                    this.p = new FrameLayout(this.g);
                }
                view2 = listAdapter.getView(i2, view3, this.p);
                view2.measure(makeMeasureSpec, makeMeasureSpec2);
                itemViewType = view2.getMeasuredWidth();
                if (itemViewType >= this.l) {
                    i = this.l;
                    break;
                }
                if (itemViewType <= i) {
                    itemViewType = i;
                }
                i2++;
                i = itemViewType;
            }
            this.r = i;
            this.q = true;
        }
        this.c.a(this.r);
        this.c.e();
        this.c.b();
        this.c.d.setOnKeyListener(this);
        return true;
    }

    public final boolean b(m mVar) {
        return false;
    }

    public final void c() {
        if (d()) {
            this.c.d();
        }
    }

    public final boolean c(m mVar) {
        return false;
    }

    public final boolean d() {
        return this.c != null && this.c.c.isShowing();
    }

    public void onDismiss() {
        this.c = null;
        this.i.close();
        if (this.o != null) {
            if (!this.o.isAlive()) {
                this.o = this.b.getViewTreeObserver();
            }
            this.o.removeGlobalOnLayoutListener(this);
            this.o = null;
        }
    }

    public void onGlobalLayout() {
        if (d()) {
            View view = this.b;
            if (view == null || !view.isShown()) {
                c();
            } else if (d()) {
                this.c.b();
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        w wVar = this.j;
        wVar.b.a(wVar.a(i), null, 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        c();
        return true;
    }
}
