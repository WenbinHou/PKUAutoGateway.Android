package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.e.e;
import android.support.v4.view.a.a;
import android.support.v4.view.ay;
import android.support.v4.view.be;
import android.support.v4.view.bf;
import android.support.v4.view.bk;
import android.support.v4.view.bm;
import android.support.v4.view.bq;
import android.support.v4.view.cj;
import android.support.v4.widget.q;
import android.support.v7.d.b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView extends ViewGroup implements be, bk {
    private static final Interpolator ao = new dp();
    private static final boolean r;
    private static final Class<?>[] s = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    private final ArrayList<Object> A;
    private final ArrayList<ee> B;
    private ee C;
    private boolean D;
    private boolean E;
    private int F;
    private boolean G;
    private boolean H;
    private int I;
    private boolean J;
    private final boolean K;
    private final AccessibilityManager L;
    private List<Object> M;
    private int N;
    private int O;
    private int P;
    private VelocityTracker Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private final int W;
    final eh a;
    private final int aa;
    private float ab;
    private ef ac;
    private List<ef> ad;
    private dy ae;
    private boolean af;
    private er ag;
    private dw ah;
    private final int[] ai;
    private final bf aj;
    private final int[] ak;
    private final int[] al;
    private final int[] am;
    private Runnable an;
    private final gg ap;
    af b;
    bp c;
    final ge d;
    eb e;
    boolean f;
    boolean g;
    boolean h;
    q i;
    q j;
    q k;
    q l;
    dx m;
    final ep n;
    final en o;
    boolean p;
    boolean q;
    private final ej t;
    private SavedState u;
    private boolean v;
    private final Runnable w;
    private final Rect x;
    private dt y;
    private ei z;

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new ek();
        Parcelable a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readParcelable(eb.class.getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.a, 0);
        }
    }

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        r = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t = new ej();
        this.a = new eh(this);
        this.d = new ge();
        this.w = new dn(this);
        this.x = new Rect();
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.F = 0;
        this.h = false;
        this.N = 0;
        this.m = new bv();
        this.O = 0;
        this.P = -1;
        this.ab = Float.MIN_VALUE;
        this.n = new ep(this);
        this.o = new en();
        this.p = false;
        this.q = false;
        this.ae = new ea();
        this.af = false;
        this.ai = new int[2];
        this.ak = new int[2];
        this.al = new int[2];
        this.am = new int[2];
        this.an = new do(this);
        this.ap = new dq(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.K = VERSION.SDK_INT >= 16;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.V = viewConfiguration.getScaledTouchSlop();
        this.W = viewConfiguration.getScaledMinimumFlingVelocity();
        this.aa = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(bq.a((View) this) == 2);
        this.m.h = this.ae;
        this.b = new af(new ds(this));
        this.c = new bp(new dr(this));
        if (bq.e(this) == 0) {
            bq.c((View) this, 1);
        }
        this.L = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new er(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.RecyclerView, i, 0);
            String string = obtainStyledAttributes.getString(b.RecyclerView_layoutManager);
            obtainStyledAttributes.recycle();
            if (string != null) {
                String trim = string.trim();
                if (trim.length() != 0) {
                    r2 = trim.charAt(0) == '.' ? context.getPackageName() + trim : trim.contains(".") ? trim : RecyclerView.class.getPackage().getName() + '.' + trim;
                    try {
                        Object[] objArr;
                        Constructor constructor;
                        Class asSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(r2).asSubclass(eb.class);
                        try {
                            objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(0)};
                            constructor = asSubclass.getConstructor(s);
                        } catch (Throwable e) {
                            constructor = asSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        }
                        constructor.setAccessible(true);
                        setLayoutManager((eb) constructor.newInstance(objArr));
                    } catch (Throwable e2) {
                        e2.initCause(e);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + r2, e2);
                    } catch (Throwable e3) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + r2, e3);
                    } catch (Throwable e32) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r2, e32);
                    } catch (Throwable e322) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r2, e322);
                    } catch (Throwable e3222) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + r2, e3222);
                    } catch (Throwable e32222) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + r2, e32222);
                    }
                }
            }
        }
        this.aj = new bf(this);
        setNestedScrollingEnabled(true);
    }

    private void A() {
        int a = this.c.a();
        for (int i = 0; i < a; i++) {
            View b = this.c.b(i);
            eq a2 = a(b);
            if (!(a2 == null || a2.h == null)) {
                View view = a2.h.a;
                int left = b.getLeft();
                int top = b.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    static /* synthetic */ void a(RecyclerView recyclerView, eq eqVar, dz dzVar, dz dzVar2) {
        recyclerView.a(eqVar);
        eqVar.a(false);
        if (recyclerView.m.a(eqVar, dzVar, dzVar2)) {
            recyclerView.s();
        }
    }

    static /* synthetic */ void a(RecyclerView recyclerView, View view) {
        b(view);
        if (recyclerView.M != null) {
            for (int size = recyclerView.M.size() - 1; size >= 0; size--) {
                recyclerView.M.get(size);
            }
        }
    }

    private void a(eq eqVar) {
        View view = eqVar.a;
        boolean z = view.getParent() == this;
        this.a.b(a(view));
        if (eqVar.n()) {
            this.c.a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            bp bpVar = this.c;
            int a = bpVar.a.a(view);
            if (a < 0) {
                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
            }
            bpVar.b.a(a);
            bpVar.a(view);
        } else {
            this.c.a(view, -1, true);
        }
    }

    private void a(eq eqVar, dz dzVar) {
        eqVar.a(0, 8192);
        if (this.o.j && eqVar.s() && !eqVar.m() && !eqVar.b()) {
            this.d.a(b(eqVar), eqVar);
        }
        this.d.a(eqVar, dzVar);
    }

    private void a(MotionEvent motionEvent) {
        int b = ay.b(motionEvent);
        if (ay.b(motionEvent, b) == this.P) {
            b = b == 0 ? 1 : 0;
            this.P = ay.b(motionEvent, b);
            int c = (int) (ay.c(motionEvent, b) + 0.5f);
            this.T = c;
            this.R = c;
            b = (int) (ay.d(motionEvent, b) + 0.5f);
            this.U = b;
            this.S = b;
        }
    }

    private boolean a(int i, int i2, MotionEvent motionEvent) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        j();
        if (this.y != null) {
            a();
            p();
            e.a("RV Scroll");
            if (i != 0) {
                i5 = this.e.a(i, this.a, this.o);
                i3 = i - i5;
            }
            if (i2 != 0) {
                i6 = this.e.b(i2, this.a, this.o);
                i4 = i2 - i6;
            }
            e.a();
            A();
            q();
            a(false);
        }
        int i7 = i4;
        i4 = i5;
        i5 = i6;
        if (!this.A.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, i5, i3, i7, this.ak)) {
            this.T -= this.ak[0];
            this.U -= this.ak[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.ak[0], (float) this.ak[1]);
            }
            int[] iArr = this.am;
            iArr[0] = iArr[0] + this.ak[0];
            iArr = this.am;
            iArr[1] = iArr[1] + this.ak[1];
        } else if (bq.a((View) this) != 2) {
            if (motionEvent != null) {
                float x = motionEvent.getX();
                float f = (float) i3;
                float y = motionEvent.getY();
                float f2 = (float) i7;
                Object obj = null;
                if (f < 0.0f) {
                    b();
                    if (this.i.a((-f) / ((float) getWidth()), 1.0f - (y / ((float) getHeight())))) {
                        obj = 1;
                    }
                } else if (f > 0.0f) {
                    c();
                    if (this.k.a(f / ((float) getWidth()), y / ((float) getHeight()))) {
                        obj = 1;
                    }
                }
                if (f2 < 0.0f) {
                    d();
                    if (this.j.a((-f2) / ((float) getHeight()), x / ((float) getWidth()))) {
                        obj = 1;
                    }
                } else if (f2 > 0.0f) {
                    e();
                    if (this.l.a(f2 / ((float) getHeight()), 1.0f - (x / ((float) getWidth())))) {
                        obj = 1;
                    }
                }
                if (!(obj == null && f == 0.0f && f2 == 0.0f)) {
                    bq.d(this);
                }
            }
            b(i, i2);
        }
        if (!(i4 == 0 && i5 == 0)) {
            g();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i4 == 0 && i5 == 0) ? false : true;
    }

    static /* synthetic */ boolean a(RecyclerView recyclerView, eq eqVar) {
        return recyclerView.m == null || recyclerView.m.a(eqVar, eqVar.p());
    }

    static /* synthetic */ int b(RecyclerView recyclerView, eq eqVar) {
        if (eqVar.a(524) || !eqVar.l()) {
            return -1;
        }
        af afVar = recyclerView.b;
        int i = eqVar.b;
        int size = afVar.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ah ahVar = (ah) afVar.a.get(i2);
            switch (ahVar.a) {
                case 1:
                    if (ahVar.b > i) {
                        break;
                    }
                    i += ahVar.d;
                    break;
                case 2:
                    if (ahVar.b <= i) {
                        if (ahVar.b + ahVar.d <= i) {
                            i -= ahVar.d;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (ahVar.b != i) {
                        if (ahVar.b < i) {
                            i--;
                        }
                        if (ahVar.d > i) {
                            break;
                        }
                        i++;
                        break;
                    }
                    i = ahVar.d;
                    break;
                default:
                    break;
            }
        }
        return i;
    }

    private long b(eq eqVar) {
        return this.y.b ? eqVar.d : (long) eqVar.b;
    }

    static eq b(View view) {
        return view == null ? null : ((ed) view.getLayoutParams()).c;
    }

    private void b(int i, int i2) {
        int i3 = 0;
        if (!(this.i == null || this.i.a() || i <= 0)) {
            i3 = this.i.c();
        }
        if (!(this.k == null || this.k.a() || i >= 0)) {
            i3 |= this.k.c();
        }
        if (!(this.j == null || this.j.a() || i2 <= 0)) {
            i3 |= this.j.c();
        }
        if (!(this.l == null || this.l.a() || i2 >= 0)) {
            i3 |= this.l.c();
        }
        if (i3 != 0) {
            bq.d(this);
        }
    }

    static /* synthetic */ void b(RecyclerView recyclerView, eq eqVar, dz dzVar, dz dzVar2) {
        eqVar.a(false);
        if (recyclerView.m.b(eqVar, dzVar, dzVar2)) {
            recyclerView.s();
        }
    }

    public static int c(View view) {
        eq b = b(view);
        return b != null ? b.c() : -1;
    }

    static /* synthetic */ void c(RecyclerView recyclerView, int i) {
        if (recyclerView.e != null) {
            recyclerView.e.b(i);
            recyclerView.awakenScrollBars();
        }
    }

    private boolean c(int i, int i2) {
        int a = this.c.a();
        if (a == 0) {
            return (i == 0 && i2 == 0) ? false : true;
        } else {
            for (int i3 = 0; i3 < a; i3++) {
                eq b = b(this.c.b(i3));
                if (!b.b()) {
                    int c = b.c();
                    if (c < i || c > i2) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static /* synthetic */ boolean c(RecyclerView recyclerView, View view) {
        boolean z;
        boolean z2 = true;
        recyclerView.a();
        bp bpVar = recyclerView.c;
        int a = bpVar.a.a(view);
        if (a == -1) {
            bpVar.b(view);
            z = true;
        } else if (bpVar.b.c(a)) {
            bpVar.b.d(a);
            bpVar.b(view);
            bpVar.a.a(a);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            eq b = b(view);
            recyclerView.a.b(b);
            recyclerView.a.a(b);
        }
        if (z) {
            z2 = false;
        }
        recyclerView.a(z2);
        return z;
    }

    private void e(View view) {
        b(view);
        if (this.M != null) {
            for (int size = this.M.size() - 1; size >= 0; size--) {
                this.M.get(size);
            }
        }
    }

    private float getScrollFactor() {
        if (this.ab == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 0.0f;
            }
            this.ab = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.ab;
    }

    private void j() {
        boolean z = false;
        if (!this.f) {
            return;
        }
        if (this.h) {
            e.a("RV FullInvalidate");
            v();
            e.a();
        } else if (!this.b.d()) {
        } else {
            if (this.b.a(4) && !this.b.a(11)) {
                e.a("RV PartialInvalidate");
                a();
                this.b.b();
                if (!this.G) {
                    int a = this.c.a();
                    for (int i = 0; i < a; i++) {
                        eq b = b(this.c.b(i));
                        if (b != null && !b.b() && b.s()) {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        v();
                    } else {
                        this.b.c();
                    }
                }
                a(true);
                e.a();
            } else if (this.b.d()) {
                e.a("RV FullInvalidate");
                v();
                e.a();
            }
        }
    }

    private void k() {
        setScrollState(0);
        l();
    }

    private void l() {
        this.n.b();
        if (this.e != null) {
            this.e.q();
        }
    }

    private void m() {
        this.l = null;
        this.j = null;
        this.k = null;
        this.i = null;
    }

    private void n() {
        if (this.Q != null) {
            this.Q.clear();
        }
        stopNestedScroll();
        int i = 0;
        if (this.i != null) {
            i = this.i.c();
        }
        if (this.j != null) {
            i |= this.j.c();
        }
        if (this.k != null) {
            i |= this.k.c();
        }
        if (this.l != null) {
            i |= this.l.c();
        }
        if (i != 0) {
            bq.d(this);
        }
    }

    static /* synthetic */ void n(RecyclerView recyclerView) {
        if (!recyclerView.h) {
            int i;
            recyclerView.h = true;
            int b = recyclerView.c.b();
            for (i = 0; i < b; i++) {
                eq b2 = b(recyclerView.c.c(i));
                if (!(b2 == null || b2.b())) {
                    b2.b(512);
                }
            }
            eh ehVar = recyclerView.a;
            int size = ehVar.c.size();
            for (i = 0; i < size; i++) {
                eq eqVar = (eq) ehVar.c.get(i);
                if (eqVar != null) {
                    eqVar.b(512);
                }
            }
        }
    }

    private void o() {
        n();
        setScrollState(0);
    }

    private void p() {
        this.N++;
    }

    private void q() {
        this.N--;
        if (this.N <= 0) {
            this.N = 0;
            int i = this.I;
            this.I = 0;
            if (i != 0 && f()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(2048);
                a.a(obtain, i);
                sendAccessibilityEventUnchecked(obtain);
            }
        }
    }

    private boolean r() {
        return this.N > 0;
    }

    private void s() {
        if (!this.af && this.D) {
            bq.a((View) this, this.an);
            this.af = true;
        }
    }

    private void setScrollState(int i) {
        if (i != this.O) {
            this.O = i;
            if (i != 2) {
                l();
            }
            if (this.e != null) {
                this.e.g(i);
            }
            if (this.ad != null) {
                for (int size = this.ad.size() - 1; size >= 0; size--) {
                    this.ad.get(size);
                }
            }
        }
    }

    private boolean t() {
        return this.m != null && this.e.c();
    }

    private void u() {
        boolean z = true;
        if (this.h) {
            this.b.a();
            z();
            this.e.a();
        }
        if (t()) {
            this.b.b();
        } else {
            this.b.e();
        }
        boolean z2 = this.p || this.q;
        en enVar = this.o;
        boolean z3 = this.f && this.m != null && ((this.h || z2 || this.e.s) && (!this.h || this.y.b));
        enVar.h = z3;
        en enVar2 = this.o;
        if (!(this.o.h && z2 && !this.h && t())) {
            z = false;
        }
        enVar2.i = z;
    }

    private void v() {
        if (this.y == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.e == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.o.k = false;
            if (this.o.b == 1) {
                w();
                this.e.b(this);
                x();
            } else {
                int i;
                af afVar = this.b;
                if (afVar.b.isEmpty() || afVar.a.isEmpty()) {
                    boolean z = false;
                } else {
                    i = 1;
                }
                if (i == 0 && MeasureSpec.getSize(this.e.w) == getWidth() && MeasureSpec.getSize(this.e.x) == getHeight()) {
                    this.e.b(this);
                } else {
                    this.e.b(this);
                    x();
                }
            }
            this.o.a(4);
            a();
            p();
            this.o.b = 1;
            if (this.o.h) {
                for (int a = this.c.a() - 1; a >= 0; a--) {
                    eq b = b(this.c.b(a));
                    if (!b.b()) {
                        long b2 = b(b);
                        dz a2 = new dz().a(b);
                        eq eqVar = (eq) this.d.b.a(b2);
                        if (!(eqVar == null || eqVar.b())) {
                            boolean a3 = this.d.a(eqVar);
                            boolean a4 = this.d.a(b);
                            if (!(a3 && eqVar == b)) {
                                dz a5 = this.d.a(eqVar, 4);
                                this.d.b(b, a2);
                                a2 = this.d.a(b, 8);
                                if (a5 == null) {
                                    int a6 = this.c.a();
                                    int i2 = 0;
                                    while (i2 < a6) {
                                        eq b3 = b(this.c.b(i2));
                                        if (b3 == b || b(b3) != b2) {
                                            i2++;
                                        } else if (this.y == null || !this.y.b) {
                                            throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + b3 + " \n View Holder 2:" + b);
                                        } else {
                                            throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + b3 + " \n View Holder 2:" + b);
                                        }
                                    }
                                    Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + eqVar + " cannot be found but it is necessary for " + b);
                                } else {
                                    eqVar.a(false);
                                    if (a3) {
                                        a(eqVar);
                                    }
                                    if (eqVar != b) {
                                        if (a4) {
                                            a(b);
                                        }
                                        eqVar.g = b;
                                        a(eqVar);
                                        this.a.b(eqVar);
                                        b.a(false);
                                        b.h = eqVar;
                                    }
                                    if (this.m.a(eqVar, b, a5, a2)) {
                                        s();
                                    }
                                }
                            }
                        }
                        this.d.b(b, a2);
                    }
                }
                this.d.a(this.ap);
            }
            this.e.b(this.a);
            this.o.d = this.o.c;
            this.h = false;
            this.o.h = false;
            this.o.i = false;
            this.e.s = false;
            if (this.a.b != null) {
                this.a.b.clear();
            }
            q();
            a(false);
            this.d.a();
            if (c(this.ai[0], this.ai[1])) {
                g();
            }
        }
    }

    private void w() {
        int i;
        int c;
        eq b;
        this.o.a(1);
        this.o.k = false;
        a();
        this.d.a();
        p();
        u();
        en enVar = this.o;
        boolean z = this.o.h && this.q;
        enVar.j = z;
        this.q = false;
        this.p = false;
        this.o.g = this.o.i;
        this.o.c = this.y.a();
        int[] iArr = this.ai;
        int a = this.c.a();
        if (a == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
        } else {
            i = Integer.MAX_VALUE;
            int i2 = Integer.MIN_VALUE;
            int i3 = 0;
            while (i3 < a) {
                eq b2 = b(this.c.b(i3));
                if (!b2.b()) {
                    c = b2.c();
                    if (c < i) {
                        i = c;
                    }
                    if (c > i2) {
                        i3++;
                        i2 = c;
                    }
                }
                c = i2;
                i3++;
                i2 = c;
            }
            iArr[0] = i;
            iArr[1] = i2;
        }
        if (this.o.h) {
            c = this.c.a();
            for (i = 0; i < c; i++) {
                b = b(this.c.b(i));
                if (!b.b() && (!b.j() || this.y.b)) {
                    dx.d(b);
                    b.p();
                    this.d.a(b, new dz().a(b));
                    if (!(!this.o.j || !b.s() || b.m() || b.b() || b.j())) {
                        this.d.a(b(b), b);
                    }
                }
            }
        }
        if (this.o.i) {
            c = this.c.b();
            for (i = 0; i < c; i++) {
                b = b(this.c.c(i));
                if (!b.b() && b.c == -1) {
                    b.c = b.b;
                }
            }
            z = this.o.f;
            this.o.f = false;
            this.e.c(this.a, this.o);
            this.o.f = z;
            for (c = 0; c < this.c.a(); c++) {
                b = b(this.c.b(c));
                if (!b.b()) {
                    gf gfVar = (gf) this.d.a.get(b);
                    if (gfVar == null || (gfVar.a & 4) == 0) {
                        z = false;
                    } else {
                        i = 1;
                    }
                    if (i == 0) {
                        dx.d(b);
                        z = b.a(8192);
                        b.p();
                        dz a2 = new dz().a(b);
                        if (z) {
                            a(b, a2);
                        } else {
                            ge geVar = this.d;
                            gfVar = (gf) geVar.a.get(b);
                            if (gfVar == null) {
                                gfVar = gf.a();
                                geVar.a.put(b, gfVar);
                            }
                            gfVar.a |= 2;
                            gfVar.b = a2;
                        }
                    }
                }
            }
            y();
        } else {
            y();
        }
        q();
        a(false);
        this.o.b = 2;
    }

    private void x() {
        a();
        p();
        this.o.a(6);
        this.b.e();
        this.o.c = this.y.a();
        this.o.e = 0;
        this.o.g = false;
        this.e.c(this.a, this.o);
        this.o.f = false;
        this.u = null;
        en enVar = this.o;
        boolean z = this.o.h && this.m != null;
        enVar.h = z;
        this.o.b = 4;
        q();
        a(false);
    }

    private void y() {
        int i = 0;
        int b = this.c.b();
        for (int i2 = 0; i2 < b; i2++) {
            eq b2 = b(this.c.c(i2));
            if (!b2.b()) {
                b2.a();
            }
        }
        eh ehVar = this.a;
        int size = ehVar.c.size();
        for (b = 0; b < size; b++) {
            ((eq) ehVar.c.get(b)).a();
        }
        size = ehVar.a.size();
        for (b = 0; b < size; b++) {
            ((eq) ehVar.a.get(b)).a();
        }
        if (ehVar.b != null) {
            b = ehVar.b.size();
            while (i < b) {
                ((eq) ehVar.b.get(i)).a();
                i++;
            }
        }
    }

    private void z() {
        int i = 0;
        int b = this.c.b();
        for (int i2 = 0; i2 < b; i2++) {
            eq b2 = b(this.c.c(i2));
            if (!(b2 == null || b2.b())) {
                b2.b(6);
            }
        }
        int b3 = this.c.b();
        for (b = 0; b < b3; b++) {
            ((ed) this.c.c(b).getLayoutParams()).e = true;
        }
        eh ehVar = this.a;
        int size = ehVar.c.size();
        for (b = 0; b < size; b++) {
            ed edVar = (ed) ((eq) ehVar.c.get(b)).a.getLayoutParams();
            if (edVar != null) {
                edVar.e = true;
            }
        }
        eh ehVar2 = this.a;
        if (ehVar2.h.y == null || !ehVar2.h.y.b) {
            ehVar2.b();
            return;
        }
        b3 = ehVar2.c.size();
        while (i < b3) {
            eq eqVar = (eq) ehVar2.c.get(i);
            if (eqVar != null) {
                eqVar.b(6);
                eqVar.a(null);
            }
            i++;
        }
    }

    public final eq a(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return b(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    final void a() {
        this.F++;
        if (this.F == 1 && !this.g) {
            this.G = false;
        }
    }

    final void a(int i, int i2) {
        setMeasuredDimension(eb.a(i, getPaddingLeft() + getPaddingRight(), bq.p(this)), eb.a(i2, getPaddingTop() + getPaddingBottom(), bq.q(this)));
    }

    final void a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int b = this.c.b();
        for (int i4 = 0; i4 < b; i4++) {
            eq b2 = b(this.c.c(i4));
            if (!(b2 == null || b2.b())) {
                if (b2.b >= i3) {
                    b2.a(-i2, z);
                    this.o.f = true;
                } else if (b2.b >= i) {
                    int i5 = i - 1;
                    int i6 = -i2;
                    b2.b(8);
                    b2.a(i6, z);
                    b2.b = i5;
                    this.o.f = true;
                }
            }
        }
        eh ehVar = this.a;
        int i7 = i + i2;
        for (i3 = ehVar.c.size() - 1; i3 >= 0; i3--) {
            eq eqVar = (eq) ehVar.c.get(i3);
            if (eqVar != null) {
                if (eqVar.b >= i7) {
                    eqVar.a(-i2, z);
                } else if (eqVar.b >= i) {
                    eqVar.b(8);
                    ehVar.c(i3);
                }
            }
        }
        requestLayout();
    }

    final void a(String str) {
        if (!r()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    final void a(boolean z) {
        if (this.F <= 0) {
            this.F = 1;
        }
        if (!z) {
            this.G = false;
        }
        if (this.F == 1) {
            if (!(!z || !this.G || this.g || this.e == null || this.y == null)) {
                v();
            }
            if (!this.g) {
                this.G = false;
            }
        }
        this.F--;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        super.addFocusables(arrayList, i, i2);
    }

    final void b() {
        if (this.i == null) {
            this.i = new q(getContext());
            if (this.v) {
                this.i.a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.i.a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    final void c() {
        if (this.k == null) {
            this.k = new q(getContext());
            if (this.v) {
                this.k.a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.k.a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof ed) && this.e.a((ed) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        return (this.e != null && this.e.e()) ? this.e.c(this.o) : 0;
    }

    public int computeHorizontalScrollOffset() {
        return (this.e != null && this.e.e()) ? this.e.a(this.o) : 0;
    }

    public int computeHorizontalScrollRange() {
        return (this.e != null && this.e.e()) ? this.e.e(this.o) : 0;
    }

    public int computeVerticalScrollExtent() {
        return (this.e != null && this.e.f()) ? this.e.d(this.o) : 0;
    }

    public int computeVerticalScrollOffset() {
        return (this.e != null && this.e.f()) ? this.e.b(this.o) : 0;
    }

    public int computeVerticalScrollRange() {
        return (this.e != null && this.e.f()) ? this.e.f(this.o) : 0;
    }

    final Rect d(View view) {
        ed edVar = (ed) view.getLayoutParams();
        if (!edVar.e) {
            return edVar.d;
        }
        Rect rect = edVar.d;
        rect.set(0, 0, 0, 0);
        int size = this.A.size();
        for (int i = 0; i < size; i++) {
            this.x.set(0, 0, 0, 0);
            this.A.get(i);
            Rect rect2 = this.x;
            ((ed) view.getLayoutParams()).c.c();
            rect2.set(0, 0, 0, 0);
            rect.left += this.x.left;
            rect.top += this.x.top;
            rect.right += this.x.right;
            rect.bottom += this.x.bottom;
        }
        edVar.e = false;
        return rect;
    }

    final void d() {
        if (this.j == null) {
            this.j = new q(getContext());
            if (this.v) {
                this.j.a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.j.a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.aj.a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.aj.a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.aj.a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.aj.a(i, i2, i3, i4, iArr);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        int i;
        int i2 = 1;
        int i3 = 0;
        super.draw(canvas);
        int size = this.A.size();
        for (i = 0; i < size; i++) {
            this.A.get(i);
        }
        if (this.i == null || this.i.a()) {
            i = 0;
        } else {
            size = canvas.save();
            i = this.v ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i + (-getHeight())), 0.0f);
            i = (this.i == null || !this.i.a(canvas)) ? 0 : 1;
            canvas.restoreToCount(size);
        }
        if (!(this.j == null || this.j.a())) {
            int save = canvas.save();
            if (this.v) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            size = (this.j == null || !this.j.a(canvas)) ? 0 : 1;
            i |= size;
            canvas.restoreToCount(save);
        }
        if (!(this.k == null || this.k.a())) {
            save = canvas.save();
            int width = getWidth();
            size = this.v ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-size), (float) (-width));
            size = (this.k == null || !this.k.a(canvas)) ? 0 : 1;
            i |= size;
            canvas.restoreToCount(save);
        }
        if (!(this.l == null || this.l.a())) {
            size = canvas.save();
            canvas.rotate(180.0f);
            if (this.v) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.l != null && this.l.a(canvas)) {
                i3 = 1;
            }
            i |= i3;
            canvas.restoreToCount(size);
        }
        if (i != 0 || this.m == null || this.A.size() <= 0 || !this.m.b()) {
            i2 = i;
        }
        if (i2 != 0) {
            bq.d(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    final void e() {
        if (this.l == null) {
            this.l = new q(getContext());
            if (this.v) {
                this.l.a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.l.a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    final boolean f() {
        return this.L != null && this.L.isEnabled();
    }

    public View focusSearch(View view, int i) {
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (!(findNextFocus != null || this.y == null || this.e == null || r() || this.g)) {
            a();
            findNextFocus = this.e.a(view, i, this.a, this.o);
            a(false);
        }
        return findNextFocus != null ? findNextFocus : super.focusSearch(view, i);
    }

    final void g() {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        if (this.ad != null) {
            for (scrollX = this.ad.size() - 1; scrollX >= 0; scrollX--) {
                this.ad.get(scrollX);
            }
        }
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.e != null) {
            return this.e.b();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.e != null) {
            return this.e.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (this.e != null) {
            return this.e.a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public dt getAdapter() {
        return this.y;
    }

    public int getBaseline() {
        return this.e != null ? -1 : super.getBaseline();
    }

    protected int getChildDrawingOrder(int i, int i2) {
        return this.ah == null ? super.getChildDrawingOrder(i, i2) : this.ah.a();
    }

    public er getCompatAccessibilityDelegate() {
        return this.ag;
    }

    public dx getItemAnimator() {
        return this.m;
    }

    public eb getLayoutManager() {
        return this.e;
    }

    public int getMaxFlingVelocity() {
        return this.aa;
    }

    public int getMinFlingVelocity() {
        return this.W;
    }

    public eg getRecycledViewPool() {
        return this.a.c();
    }

    public int getScrollState() {
        return this.O;
    }

    public boolean hasNestedScrollingParent() {
        return this.aj.a();
    }

    public boolean isAttachedToWindow() {
        return this.D;
    }

    public boolean isNestedScrollingEnabled() {
        return this.aj.a;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.N = 0;
        this.D = true;
        this.f = false;
        if (this.e != null) {
            this.e.t = true;
        }
        this.af = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.m != null) {
            this.m.d();
        }
        this.f = false;
        k();
        this.D = false;
        if (this.e != null) {
            this.e.b(this, this.a);
        }
        removeCallbacks(this.an);
        gf.b();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.A.size();
        for (int i = 0; i < size; i++) {
            this.A.get(i);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.e == null || this.g || (ay.d(motionEvent) & 2) == 0 || motionEvent.getAction() != 8)) {
            float f = this.e.f() ? -ay.e(motionEvent, 9) : 0.0f;
            float e = this.e.e() ? ay.e(motionEvent, 10) : 0.0f;
            if (!(f == 0.0f && e == 0.0f)) {
                float scrollFactor = getScrollFactor();
                a((int) (e * scrollFactor), (int) (f * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        if (this.g) {
            return false;
        }
        int i2;
        boolean z;
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.C = null;
        }
        int size = this.B.size();
        for (i2 = 0; i2 < size; i2++) {
            ee eeVar = (ee) this.B.get(i2);
            if (eeVar.a() && action != 3) {
                this.C = eeVar;
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            o();
            return true;
        } else if (this.e == null) {
            return false;
        } else {
            z = this.e.e();
            boolean f = this.e.f();
            if (this.Q == null) {
                this.Q = VelocityTracker.obtain();
            }
            this.Q.addMovement(motionEvent);
            action = ay.a(motionEvent);
            size = ay.b(motionEvent);
            int i3;
            switch (action) {
                case 0:
                    if (this.H) {
                        this.H = false;
                    }
                    this.P = ay.b(motionEvent, 0);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.T = i;
                    this.R = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.U = i;
                    this.S = i;
                    if (this.O == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.am;
                    this.am[1] = 0;
                    iArr[0] = 0;
                    i3 = z ? 1 : 0;
                    if (f) {
                        i3 |= 2;
                    }
                    startNestedScroll(i3);
                    break;
                case 1:
                    this.Q.clear();
                    stopNestedScroll();
                    break;
                case 2:
                    action = ay.a(motionEvent, this.P);
                    if (action >= 0) {
                        size = (int) (ay.c(motionEvent, action) + 0.5f);
                        action = (int) (ay.d(motionEvent, action) + 0.5f);
                        if (this.O != 1) {
                            size -= this.R;
                            action -= this.S;
                            if (!z || Math.abs(size) <= this.V) {
                                z = false;
                            } else {
                                this.T = ((size < 0 ? -1 : 1) * this.V) + this.R;
                                z = true;
                            }
                            if (f && Math.abs(action) > this.V) {
                                i3 = this.S;
                                i2 = this.V;
                                if (action >= 0) {
                                    i = 1;
                                }
                                this.U = i3 + (i * i2);
                                z = true;
                            }
                            if (z) {
                                setScrollState(1);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.P + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    o();
                    break;
                case 5:
                    this.P = ay.b(motionEvent, size);
                    i3 = (int) (ay.c(motionEvent, size) + 0.5f);
                    this.T = i3;
                    this.R = i3;
                    i3 = (int) (ay.d(motionEvent, size) + 0.5f);
                    this.U = i3;
                    this.S = i3;
                    break;
                case 6:
                    a(motionEvent);
                    break;
            }
            return this.O == 1;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        e.a("RV OnLayout");
        v();
        e.a();
        this.f = true;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.e == null) {
            a(i, i2);
        } else if (this.e.u) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.e.g(i, i2);
            if (!z && this.y != null) {
                if (this.o.b == 1) {
                    w();
                }
                this.e.e(i, i2);
                this.o.k = true;
                x();
                this.e.f(i, i2);
                if (this.e.i()) {
                    this.e.e(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.o.k = true;
                    x();
                    this.e.f(i, i2);
                }
            }
        } else if (this.E) {
            this.e.g(i, i2);
        } else {
            if (this.J) {
                a();
                u();
                if (this.o.i) {
                    this.o.g = true;
                } else {
                    this.b.e();
                    this.o.g = false;
                }
                this.J = false;
                a(false);
            }
            if (this.y != null) {
                this.o.c = this.y.a();
            } else {
                this.o.c = 0;
            }
            a();
            this.e.g(i, i2);
            a(false);
            this.o.g = false;
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        this.u = (SavedState) parcelable;
        super.onRestoreInstanceState(this.u.getSuperState());
        if (this.e != null && this.u.a != null) {
            this.e.a(this.u.a);
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.u != null) {
            savedState.a = this.u.a;
        } else if (this.e != null) {
            savedState.a = this.e.d();
        } else {
            savedState.a = null;
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            m();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.g || this.H) {
            return false;
        }
        boolean z2;
        boolean e;
        boolean f;
        MotionEvent obtain;
        int b;
        float f2;
        float f3;
        int i;
        int c;
        int d;
        boolean z3;
        int action = motionEvent.getAction();
        if (this.C != null) {
            if (action == 0) {
                this.C = null;
            } else {
                if (action == 3 || action == 1) {
                    this.C = null;
                }
                z2 = true;
                if (z2) {
                    o();
                    return true;
                } else if (this.e != null) {
                    return false;
                } else {
                    e = this.e.e();
                    f = this.e.f();
                    if (this.Q == null) {
                        this.Q = VelocityTracker.obtain();
                    }
                    obtain = MotionEvent.obtain(motionEvent);
                    action = ay.a(motionEvent);
                    b = ay.b(motionEvent);
                    if (action == 0) {
                        int[] iArr = this.am;
                        this.am[1] = 0;
                        iArr[0] = 0;
                    }
                    obtain.offsetLocation((float) this.am[0], (float) this.am[1]);
                    switch (action) {
                        case 0:
                            this.P = ay.b(motionEvent, 0);
                            action = (int) (motionEvent.getX() + 0.5f);
                            this.T = action;
                            this.R = action;
                            action = (int) (motionEvent.getY() + 0.5f);
                            this.U = action;
                            this.S = action;
                            action = e ? 1 : 0;
                            if (f) {
                                action |= 2;
                            }
                            startNestedScroll(action);
                            break;
                        case 1:
                            this.Q.addMovement(obtain);
                            this.Q.computeCurrentVelocity(1000, (float) this.aa);
                            f2 = e ? -bm.a(this.Q, this.P) : 0.0f;
                            f3 = f ? -bm.b(this.Q, this.P) : 0.0f;
                            if (!(f2 == 0.0f && f3 == 0.0f)) {
                                i = (int) f2;
                                action = (int) f3;
                                if (this.e == null) {
                                    if (!this.g) {
                                        e = this.e.e();
                                        f = this.e.f();
                                        if (!e || Math.abs(i) < this.W) {
                                            i = 0;
                                        }
                                        b = (f || Math.abs(action) < this.W) ? 0 : action;
                                        if (!((i == 0 && b == 0) || dispatchNestedPreFling((float) i, (float) b))) {
                                            z2 = e || f;
                                            dispatchNestedFling((float) i, (float) b, z2);
                                            if (z2) {
                                                i = Math.max(-this.aa, Math.min(i, this.aa));
                                                b = Math.max(-this.aa, Math.min(b, this.aa));
                                                ep epVar = this.n;
                                                epVar.d.setScrollState(2);
                                                epVar.b = 0;
                                                epVar.a = 0;
                                                epVar.c.a(0, i, b, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                                                epVar.a();
                                                z2 = true;
                                                break;
                                            }
                                        }
                                    }
                                }
                                Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                                z2 = false;
                                break;
                            }
                            setScrollState(0);
                            n();
                            z = true;
                            break;
                        case 2:
                            action = ay.a(motionEvent, this.P);
                            if (action < 0) {
                                c = (int) (ay.c(motionEvent, action) + 0.5f);
                                d = (int) (ay.d(motionEvent, action) + 0.5f);
                                i = this.T - c;
                                action = this.U - d;
                                if (dispatchNestedPreScroll(i, action, this.al, this.ak)) {
                                    i -= this.al[0];
                                    action -= this.al[1];
                                    obtain.offsetLocation((float) this.ak[0], (float) this.ak[1]);
                                    int[] iArr2 = this.am;
                                    iArr2[0] = iArr2[0] + this.ak[0];
                                    iArr2 = this.am;
                                    iArr2[1] = iArr2[1] + this.ak[1];
                                }
                                if (this.O != 1) {
                                    if (e || Math.abs(i) <= this.V) {
                                        z3 = false;
                                    } else {
                                        i = i > 0 ? i - this.V : i + this.V;
                                        z3 = true;
                                    }
                                    if (f && Math.abs(action) > this.V) {
                                        action = action <= 0 ? action - this.V : action + this.V;
                                        z3 = true;
                                    }
                                    if (z3) {
                                        setScrollState(1);
                                    }
                                }
                                if (this.O == 1) {
                                    this.T = c - this.ak[0];
                                    this.U = d - this.ak[1];
                                    if (!e) {
                                        i = 0;
                                    }
                                    if (!f) {
                                        action = 0;
                                    }
                                    if (a(i, action, obtain)) {
                                        getParent().requestDisallowInterceptTouchEvent(true);
                                        break;
                                    }
                                }
                            }
                            Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.P + " not found. Did any MotionEvents get skipped?");
                            return false;
                            break;
                        case 3:
                            o();
                            break;
                        case 5:
                            this.P = ay.b(motionEvent, b);
                            action = (int) (ay.c(motionEvent, b) + 0.5f);
                            this.T = action;
                            this.R = action;
                            action = (int) (ay.d(motionEvent, b) + 0.5f);
                            this.U = action;
                            this.S = action;
                            break;
                        case 6:
                            a(motionEvent);
                            break;
                    }
                    if (!z) {
                        this.Q.addMovement(obtain);
                    }
                    obtain.recycle();
                    return true;
                }
            }
        }
        if (action != 0) {
            int size = this.B.size();
            for (b = 0; b < size; b++) {
                ee eeVar = (ee) this.B.get(b);
                if (eeVar.a()) {
                    this.C = eeVar;
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        if (z2) {
            o();
            return true;
        } else if (this.e != null) {
            return false;
        } else {
            e = this.e.e();
            f = this.e.f();
            if (this.Q == null) {
                this.Q = VelocityTracker.obtain();
            }
            obtain = MotionEvent.obtain(motionEvent);
            action = ay.a(motionEvent);
            b = ay.b(motionEvent);
            if (action == 0) {
                int[] iArr3 = this.am;
                this.am[1] = 0;
                iArr3[0] = 0;
            }
            obtain.offsetLocation((float) this.am[0], (float) this.am[1]);
            switch (action) {
                case 0:
                    this.P = ay.b(motionEvent, 0);
                    action = (int) (motionEvent.getX() + 0.5f);
                    this.T = action;
                    this.R = action;
                    action = (int) (motionEvent.getY() + 0.5f);
                    this.U = action;
                    this.S = action;
                    if (e) {
                    }
                    if (f) {
                        action |= 2;
                    }
                    startNestedScroll(action);
                    break;
                case 1:
                    this.Q.addMovement(obtain);
                    this.Q.computeCurrentVelocity(1000, (float) this.aa);
                    if (e) {
                    }
                    if (f) {
                    }
                    i = (int) f2;
                    action = (int) f3;
                    if (this.e == null) {
                        if (this.g) {
                            e = this.e.e();
                            f = this.e.f();
                            i = 0;
                            if (f) {
                                break;
                            }
                            if (!e) {
                            }
                            dispatchNestedFling((float) i, (float) b, z2);
                            if (z2) {
                                i = Math.max(-this.aa, Math.min(i, this.aa));
                                b = Math.max(-this.aa, Math.min(b, this.aa));
                                ep epVar2 = this.n;
                                epVar2.d.setScrollState(2);
                                epVar2.b = 0;
                                epVar2.a = 0;
                                epVar2.c.a(0, i, b, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                                epVar2.a();
                                z2 = true;
                                break;
                            }
                            break;
                        }
                    }
                    Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                    z2 = false;
                    break;
                case 2:
                    action = ay.a(motionEvent, this.P);
                    if (action < 0) {
                        c = (int) (ay.c(motionEvent, action) + 0.5f);
                        d = (int) (ay.d(motionEvent, action) + 0.5f);
                        i = this.T - c;
                        action = this.U - d;
                        if (dispatchNestedPreScroll(i, action, this.al, this.ak)) {
                            i -= this.al[0];
                            action -= this.al[1];
                            obtain.offsetLocation((float) this.ak[0], (float) this.ak[1]);
                            int[] iArr22 = this.am;
                            iArr22[0] = iArr22[0] + this.ak[0];
                            iArr22 = this.am;
                            iArr22[1] = iArr22[1] + this.ak[1];
                        }
                        if (this.O != 1) {
                            if (e) {
                                break;
                            }
                            z3 = false;
                            if (action <= 0) {
                            }
                            z3 = true;
                            if (z3) {
                                setScrollState(1);
                            }
                            break;
                        }
                        if (this.O == 1) {
                            this.T = c - this.ak[0];
                            this.U = d - this.ak[1];
                            if (e) {
                                i = 0;
                            }
                            if (f) {
                                action = 0;
                            }
                            if (a(i, action, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.P + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    o();
                    break;
                case 5:
                    this.P = ay.b(motionEvent, b);
                    action = (int) (ay.c(motionEvent, b) + 0.5f);
                    this.T = action;
                    this.R = action;
                    action = (int) (ay.d(motionEvent, b) + 0.5f);
                    this.U = action;
                    this.S = action;
                    break;
                case 6:
                    a(motionEvent);
                    break;
            }
            if (z) {
                this.Q.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    protected void removeDetachedView(View view, boolean z) {
        eq b = b(view);
        if (b != null) {
            if (b.n()) {
                b.i();
            } else if (!b.b()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + b);
            }
        }
        e(view);
        super.removeDetachedView(view, z);
    }

    public void requestChildFocus(View view, View view2) {
        int i = (this.e.k() || r()) ? 1 : 0;
        if (i == 0 && view2 != null) {
            this.x.set(0, 0, view2.getWidth(), view2.getHeight());
            LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof ed) {
                ed edVar = (ed) layoutParams;
                if (!edVar.e) {
                    Rect rect = edVar.d;
                    Rect rect2 = this.x;
                    rect2.left -= rect.left;
                    rect2 = this.x;
                    rect2.right += rect.right;
                    rect2 = this.x;
                    rect2.top -= rect.top;
                    rect2 = this.x;
                    rect2.bottom = rect.bottom + rect2.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.x);
            offsetRectIntoDescendantCoords(view, this.x);
            requestChildRectangleOnScreen(view, this.x, !this.f);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        eb ebVar = this.e;
        int m = ebVar.m();
        int n = ebVar.n();
        int size = MeasureSpec.getSize(ebVar.w) - ebVar.o();
        int size2 = MeasureSpec.getSize(ebVar.x) - ebVar.p();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int width = left + rect.width();
        int height = top + rect.height();
        int min = Math.min(0, left - m);
        int min2 = Math.min(0, top - n);
        int max = Math.max(0, width - size);
        size2 = Math.max(0, height - size2);
        if (bq.h(ebVar.q) != 1) {
            max = min != 0 ? min : Math.min(left - m, max);
        } else if (max == 0) {
            max = Math.max(min, width - size);
        }
        min = min2 != 0 ? min2 : Math.min(top - n, size2);
        if (max == 0 && min == 0) {
            return false;
        }
        if (z) {
            scrollBy(max, min);
        } else if (this.e == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.g) {
            if (!this.e.e()) {
                max = 0;
            }
            if (!this.e.f()) {
                min = 0;
            }
            if (!(max == 0 && min == 0)) {
                this.n.a(max, min);
            }
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.B.size();
        for (int i = 0; i < size; i++) {
            this.B.get(i);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        if (this.F != 0 || this.g) {
            this.G = true;
        } else {
            super.requestLayout();
        }
    }

    public void scrollBy(int i, int i2) {
        if (this.e == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.g) {
            boolean e = this.e.e();
            boolean f = this.e.f();
            if (e || f) {
                if (!e) {
                    i = 0;
                }
                if (!f) {
                    i2 = 0;
                }
                a(i, i2, null);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (r()) {
            int b = accessibilityEvent != null ? a.b(accessibilityEvent) : 0;
            if (b != 0) {
                i = b;
            }
            this.I = i | this.I;
            i = 1;
        }
        if (i == 0) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(er erVar) {
        this.ag = erVar;
        bq.a((View) this, this.ag);
    }

    public void setAdapter(dt dtVar) {
        dt dtVar2;
        setLayoutFrozen(false);
        if (this.y != null) {
            dtVar2 = this.y;
            dtVar2.a.unregisterObserver(this.t);
        }
        if (this.m != null) {
            this.m.d();
        }
        if (this.e != null) {
            this.e.c(this.a);
            this.e.b(this.a);
        }
        this.a.a();
        this.b.a();
        dtVar2 = this.y;
        this.y = dtVar;
        if (dtVar != null) {
            dtVar.a.registerObserver(this.t);
        }
        eh ehVar = this.a;
        dt dtVar3 = this.y;
        ehVar.a();
        eg c = ehVar.c();
        if (dtVar2 != null) {
            c.b();
        }
        if (c.c == 0) {
            c.a.clear();
        }
        if (dtVar3 != null) {
            c.a();
        }
        this.o.f = true;
        z();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(dw dwVar) {
        if (dwVar != this.ah) {
            this.ah = dwVar;
            setChildrenDrawingOrderEnabled(this.ah != null);
        }
    }

    public void setClipToPadding(boolean z) {
        if (z != this.v) {
            m();
        }
        this.v = z;
        super.setClipToPadding(z);
        if (this.f) {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean z) {
        this.E = z;
    }

    public void setItemAnimator(dx dxVar) {
        if (this.m != null) {
            this.m.d();
            this.m.h = null;
        }
        this.m = dxVar;
        if (this.m != null) {
            this.m.h = this.ae;
        }
    }

    public void setItemViewCacheSize(int i) {
        eh ehVar = this.a;
        ehVar.e = i;
        for (int size = ehVar.c.size() - 1; size >= 0 && ehVar.c.size() > i; size--) {
            ehVar.c(size);
        }
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.g) {
            a("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.g = true;
                this.H = true;
                k();
                return;
            }
            this.g = false;
            if (!(!this.G || this.e == null || this.y == null)) {
                requestLayout();
            }
            this.G = false;
        }
    }

    public void setLayoutManager(eb ebVar) {
        if (ebVar != this.e) {
            k();
            if (this.e != null) {
                if (this.D) {
                    this.e.b(this, this.a);
                }
                this.e.a(null);
            }
            this.a.a();
            bp bpVar = this.c;
            bq bqVar = bpVar.b;
            while (true) {
                bqVar.a = 0;
                if (bqVar.b == null) {
                    break;
                }
                bqVar = bqVar.b;
            }
            for (int size = bpVar.c.size() - 1; size >= 0; size--) {
                bpVar.a.d((View) bpVar.c.get(size));
                bpVar.c.remove(size);
            }
            bpVar.a.b();
            this.e = ebVar;
            if (ebVar != null) {
                if (ebVar.q != null) {
                    throw new IllegalArgumentException("LayoutManager " + ebVar + " is already attached to a RecyclerView: " + ebVar.q);
                }
                this.e.a(this);
                if (this.D) {
                    this.e.t = true;
                }
            }
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.aj.a(z);
    }

    @Deprecated
    public void setOnScrollListener(ef efVar) {
        this.ac = efVar;
    }

    public void setRecycledViewPool(eg egVar) {
        eh ehVar = this.a;
        if (ehVar.f != null) {
            ehVar.f.b();
        }
        ehVar.f = egVar;
        if (egVar != null) {
            eg egVar2 = ehVar.f;
            ehVar.h.getAdapter();
            egVar2.a();
        }
    }

    public void setRecyclerListener(ei eiVar) {
        this.z = eiVar;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.V = cj.a(viewConfiguration);
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.V = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(eo eoVar) {
        this.a.g = eoVar;
    }

    public boolean startNestedScroll(int i) {
        return this.aj.a(i);
    }

    public void stopNestedScroll() {
        this.aj.b();
    }
}
