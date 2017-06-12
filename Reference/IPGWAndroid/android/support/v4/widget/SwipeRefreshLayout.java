package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ay;
import android.support.v4.view.be;
import android.support.v4.view.bf;
import android.support.v4.view.bg;
import android.support.v4.view.bh;
import android.support.v4.view.bq;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;

public class SwipeRefreshLayout extends ViewGroup implements be, bg {
    private static final String c = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] y = new int[]{16842766};
    private int A;
    private float B;
    private x C;
    private Animation D;
    private Animation E;
    private Animation F;
    private Animation G;
    private Animation H;
    private float I;
    private boolean J;
    private int K;
    private int L;
    private boolean M;
    private AnimationListener N;
    private final Animation O;
    private final Animation P;
    protected int a;
    protected int b;
    private View d;
    private bc e;
    private boolean f;
    private int g;
    private float h;
    private float i;
    private final bh j;
    private final bf k;
    private final int[] l;
    private final int[] m;
    private boolean n;
    private int o;
    private int p;
    private boolean q;
    private float r;
    private float s;
    private boolean t;
    private int u;
    private boolean v;
    private boolean w;
    private final DecelerateInterpolator x;
    private d z;

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
        this.h = -1.0f;
        this.l = new int[2];
        this.m = new int[2];
        this.q = false;
        this.u = -1;
        this.A = -1;
        this.N = new au(this);
        this.O = new az(this);
        this.P = new ba(this);
        this.g = ViewConfiguration.get(context).getScaledTouchSlop();
        this.o = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.x = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.K = (int) (displayMetrics.density * 40.0f);
        this.L = (int) (displayMetrics.density * 40.0f);
        this.z = new d(getContext());
        this.C = new x(getContext(), this);
        this.C.b(-328966);
        this.z.setImageDrawable(this.C);
        this.z.setVisibility(8);
        addView(this.z);
        bq.a((ViewGroup) this);
        this.I = displayMetrics.density * 64.0f;
        this.h = this.I;
        this.j = new bh(this);
        this.k = new bf(this);
        setNestedScrollingEnabled(true);
    }

    private static float a(MotionEvent motionEvent, int i) {
        int a = ay.a(motionEvent, i);
        return a < 0 ? -1.0f : ay.d(motionEvent, a);
    }

    private Animation a(int i, int i2) {
        if (this.v && b()) {
            return null;
        }
        Animation axVar = new ax(this, i, i2);
        axVar.setDuration(300);
        this.z.a = null;
        this.z.clearAnimation();
        this.z.startAnimation(axVar);
        return axVar;
    }

    private void a() {
        this.z.clearAnimation();
        this.C.stop();
        this.z.setVisibility(8);
        setColorViewAlpha(255);
        if (this.v) {
            setAnimationProgress(0.0f);
        } else {
            a(this.b - this.p, true);
        }
        this.p = this.z.getTop();
    }

    private void a(float f) {
        this.C.a(true);
        float min = Math.min(1.0f, Math.abs(f / this.h));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.h;
        float f2 = this.M ? this.I - ((float) this.b) : this.I;
        abs = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
        abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + ((f2 * abs) * 2.0f))) + this.b;
        if (this.z.getVisibility() != 0) {
            this.z.setVisibility(0);
        }
        if (!this.v) {
            bq.d(this.z, 1.0f);
            bq.e(this.z, 1.0f);
        }
        if (this.v) {
            setAnimationProgress(Math.min(1.0f, f / this.h));
        }
        if (f < this.h) {
            if (this.C.getAlpha() > 76 && !a(this.F)) {
                this.F = a(this.C.getAlpha(), 76);
            }
        } else if (this.C.getAlpha() < 255 && !a(this.G)) {
            this.G = a(this.C.getAlpha(), 255);
        }
        this.C.b(Math.min(0.8f, max * 0.8f));
        this.C.a(Math.min(1.0f, max));
        this.C.a.c(((-0.25f + (max * 0.4f)) + (abs * 2.0f)) * 0.5f);
        a(i - this.p, true);
    }

    private void a(int i, boolean z) {
        this.z.bringToFront();
        this.z.offsetTopAndBottom(i);
        this.p = this.z.getTop();
        if (z && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void a(MotionEvent motionEvent) {
        int b = ay.b(motionEvent);
        if (ay.b(motionEvent, b) == this.u) {
            this.u = ay.b(motionEvent, b == 0 ? 1 : 0);
        }
    }

    private void a(AnimationListener animationListener) {
        this.E = new aw(this);
        this.E.setDuration(150);
        this.z.a = animationListener;
        this.z.clearAnimation();
        this.z.startAnimation(this.E);
    }

    private void a(boolean z, boolean z2) {
        if (this.f != z) {
            this.J = z2;
            c();
            this.f = z;
            if (this.f) {
                int i = this.p;
                AnimationListener animationListener = this.N;
                this.a = i;
                this.O.reset();
                this.O.setDuration(200);
                this.O.setInterpolator(this.x);
                if (animationListener != null) {
                    this.z.a = animationListener;
                }
                this.z.clearAnimation();
                this.z.startAnimation(this.O);
                return;
            }
            a(this.N);
        }
    }

    private static boolean a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void b(float f) {
        if (f > this.h) {
            a(true, true);
            return;
        }
        this.f = false;
        this.C.b(0.0f);
        AnimationListener animationListener = null;
        if (!this.v) {
            animationListener = new ay(this);
        }
        int i = this.p;
        if (this.v) {
            this.a = i;
            if (b()) {
                this.B = (float) this.C.getAlpha();
            } else {
                this.B = bq.s(this.z);
            }
            this.H = new bb(this);
            this.H.setDuration(150);
            if (animationListener != null) {
                this.z.a = animationListener;
            }
            this.z.clearAnimation();
            this.z.startAnimation(this.H);
        } else {
            this.a = i;
            this.P.reset();
            this.P.setDuration(200);
            this.P.setInterpolator(this.x);
            if (animationListener != null) {
                this.z.a = animationListener;
            }
            this.z.clearAnimation();
            this.z.startAnimation(this.P);
        }
        this.C.a(false);
    }

    private static boolean b() {
        return VERSION.SDK_INT < 11;
    }

    private void c() {
        if (this.d == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.z)) {
                    i++;
                } else {
                    this.d = childAt;
                    return;
                }
            }
        }
    }

    private boolean d() {
        if (VERSION.SDK_INT >= 14) {
            return bq.b(this.d, -1);
        }
        if (!(this.d instanceof AbsListView)) {
            return bq.b(this.d, -1) || this.d.getScrollY() > 0;
        } else {
            AbsListView absListView = (AbsListView) this.d;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
    }

    private void setAnimationProgress(float f) {
        if (b()) {
            setColorViewAlpha((int) (255.0f * f));
            return;
        }
        bq.d(this.z, f);
        bq.e(this.z, f);
    }

    private void setColorViewAlpha(int i) {
        this.z.getBackground().setAlpha(i);
        this.C.setAlpha(i);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.k.a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.k.a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.k.a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.k.a(i, i2, i3, i4, iArr);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        return this.A < 0 ? i2 : i2 == i + -1 ? this.A : i2 >= this.A ? i2 + 1 : i2;
    }

    public int getNestedScrollAxes() {
        return this.j.a;
    }

    public int getProgressCircleDiameter() {
        return this.z != null ? this.z.getMeasuredHeight() : 0;
    }

    public boolean hasNestedScrollingParent() {
        return this.k.a();
    }

    public boolean isNestedScrollingEnabled() {
        return this.k.a;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        c();
        int a = ay.a(motionEvent);
        if (this.w && a == 0) {
            this.w = false;
        }
        if (!isEnabled() || this.w || d() || this.f || this.n) {
            return false;
        }
        float a2;
        switch (a) {
            case 0:
                a(this.b - this.z.getTop(), true);
                this.u = ay.b(motionEvent, 0);
                this.t = false;
                a2 = a(motionEvent, this.u);
                if (a2 != -1.0f) {
                    this.s = a2;
                    break;
                }
                return false;
            case 1:
            case 3:
                this.t = false;
                this.u = -1;
                break;
            case 2:
                if (this.u == -1) {
                    Log.e(c, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                a2 = a(motionEvent, this.u);
                if (a2 != -1.0f) {
                    if (a2 - this.s > ((float) this.g) && !this.t) {
                        this.r = this.s + ((float) this.g);
                        this.t = true;
                        this.C.setAlpha(76);
                        break;
                    }
                }
                return false;
            case 6:
                a(motionEvent);
                break;
        }
        return this.t;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.d == null) {
                c();
            }
            if (this.d != null) {
                View view = this.d;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.z.getMeasuredWidth();
                this.z.layout((measuredWidth / 2) - (measuredHeight / 2), this.p, (measuredWidth / 2) + (measuredHeight / 2), this.p + this.z.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.d == null) {
            c();
        }
        if (this.d != null) {
            int i3;
            this.d.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.z.measure(MeasureSpec.makeMeasureSpec(this.K, 1073741824), MeasureSpec.makeMeasureSpec(this.L, 1073741824));
            if (!(this.M || this.q)) {
                this.q = true;
                i3 = -this.z.getMeasuredHeight();
                this.b = i3;
                this.p = i3;
            }
            this.A = -1;
            for (i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.z) {
                    this.A = i3;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.i > 0.0f) {
            if (((float) i2) > this.i) {
                iArr[1] = i2 - ((int) this.i);
                this.i = 0.0f;
            } else {
                this.i -= (float) i2;
                iArr[1] = i2;
            }
            a(this.i);
        }
        if (this.M && i2 > 0 && this.i == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.z.setVisibility(8);
        }
        int[] iArr2 = this.l;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.m);
        int i5 = this.m[1] + i4;
        if (i5 < 0 && !d()) {
            this.i = ((float) Math.abs(i5)) + this.i;
            a(this.i);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.j.a = i;
        startNestedScroll(i & 2);
        this.i = 0.0f;
        this.n = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.w || this.f || (i & 2) == 0) ? false : true;
    }

    public void onStopNestedScroll(View view) {
        this.j.a = 0;
        this.n = false;
        if (this.i > 0.0f) {
            b(this.i);
            this.i = 0.0f;
        }
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = ay.a(motionEvent);
        if (this.w && a == 0) {
            this.w = false;
        }
        if (!isEnabled() || this.w || d() || this.n) {
            return false;
        }
        float d;
        switch (a) {
            case 0:
                this.u = ay.b(motionEvent, 0);
                this.t = false;
                break;
            case 1:
                a = ay.a(motionEvent, this.u);
                if (a < 0) {
                    Log.e(c, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                d = (ay.d(motionEvent, a) - this.r) * 0.5f;
                this.t = false;
                b(d);
                this.u = -1;
                return false;
            case 2:
                a = ay.a(motionEvent, this.u);
                if (a < 0) {
                    Log.e(c, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                d = (ay.d(motionEvent, a) - this.r) * 0.5f;
                if (this.t) {
                    if (d > 0.0f) {
                        a(d);
                        break;
                    }
                    return false;
                }
                break;
            case 3:
                return false;
            case 5:
                a = ay.b(motionEvent);
                if (a >= 0) {
                    this.u = ay.b(motionEvent, a);
                    break;
                }
                Log.e(c, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                return false;
            case 6:
                a(motionEvent);
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.d instanceof AbsListView)) {
            return;
        }
        if (this.d == null || bq.D(this.d)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        c();
        x xVar = this.C;
        xVar.a.a(iArr);
        xVar.a.a(0);
    }

    public void setColorSchemeResources(int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i) {
        this.h = (float) i;
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.k.a(z);
    }

    public void setOnRefreshListener(bc bcVar) {
        this.e = bcVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.z.setBackgroundColor(i);
        this.C.b(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i));
    }

    public void setRefreshing(boolean z) {
        if (!z || this.f == z) {
            a(z, false);
            return;
        }
        this.f = z;
        a((!this.M ? (int) (this.I + ((float) this.b)) : (int) this.I) - this.p, true);
        this.J = false;
        AnimationListener animationListener = this.N;
        this.z.setVisibility(0);
        if (VERSION.SDK_INT >= 11) {
            this.C.setAlpha(255);
        }
        this.D = new av(this);
        this.D.setDuration((long) this.o);
        if (animationListener != null) {
            this.z.a = animationListener;
        }
        this.z.clearAnimation();
        this.z.startAnimation(this.D);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i2;
            if (i == 0) {
                i2 = (int) (displayMetrics.density * 56.0f);
                this.K = i2;
                this.L = i2;
            } else {
                i2 = (int) (displayMetrics.density * 40.0f);
                this.K = i2;
                this.L = i2;
            }
            this.z.setImageDrawable(null);
            this.C.a(i);
            this.z.setImageDrawable(this.C);
        }
    }

    public boolean startNestedScroll(int i) {
        return this.k.a(i);
    }

    public void stopNestedScroll() {
        this.k.b();
    }
}
