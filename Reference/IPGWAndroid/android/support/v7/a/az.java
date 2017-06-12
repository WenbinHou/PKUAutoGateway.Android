package android.support.v7.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.bq;
import android.support.v4.view.dk;
import android.support.v4.view.ea;
import android.support.v4.view.ec;
import android.support.v7.b.g;
import android.support.v7.view.a;
import android.support.v7.view.b;
import android.support.v7.view.c;
import android.support.v7.view.l;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.bu;
import android.support.v7.widget.ev;
import android.support.v7.widget.i;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import ccnet.pku.edu.cn.ipgw_android.R;
import java.util.ArrayList;

public class az extends a implements i {
    static final /* synthetic */ boolean h = (!az.class.desiredAssertionStatus());
    private static final Interpolator i = new AccelerateInterpolator();
    private static final Interpolator j = new DecelerateInterpolator();
    private static final boolean k;
    private boolean A;
    private int B = 0;
    private boolean C = true;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G = true;
    private l H;
    private boolean I;
    bd a;
    b b;
    c c;
    boolean d;
    final ea e = new ba(this);
    final ea f = new bb(this);
    final ec g = new bc(this);
    private Context l;
    private Context m;
    private Activity n;
    private Dialog o;
    private ActionBarOverlayLayout p;
    private ActionBarContainer q;
    private bu r;
    private ActionBarContextView s;
    private View t;
    private ev u;
    private ArrayList<Object> v = new ArrayList();
    private int w = -1;
    private boolean x;
    private boolean y;
    private ArrayList<Object> z = new ArrayList();

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        k = z;
    }

    public az(Activity activity, boolean z) {
        this.n = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (!z) {
            this.t = decorView.findViewById(16908290);
        }
    }

    public az(Dialog dialog) {
        this.o = dialog;
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        bu buVar;
        this.p = (ActionBarOverlayLayout) view.findViewById(g.decor_content_parent);
        if (this.p != null) {
            this.p.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(g.action_bar);
        if (findViewById instanceof bu) {
            buVar = (bu) findViewById;
        } else if (findViewById instanceof Toolbar) {
            buVar = ((Toolbar) findViewById).getWrapper();
        } else {
            throw new IllegalStateException(new StringBuilder("Can't make a decor toolbar out of ").append(findViewById).toString() != null ? findViewById.getClass().getSimpleName() : "null");
        }
        this.r = buVar;
        this.s = (ActionBarContextView) view.findViewById(g.action_context_bar);
        this.q = (ActionBarContainer) view.findViewById(g.action_bar_container);
        if (this.r == null || this.s == null || this.q == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.l = this.r.b();
        if ((this.r.o() & 4) != 0) {
            this.x = true;
        }
        a a = a.a(this.l);
        int i = a.a.getApplicationInfo().targetSdkVersion;
        g(a.a());
        TypedArray obtainStyledAttributes = this.l.obtainStyledAttributes(null, android.support.v7.b.l.ActionBar, android.support.v7.b.b.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(android.support.v7.b.l.ActionBar_hideOnContentScroll, false)) {
            if (this.p.a) {
                this.d = true;
                this.p.setHideOnContentScrollEnabled(true);
            } else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(android.support.v7.b.l.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            bq.f(this.q, (float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private static boolean a(boolean z, boolean z2, boolean z3) {
        return z3 ? true : (z || z2) ? false : true;
    }

    private void g(boolean z) {
        boolean z2 = true;
        this.A = z;
        if (this.A) {
            this.q.setTabContainer(null);
            this.r.a(this.u);
        } else {
            this.r.a(null);
            this.q.setTabContainer(this.u);
        }
        boolean z3 = this.r.p() == 2;
        if (this.u != null) {
            if (z3) {
                this.u.setVisibility(0);
                if (this.p != null) {
                    bq.u(this.p);
                }
            } else {
                this.u.setVisibility(8);
            }
        }
        bu buVar = this.r;
        boolean z4 = !this.A && z3;
        buVar.a(z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.p;
        if (this.A || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    private void h(boolean z) {
        float f;
        l lVar;
        dk c;
        if (a(this.D, this.E, this.F)) {
            if (!this.G) {
                this.G = true;
                if (this.H != null) {
                    this.H.b();
                }
                this.q.setVisibility(0);
                if (this.B == 0 && k && (this.I || z)) {
                    bq.b(this.q, 0.0f);
                    f = (float) (-this.q.getHeight());
                    if (z) {
                        int[] iArr = new int[]{0, 0};
                        this.q.getLocationInWindow(iArr);
                        f -= (float) iArr[1];
                    }
                    bq.b(this.q, f);
                    lVar = new l();
                    c = bq.r(this.q).c(0.0f);
                    c.a(this.g);
                    lVar.a(c);
                    if (this.C && this.t != null) {
                        bq.b(this.t, f);
                        lVar.a(bq.r(this.t).c(0.0f));
                    }
                    lVar.a(j);
                    lVar.c();
                    lVar.a(this.f);
                    this.H = lVar;
                    lVar.a();
                } else {
                    bq.c(this.q, 1.0f);
                    bq.b(this.q, 0.0f);
                    if (this.C && this.t != null) {
                        bq.b(this.t, 0.0f);
                    }
                    this.f.b(null);
                }
                if (this.p != null) {
                    bq.u(this.p);
                }
            }
        } else if (this.G) {
            this.G = false;
            if (this.H != null) {
                this.H.b();
            }
            if (this.B == 0 && k && (this.I || z)) {
                bq.c(this.q, 1.0f);
                this.q.setTransitioning(true);
                lVar = new l();
                f = (float) (-this.q.getHeight());
                if (z) {
                    int[] iArr2 = new int[]{0, 0};
                    this.q.getLocationInWindow(iArr2);
                    f -= (float) iArr2[1];
                }
                c = bq.r(this.q).c(f);
                c.a(this.g);
                lVar.a(c);
                if (this.C && this.t != null) {
                    lVar.a(bq.r(this.t).c(f));
                }
                lVar.a(i);
                lVar.c();
                lVar.a(this.e);
                this.H = lVar;
                lVar.a();
                return;
            }
            this.e.b(null);
        }
    }

    public final b a(c cVar) {
        if (this.a != null) {
            this.a.c();
        }
        this.p.setHideOnContentScrollEnabled(false);
        this.s.b();
        b bdVar = new bd(this, this.s.getContext(), cVar);
        if (!bdVar.e()) {
            return null;
        }
        bdVar.d();
        this.s.a(bdVar);
        f(true);
        this.s.sendAccessibilityEvent(32);
        this.a = bdVar;
        return bdVar;
    }

    public final void a() {
        this.r.a(LayoutInflater.from(f()).inflate(R.layout.abs_layout, this.r.a(), false));
    }

    public final void a(int i) {
        this.r.b(this.l.getString(i));
    }

    public final void a(Configuration configuration) {
        g(a.a(this.l).a());
    }

    public final void a(Drawable drawable) {
        this.q.setPrimaryBackground(drawable);
    }

    public final void a(CharSequence charSequence) {
        this.r.a(charSequence);
    }

    public final void a(boolean z) {
        int i = z ? 4 : 0;
        int o = this.r.o();
        this.x = true;
        this.r.c((i & 4) | (o & -5));
    }

    public final void b() {
        this.r.c(16);
    }

    public final void b(int i) {
        this.B = i;
    }

    public final void b(boolean z) {
        if (!this.x) {
            a(z);
        }
    }

    public final View c() {
        return this.r.q();
    }

    public final void c(boolean z) {
        this.I = z;
        if (!z && this.H != null) {
            this.H.b();
        }
    }

    public final int d() {
        return this.r.o();
    }

    public final void d(boolean z) {
        if (z != this.y) {
            this.y = z;
            int size = this.z.size();
            for (int i = 0; i < size; i++) {
                this.z.get(i);
            }
        }
    }

    public final void e(boolean z) {
        this.C = z;
    }

    public final boolean e() {
        int height = this.q.getHeight();
        return this.G && (height == 0 || this.p.getActionBarHideOffset() < height);
    }

    public final Context f() {
        if (this.m == null) {
            TypedValue typedValue = new TypedValue();
            this.l.getTheme().resolveAttribute(android.support.v7.b.b.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.m = new ContextThemeWrapper(this.l, i);
            } else {
                this.m = this.l;
            }
        }
        return this.m;
    }

    public final void f(boolean z) {
        dk a;
        dk a2;
        if (z) {
            if (!this.F) {
                this.F = true;
                if (this.p != null) {
                    this.p.setShowingForActionMode(true);
                }
                h(false);
            }
        } else if (this.F) {
            this.F = false;
            if (this.p != null) {
                this.p.setShowingForActionMode(false);
            }
            h(false);
        }
        if (z) {
            a = this.r.a(4, 100);
            a2 = this.s.a(0, 200);
        } else {
            a2 = this.r.a(0, 200);
            a = this.s.a(8, 100);
        }
        l lVar = new l();
        lVar.a.add(a);
        View view = (View) a.a.get();
        a2.b(view != null ? dk.b.a(view) : 0);
        lVar.a.add(a2);
        lVar.a();
    }

    public final boolean h() {
        if (this.r == null || !this.r.c()) {
            return false;
        }
        this.r.d();
        return true;
    }

    public final boolean i() {
        ViewGroup a = this.r.a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    public final void k() {
        if (this.E) {
            this.E = false;
            h(true);
        }
    }

    public final void l() {
        if (!this.E) {
            this.E = true;
            h(true);
        }
    }

    public final void m() {
        if (this.H != null) {
            this.H.b();
            this.H = null;
        }
    }
}
