package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.e.a;
import android.support.v4.widget.q;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final dc ai = new dc();
    private static final int[] b = new int[]{16842931};
    private static final Comparator<cu> d = new cp();
    private static final Interpolator e = new cq();
    private boolean A;
    private int B = 1;
    private boolean C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private float H;
    private float I;
    private float J;
    private float K;
    private int L = -1;
    private VelocityTracker M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private boolean R;
    private q S;
    private q T;
    private boolean U = true;
    private boolean V = false;
    private boolean W;
    public List<cy> a;
    private int aa;
    private cy ab;
    private cy ac;
    private cx ad;
    private cz ae;
    private Method af;
    private int ag;
    private ArrayList<View> ah;
    private final Runnable aj = new cr(this);
    private int ak = 0;
    private int c;
    private final ArrayList<cu> f = new ArrayList();
    private final cu g = new cu();
    private final Rect h = new Rect();
    private bj i;
    private int j;
    private int k = -1;
    private Parcelable l = null;
    private ClassLoader m = null;
    private Scroller n;
    private boolean o;
    private da p;
    private int q;
    private Drawable r;
    private int s;
    private int t;
    private float u = -3.4028235E38f;
    private float v = Float.MAX_VALUE;
    private int w;
    private int x;
    private boolean y;
    private boolean z;

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = a.a(new db());
        int a;
        Parcelable b;
        ClassLoader c;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.a = parcel.readInt();
            this.b = parcel.readParcelable(classLoader);
            this.c = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeParcelable(this.b, i);
        }
    }

    public ViewPager(Context context) {
        super(context);
        d();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    private Rect a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private cu a(int i, int i2) {
        cu cuVar = new cu();
        cuVar.b = i;
        cuVar.a = this.i.a((ViewGroup) this, i);
        cuVar.d = 1.0f;
        if (i2 < 0 || i2 >= this.f.size()) {
            this.f.add(cuVar);
        } else {
            this.f.add(i2, cuVar);
        }
        return cuVar;
    }

    private cu a(View view) {
        for (int i = 0; i < this.f.size(); i++) {
            cu cuVar = (cu) this.f.get(i);
            if (this.i.a(view, cuVar.a)) {
                return cuVar;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int i) {
        cu cuVar;
        if (this.j != i) {
            cu b = b(this.j);
            this.j = i;
            cuVar = b;
        } else {
            cuVar = null;
        }
        if (this.i == null) {
            e();
        } else if (this.A) {
            e();
        } else if (getWindowToken() != null) {
            int i2 = this.B;
            int max = Math.max(0, this.j - i2);
            int min = Math.min(2, i2 + this.j);
            if (3 != this.c) {
                String resourceName;
                try {
                    resourceName = getResources().getResourceName(getId());
                } catch (NotFoundException e) {
                    resourceName = Integer.toHexString(getId());
                }
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.c + ", found: 3 Pager id: " + resourceName + " Pager class: " + getClass() + " Problematic adapter: " + this.i.getClass());
            }
            cu cuVar2;
            int i3 = 0;
            while (i3 < this.f.size()) {
                b = (cu) this.f.get(i3);
                if (b.b < this.j) {
                    i3++;
                }
            }
            b = null;
            cu a = b == null ? a(this.j, i3) : b;
            if (a != null) {
                int i4 = i3 - 1;
                b = i4 >= 0 ? (cu) this.f.get(i4) : null;
                int clientWidth = getClientWidth();
                float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - a.d) + (((float) getPaddingLeft()) / ((float) clientWidth));
                float f = 0.0f;
                int i5 = this.j - 1;
                int i6 = i4;
                i4 = i3;
                i3 = i6;
                while (i5 >= 0) {
                    if (f >= paddingLeft && i5 < max) {
                        if (b == null) {
                            break;
                        } else if (i5 == b.b && !b.c) {
                            this.f.remove(i3);
                            this.i.a(b.a);
                            i3--;
                            i4--;
                            b = i3 >= 0 ? (cu) this.f.get(i3) : null;
                        }
                    } else if (b == null || i5 != b.b) {
                        f += a(i5, i3 + 1).d;
                        i4++;
                        b = i3 >= 0 ? (cu) this.f.get(i3) : null;
                    } else {
                        f += b.d;
                        i3--;
                        b = i3 >= 0 ? (cu) this.f.get(i3) : null;
                    }
                    i5--;
                }
                paddingLeft = a.d;
                i5 = i4 + 1;
                if (paddingLeft < 2.0f) {
                    cu cuVar3 = i5 < this.f.size() ? (cu) this.f.get(i5) : null;
                    float paddingRight = clientWidth <= 0 ? 0.0f : (((float) getPaddingRight()) / ((float) clientWidth)) + 2.0f;
                    cu cuVar4 = cuVar3;
                    int i7 = i5;
                    i5 = this.j + 1;
                    b = cuVar4;
                    while (i5 < 3) {
                        float f2;
                        float f3;
                        if (paddingLeft >= paddingRight && i5 > min) {
                            if (b == null) {
                                break;
                            } else if (i5 != b.b || b.c) {
                                f2 = paddingLeft;
                                cuVar2 = b;
                                f3 = f2;
                            } else {
                                this.f.remove(i7);
                                this.i.a(b.a);
                                f2 = paddingLeft;
                                cuVar2 = i7 < this.f.size() ? (cu) this.f.get(i7) : null;
                                f3 = f2;
                            }
                        } else if (b == null || i5 != b.b) {
                            b = a(i5, i7);
                            i7++;
                            f2 = paddingLeft + b.d;
                            cuVar2 = i7 < this.f.size() ? (cu) this.f.get(i7) : null;
                            f3 = f2;
                        } else {
                            i7++;
                            f2 = paddingLeft + b.d;
                            cuVar2 = i7 < this.f.size() ? (cu) this.f.get(i7) : null;
                            f3 = f2;
                        }
                        i5++;
                        f2 = f3;
                        b = cuVar2;
                        paddingLeft = f2;
                    }
                }
                a(a, i4, cuVar);
            }
            this.i.b(a != null ? a.a : null);
            this.i.a();
            i3 = getChildCount();
            for (int i8 = 0; i8 < i3; i8++) {
                View childAt = getChildAt(i8);
                cv cvVar = (cv) childAt.getLayoutParams();
                cvVar.f = i8;
                if (!cvVar.a && cvVar.c == 0.0f) {
                    cuVar2 = a(childAt);
                    if (cuVar2 != null) {
                        cvVar.c = cuVar2.d;
                        cvVar.e = cuVar2.b;
                    }
                }
            }
            e();
            if (hasFocus()) {
                View findFocus = findFocus();
                b = findFocus != null ? b(findFocus) : null;
                if (b == null || b.b != this.j) {
                    i2 = 0;
                    while (i2 < getChildCount()) {
                        View childAt2 = getChildAt(i2);
                        cu a2 = a(childAt2);
                        if (a2 == null || a2.b != this.j || !childAt2.requestFocus(2)) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private void a(int i, float f) {
        int paddingLeft;
        int paddingRight;
        if (this.aa > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                int i3;
                View childAt = getChildAt(i2);
                cv cvVar = (cv) childAt.getLayoutParams();
                if (cvVar.a) {
                    int max;
                    switch (cvVar.b & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i3 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i3;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i3 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i3;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i3 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i3;
                            break;
                        default:
                            max = paddingLeft;
                            i3 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i3;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i3 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i3;
                }
                i2++;
                i3 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i3;
            }
        }
        if (this.ab != null) {
            this.ab.a(i, f);
        }
        if (this.a != null) {
            paddingRight = this.a.size();
            for (paddingLeft = 0; paddingLeft < paddingRight; paddingLeft++) {
                cy cyVar = (cy) this.a.get(paddingLeft);
                if (cyVar != null) {
                    cyVar.a(i, f);
                }
            }
        }
        if (this.ac != null) {
            this.ac.a(i, f);
        }
        if (this.ae != null) {
            getScrollX();
            paddingRight = getChildCount();
            for (paddingLeft = 0; paddingLeft < paddingRight; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((cv) childAt2.getLayoutParams()).a) {
                    childAt2.getLeft();
                    getClientWidth();
                }
            }
        }
        this.W = true;
    }

    private void a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f.isEmpty()) {
            cu b = b(this.j);
            int min = (int) ((b != null ? Math.min(b.e, this.v) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                a(false);
                scrollTo(min, getScrollY());
            }
        } else if (this.n.isFinished()) {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        } else {
            this.n.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        cu b = b(i);
        int clientWidth = b != null ? (int) (((float) getClientWidth()) * Math.max(this.u, Math.min(b.e, this.v))) : 0;
        if (z) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                int currX;
                int i3;
                Object obj = (this.n == null || this.n.isFinished()) ? null : 1;
                if (obj != null) {
                    currX = this.o ? this.n.getCurrX() : this.n.getStartX();
                    this.n.abortAnimation();
                    setScrollingCacheEnabled(false);
                    i3 = currX;
                } else {
                    i3 = getScrollX();
                }
                int scrollY = getScrollY();
                clientWidth -= i3;
                int i4 = 0 - scrollY;
                if (clientWidth == 0 && i4 == 0) {
                    a(false);
                    b();
                    setScrollState(0);
                } else {
                    setScrollingCacheEnabled(true);
                    setScrollState(2);
                    currX = getClientWidth();
                    int i5 = currX / 2;
                    float sin = (((float) i5) * ((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (1.0f * ((float) Math.abs(clientWidth))) / ((float) currX)) - 0.5f)) * 0.4712389167638204d))))) + ((float) i5);
                    int abs = Math.abs(i2);
                    i5 = Math.min(abs > 0 ? Math.round(1000.0f * Math.abs(sin / ((float) abs))) * 4 : (int) (((((float) Math.abs(clientWidth)) / ((((float) currX) * 1.0f) + ((float) this.q))) + 1.0f) * 100.0f), 600);
                    this.o = false;
                    this.n.startScroll(i3, scrollY, clientWidth, i4, i5);
                    bq.d(this);
                }
            }
            if (z2) {
                d(i);
                return;
            }
            return;
        }
        if (z2) {
            d(i);
        }
        a(false);
        scrollTo(clientWidth, 0);
        c(clientWidth);
    }

    private void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    private void a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.i == null) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.j != i || this.f.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= 3) {
                i = 2;
            }
            int i3 = this.B;
            if (i > this.j + i3 || i < this.j - i3) {
                for (int i4 = 0; i4 < this.f.size(); i4++) {
                    ((cu) this.f.get(i4)).c = true;
                }
            }
            if (this.j != i) {
                z3 = true;
            }
            if (this.U) {
                this.j = i;
                if (z3) {
                    d(i);
                }
                requestLayout();
                return;
            }
            a(i);
            a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void a(cu cuVar, int i, cu cuVar2) {
        int i2;
        cu cuVar3;
        float f;
        int i3;
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.q) / ((float) clientWidth) : 0.0f;
        if (cuVar2 != null) {
            clientWidth = cuVar2.b;
            float f3;
            int i4;
            int i5;
            if (clientWidth < cuVar.b) {
                f3 = (cuVar2.e + cuVar2.d) + f2;
                i2 = 0;
                i4 = clientWidth + 1;
                while (i4 <= cuVar.b && i2 < this.f.size()) {
                    cuVar3 = (cu) this.f.get(i2);
                    while (i4 > cuVar3.b && i2 < this.f.size() - 1) {
                        i2++;
                        cuVar3 = (cu) this.f.get(i2);
                    }
                    i5 = i4;
                    f = f3;
                    i3 = i5;
                    while (i3 < cuVar3.b) {
                        i3++;
                        f = (1.0f + f2) + f;
                    }
                    cuVar3.e = f;
                    f += cuVar3.d + f2;
                    clientWidth = i3 + 1;
                    f3 = f;
                    i4 = clientWidth;
                }
            } else if (clientWidth > cuVar.b) {
                i2 = this.f.size() - 1;
                f3 = cuVar2.e;
                i4 = clientWidth - 1;
                while (i4 >= cuVar.b && i2 >= 0) {
                    cuVar3 = (cu) this.f.get(i2);
                    while (i4 < cuVar3.b && i2 > 0) {
                        i2--;
                        cuVar3 = (cu) this.f.get(i2);
                    }
                    i5 = i4;
                    f = f3;
                    i3 = i5;
                    while (i3 > cuVar3.b) {
                        i3--;
                        f -= 1.0f + f2;
                    }
                    f -= cuVar3.d + f2;
                    cuVar3.e = f;
                    clientWidth = i3 - 1;
                    f3 = f;
                    i4 = clientWidth;
                }
            }
        }
        int size = this.f.size();
        f = cuVar.e;
        i3 = cuVar.b - 1;
        this.u = cuVar.b == 0 ? cuVar.e : -3.4028235E38f;
        this.v = cuVar.b == 2 ? (cuVar.e + cuVar.d) - 1.0f : Float.MAX_VALUE;
        for (i2 = i - 1; i2 >= 0; i2--) {
            cuVar3 = (cu) this.f.get(i2);
            while (i3 > cuVar3.b) {
                i3--;
                f -= 1.0f + f2;
            }
            f -= cuVar3.d + f2;
            cuVar3.e = f;
            if (cuVar3.b == 0) {
                this.u = f;
            }
            i3--;
        }
        f = (cuVar.e + cuVar.d) + f2;
        i3 = cuVar.b + 1;
        for (i2 = i + 1; i2 < size; i2++) {
            cuVar3 = (cu) this.f.get(i2);
            while (i3 < cuVar3.b) {
                i3++;
                f += 1.0f + f2;
            }
            if (cuVar3.b == 2) {
                this.v = (cuVar3.d + f) - 1.0f;
            }
            cuVar3.e = f;
            f += cuVar3.d + f2;
            i3++;
        }
        this.V = false;
    }

    private void a(MotionEvent motionEvent) {
        int b = ay.b(motionEvent);
        if (ay.b(motionEvent, b) == this.L) {
            b = b == 0 ? 1 : 0;
            this.H = ay.c(motionEvent, b);
            this.L = ay.b(motionEvent, b);
            if (this.M != null) {
                this.M.clear();
            }
        }
    }

    private void a(boolean z) {
        int scrollX;
        boolean z2 = this.ak == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.n.isFinished()) {
                this.n.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.n.getCurrX();
                int currY = this.n.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        c(currX);
                    }
                }
            }
        }
        this.A = false;
        boolean z3 = z2;
        for (scrollX = 0; scrollX < this.f.size(); scrollX++) {
            cu cuVar = (cu) this.f.get(scrollX);
            if (cuVar.c) {
                cuVar.c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            bq.a((View) this, this.aj);
        } else {
            this.aj.run();
        }
    }

    private boolean a(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.H - f;
        this.H = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.u;
        float f5 = ((float) clientWidth) * this.v;
        cu cuVar = (cu) this.f.get(0);
        cu cuVar2 = (cu) this.f.get(this.f.size() - 1);
        if (cuVar.b != 0) {
            f4 = cuVar.e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (cuVar2.b != 2) {
            f2 = cuVar2.e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.S.a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.T.a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.H += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        c((int) f4);
        return z3;
    }

    private boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && bq.a(view, -i);
    }

    private cu b(int i) {
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            cu cuVar = (cu) this.f.get(i2);
            if (cuVar.b == i) {
                return cuVar;
            }
        }
        return null;
    }

    private cu b(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    private boolean c(int i) {
        if (this.f.size() == 0) {
            this.W = false;
            a(0, 0.0f);
            if (this.W) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        cu h = h();
        int clientWidth = getClientWidth();
        float f = ((float) this.q) / ((float) clientWidth);
        int i2 = h.b;
        float f2 = ((((float) i) / ((float) clientWidth)) - h.e) / (h.d + f);
        this.W = false;
        a(i2, f2);
        if (this.W) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void d() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.n = new Scroller(context, e);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.G = cj.a(viewConfiguration);
        this.N = (int) (400.0f * f);
        this.O = viewConfiguration.getScaledMaximumFlingVelocity();
        this.S = new q(context);
        this.T = new q(context);
        this.P = (int) (25.0f * f);
        this.Q = (int) (2.0f * f);
        this.E = (int) (16.0f * f);
        bq.a((View) this, new cw(this));
        if (bq.e(this) == 0) {
            bq.c((View) this, 1);
        }
        bq.a((View) this, new cs(this));
    }

    private void d(int i) {
        if (this.ab != null) {
            this.ab.b(i);
        }
        if (this.a != null) {
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                cy cyVar = (cy) this.a.get(i2);
                if (cyVar != null) {
                    cyVar.b(i);
                }
            }
        }
        if (this.ac != null) {
            this.ac.b(i);
        }
    }

    private void e() {
        if (this.ag != 0) {
            if (this.ah == null) {
                this.ah = new ArrayList();
            } else {
                this.ah.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ah.add(getChildAt(i));
            }
            Collections.sort(this.ah, ai);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e(int i) {
        View view;
        boolean z;
        boolean z2 = false;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        z = true;
                        break;
                    }
                }
                z = false;
                if (!z) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        findFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findFocus == null || findFocus == view) {
            if (i == 17 || i == 1) {
                z = i();
            } else {
                if (i != 66) {
                }
                if (this.i != null || this.j >= 2) {
                    z = false;
                } else {
                    setCurrentItem$2563266(this.j + 1);
                    z = true;
                }
            }
        } else if (i == 17) {
            z = (view == null || a(this.h, findFocus).left < a(this.h, view).left) ? findFocus.requestFocus() : i();
        } else {
            if (i == 66) {
                int i2 = a(this.h, findFocus).left;
                int i3 = a(this.h, view).left;
                if (view == null || i2 > i3) {
                    z = findFocus.requestFocus();
                }
                if (this.i != null) {
                }
                z = false;
            }
            if (z2) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return z2;
        }
        z2 = z;
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z2;
    }

    private boolean f() {
        this.L = -1;
        this.C = false;
        this.D = false;
        if (this.M != null) {
            this.M.recycle();
            this.M = null;
        }
        return this.S.c() | this.T.c();
    }

    private void g() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private cu h() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.q) / ((float) clientWidth) : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        cu cuVar = null;
        while (i2 < this.f.size()) {
            int i3;
            cu cuVar2;
            cu cuVar3 = (cu) this.f.get(i2);
            cu cuVar4;
            if (obj != null || cuVar3.b == i + 1) {
                cuVar4 = cuVar3;
                i3 = i2;
                cuVar2 = cuVar4;
            } else {
                cuVar3 = this.g;
                cuVar3.e = (f2 + f3) + f;
                cuVar3.b = i + 1;
                cuVar3.d = 1.0f;
                cuVar4 = cuVar3;
                i3 = i2 - 1;
                cuVar2 = cuVar4;
            }
            f2 = cuVar2.e;
            f3 = (cuVar2.d + f2) + f;
            if (obj == null && scrollX < f2) {
                return cuVar;
            }
            if (scrollX < f3 || i3 == this.f.size() - 1) {
                return cuVar2;
            }
            f3 = f2;
            i = cuVar2.b;
            obj = null;
            f2 = cuVar2.d;
            cuVar = cuVar2;
            i2 = i3 + 1;
        }
        return cuVar;
    }

    private boolean i() {
        if (this.j <= 0) {
            return false;
        }
        setCurrentItem$2563266(this.j - 1);
        return true;
    }

    private void setCurrentItem$2563266(int i) {
        this.A = false;
        a(i, true, false);
    }

    private void setScrollState(int i) {
        int i2 = 0;
        if (this.ak != i) {
            this.ak = i;
            if (this.ae != null) {
                int i3 = i != 0 ? 1 : 0;
                int childCount = getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    bq.a(getChildAt(i4), i3 != 0 ? 2 : 0, null);
                }
            }
            if (this.ab != null) {
                this.ab.a(i);
            }
            if (this.a != null) {
                int size = this.a.size();
                while (i2 < size) {
                    cy cyVar = (cy) this.a.get(i2);
                    if (cyVar != null) {
                        cyVar.a(i);
                    }
                    i2++;
                }
            }
            if (this.ac != null) {
                this.ac.a(i);
            }
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.z != z) {
            this.z = z;
        }
    }

    final void a() {
        int i;
        this.c = 3;
        boolean z = this.f.size() < (this.B * 2) + 1 && this.f.size() < 3;
        int i2 = this.j;
        for (i = 0; i < this.f.size(); i++) {
            this.f.get(i);
        }
        Collections.sort(this.f, d);
        if (z) {
            int childCount = getChildCount();
            for (i = 0; i < childCount; i++) {
                cv cvVar = (cv) getChildAt(i).getLayoutParams();
                if (!cvVar.a) {
                    cvVar.c = 0.0f;
                }
            }
            a(i2, false, true);
            requestLayout();
        }
    }

    public final void a(cy cyVar) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(cyVar);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    cu a = a(childAt);
                    if (a != null && a.b == this.j) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                cu a = a(childAt);
                if (a != null && a.b == this.j) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        cv cvVar = (cv) generateLayoutParams;
        cvVar.a |= view instanceof ct;
        if (!this.y) {
            super.addView(view, i, generateLayoutParams);
        } else if (cvVar == null || !cvVar.a) {
            cvVar.d = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    final void b() {
        a(this.j);
    }

    public boolean canScrollHorizontally(int i) {
        if (this.i == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.u)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.v));
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof cv) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        this.o = true;
        if (this.n.isFinished() || !this.n.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.n.getCurrX();
        int currY = this.n.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!c(currX)) {
                this.n.abortAnimation();
                scrollTo(0, currY);
            }
        }
        bq.d(this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent)) {
            boolean e;
            if (keyEvent.getAction() == 0) {
                switch (keyEvent.getKeyCode()) {
                    case 21:
                        e = e(17);
                        break;
                    case 22:
                        e = e(66);
                        break;
                    case 61:
                        if (VERSION.SDK_INT >= 11) {
                            if (!z.a(keyEvent)) {
                                if (z.a(keyEvent, 1)) {
                                    e = e(1);
                                    break;
                                }
                            }
                            e = e(2);
                            break;
                        }
                }
            }
            e = false;
            if (!e) {
                return false;
            }
        }
        return true;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                cu a = a(childAt);
                if (a != null && a.b == this.j && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = bq.a((View) this);
        if (a == 0 || (a == 1 && this.i != null)) {
            int width;
            if (!this.S.a()) {
                a = canvas.save();
                i = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-i) + getPaddingTop()), this.u * ((float) width));
                this.S.a(i, width);
                i = this.S.a(canvas) | 0;
                canvas.restoreToCount(a);
            }
            if (!this.T.a()) {
                a = canvas.save();
                width = getWidth();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.v + 1.0f)) * ((float) width));
                this.T.a(height, width);
                i |= this.T.a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.S.b();
            this.T.b();
        }
        if (i != 0) {
            bq.d(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.r;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new cv();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new cv(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public bj getAdapter() {
        return this.i;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ag == 2) {
            i2 = (i - 1) - i2;
        }
        return ((cv) ((View) this.ah.get(i2)).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.j;
    }

    public int getOffscreenPageLimit() {
        return this.B;
    }

    public int getPageMargin() {
        return this.q;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.U = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.aj);
        if (!(this.n == null || this.n.isFinished())) {
            this.n.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.q > 0 && this.r != null && this.f.size() > 0 && this.i != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.q) / ((float) width);
            cu cuVar = (cu) this.f.get(0);
            float f2 = cuVar.e;
            int size = this.f.size();
            int i = cuVar.b;
            int i2 = ((cu) this.f.get(size - 1)).b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > cuVar.b && i3 < size) {
                    i3++;
                    cuVar = (cu) this.f.get(i3);
                }
                if (i4 == cuVar.b) {
                    f3 = (cuVar.e + cuVar.d) * ((float) width);
                    f2 = (cuVar.e + cuVar.d) + f;
                } else {
                    f3 = (1.0f + f2) * ((float) width);
                    f2 += 1.0f + f;
                }
                if (((float) this.q) + f3 > ((float) scrollX)) {
                    this.r.setBounds(Math.round(f3), this.s, Math.round(((float) this.q) + f3), this.t);
                    this.r.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            f();
            return false;
        }
        if (action != 0) {
            if (this.C) {
                return true;
            }
            if (this.D) {
                return false;
            }
        }
        float x;
        switch (action) {
            case 0:
                x = motionEvent.getX();
                this.J = x;
                this.H = x;
                x = motionEvent.getY();
                this.K = x;
                this.I = x;
                this.L = ay.b(motionEvent, 0);
                this.D = false;
                this.o = true;
                this.n.computeScrollOffset();
                if (this.ak == 2 && Math.abs(this.n.getFinalX() - this.n.getCurrX()) > this.Q) {
                    this.n.abortAnimation();
                    this.A = false;
                    b();
                    this.C = true;
                    g();
                    setScrollState(1);
                    break;
                }
                a(false);
                this.C = false;
                break;
                break;
            case 2:
                action = this.L;
                if (action != -1) {
                    action = ay.a(motionEvent, action);
                    float c = ay.c(motionEvent, action);
                    float f = c - this.H;
                    float abs = Math.abs(f);
                    float d = ay.d(motionEvent, action);
                    float abs2 = Math.abs(d - this.K);
                    if (f != 0.0f) {
                        x = this.H;
                        boolean z = (x < ((float) this.F) && f > 0.0f) || (x > ((float) (getWidth() - this.F)) && f < 0.0f);
                        if (!z && a(this, false, (int) f, (int) c, (int) d)) {
                            this.H = c;
                            this.I = d;
                            this.D = true;
                            return false;
                        }
                    }
                    if (abs > ((float) this.G) && 0.5f * abs > abs2) {
                        this.C = true;
                        g();
                        setScrollState(1);
                        this.H = f > 0.0f ? this.J + ((float) this.G) : this.J - ((float) this.G);
                        this.I = d;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.G)) {
                        this.D = true;
                    }
                    if (this.C && a(c)) {
                        bq.d(this);
                        break;
                    }
                }
                break;
            case 6:
                a(motionEvent);
                break;
        }
        if (this.M == null) {
            this.M = VelocityTracker.obtain();
        }
        this.M.addMovement(motionEvent);
        return this.C;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        cv cvVar;
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                cvVar = (cv) childAt.getLayoutParams();
                if (cvVar.a) {
                    int i9 = cvVar.b & 112;
                    switch (cvVar.b & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                cvVar = (cv) childAt2.getLayoutParams();
                if (!cvVar.a) {
                    cu a = a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.e * ((float) max))) + paddingLeft;
                        if (cvVar.d) {
                            cvVar.d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (cvVar.c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.s = paddingTop;
        this.t = i6 - paddingBottom;
        this.aa = i7;
        if (this.U) {
            a(this.j, false, 0, false);
        }
        this.U = false;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.F = Math.min(measuredWidth / 10, this.E);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            cv cvVar;
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                cvVar = (cv) childAt.getLayoutParams();
                if (cvVar != null && cvVar.a) {
                    int i6 = cvVar.b & 7;
                    int i7 = cvVar.b & 112;
                    i3 = Integer.MIN_VALUE;
                    i4 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i4 = 1073741824;
                    }
                    if (cvVar.width != -2) {
                        i7 = 1073741824;
                        i3 = cvVar.width != -1 ? cvVar.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (cvVar.height != -2) {
                        i4 = 1073741824;
                        if (cvVar.height != -1) {
                            measuredWidth = cvVar.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.w = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.x = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.y = true;
        b();
        this.y = false;
        i3 = getChildCount();
        for (i4 = 0; i4 < i3; i4++) {
            View childAt2 = getChildAt(i4);
            if (childAt2.getVisibility() != 8) {
                cvVar = (cv) childAt2.getLayoutParams();
                if (cvVar == null || !cvVar.a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (cvVar.c * ((float) paddingLeft)), 1073741824), this.x);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                cu a = a(childAt);
                if (a != null && a.b == this.j && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.i != null) {
                Parcelable parcelable2 = savedState.b;
                ClassLoader classLoader = savedState.c;
                a(savedState.a, false, true);
                return;
            }
            this.k = savedState.a;
            this.l = savedState.b;
            this.m = savedState.c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.j;
        if (this.i != null) {
            savedState.b = null;
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            a(i, i3, this.q, this.q);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.R) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.i == null) {
            return false;
        }
        if (this.M == null) {
            this.M = VelocityTracker.obtain();
        }
        this.M.addMovement(motionEvent);
        float x;
        int i;
        float f;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.n.abortAnimation();
                this.A = false;
                b();
                x = motionEvent.getX();
                this.J = x;
                this.H = x;
                x = motionEvent.getY();
                this.K = x;
                this.I = x;
                this.L = ay.b(motionEvent, 0);
                break;
            case 1:
                if (this.C) {
                    VelocityTracker velocityTracker = this.M;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.O);
                    int a = (int) bm.a(velocityTracker, this.L);
                    this.A = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    cu h = h();
                    float f2 = ((float) this.q) / ((float) clientWidth);
                    i = h.b;
                    f = ((((float) scrollX) / ((float) clientWidth)) - h.e) / (h.d + f2);
                    if (Math.abs((int) (ay.c(motionEvent, ay.a(motionEvent, this.L)) - this.J)) <= this.P || Math.abs(a) <= this.N) {
                        scrollX = (int) ((((float) i) + f) + (i >= this.j ? 0.4f : 0.6f));
                    } else {
                        if (a <= 0) {
                            i++;
                        }
                        scrollX = i;
                    }
                    if (this.f.size() > 0) {
                        scrollX = Math.max(((cu) this.f.get(0)).b, Math.min(scrollX, ((cu) this.f.get(this.f.size() - 1)).b));
                    }
                    a(scrollX, true, true, a);
                    z = f();
                    break;
                }
                break;
            case 2:
                if (!this.C) {
                    i = ay.a(motionEvent, this.L);
                    if (i == -1) {
                        z = f();
                        break;
                    }
                    float c = ay.c(motionEvent, i);
                    f = Math.abs(c - this.H);
                    float d = ay.d(motionEvent, i);
                    x = Math.abs(d - this.I);
                    if (f > ((float) this.G) && f > x) {
                        this.C = true;
                        g();
                        this.H = c - this.J > 0.0f ? this.J + ((float) this.G) : this.J - ((float) this.G);
                        this.I = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.C) {
                    z = a(ay.c(motionEvent, ay.a(motionEvent, this.L))) | 0;
                    break;
                }
                break;
            case 3:
                if (this.C) {
                    a(this.j, true, 0, false);
                    z = f();
                    break;
                }
                break;
            case 5:
                i = ay.b(motionEvent);
                this.H = ay.c(motionEvent, i);
                this.L = ay.b(motionEvent, i);
                break;
            case 6:
                a(motionEvent);
                this.H = ay.c(motionEvent, ay.a(motionEvent, this.L));
                break;
        }
        if (z) {
            bq.d(this);
        }
        return true;
    }

    public void removeView(View view) {
        if (this.y) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(bj bjVar) {
        if (this.i != null) {
            int i;
            this.i.a(null);
            for (i = 0; i < this.f.size(); i++) {
                this.i.a(((cu) this.f.get(i)).a);
            }
            this.i.a();
            this.f.clear();
            i = 0;
            while (i < getChildCount()) {
                if (!((cv) getChildAt(i).getLayoutParams()).a) {
                    removeViewAt(i);
                    i--;
                }
                i++;
            }
            this.j = 0;
            scrollTo(0, 0);
        }
        this.i = bjVar;
        this.c = 0;
        if (this.i != null) {
            if (this.p == null) {
                this.p = new da();
            }
            this.i.a(this.p);
            this.A = false;
            boolean z = this.U;
            this.U = true;
            this.c = 3;
            if (this.k >= 0) {
                a(this.k, false, true);
                this.k = -1;
                this.l = null;
                this.m = null;
            } else if (z) {
                requestLayout();
            } else {
                b();
            }
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.af == null) {
                try {
                    this.af = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.af.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.A = false;
        a(i, !this.U, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.B) {
            this.B = i;
            b();
        }
    }

    void setOnAdapterChangeListener(cx cxVar) {
        this.ad = cxVar;
    }

    @Deprecated
    public void setOnPageChangeListener(cy cyVar) {
        this.ab = cyVar;
    }

    public void setPageMargin(int i) {
        int i2 = this.q;
        this.q = i;
        int width = getWidth();
        a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.r = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.r;
    }
}
