package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.bg;
import android.support.v4.view.bh;
import android.support.v4.view.bq;
import android.support.v4.view.dk;
import android.support.v4.view.ea;
import android.support.v4.widget.ap;
import android.support.v7.b.b;
import android.support.v7.b.g;
import android.support.v7.view.menu.y;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public class ActionBarOverlayLayout extends ViewGroup implements bg, bt {
    static final int[] b = new int[]{b.actionBarSize, 16842841};
    private final Runnable A;
    private final bh B;
    public boolean a;
    private int c;
    private int d;
    private ContentFrameLayout e;
    private ActionBarContainer f;
    private bu g;
    private Drawable h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private final Rect o;
    private final Rect p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private i u;
    private final int v;
    private ap w;
    private dk x;
    private final ea y;
    private final Runnable z;

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.v = 600;
        this.y = new f(this);
        this.z = new g(this);
        this.A = new h(this);
        a(context);
        this.B = new bh(this);
    }

    private void a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(b);
        this.c = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.h = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.h == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.i = z;
        this.w = ap.a(context, null);
    }

    private static boolean a(View view, Rect rect, boolean z) {
        boolean z2 = false;
        j jVar = (j) view.getLayoutParams();
        if (jVar.leftMargin != rect.left) {
            jVar.leftMargin = rect.left;
            z2 = true;
        }
        if (jVar.topMargin != rect.top) {
            jVar.topMargin = rect.top;
            z2 = true;
        }
        if (jVar.rightMargin != rect.right) {
            jVar.rightMargin = rect.right;
            z2 = true;
        }
        if (!z || jVar.bottomMargin == rect.bottom) {
            return z2;
        }
        jVar.bottomMargin = rect.bottom;
        return true;
    }

    private void h() {
        if (this.e == null) {
            bu buVar;
            this.e = (ContentFrameLayout) findViewById(g.action_bar_activity_content);
            this.f = (ActionBarContainer) findViewById(g.action_bar_container);
            View findViewById = findViewById(g.action_bar);
            if (findViewById instanceof bu) {
                buVar = (bu) findViewById;
            } else if (findViewById instanceof Toolbar) {
                buVar = ((Toolbar) findViewById).getWrapper();
            } else {
                throw new IllegalStateException("Can't make a decor toolbar out of " + findViewById.getClass().getSimpleName());
            }
            this.g = buVar;
        }
    }

    private void i() {
        removeCallbacks(this.z);
        removeCallbacks(this.A);
        if (this.x != null) {
            this.x.a();
        }
    }

    public final void a(int i) {
        h();
        switch (i) {
            case 2:
                this.g.f();
                return;
            case 5:
                this.g.g();
                return;
            case 109:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public final void a(Menu menu, y yVar) {
        h();
        this.g.a(menu, yVar);
    }

    public final boolean a() {
        h();
        return this.g.h();
    }

    public final boolean b() {
        h();
        return this.g.i();
    }

    public final boolean c() {
        h();
        return this.g.j();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof j;
    }

    public final boolean d() {
        h();
        return this.g.k();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.h != null && !this.i) {
            int bottom = this.f.getVisibility() == 0 ? (int) ((((float) this.f.getBottom()) + bq.o(this.f)) + 0.5f) : 0;
            this.h.setBounds(0, bottom, getWidth(), this.h.getIntrinsicHeight() + bottom);
            this.h.draw(canvas);
        }
    }

    public final boolean e() {
        h();
        return this.g.l();
    }

    public final void f() {
        h();
        this.g.m();
    }

    protected boolean fitSystemWindows(Rect rect) {
        h();
        bq.t(this);
        boolean a = a(this.f, rect, false);
        this.r.set(rect);
        gi.a(this, this.r, this.o);
        if (!this.p.equals(this.o)) {
            this.p.set(this.o);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    public final void g() {
        h();
        this.g.n();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return new j();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new j(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new j(layoutParams);
    }

    public int getActionBarHideOffset() {
        return this.f != null ? -((int) bq.o(this.f)) : 0;
    }

    public int getNestedScrollAxes() {
        return this.B.a;
    }

    public CharSequence getTitle() {
        h();
        return this.g.e();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        a(getContext());
        bq.u(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                j jVar = (j) childAt.getLayoutParams();
                int i6 = jVar.leftMargin + paddingLeft;
                int i7 = jVar.topMargin + paddingTop;
                childAt.layout(i6, i7, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + i7);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        h();
        measureChildWithMargins(this.f, i, 0, i2, 0);
        j jVar = (j) this.f.getLayoutParams();
        int max = Math.max(0, (this.f.getMeasuredWidth() + jVar.leftMargin) + jVar.rightMargin);
        int max2 = Math.max(0, jVar.bottomMargin + (this.f.getMeasuredHeight() + jVar.topMargin));
        int a = gi.a(0, bq.j(this.f));
        boolean z = (bq.t(this) & 256) != 0;
        if (z) {
            i3 = this.c;
            if (this.j && this.f.getTabContainer() != null) {
                i3 += this.c;
            }
        } else {
            i3 = this.f.getVisibility() != 8 ? this.f.getMeasuredHeight() : 0;
        }
        this.q.set(this.o);
        this.s.set(this.r);
        Rect rect;
        Rect rect2;
        if (this.a || z) {
            rect = this.s;
            rect.top = i3 + rect.top;
            rect2 = this.s;
            rect2.bottom += 0;
        } else {
            rect = this.q;
            rect.top = i3 + rect.top;
            rect2 = this.q;
            rect2.bottom += 0;
        }
        a(this.e, this.q, true);
        if (!this.t.equals(this.s)) {
            this.t.set(this.s);
            this.e.a(this.s);
        }
        measureChildWithMargins(this.e, i, 0, i2, 0);
        jVar = (j) this.e.getLayoutParams();
        int max3 = Math.max(max, (this.e.getMeasuredWidth() + jVar.leftMargin) + jVar.rightMargin);
        i3 = Math.max(max2, jVar.bottomMargin + (this.e.getMeasuredHeight() + jVar.topMargin));
        int a2 = gi.a(a, bq.j(this.e));
        setMeasuredDimension(bq.a(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, a2), bq.a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, a2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        boolean z2 = false;
        if (!this.k || !z) {
            return false;
        }
        this.w.a(0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.w.e() > this.f.getHeight()) {
            z2 = true;
        }
        if (z2) {
            i();
            this.A.run();
        } else {
            i();
            this.z.run();
        }
        this.l = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.m += i2;
        setActionBarHideOffset(this.m);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.B.a = i;
        this.m = getActionBarHideOffset();
        i();
        if (this.u != null) {
            this.u.m();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return ((i & 2) == 0 || this.f.getVisibility() != 0) ? false : this.k;
    }

    public void onStopNestedScroll(View view) {
        if (this.k && !this.l) {
            if (this.m <= this.f.getHeight()) {
                i();
                postDelayed(this.z, 600);
                return;
            }
            i();
            postDelayed(this.A, 600);
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        h();
        int i2 = this.n ^ i;
        this.n = i;
        boolean z2 = (i & 4) == 0;
        boolean z3 = (i & 256) != 0;
        if (this.u != null) {
            i iVar = this.u;
            if (z3) {
                z = false;
            }
            iVar.e(z);
            if (z2 || !z3) {
                this.u.k();
            } else {
                this.u.l();
            }
        }
        if ((i2 & 256) != 0 && this.u != null) {
            bq.u(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.d = i;
        if (this.u != null) {
            this.u.b(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        i();
        bq.b(this.f, (float) (-Math.max(0, Math.min(i, this.f.getHeight()))));
    }

    public void setActionBarVisibilityCallback(i iVar) {
        this.u = iVar;
        if (getWindowToken() != null) {
            this.u.b(this.d);
            if (this.n != 0) {
                onWindowSystemUiVisibilityChanged(this.n);
                bq.u(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.j = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.k) {
            this.k = z;
            if (!z) {
                i();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        h();
        this.g.a(i);
    }

    public void setIcon(Drawable drawable) {
        h();
        this.g.a(drawable);
    }

    public void setLogo(int i) {
        h();
        this.g.b(i);
    }

    public void setOverlayMode(boolean z) {
        this.a = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.i = z2;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Callback callback) {
        h();
        this.g.a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        h();
        this.g.a(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
