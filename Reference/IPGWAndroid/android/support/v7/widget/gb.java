package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.bq;
import android.support.v4.view.dk;
import android.support.v7.b.b;
import android.support.v7.b.f;
import android.support.v7.b.g;
import android.support.v7.b.j;
import android.support.v7.b.l;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.x;
import android.support.v7.view.menu.y;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public final class gb implements bu {
    Toolbar a;
    CharSequence b;
    Callback c;
    boolean d;
    private int e;
    private View f;
    private View g;
    private Drawable h;
    private Drawable i;
    private Drawable j;
    private boolean k;
    private CharSequence l;
    private CharSequence m;
    private k n;
    private int o;
    private final ao p;
    private int q;
    private Drawable r;

    public gb(Toolbar toolbar) {
        this(toolbar, j.abc_action_bar_up_description, f.abc_ic_ab_back_mtrl_am_alpha);
    }

    private gb(Toolbar toolbar, int i, int i2) {
        Context context;
        this.o = 0;
        this.q = 0;
        this.a = toolbar;
        this.b = toolbar.getTitle();
        this.l = toolbar.getSubtitle();
        this.k = this.b != null;
        this.j = toolbar.getNavigationIcon();
        ft a = ft.a(toolbar.getContext(), null, l.ActionBar, b.actionBarStyle);
        CharSequence c = a.c(l.ActionBar_title);
        if (!TextUtils.isEmpty(c)) {
            b(c);
        }
        c = a.c(l.ActionBar_subtitle);
        if (!TextUtils.isEmpty(c)) {
            this.l = c;
            if ((this.e & 8) != 0) {
                this.a.setSubtitle(c);
            }
        }
        Drawable a2 = a.a(l.ActionBar_logo);
        if (a2 != null) {
            c(a2);
        }
        a2 = a.a(l.ActionBar_icon);
        if (this.j == null && a2 != null) {
            a(a2);
        }
        a2 = a.a(l.ActionBar_homeAsUpIndicator);
        if (a2 != null) {
            this.j = a2;
            v();
        }
        c(a.a(l.ActionBar_displayOptions, 0));
        int e = a.e(l.ActionBar_customNavigationLayout, 0);
        if (e != 0) {
            a(LayoutInflater.from(this.a.getContext()).inflate(e, this.a, false));
            c(this.e | 16);
        }
        e = a.d(l.ActionBar_height, 0);
        if (e > 0) {
            LayoutParams layoutParams = this.a.getLayoutParams();
            layoutParams.height = e;
            this.a.setLayoutParams(layoutParams);
        }
        e = a.b(l.ActionBar_contentInsetStart, -1);
        int b = a.b(l.ActionBar_contentInsetEnd, -1);
        if (e >= 0 || b >= 0) {
            this.a.i.a(Math.max(e, 0), Math.max(b, 0));
        }
        e = a.e(l.ActionBar_titleTextStyle, 0);
        if (e != 0) {
            Toolbar toolbar2;
            toolbar2 = this.a;
            context = this.a.getContext();
            toolbar2.g = e;
            if (toolbar2.b != null) {
                toolbar2.b.setTextAppearance(context, e);
            }
        }
        e = a.e(l.ActionBar_subtitleTextStyle, 0);
        if (e != 0) {
            toolbar2 = this.a;
            context = this.a.getContext();
            toolbar2.h = e;
            if (toolbar2.c != null) {
                toolbar2.c.setTextAppearance(context, e);
            }
        }
        e = a.e(l.ActionBar_popupTheme, 0);
        if (e != 0) {
            this.a.setPopupTheme(e);
        }
        a.a.recycle();
        this.p = ao.a();
        if (i != this.q) {
            this.q = i;
            if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
                int i3 = this.q;
                this.m = i3 == 0 ? null : this.a.getContext().getString(i3);
                u();
            }
        }
        this.m = this.a.getNavigationContentDescription();
        Drawable a3 = this.p.a(this.a.getContext(), i2, false);
        if (this.r != a3) {
            this.r = a3;
            v();
        }
        this.a.setNavigationOnClickListener(new gc(this));
    }

    private void c(Drawable drawable) {
        this.i = drawable;
        t();
    }

    private void c(CharSequence charSequence) {
        this.b = charSequence;
        if ((this.e & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    private void t() {
        Drawable drawable = null;
        if ((this.e & 2) != 0) {
            drawable = (this.e & 1) != 0 ? this.i != null ? this.i : this.h : this.h;
        }
        this.a.setLogo(drawable);
    }

    private void u() {
        if ((this.e & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.m)) {
            this.a.setNavigationContentDescription(this.q);
        } else {
            this.a.setNavigationContentDescription(this.m);
        }
    }

    private void v() {
        if ((this.e & 4) != 0) {
            this.a.setNavigationIcon(this.j != null ? this.j : this.r);
        }
    }

    public final dk a(int i, long j) {
        return bq.r(this.a).a(i == 0 ? 1.0f : 0.0f).a(j).a(new gd(this, i));
    }

    public final ViewGroup a() {
        return this.a;
    }

    public final void a(int i) {
        a(i != 0 ? this.p.a(this.a.getContext(), i, false) : null);
    }

    public final void a(Drawable drawable) {
        this.h = drawable;
        t();
    }

    public final void a(y yVar, android.support.v7.view.menu.j jVar) {
        Toolbar toolbar = this.a;
        toolbar.m = yVar;
        toolbar.n = jVar;
        if (toolbar.a != null) {
            toolbar.a.a(yVar, jVar);
        }
    }

    public final void a(ev evVar) {
        if (this.f != null && this.f.getParent() == this.a) {
            this.a.removeView(this.f);
        }
        this.f = evVar;
        if (evVar != null && this.o == 2) {
            this.a.addView(this.f, 0);
            fy fyVar = (fy) this.f.getLayoutParams();
            fyVar.width = -2;
            fyVar.height = -2;
            fyVar.a = 8388691;
            evVar.setAllowCollapse(true);
        }
    }

    public final void a(Menu menu, y yVar) {
        if (this.n == null) {
            this.n = new k(this.a.getContext());
            this.n.h = g.action_menu_presenter;
        }
        this.n.f = yVar;
        Toolbar toolbar = this.a;
        i iVar = (i) menu;
        x xVar = this.n;
        if (iVar != null || toolbar.a != null) {
            toolbar.d();
            i iVar2 = toolbar.a.a;
            if (iVar2 != iVar) {
                if (iVar2 != null) {
                    iVar2.b(toolbar.k);
                    iVar2.b(toolbar.l);
                }
                if (toolbar.l == null) {
                    toolbar.l = new fx(toolbar);
                }
                xVar.n = true;
                if (iVar != null) {
                    iVar.a(xVar, toolbar.e);
                    iVar.a(toolbar.l, toolbar.e);
                } else {
                    xVar.a(toolbar.e, null);
                    toolbar.l.a(toolbar.e, null);
                    xVar.b(true);
                    toolbar.l.b(true);
                }
                toolbar.a.setPopupTheme(toolbar.f);
                toolbar.a.setPresenter(xVar);
                toolbar.k = xVar;
            }
        }
    }

    public final void a(View view) {
        if (!(this.g == null || (this.e & 16) == 0)) {
            this.a.removeView(this.g);
        }
        this.g = view;
        if (view != null && (this.e & 16) != 0) {
            this.a.addView(this.g);
        }
    }

    public final void a(Callback callback) {
        this.c = callback;
    }

    public final void a(CharSequence charSequence) {
        if (!this.k) {
            c(charSequence);
        }
    }

    public final void a(boolean z) {
        this.a.setCollapsible(z);
    }

    public final Context b() {
        return this.a.getContext();
    }

    public final void b(int i) {
        c(i != 0 ? this.p.a(this.a.getContext(), i, false) : null);
    }

    public final void b(Drawable drawable) {
        this.a.setBackgroundDrawable(drawable);
    }

    public final void b(CharSequence charSequence) {
        this.k = true;
        c(charSequence);
    }

    public final void c(int i) {
        int i2 = this.e ^ i;
        this.e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    v();
                    u();
                } else {
                    this.a.setNavigationIcon(null);
                }
            }
            if ((i2 & 3) != 0) {
                t();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.a.setTitle(this.b);
                    this.a.setSubtitle(this.l);
                } else {
                    this.a.setTitle(null);
                    this.a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.g != null) {
                if ((i & 16) != 0) {
                    this.a.addView(this.g);
                } else {
                    this.a.removeView(this.g);
                }
            }
        }
    }

    public final boolean c() {
        Toolbar toolbar = this.a;
        return (toolbar.l == null || toolbar.l.b == null) ? false : true;
    }

    public final void d() {
        this.a.c();
    }

    public final CharSequence e() {
        return this.a.getTitle();
    }

    public final void f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public final void g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public final boolean h() {
        Toolbar toolbar = this.a;
        return toolbar.getVisibility() == 0 && toolbar.a != null && toolbar.a.b;
    }

    public final boolean i() {
        return this.a.a();
    }

    public final boolean j() {
        Toolbar toolbar = this.a;
        if (toolbar.a != null) {
            boolean z;
            ActionMenuView actionMenuView = toolbar.a;
            if (actionMenuView.c != null) {
                k kVar = actionMenuView.c;
                z = kVar.q != null || kVar.g();
                if (z) {
                    z = true;
                    if (z) {
                        return true;
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean k() {
        return this.a.b();
    }

    public final boolean l() {
        Toolbar toolbar = this.a;
        if (toolbar.a != null) {
            ActionMenuView actionMenuView = toolbar.a;
            boolean z = actionMenuView.c != null && actionMenuView.c.d();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void m() {
        this.d = true;
    }

    public final void n() {
        Toolbar toolbar = this.a;
        if (toolbar.a != null) {
            toolbar.a.b();
        }
    }

    public final int o() {
        return this.e;
    }

    public final int p() {
        return this.o;
    }

    public final View q() {
        return this.g;
    }

    public final int r() {
        return this.a.getVisibility();
    }

    public final Menu s() {
        return this.a.getMenu();
    }
}
