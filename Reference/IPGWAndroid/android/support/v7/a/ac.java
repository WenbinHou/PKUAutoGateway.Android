package android.support.v7.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ae;
import android.support.v4.view.an;
import android.support.v4.view.bq;
import android.support.v4.view.cj;
import android.support.v4.view.dk;
import android.support.v7.b.d;
import android.support.v7.b.i;
import android.support.v7.b.k;
import android.support.v7.b.l;
import android.support.v7.view.b;
import android.support.v7.view.e;
import android.support.v7.view.menu.ExpandedMenuView;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.y;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ai;
import android.support.v7.widget.ak;
import android.support.v7.widget.al;
import android.support.v7.widget.am;
import android.support.v7.widget.at;
import android.support.v7.widget.au;
import android.support.v7.widget.aw;
import android.support.v7.widget.ax;
import android.support.v7.widget.bb;
import android.support.v7.widget.bc;
import android.support.v7.widget.bd;
import android.support.v7.widget.bf;
import android.support.v7.widget.bo;
import android.support.v7.widget.bt;
import android.support.v7.widget.ci;
import android.support.v7.widget.fq;
import android.support.v7.widget.gi;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

class ac extends v implements an, j {
    private View A;
    private boolean B;
    private boolean C;
    private boolean D;
    private ao[] E;
    private ao F;
    private boolean G;
    private boolean H;
    private int I;
    private final Runnable J = new ad(this);
    private boolean K;
    private Rect L;
    private Rect M;
    private ar N;
    private bt p;
    b q;
    ActionBarContextView r;
    PopupWindow s;
    Runnable t;
    dk u = null;
    ViewGroup v;
    private ak w;
    private ap x;
    private boolean y;
    private TextView z;

    ac(Context context, Window window, t tVar) {
        super(context, window, tVar);
    }

    private ao a(Menu menu) {
        ao[] aoVarArr = this.E;
        int length = aoVarArr != null ? aoVarArr.length : 0;
        for (int i = 0; i < length; i++) {
            ao aoVar = aoVarArr[i];
            if (aoVar != null && aoVar.j == menu) {
                return aoVar;
            }
        }
        return null;
    }

    private void a(int i, ao aoVar, Menu menu) {
        if (menu == null) {
            if (aoVar == null && i >= 0 && i < this.E.length) {
                aoVar = this.E[i];
            }
            if (aoVar != null) {
                menu = aoVar.j;
            }
        }
        if ((aoVar == null || aoVar.o) && !this.o) {
            this.d.onPanelClosed(i, menu);
        }
    }

    static /* synthetic */ void a(ac acVar, int i) {
        ao f = acVar.f(i);
        if (f.j != null) {
            Bundle bundle = new Bundle();
            f.j.a(bundle);
            if (bundle.size() > 0) {
                f.s = bundle;
            }
            f.j.d();
            f.j.clear();
        }
        f.r = true;
        f.q = true;
        if ((i == 108 || i == 0) && acVar.p != null) {
            f = acVar.f(0);
            if (f != null) {
                f.m = false;
                acVar.b(f, null);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(ao aoVar, KeyEvent keyEvent) {
        int i = -1;
        if (!aoVar.o && !this.o) {
            boolean z;
            if (aoVar.a == 0) {
                Context context = this.b;
                z = (context.getResources().getConfiguration().screenLayout & 15) == 4;
                boolean z2 = context.getApplicationInfo().targetSdkVersion >= 11;
                if (z && z2) {
                    return;
                }
            }
            Callback callback = this.c.getCallback();
            if (callback == null || callback.onMenuOpened(aoVar.a, aoVar.j)) {
                WindowManager windowManager = (WindowManager) this.b.getSystemService("window");
                if (windowManager != null && b(aoVar, keyEvent)) {
                    LayoutParams layoutParams;
                    if (aoVar.g == null || aoVar.q) {
                        if (aoVar.g == null) {
                            Context k = k();
                            TypedValue typedValue = new TypedValue();
                            Theme newTheme = k.getResources().newTheme();
                            newTheme.setTo(k.getTheme());
                            newTheme.resolveAttribute(android.support.v7.b.b.actionBarPopupTheme, typedValue, true);
                            if (typedValue.resourceId != 0) {
                                newTheme.applyStyle(typedValue.resourceId, true);
                            }
                            newTheme.resolveAttribute(android.support.v7.b.b.panelMenuListTheme, typedValue, true);
                            if (typedValue.resourceId != 0) {
                                newTheme.applyStyle(typedValue.resourceId, true);
                            } else {
                                newTheme.applyStyle(k.Theme_AppCompat_CompactMenu, true);
                            }
                            Context eVar = new e(k, 0);
                            eVar.getTheme().setTo(newTheme);
                            aoVar.l = eVar;
                            TypedArray obtainStyledAttributes = eVar.obtainStyledAttributes(l.AppCompatTheme);
                            aoVar.b = obtainStyledAttributes.getResourceId(l.AppCompatTheme_panelBackground, 0);
                            aoVar.f = obtainStyledAttributes.getResourceId(l.AppCompatTheme_android_windowAnimationStyle, 0);
                            obtainStyledAttributes.recycle();
                            aoVar.g = new an(this, aoVar.l);
                            aoVar.c = 81;
                            if (aoVar.g == null) {
                                return;
                            }
                        } else if (aoVar.q && aoVar.g.getChildCount() > 0) {
                            aoVar.g.removeAllViews();
                        }
                        if (aoVar.i != null) {
                            aoVar.h = aoVar.i;
                            z = true;
                        } else {
                            if (aoVar.j != null) {
                                ExpandedMenuView expandedMenuView;
                                if (this.x == null) {
                                    this.x = new ap();
                                }
                                y yVar = this.x;
                                if (aoVar.j == null) {
                                    expandedMenuView = null;
                                } else {
                                    if (aoVar.k == null) {
                                        aoVar.k = new g(aoVar.l, i.abc_list_menu_item_layout);
                                        aoVar.k.g = yVar;
                                        aoVar.j.a(aoVar.k);
                                    }
                                    Object obj = aoVar.k;
                                    ViewGroup viewGroup = aoVar.g;
                                    if (obj.d == null) {
                                        obj.d = (ExpandedMenuView) obj.b.inflate(i.abc_expanded_menu_layout, viewGroup, false);
                                        if (obj.h == null) {
                                            obj.h = new h(obj);
                                        }
                                        obj.d.setAdapter(obj.h);
                                        obj.d.setOnItemClickListener(obj);
                                    }
                                    expandedMenuView = obj.d;
                                }
                                aoVar.h = expandedMenuView;
                                if (aoVar.h != null) {
                                    z = true;
                                }
                            }
                            z = false;
                        }
                        if (z) {
                            LayoutParams layoutParams2;
                            ViewParent parent;
                            if (aoVar.h != null) {
                                if (aoVar.i != null) {
                                    z = true;
                                } else if (aoVar.k.b().getCount() > 0) {
                                    z = true;
                                }
                                if (z) {
                                    layoutParams = aoVar.h.getLayoutParams();
                                    layoutParams2 = layoutParams != null ? new LayoutParams(-2, -2) : layoutParams;
                                    aoVar.g.setBackgroundResource(aoVar.b);
                                    parent = aoVar.h.getParent();
                                    if (parent != null && (parent instanceof ViewGroup)) {
                                        ((ViewGroup) parent).removeView(aoVar.h);
                                    }
                                    aoVar.g.addView(aoVar.h, layoutParams2);
                                    if (!aoVar.h.hasFocus()) {
                                        aoVar.h.requestFocus();
                                    }
                                    i = -2;
                                } else {
                                    return;
                                }
                            }
                            z = false;
                            if (z) {
                                layoutParams = aoVar.h.getLayoutParams();
                                if (layoutParams != null) {
                                }
                                aoVar.g.setBackgroundResource(aoVar.b);
                                parent = aoVar.h.getParent();
                                ((ViewGroup) parent).removeView(aoVar.h);
                                aoVar.g.addView(aoVar.h, layoutParams2);
                                if (aoVar.h.hasFocus()) {
                                    aoVar.h.requestFocus();
                                }
                                i = -2;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (aoVar.i != null) {
                        layoutParams = aoVar.i.getLayoutParams();
                        if (layoutParams != null) {
                        }
                    }
                    i = -2;
                    aoVar.n = false;
                    layoutParams = new WindowManager.LayoutParams(i, -2, aoVar.d, aoVar.e, 1002, 8519680, -3);
                    layoutParams.gravity = aoVar.c;
                    layoutParams.windowAnimations = aoVar.f;
                    windowManager.addView(aoVar.g, layoutParams);
                    aoVar.o = true;
                    return;
                }
                return;
            }
            a(aoVar, true);
        }
    }

    private void a(ao aoVar, boolean z) {
        if (z && aoVar.a == 0 && this.p != null && this.p.b()) {
            b(aoVar.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.b.getSystemService("window");
        if (!(windowManager == null || !aoVar.o || aoVar.g == null)) {
            windowManager.removeView(aoVar.g);
            if (z) {
                a(aoVar.a, aoVar, null);
            }
        }
        aoVar.m = false;
        aoVar.n = false;
        aoVar.o = false;
        aoVar.h = null;
        aoVar.q = true;
        if (this.F == aoVar) {
            this.F = null;
        }
    }

    private boolean a(ao aoVar, int i, KeyEvent keyEvent) {
        return keyEvent.isSystem() ? false : ((aoVar.m || b(aoVar, keyEvent)) && aoVar.j != null) ? aoVar.j.performShortcut(i, keyEvent, 1) : false;
    }

    static /* synthetic */ int b(ac acVar, int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (acVar.r == null || !(acVar.r.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) acVar.r.getLayoutParams();
            if (acVar.r.isShown()) {
                if (acVar.L == null) {
                    acVar.L = new Rect();
                    acVar.M = new Rect();
                }
                Rect rect = acVar.L;
                Rect rect2 = acVar.M;
                rect.set(0, i, 0, 0);
                gi.a(acVar.v, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (acVar.A == null) {
                        acVar.A = new View(acVar.b);
                        acVar.A.setBackgroundColor(acVar.b.getResources().getColor(d.abc_input_method_navigation_guard));
                        acVar.v.addView(acVar.A, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = acVar.A.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            acVar.A.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (acVar.A == null) {
                    i3 = 0;
                }
                if (!(acVar.k || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                acVar.r.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (acVar.A != null) {
            View view = acVar.A;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    private void b(android.support.v7.view.menu.i iVar) {
        if (!this.D) {
            this.D = true;
            this.p.g();
            Callback callback = this.c.getCallback();
            if (!(callback == null || this.o)) {
                callback.onPanelClosed(108, iVar);
            }
            this.D = false;
        }
    }

    private boolean b(ao aoVar, KeyEvent keyEvent) {
        if (this.o) {
            return false;
        }
        if (aoVar.m) {
            return true;
        }
        if (!(this.F == null || this.F == aoVar)) {
            a(this.F, false);
        }
        Callback callback = this.c.getCallback();
        if (callback != null) {
            aoVar.i = callback.onCreatePanelView(aoVar.a);
        }
        boolean z = aoVar.a == 0 || aoVar.a == 108;
        if (z && this.p != null) {
            this.p.f();
        }
        if (aoVar.i == null && !(z && (this.g instanceof at))) {
            if (aoVar.j == null || aoVar.r) {
                if (aoVar.j == null) {
                    Context eVar;
                    android.support.v7.view.menu.i iVar;
                    Context context = this.b;
                    if ((aoVar.a == 0 || aoVar.a == 108) && this.p != null) {
                        Theme newTheme;
                        TypedValue typedValue = new TypedValue();
                        Theme theme = context.getTheme();
                        theme.resolveAttribute(android.support.v7.b.b.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            newTheme = context.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            newTheme.resolveAttribute(android.support.v7.b.b.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(android.support.v7.b.b.actionBarWidgetTheme, typedValue, true);
                            newTheme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (newTheme == null) {
                                newTheme = context.getResources().newTheme();
                                newTheme.setTo(theme);
                            }
                            newTheme.applyStyle(typedValue.resourceId, true);
                        }
                        Theme theme2 = newTheme;
                        if (theme2 != null) {
                            eVar = new e(context, 0);
                            eVar.getTheme().setTo(theme2);
                            iVar = new android.support.v7.view.menu.i(eVar);
                            iVar.a((j) this);
                            aoVar.a(iVar);
                            if (aoVar.j == null) {
                                return false;
                            }
                        }
                    }
                    eVar = context;
                    iVar = new android.support.v7.view.menu.i(eVar);
                    iVar.a((j) this);
                    aoVar.a(iVar);
                    if (aoVar.j == null) {
                        return false;
                    }
                }
                if (z && this.p != null) {
                    if (this.w == null) {
                        this.w = new ak();
                    }
                    this.p.a(aoVar.j, this.w);
                }
                aoVar.j.d();
                if (callback.onCreatePanelMenu(aoVar.a, aoVar.j)) {
                    aoVar.r = false;
                } else {
                    aoVar.a(null);
                    if (!z || this.p == null) {
                        return false;
                    }
                    this.p.a(null, this.w);
                    return false;
                }
            }
            aoVar.j.d();
            if (aoVar.s != null) {
                aoVar.j.b(aoVar.s);
                aoVar.s = null;
            }
            if (callback.onPreparePanel(0, aoVar.i, aoVar.j)) {
                aoVar.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
                aoVar.j.setQwertyMode(aoVar.p);
                aoVar.j.e();
            } else {
                if (z && this.p != null) {
                    this.p.a(null, this.w);
                }
                aoVar.j.e();
                return false;
            }
        }
        aoVar.m = true;
        aoVar.n = false;
        this.F = aoVar;
        return true;
    }

    static /* synthetic */ void d(ac acVar) {
        if (acVar.p != null) {
            acVar.p.g();
        }
        if (acVar.s != null) {
            acVar.c.getDecorView().removeCallbacks(acVar.t);
            if (acVar.s.isShowing()) {
                try {
                    acVar.s.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            acVar.s = null;
        }
        acVar.l();
        ao f = acVar.f(0);
        if (f != null && f.j != null) {
            f.j.close();
        }
    }

    private ao f(int i) {
        Object obj = this.E;
        if (obj == null || obj.length <= i) {
            Object obj2 = new ao[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.E = obj2;
            obj = obj2;
        }
        ao aoVar = obj[i];
        if (aoVar != null) {
            return aoVar;
        }
        aoVar = new ao(i);
        obj[i] = aoVar;
        return aoVar;
    }

    private void g(int i) {
        this.I |= 1 << i;
        if (!this.H) {
            bq.a(this.c.getDecorView(), this.J);
            this.H = true;
        }
    }

    private void m() {
        if (!this.y) {
            TypedArray obtainStyledAttributes = this.b.obtainStyledAttributes(l.AppCompatTheme);
            if (obtainStyledAttributes.hasValue(l.AppCompatTheme_windowActionBar)) {
                View view;
                View view2;
                if (obtainStyledAttributes.getBoolean(l.AppCompatTheme_windowNoTitle, false)) {
                    c(1);
                } else if (obtainStyledAttributes.getBoolean(l.AppCompatTheme_windowActionBar, false)) {
                    c(108);
                }
                if (obtainStyledAttributes.getBoolean(l.AppCompatTheme_windowActionBarOverlay, false)) {
                    c(109);
                }
                if (obtainStyledAttributes.getBoolean(l.AppCompatTheme_windowActionModeOverlay, false)) {
                    c(10);
                }
                this.l = obtainStyledAttributes.getBoolean(l.AppCompatTheme_android_windowIsFloating, false);
                obtainStyledAttributes.recycle();
                LayoutInflater from = LayoutInflater.from(this.b);
                if (this.m) {
                    view = this.k ? (ViewGroup) from.inflate(i.abc_screen_simple_overlay_action_mode, null) : (ViewGroup) from.inflate(i.abc_screen_simple, null);
                    if (VERSION.SDK_INT >= 21) {
                        bq.a(view, new ae(this));
                        view2 = view;
                    } else {
                        ((ci) view).setOnFitSystemWindowsListener(new af(this));
                        view2 = view;
                    }
                } else if (this.l) {
                    r0 = (ViewGroup) from.inflate(i.abc_dialog_title_material, null);
                    this.j = false;
                    this.i = false;
                    view2 = r0;
                } else if (this.i) {
                    TypedValue typedValue = new TypedValue();
                    this.b.getTheme().resolveAttribute(android.support.v7.b.b.actionBarTheme, typedValue, true);
                    r0 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new e(this.b, typedValue.resourceId) : this.b).inflate(i.abc_screen_toolbar, null);
                    this.p = (bt) r0.findViewById(android.support.v7.b.g.decor_content_parent);
                    this.p.setWindowCallback(this.c.getCallback());
                    if (this.j) {
                        this.p.a(109);
                    }
                    if (this.B) {
                        this.p.a(2);
                    }
                    if (this.C) {
                        this.p.a(5);
                    }
                    view2 = r0;
                } else {
                    view2 = null;
                }
                if (view2 == null) {
                    throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.i + ", windowActionBarOverlay: " + this.j + ", android:windowIsFloating: " + this.l + ", windowActionModeOverlay: " + this.k + ", windowNoTitle: " + this.m + " }");
                }
                if (this.p == null) {
                    this.z = (TextView) view2.findViewById(android.support.v7.b.g.title);
                }
                gi.b(view2);
                ViewGroup viewGroup = (ViewGroup) this.c.findViewById(16908290);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view2.findViewById(android.support.v7.b.g.action_bar_activity_content);
                while (viewGroup.getChildCount() > 0) {
                    View childAt = viewGroup.getChildAt(0);
                    viewGroup.removeViewAt(0);
                    contentFrameLayout.addView(childAt);
                }
                this.c.setContentView(view2);
                viewGroup.setId(-1);
                contentFrameLayout.setId(16908290);
                if (viewGroup instanceof FrameLayout) {
                    ((FrameLayout) viewGroup).setForeground(null);
                }
                contentFrameLayout.setAttachListener(new ag(this));
                this.v = view2;
                CharSequence title = this.d instanceof Activity ? ((Activity) this.d).getTitle() : this.n;
                if (!TextUtils.isEmpty(title)) {
                    b(title);
                }
                ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.v.findViewById(16908290);
                view = this.c.getDecorView();
                contentFrameLayout2.b.set(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
                if (bq.F(contentFrameLayout2)) {
                    contentFrameLayout2.requestLayout();
                }
                TypedArray obtainStyledAttributes2 = this.b.obtainStyledAttributes(l.AppCompatTheme);
                obtainStyledAttributes2.getValue(l.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
                obtainStyledAttributes2.getValue(l.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
                if (obtainStyledAttributes2.hasValue(l.AppCompatTheme_windowFixedWidthMajor)) {
                    obtainStyledAttributes2.getValue(l.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout2.getFixedWidthMajor());
                }
                if (obtainStyledAttributes2.hasValue(l.AppCompatTheme_windowFixedWidthMinor)) {
                    obtainStyledAttributes2.getValue(l.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout2.getFixedWidthMinor());
                }
                if (obtainStyledAttributes2.hasValue(l.AppCompatTheme_windowFixedHeightMajor)) {
                    obtainStyledAttributes2.getValue(l.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout2.getFixedHeightMajor());
                }
                if (obtainStyledAttributes2.hasValue(l.AppCompatTheme_windowFixedHeightMinor)) {
                    obtainStyledAttributes2.getValue(l.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout2.getFixedHeightMinor());
                }
                obtainStyledAttributes2.recycle();
                contentFrameLayout2.requestLayout();
                this.y = true;
                ao f = f(0);
                if (!this.o) {
                    if (f == null || f.j == null) {
                        g(108);
                        return;
                    }
                    return;
                }
                return;
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    private void n() {
        if (this.y) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final View a(int i) {
        m();
        return this.c.findViewById(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View a(View view, String str, Context context, AttributeSet attributeSet) {
        Object obj = null;
        View a = a(str, context, attributeSet);
        if (a == null) {
            Object obj2;
            ar arVar;
            Context context2;
            View view2;
            int i;
            boolean z = VERSION.SDK_INT < 21;
            if (this.N == null) {
                this.N = new ar();
            }
            if (z) {
                ViewParent viewParent = (ViewParent) view;
                if (viewParent == null) {
                    obj2 = null;
                } else {
                    ViewParent decorView = this.c.getDecorView();
                    ViewParent viewParent2 = viewParent;
                    while (viewParent2 != null) {
                        if (viewParent2 == decorView || !(viewParent2 instanceof View) || bq.H((View) viewParent2)) {
                            obj2 = null;
                            break;
                        }
                        viewParent2 = viewParent2.getParent();
                    }
                    int i2 = 1;
                }
                if (obj2 != null) {
                    obj2 = 1;
                    arVar = this.N;
                    context2 = (obj2 != null || view == null) ? context : view.getContext();
                    context2 = ar.a(context2, attributeSet, z);
                    if (z) {
                        context2 = fq.a(context2);
                    }
                    view2 = null;
                    switch (str.hashCode()) {
                        case -1946472170:
                            if (str.equals("RatingBar")) {
                                obj = 11;
                                break;
                            }
                        case -1455429095:
                            if (str.equals("CheckedTextView")) {
                                obj = 8;
                                break;
                            }
                        case -1346021293:
                            if (str.equals("MultiAutoCompleteTextView")) {
                                obj = 10;
                                break;
                            }
                        case -938935918:
                            if (str.equals("TextView")) {
                                break;
                            }
                        case -937446323:
                            if (str.equals("ImageButton")) {
                                obj = 5;
                                break;
                            }
                        case -658531749:
                            if (str.equals("SeekBar")) {
                                obj = 12;
                                break;
                            }
                        case -339785223:
                            if (str.equals("Spinner")) {
                                obj = 4;
                                break;
                            }
                        case 776382189:
                            if (str.equals("RadioButton")) {
                                obj = 7;
                                break;
                            }
                        case 1125864064:
                            if (str.equals("ImageView")) {
                                i = 1;
                                break;
                            }
                        case 1413872058:
                            if (str.equals("AutoCompleteTextView")) {
                                obj = 9;
                                break;
                            }
                        case 1601505219:
                            if (str.equals("CheckBox")) {
                                obj = 6;
                                break;
                            }
                        case 1666676343:
                            if (str.equals("EditText")) {
                                obj = 3;
                                break;
                            }
                        case 2001146706:
                            if (str.equals("Button")) {
                                obj = 2;
                                break;
                            }
                        default:
                            obj = -1;
                            break;
                    }
                    switch (obj) {
                        case null:
                            view2 = new bo(context2, attributeSet);
                            break;
                        case 1:
                            view2 = new aw(context2, attributeSet);
                            break;
                        case 2:
                            view2 = new ak(context2, attributeSet);
                            break;
                        case 3:
                            view2 = new at(context2, attributeSet);
                            break;
                        case 4:
                            view2 = new bf(context2, attributeSet);
                            break;
                        case 5:
                            view2 = new au(context2, attributeSet);
                            break;
                        case 6:
                            view2 = new al(context2, attributeSet);
                            break;
                        case 7:
                            view2 = new bb(context2, attributeSet);
                            break;
                        case 8:
                            view2 = new am(context2, attributeSet);
                            break;
                        case 9:
                            view2 = new ai(context2, attributeSet);
                            break;
                        case 10:
                            view2 = new ax(context2, attributeSet);
                            break;
                        case 11:
                            view2 = new bc(context2, attributeSet);
                            break;
                        case 12:
                            view2 = new bd(context2, attributeSet);
                            break;
                    }
                    a = (view2 == null || context == context2) ? view2 : arVar.a(context2, str, attributeSet);
                    if (a != null) {
                        ar.a(a, attributeSet);
                    }
                }
            }
            obj2 = null;
            arVar = this.N;
            if (obj2 != null) {
            }
            context2 = ar.a(context2, attributeSet, z);
            if (z) {
                context2 = fq.a(context2);
            }
            view2 = null;
            switch (str.hashCode()) {
                case -1946472170:
                    if (str.equals("RatingBar")) {
                        obj = 11;
                        break;
                    }
                case -1455429095:
                    if (str.equals("CheckedTextView")) {
                        obj = 8;
                        break;
                    }
                case -1346021293:
                    if (str.equals("MultiAutoCompleteTextView")) {
                        obj = 10;
                        break;
                    }
                case -938935918:
                    if (str.equals("TextView")) {
                        break;
                    }
                case -937446323:
                    if (str.equals("ImageButton")) {
                        obj = 5;
                        break;
                    }
                case -658531749:
                    if (str.equals("SeekBar")) {
                        obj = 12;
                        break;
                    }
                case -339785223:
                    if (str.equals("Spinner")) {
                        obj = 4;
                        break;
                    }
                case 776382189:
                    if (str.equals("RadioButton")) {
                        obj = 7;
                        break;
                    }
                case 1125864064:
                    if (str.equals("ImageView")) {
                        i = 1;
                        break;
                    }
                case 1413872058:
                    if (str.equals("AutoCompleteTextView")) {
                        obj = 9;
                        break;
                    }
                case 1601505219:
                    if (str.equals("CheckBox")) {
                        obj = 6;
                        break;
                    }
                case 1666676343:
                    if (str.equals("EditText")) {
                        obj = 3;
                        break;
                    }
                case 2001146706:
                    if (str.equals("Button")) {
                        obj = 2;
                        break;
                    }
                default:
                    obj = -1;
                    break;
            }
            switch (obj) {
                case null:
                    view2 = new bo(context2, attributeSet);
                    break;
                case 1:
                    view2 = new aw(context2, attributeSet);
                    break;
                case 2:
                    view2 = new ak(context2, attributeSet);
                    break;
                case 3:
                    view2 = new at(context2, attributeSet);
                    break;
                case 4:
                    view2 = new bf(context2, attributeSet);
                    break;
                case 5:
                    view2 = new au(context2, attributeSet);
                    break;
                case 6:
                    view2 = new al(context2, attributeSet);
                    break;
                case 7:
                    view2 = new bb(context2, attributeSet);
                    break;
                case 8:
                    view2 = new am(context2, attributeSet);
                    break;
                case 9:
                    view2 = new ai(context2, attributeSet);
                    break;
                case 10:
                    view2 = new ax(context2, attributeSet);
                    break;
                case 11:
                    view2 = new bc(context2, attributeSet);
                    break;
                case 12:
                    view2 = new bd(context2, attributeSet);
                    break;
            }
            if (view2 == null) {
            }
            if (a != null) {
                ar.a(a, attributeSet);
            }
        }
        return a;
    }

    View a(String str, Context context, AttributeSet attributeSet) {
        if (this.d instanceof Factory) {
            View onCreateView = ((Factory) this.d).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    public final void a(Configuration configuration) {
        if (this.i && this.y) {
            a a = a();
            if (a != null) {
                a.a(configuration);
            }
        }
    }

    public void a(Bundle bundle) {
        if ((this.d instanceof Activity) && android.support.v4.app.ax.b((Activity) this.d) != null) {
            a aVar = this.g;
            if (aVar == null) {
                this.K = true;
            } else {
                aVar.b(true);
            }
        }
    }

    public final void a(android.support.v7.view.menu.i iVar) {
        if (this.p == null || !this.p.a() || (cj.b(ViewConfiguration.get(this.b)) && !this.p.c())) {
            ao f = f(0);
            f.q = true;
            a(f, false);
            a(f, null);
            return;
        }
        Callback callback = this.c.getCallback();
        if (this.p.b()) {
            this.p.e();
            if (!this.o) {
                callback.onPanelClosed(108, f(0).j);
            }
        } else if (callback != null && !this.o) {
            if (this.H && (this.I & 1) != 0) {
                this.c.getDecorView().removeCallbacks(this.J);
                this.J.run();
            }
            ao f2 = f(0);
            if (f2.j != null && !f2.r && callback.onPreparePanel(0, f2.i, f2.j)) {
                callback.onMenuOpened(108, f2.j);
                this.p.d();
            }
        }
    }

    public final void a(View view) {
        m();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.d.onContentChanged();
    }

    public final void a(View view, LayoutParams layoutParams) {
        m();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.d.onContentChanged();
    }

    final boolean a(int i, KeyEvent keyEvent) {
        a a = a();
        if (a != null && a.a(i, keyEvent)) {
            return true;
        }
        if (this.F == null || !a(this.F, keyEvent.getKeyCode(), keyEvent)) {
            if (this.F == null) {
                ao f = f(0);
                b(f, keyEvent);
                boolean a2 = a(f, keyEvent.getKeyCode(), keyEvent);
                f.m = false;
                if (a2) {
                    return true;
                }
            }
            return false;
        } else if (this.F == null) {
            return true;
        } else {
            this.F.n = true;
            return true;
        }
    }

    public final boolean a(android.support.v7.view.menu.i iVar, MenuItem menuItem) {
        Callback callback = this.c.getCallback();
        if (!(callback == null || this.o)) {
            ao a = a(iVar.k());
            if (a != null) {
                return callback.onMenuItemSelected(a.a, menuItem);
            }
        }
        return false;
    }

    final boolean a(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.d.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            switch (keyCode) {
                case 4:
                    this.G = (keyEvent.getFlags() & 128) != 0;
                    break;
                case 82:
                    if (keyEvent.getRepeatCount() != 0) {
                        return true;
                    }
                    ao f = f(0);
                    if (f.o) {
                        return true;
                    }
                    b(f, keyEvent);
                    return true;
            }
            if (VERSION.SDK_INT < 11) {
                a(keyCode, keyEvent);
            }
            return false;
        }
        boolean z;
        ao f2;
        switch (keyCode) {
            case 4:
                z = this.G;
                this.G = false;
                f2 = f(0);
                if (f2 == null || !f2.o) {
                    if (this.q != null) {
                        this.q.c();
                        z = true;
                    } else {
                        a a = a();
                        z = a != null && a.h();
                    }
                    if (z) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    a(f2, true);
                    return true;
                }
                break;
            case 82:
                if (this.q != null) {
                    return true;
                }
                f2 = f(0);
                if (this.p == null || !this.p.a() || cj.b(ViewConfiguration.get(this.b))) {
                    if (f2.o || f2.n) {
                        z = f2.o;
                        a(f2, true);
                    } else {
                        if (f2.m) {
                            if (f2.r) {
                                f2.m = false;
                                z = b(f2, keyEvent);
                            } else {
                                z = true;
                            }
                            if (z) {
                                a(f2, keyEvent);
                                z = true;
                            }
                        }
                        z = false;
                    }
                } else if (this.p.b()) {
                    z = this.p.e();
                } else {
                    if (!this.o && b(f2, keyEvent)) {
                        z = this.p.d();
                    }
                    z = false;
                }
                if (!z) {
                    return true;
                }
                AudioManager audioManager = (AudioManager) this.b.getSystemService("audio");
                if (audioManager != null) {
                    audioManager.playSoundEffect(0);
                    return true;
                }
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
                return true;
        }
        return false;
    }

    public final void b(int i) {
        m();
        ViewGroup viewGroup = (ViewGroup) this.v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.b).inflate(i, viewGroup);
        this.d.onContentChanged();
    }

    public final void b(View view, LayoutParams layoutParams) {
        m();
        ((ViewGroup) this.v.findViewById(16908290)).addView(view, layoutParams);
        this.d.onContentChanged();
    }

    final void b(CharSequence charSequence) {
        if (this.p != null) {
            this.p.setWindowTitle(charSequence);
        } else if (this.g != null) {
            this.g.a(charSequence);
        } else if (this.z != null) {
            this.z.setText(charSequence);
        }
    }

    public final void c() {
        m();
    }

    public final boolean c(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.m && i == 108) {
            return false;
        }
        if (this.i && i == 1) {
            this.i = false;
        }
        switch (i) {
            case 1:
                n();
                this.m = true;
                return true;
            case 2:
                n();
                this.B = true;
                return true;
            case 5:
                n();
                this.C = true;
                return true;
            case 10:
                n();
                this.k = true;
                return true;
            case 108:
                n();
                this.i = true;
                return true;
            case 109:
                n();
                this.j = true;
                return true;
            default:
                return this.c.requestFeature(i);
        }
    }

    public final void d() {
        a a = a();
        if (a != null) {
            a.c(false);
        }
    }

    final void d(int i) {
        if (i == 108) {
            a a = a();
            if (a != null) {
                a.d(false);
            }
        } else if (i == 0) {
            ao f = f(i);
            if (f.o) {
                a(f, false);
            }
        }
    }

    public final void e() {
        a a = a();
        if (a != null) {
            a.c(true);
        }
    }

    final boolean e(int i) {
        if (i != 108) {
            return false;
        }
        a a = a();
        if (a == null) {
            return true;
        }
        a.d(true);
        return true;
    }

    public final void f() {
        a a = a();
        if (a == null || !a.g()) {
            g(0);
        }
    }

    public final void g() {
        super.g();
        if (this.g != null) {
            this.g.j();
            this.g = null;
        }
    }

    public final void h() {
        LayoutInflater from = LayoutInflater.from(this.b);
        if (from.getFactory() == null) {
            ae.a(from, this);
        } else if (!(ae.a(from) instanceof ac)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final void j() {
        m();
        if (this.i && this.g == null) {
            if (this.d instanceof Activity) {
                this.g = new az((Activity) this.d, this.j);
            } else if (this.d instanceof Dialog) {
                this.g = new az((Dialog) this.d);
            }
            if (this.g != null) {
                this.g.b(this.K);
            }
        }
    }

    final void l() {
        if (this.u != null) {
            this.u.a();
        }
    }
}
