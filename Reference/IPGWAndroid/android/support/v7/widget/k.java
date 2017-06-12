package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.cj;
import android.support.v4.view.n;
import android.support.v4.view.o;
import android.support.v7.b.h;
import android.support.v7.b.i;
import android.support.v7.view.a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.aa;
import android.support.v7.view.menu.ad;
import android.support.v7.view.menu.d;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.v;
import android.support.v7.view.menu.z;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

final class k extends d implements o {
    private final SparseBooleanArray A = new SparseBooleanArray();
    private View B;
    private m C;
    o i;
    Drawable j;
    boolean k;
    int l;
    boolean m;
    boolean n;
    q o;
    l p;
    n q;
    final r r = new r();
    int s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private int z;

    public k(Context context) {
        super(context, i.abc_action_menu_layout, i.abc_action_menu_item_layout);
    }

    public final z a(ViewGroup viewGroup) {
        z a = super.a(viewGroup);
        ((ActionMenuView) a).setPresenter(this);
        return a;
    }

    public final View a(m mVar, View view, ViewGroup viewGroup) {
        View actionView = mVar.getActionView();
        if (actionView == null || mVar.i()) {
            actionView = super.a(mVar, view, viewGroup);
        }
        actionView.setVisibility(mVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.a(layoutParams));
        }
        return actionView;
    }

    public final void a(Context context, android.support.v7.view.menu.i iVar) {
        boolean z = true;
        super.a(context, iVar);
        Resources resources = context.getResources();
        a a = a.a(context);
        if (!this.u) {
            if (VERSION.SDK_INT < 19 && cj.b(ViewConfiguration.get(a.a))) {
                z = false;
            }
            this.t = z;
        }
        if (!this.y) {
            this.v = a.a.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.m) {
            this.l = a.a.getResources().getInteger(h.abc_max_action_buttons);
        }
        int i = this.v;
        if (this.t) {
            if (this.i == null) {
                this.i = new o(this, this.a);
                if (this.k) {
                    this.i.setImageDrawable(this.j);
                    this.j = null;
                    this.k = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.i.getMeasuredWidth();
        } else {
            this.i = null;
        }
        this.w = i;
        this.z = (int) (56.0f * resources.getDisplayMetrics().density);
        this.B = null;
    }

    public final void a(android.support.v7.view.menu.i iVar, boolean z) {
        e();
        super.a(iVar, z);
    }

    public final void a(m mVar, aa aaVar) {
        aaVar.a(mVar);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aaVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.g);
        if (this.C == null) {
            this.C = new m();
        }
        actionMenuItemView.setPopupCallback(this.C);
    }

    public final void a(ActionMenuView actionMenuView) {
        this.g = actionMenuView;
        actionMenuView.a = this.c;
    }

    public final void a(boolean z) {
        if (z) {
            super.a(null);
        } else {
            this.c.a(false);
        }
    }

    public final boolean a() {
        int i;
        ArrayList h = this.c.h();
        int size = h.size();
        int i2 = this.l;
        int i3 = this.w;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.g;
        int i4 = 0;
        int i5 = 0;
        Object obj = null;
        int i6 = 0;
        while (i6 < size) {
            m mVar = (m) h.get(i6);
            if (mVar.h()) {
                i4++;
            } else if (mVar.g()) {
                i5++;
            } else {
                obj = 1;
            }
            i = (this.n && mVar.isActionViewExpanded()) ? 0 : i2;
            i6++;
            i2 = i;
        }
        if (this.t && (r4 != null || i4 + i5 > i2)) {
            i2--;
        }
        i6 = i2 - i4;
        SparseBooleanArray sparseBooleanArray = this.A;
        sparseBooleanArray.clear();
        if (this.x) {
            int i7 = i3 / this.z;
            i5 = ((i3 % this.z) / i7) + this.z;
            i = i7;
        } else {
            i5 = 0;
            i = 0;
        }
        i2 = 0;
        int i8 = 0;
        i4 = i;
        while (i8 < size) {
            m mVar2 = (m) h.get(i8);
            View a;
            int i9;
            if (mVar2.h()) {
                a = a(mVar2, this.B, viewGroup);
                if (this.B == null) {
                    this.B = a;
                }
                if (this.x) {
                    i = i4 - ActionMenuView.a(a, i5, i4, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                    i = i4;
                }
                i4 = a.getMeasuredWidth();
                i9 = i3 - i4;
                if (i2 != 0) {
                    i4 = i2;
                }
                i2 = mVar2.getGroupId();
                if (i2 != 0) {
                    sparseBooleanArray.put(i2, true);
                }
                mVar2.c(true);
                i7 = i9;
                i2 = i6;
            } else if (mVar2.g()) {
                boolean z;
                int groupId = mVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i6 > 0 || z2) && i3 > 0 && (!this.x || i4 > 0);
                if (z3) {
                    a = a(mVar2, this.B, viewGroup);
                    if (this.B == null) {
                        this.B = a;
                    }
                    if (this.x) {
                        int a2 = ActionMenuView.a(a, i5, i4, makeMeasureSpec, 0);
                        i4 -= a2;
                        if (a2 == 0) {
                            i = 0;
                        }
                    } else {
                        a.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    i9 = a.getMeasuredWidth();
                    i3 -= i9;
                    if (i2 == 0) {
                        i2 = i9;
                    }
                    if (this.x) {
                        z = i & (i3 >= 0 ? 1 : 0);
                        i9 = i4;
                    } else {
                        z = i & (i3 + i2 > 0 ? 1 : 0);
                        i9 = i4;
                    }
                } else {
                    z = z3;
                    i9 = i4;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i = i6;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i4 = i6;
                    for (i6 = 0; i6 < i8; i6++) {
                        mVar = (m) h.get(i6);
                        if (mVar.getGroupId() == groupId) {
                            if (mVar.f()) {
                                i4++;
                            }
                            mVar.c(false);
                        }
                    }
                    i = i4;
                } else {
                    i = i6;
                }
                if (z) {
                    i--;
                }
                mVar2.c(z);
                i4 = i2;
                i7 = i3;
                i2 = i;
                i = i9;
            } else {
                mVar2.c(false);
                i = i4;
                i7 = i3;
                i4 = i2;
                i2 = i6;
            }
            i8++;
            i3 = i7;
            i6 = i2;
            i2 = i4;
            i4 = i;
        }
        return true;
    }

    public final boolean a(ad adVar) {
        if (!adVar.hasVisibleItems()) {
            return false;
        }
        View view;
        ad adVar2 = adVar;
        while (adVar2.l != this.c) {
            adVar2 = (ad) adVar2.l;
        }
        m item = adVar2.getItem();
        ViewGroup viewGroup = (ViewGroup) this.g;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof aa) && ((aa) childAt).getItemData() == item) {
                    view = childAt;
                    break;
                }
            }
        }
        view = null;
        if (view == null) {
            if (this.i == null) {
                return false;
            }
            view = this.i;
        }
        this.s = adVar.getItem().getItemId();
        this.p = new l(this, this.b, adVar);
        this.p.b = view;
        if (this.p.b()) {
            super.a(adVar);
            return true;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public final boolean a(m mVar) {
        return mVar.f();
    }

    public final boolean a(ViewGroup viewGroup, int i) {
        return viewGroup.getChildAt(i) == this.i ? false : super.a(viewGroup, i);
    }

    public final void b() {
        this.t = true;
        this.u = true;
    }

    public final void b(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ((View) this.g).getParent();
        super.b(z);
        ((View) this.g).requestLayout();
        if (this.c != null) {
            android.support.v7.view.menu.i iVar = this.c;
            iVar.i();
            ArrayList arrayList = iVar.d;
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                n nVar = ((m) arrayList.get(i)).d;
                if (nVar != null) {
                    nVar.a = this;
                }
            }
        }
        ArrayList j = this.c != null ? this.c.j() : null;
        if (this.t && j != null) {
            i = j.size();
            if (i == 1) {
                i3 = !((m) j.get(0)).isActionViewExpanded() ? 1 : 0;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.i == null) {
                this.i = new o(this, this.a);
            }
            ViewGroup viewGroup = (ViewGroup) this.i.getParent();
            if (viewGroup != this.g) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.i);
                }
                ((ActionMenuView) this.g).addView(this.i, ActionMenuView.a());
            }
        } else if (this.i != null && this.i.getParent() == this.g) {
            ((ViewGroup) this.g).removeView(this.i);
        }
        ((ActionMenuView) this.g).setOverflowReserved(this.t);
    }

    public final boolean c() {
        if (!this.t || g() || this.c == null || this.g == null || this.q != null || this.c.j().isEmpty()) {
            return false;
        }
        this.q = new n(this, new q(this, this.b, this.c, this.i));
        ((View) this.g).post(this.q);
        super.a(null);
        return true;
    }

    public final boolean d() {
        if (this.q == null || this.g == null) {
            v vVar = this.o;
            if (vVar == null) {
                return false;
            }
            vVar.c();
            return true;
        }
        ((View) this.g).removeCallbacks(this.q);
        this.q = null;
        return true;
    }

    public final boolean e() {
        return d() | f();
    }

    public final boolean f() {
        if (this.p == null) {
            return false;
        }
        this.p.c();
        return true;
    }

    public final boolean g() {
        return this.o != null && this.o.d();
    }
}
