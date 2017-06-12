package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.design.g;
import android.support.design.h;
import android.support.v4.e.a;
import android.support.v4.view.ay;
import android.support.v4.view.bg;
import android.support.v4.view.bh;
import android.support.v4.view.bq;
import android.support.v4.view.ed;
import android.support.v4.view.v;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements bg {
    static final String a;
    static final Class<?>[] b = new Class[]{Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<n>>> c = new ThreadLocal();
    static final Comparator<View> e;
    static final u f;
    final Comparator<View> d;
    final List<View> g;
    final Rect h;
    final Rect i;
    private final List<View> j;
    private final List<View> k;
    private final Rect l;
    private final int[] m;
    private boolean n;
    private int[] o;
    private View p;
    private View q;
    private View r;
    private r s;
    private boolean t;
    private ed u;
    private boolean v;
    private Drawable w;
    private OnHierarchyChangeListener x;
    private final bh y;

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = a.a(new s());
        SparseArray<Parcelable> a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.a = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            int size = this.a != null ? this.a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.a.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.a.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        a = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            e = new t();
            f = new v();
        } else {
            e = null;
            f = null;
        }
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new l(this);
        this.g = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.h = new Rect();
        this.i = new Rect();
        this.l = new Rect();
        this.m = new int[2];
        this.y = new bh(this);
        by.a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.CoordinatorLayout, i, g.Widget_Design_CoordinatorLayout);
        int resourceId = obtainStyledAttributes.getResourceId(h.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.o = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.o.length;
            for (resourceId = 0; resourceId < length; resourceId++) {
                int[] iArr = this.o;
                iArr[resourceId] = (int) (((float) iArr[resourceId]) * f);
            }
        }
        this.w = obtainStyledAttributes.getDrawable(h.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        if (f != null) {
            f.a(this, new m());
        }
        super.setOnHierarchyChangeListener(new p());
    }

    private int a(int i) {
        if (this.o == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < this.o.length) {
            return this.o[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    static n a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(a)) {
            str = a + '.' + str;
        }
        try {
            Map map;
            Map map2 = (Map) c.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                c.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (n) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Throwable e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    static /* synthetic */ ed a(CoordinatorLayout coordinatorLayout, ed edVar) {
        boolean z = true;
        int i = 0;
        if (coordinatorLayout.u == edVar) {
            return edVar;
        }
        ed edVar2;
        coordinatorLayout.u = edVar;
        boolean z2 = edVar != null && edVar.b() > 0;
        coordinatorLayout.v = z2;
        if (coordinatorLayout.v || coordinatorLayout.getBackground() != null) {
            z = false;
        }
        coordinatorLayout.setWillNotDraw(z);
        if (!edVar.e()) {
            int childCount = coordinatorLayout.getChildCount();
            edVar2 = edVar;
            while (i < childCount) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (bq.v(childAt) && ((q) childAt.getLayoutParams()).a != null && edVar2.e()) {
                    break;
                }
                i++;
                edVar2 = edVar2;
            }
        } else {
            edVar2 = edVar;
        }
        coordinatorLayout.requestLayout();
        return edVar2;
    }

    private void a() {
        if (this.p != null) {
            n nVar = ((q) this.p.getLayoutParams()).a;
            if (nVar != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                nVar.b(this, this.p, obtain);
                obtain.recycle();
            }
            this.p = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((q) getChildAt(i).getLayoutParams()).i = false;
        }
    }

    private void a(View view, int i, Rect rect, Rect rect2) {
        q qVar = (q) view.getLayoutParams();
        int i2 = qVar.c;
        if (i2 == 0) {
            i2 = 17;
        }
        i2 = v.a(i2, i);
        int a = v.a(b(qVar.d), i);
        int i3 = i2 & 7;
        int i4 = i2 & 112;
        i2 = a & 7;
        int i5 = a & 112;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        switch (i2) {
            case 1:
                a = (rect.width() / 2) + rect.left;
                break;
            case 5:
                a = rect.right;
                break;
            default:
                a = rect.left;
                break;
        }
        switch (i5) {
            case 16:
                i2 = rect.top + (rect.height() / 2);
                break;
            case 80:
                i2 = rect.bottom;
                break;
            default:
                i2 = rect.top;
                break;
        }
        switch (i3) {
            case 1:
                a -= measuredWidth / 2;
                break;
            case 5:
                break;
            default:
                a -= measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                i2 -= measuredHeight / 2;
                break;
            case 80:
                break;
            default:
                i2 -= measuredHeight;
                break;
        }
        i3 = getWidth();
        i4 = getHeight();
        a = Math.max(getPaddingLeft() + qVar.leftMargin, Math.min(a, ((i3 - getPaddingRight()) - measuredWidth) - qVar.rightMargin));
        int max = Math.max(getPaddingTop() + qVar.topMargin, Math.min(i2, ((i4 - getPaddingBottom()) - measuredHeight) - qVar.bottomMargin));
        rect2.set(a, max, a + measuredWidth, max + measuredHeight);
    }

    private static void a(List<View> list, Comparator<View> comparator) {
        if (list != null && list.size() >= 2) {
            int i;
            View[] viewArr = new View[list.size()];
            list.toArray(viewArr);
            for (int i2 = 0; i2 < r5; i2++) {
                i = i2;
                for (int i3 = i2 + 1; i3 < r5; i3++) {
                    if (comparator.compare(viewArr[i3], viewArr[i]) < 0) {
                        i = i3;
                    }
                }
                if (i2 != i) {
                    View view = viewArr[i];
                    viewArr[i] = viewArr[i2];
                    viewArr[i2] = view;
                }
            }
            list.clear();
            for (Object add : viewArr) {
                list.add(add);
            }
        }
    }

    private boolean a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2 = false;
        Object obj = null;
        int a = ay.a(motionEvent);
        List list = this.j;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i2 = childCount - 1;
        while (i2 >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
            i2--;
        }
        if (e != null) {
            Collections.sort(list, e);
        }
        int size = list.size();
        int i3 = 0;
        MotionEvent motionEvent2 = null;
        while (i3 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i3);
            q qVar = (q) view.getLayoutParams();
            n nVar = qVar.a;
            if ((!z2 && obj == null) || a == 0) {
                if (!(z2 || nVar == null)) {
                    switch (i) {
                        case 0:
                            z2 = nVar.a(this, view, motionEvent);
                            break;
                        case 1:
                            z2 = nVar.b(this, view, motionEvent);
                            break;
                    }
                    if (z2) {
                        this.p = view;
                    }
                }
                z = z2;
                if (qVar.a == null) {
                    qVar.i = false;
                }
                boolean z3 = qVar.i;
                if (qVar.i) {
                    isChildrenDrawingOrderEnabled = true;
                } else {
                    isChildrenDrawingOrderEnabled = qVar.i | 0;
                    qVar.i = isChildrenDrawingOrderEnabled;
                }
                Object obj3 = (!isChildrenDrawingOrderEnabled || z3) ? null : 1;
                if (isChildrenDrawingOrderEnabled && obj3 == null) {
                    list.clear();
                    return z;
                }
                MotionEvent motionEvent4 = motionEvent2;
                obj2 = obj3;
                motionEvent3 = motionEvent4;
            } else if (nVar != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case 0:
                        nVar.a(this, view, motionEvent3);
                        obj2 = obj;
                        z = z2;
                        continue;
                    case 1:
                        nVar.b(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                z = z2;
            } else {
                motionEvent3 = motionEvent2;
                z = z2;
                obj2 = obj;
            }
            i3++;
            obj = obj2;
            z2 = z;
            motionEvent2 = motionEvent3;
        }
        z = z2;
        list.clear();
        return z;
    }

    private static int b(int i) {
        return i == 0 ? 8388659 : i;
    }

    private static q b(View view) {
        q qVar = (q) view.getLayoutParams();
        if (!qVar.b) {
            o oVar = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                oVar = (o) cls.getAnnotation(o.class);
                if (oVar != null) {
                    break;
                }
            }
            o oVar2 = oVar;
            if (oVar2 != null) {
                try {
                    qVar.a((n) oVar2.a().newInstance());
                } catch (Throwable e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + oVar2.a().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            qVar.b = true;
        }
        return qVar;
    }

    private void b() {
        boolean z;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            q qVar = (q) childAt.getLayoutParams();
            if (qVar.g != null) {
                z = true;
            } else {
                int childCount2 = getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    View childAt2 = getChildAt(i2);
                    if (childAt2 != childAt && qVar.a(childAt2)) {
                        z = true;
                        break;
                    }
                }
                z = false;
            }
            if (z) {
                z = true;
                break;
            }
        }
        z = false;
        if (z == this.t) {
            return;
        }
        if (z) {
            if (this.n) {
                if (this.s == null) {
                    this.s = new r(this);
                }
                getViewTreeObserver().addOnPreDrawListener(this.s);
            }
            this.t = true;
            return;
        }
        if (this.n && this.s != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.s);
        }
        this.t = false;
    }

    private static int c(int i) {
        return i == 0 ? 8388661 : i;
    }

    public final List<View> a(View view) {
        q qVar = (q) view.getLayoutParams();
        List<View> list = this.k;
        list.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && qVar.a(childAt)) {
                list.add(childAt);
            }
        }
        return list;
    }

    public final void a(View view, int i) {
        q qVar = (q) view.getLayoutParams();
        Object obj = (qVar.g != null || qVar.f == -1) ? null : 1;
        if (obj != null) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (qVar.g != null) {
            View view2 = qVar.g;
            view.getLayoutParams();
            Rect rect = this.h;
            Rect rect2 = this.i;
            co.a(this, view2, rect);
            a(view, i, rect, rect2);
            view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        } else if (qVar.e >= 0) {
            int i2;
            int i3 = qVar.e;
            qVar = (q) view.getLayoutParams();
            int a = v.a(c(qVar.c), i);
            int i4 = a & 7;
            a &= 112;
            int width = getWidth();
            int height = getHeight();
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            if (i == 1) {
                i3 = width - i3;
            }
            i3 = a(i3) - measuredWidth;
            switch (i4) {
                case 1:
                    i2 = i3 + (measuredWidth / 2);
                    break;
                case 5:
                    i2 = i3 + measuredWidth;
                    break;
                default:
                    i2 = i3;
                    break;
            }
            switch (a) {
                case 16:
                    i3 = (measuredHeight / 2) + 0;
                    break;
                case 80:
                    i3 = measuredHeight + 0;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            int max = Math.max(getPaddingLeft() + qVar.leftMargin, Math.min(i2, ((width - getPaddingRight()) - measuredWidth) - qVar.rightMargin));
            int max2 = Math.max(getPaddingTop() + qVar.topMargin, Math.min(i3, ((height - getPaddingBottom()) - measuredHeight) - qVar.bottomMargin));
            view.layout(max, max2, max + measuredWidth, max2 + measuredHeight);
        } else {
            qVar = (q) view.getLayoutParams();
            Rect rect3 = this.h;
            rect3.set(getPaddingLeft() + qVar.leftMargin, getPaddingTop() + qVar.topMargin, (getWidth() - getPaddingRight()) - qVar.rightMargin, (getHeight() - getPaddingBottom()) - qVar.bottomMargin);
            if (!(this.u == null || !bq.v(this) || bq.v(view))) {
                rect3.left += this.u.a();
                rect3.top += this.u.b();
                rect3.right -= this.u.c();
                rect3.bottom -= this.u.d();
            }
            Rect rect4 = this.i;
            v.a(b(qVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect3, rect4, i);
            view.layout(rect4.left, rect4.top, rect4.right, rect4.bottom);
        }
    }

    public final void a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    final void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.set(0, 0, 0, 0);
        } else if (z) {
            co.a(this, view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    final void a(boolean z) {
        int h = bq.h(this);
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            int i2;
            n nVar;
            View view = (View) this.g.get(i);
            q qVar = (q) view.getLayoutParams();
            for (i2 = 0; i2 < i; i2++) {
                q qVar2;
                if (qVar.h == ((View) this.g.get(i2))) {
                    qVar2 = (q) view.getLayoutParams();
                    if (qVar2.g != null) {
                        Rect rect = this.h;
                        Rect rect2 = this.i;
                        Rect rect3 = this.l;
                        co.a(this, qVar2.g, rect);
                        a(view, false, rect2);
                        a(view, h, rect, rect3);
                        int i3 = rect3.left - rect2.left;
                        int i4 = rect3.top - rect2.top;
                        if (i3 != 0) {
                            view.offsetLeftAndRight(i3);
                        }
                        if (i4 != 0) {
                            view.offsetTopAndBottom(i4);
                        }
                        if (i3 != 0 || i4 != 0) {
                            nVar = qVar2.a;
                            if (nVar != null) {
                                nVar.b(this, view, qVar2.g);
                            }
                        }
                    }
                }
            }
            Rect rect4 = this.h;
            Rect rect5 = this.i;
            rect4.set(((q) view.getLayoutParams()).l);
            a(view, true, rect5);
            if (!rect4.equals(rect5)) {
                ((q) view.getLayoutParams()).l.set(rect5);
                for (i2 = i + 1; i2 < size; i2++) {
                    View view2 = (View) this.g.get(i2);
                    qVar2 = (q) view2.getLayoutParams();
                    nVar = qVar2.a;
                    if (nVar != null && nVar.a_(view)) {
                        if (z || !qVar2.k) {
                            nVar.b(this, view2, view);
                            if (z) {
                                qVar2.k = false;
                            }
                        } else {
                            qVar2.k = false;
                        }
                    }
                }
            }
        }
    }

    public final boolean a(View view, int i, int i2) {
        Rect rect = this.h;
        co.a(this, view, rect);
        return rect.contains(i, i2);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof q) && super.checkLayoutParams(layoutParams);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        view.getLayoutParams();
        return super.drawChild(canvas, view, j);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.w;
        if (drawable != null && drawable.isStateful()) {
            i = drawable.setState(drawableState) | 0;
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return new q();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new q(getContext(), attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof q ? new q((q) layoutParams) : layoutParams instanceof MarginLayoutParams ? new q((MarginLayoutParams) layoutParams) : new q(layoutParams);
    }

    public int getNestedScrollAxes() {
        return this.y.a;
    }

    public Drawable getStatusBarBackground() {
        return this.w;
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
        if (this.t) {
            if (this.s == null) {
                this.s = new r(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.s);
        }
        if (this.u == null && bq.v(this)) {
            bq.u(this);
        }
        this.n = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
        if (this.t && this.s != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.s);
        }
        if (this.r != null) {
            onStopNestedScroll(this.r);
        }
        this.n = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.v && this.w != null) {
            int b = this.u != null ? this.u.b() : 0;
            if (b > 0) {
                this.w.setBounds(0, 0, getWidth(), b);
                this.w.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int a = ay.a(motionEvent);
        if (a == 0) {
            a();
        }
        boolean a2 = a(motionEvent, 0);
        if (a == 1 || a == 3) {
            a();
        }
        return a2;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int h = bq.h(this);
        int size = this.g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.g.get(i5);
            n nVar = ((q) view.getLayoutParams()).a;
            if (nVar == null || !nVar.a(this, view, h)) {
                a(view, h);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        this.g.clear();
        int childCount = getChildCount();
        for (i3 = 0; i3 < childCount; i3++) {
            ViewParent childAt = getChildAt(i3);
            q b = b((View) childAt);
            if (b.f == -1) {
                b.h = null;
                b.g = null;
            } else {
                View view;
                ViewParent parent;
                if (b.g != null) {
                    Object obj;
                    if (b.g.getId() != b.f) {
                        obj = null;
                    } else {
                        view = b.g;
                        parent = b.g.getParent();
                        while (parent != this) {
                            if (parent == null || parent == childAt) {
                                b.h = null;
                                b.g = null;
                                obj = null;
                                break;
                            }
                            if (parent instanceof View) {
                                view = (View) parent;
                            }
                            parent = parent.getParent();
                        }
                        b.h = view;
                        obj = 1;
                    }
                    if (obj != null) {
                        continue;
                    }
                }
                b.g = findViewById(b.f);
                if (b.g != null) {
                    if (b.g != this) {
                        view = b.g;
                        parent = b.g.getParent();
                        while (parent != this && parent != null) {
                            if (parent != childAt) {
                                if (parent instanceof View) {
                                    view = (View) parent;
                                }
                                parent = parent.getParent();
                            } else if (isInEditMode()) {
                                b.h = null;
                                b.g = null;
                            } else {
                                throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                            }
                        }
                        b.h = view;
                    } else if (isInEditMode()) {
                        b.h = null;
                        b.g = null;
                    } else {
                        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                    }
                } else if (isInEditMode()) {
                    b.h = null;
                    b.g = null;
                } else {
                    throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(b.f) + " to anchor view " + childAt);
                }
            }
            this.g.add(childAt);
        }
        a(this.g, this.d);
        b();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        i3 = getPaddingBottom();
        int h = bq.h(this);
        Object obj2 = h == 1 ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i4 = paddingLeft + paddingRight;
        int i5 = paddingTop + i3;
        childCount = getSuggestedMinimumWidth();
        i3 = getSuggestedMinimumHeight();
        Object obj3 = (this.u == null || !bq.v(this)) ? null : 1;
        int size3 = this.g.size();
        int i6 = 0;
        int i7 = 0;
        int i8 = i3;
        int i9 = childCount;
        while (i6 < size3) {
            int i10;
            View view2 = (View) this.g.get(i6);
            q qVar = (q) view2.getLayoutParams();
            int i11 = 0;
            if (qVar.e >= 0 && mode != 0) {
                int a = a(qVar.e);
                paddingTop = v.a(c(qVar.c), h) & 7;
                if ((paddingTop == 3 && obj2 == null) || (paddingTop == 5 && obj2 != null)) {
                    i11 = Math.max(0, (size - paddingRight) - a);
                } else if ((paddingTop == 5 && obj2 == null) || (paddingTop == 3 && obj2 != null)) {
                    i11 = Math.max(0, a - paddingLeft);
                }
            }
            if (obj3 == null || bq.v(view2)) {
                i10 = i2;
                childCount = i;
            } else {
                paddingTop = this.u.b() + this.u.d();
                childCount = MeasureSpec.makeMeasureSpec(size - (this.u.a() + this.u.c()), mode);
                i10 = MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
            }
            n nVar = qVar.a;
            if (nVar == null || !nVar.a(this, view2, childCount, i11, i10, 0)) {
                a(view2, childCount, i11, i10, 0);
            }
            i11 = Math.max(i9, ((view2.getMeasuredWidth() + i4) + qVar.leftMargin) + qVar.rightMargin);
            childCount = Math.max(i8, ((view2.getMeasuredHeight() + i5) + qVar.topMargin) + qVar.bottomMargin);
            i6++;
            i7 = bq.a(i7, bq.j(view2));
            i8 = childCount;
            i9 = i11;
        }
        setMeasuredDimension(bq.a(i9, i, -16777216 & i7), bq.a(i8, i2, i7 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            q qVar = (q) childAt.getLayoutParams();
            if (qVar.j) {
                n nVar = qVar.a;
                if (nVar != null) {
                    a = nVar.a(this, childAt, f2, z) | z2;
                    i++;
                    z2 = a;
                }
            }
            a = z2;
            i++;
            z2 = a;
        }
        if (z2) {
            a(true);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            boolean a;
            View childAt = getChildAt(i);
            q qVar = (q) childAt.getLayoutParams();
            if (qVar.j) {
                n nVar = qVar.a;
                if (nVar != null) {
                    a = nVar.a(this, childAt, view, f, f2) | z;
                    i++;
                    z = a;
                }
            }
            a = z;
            i++;
            z = a;
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3 = 0;
        int i4 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            int max;
            int max2;
            Object obj2;
            View childAt = getChildAt(i5);
            q qVar = (q) childAt.getLayoutParams();
            if (qVar.j) {
                n nVar = qVar.a;
                if (nVar != null) {
                    int[] iArr2 = this.m;
                    this.m[1] = 0;
                    iArr2[0] = 0;
                    nVar.a(this, childAt, view, i2, this.m);
                    max = i > 0 ? Math.max(i3, this.m[0]) : Math.min(i3, this.m[0]);
                    max2 = i2 > 0 ? Math.max(i4, this.m[1]) : Math.min(i4, this.m[1]);
                    obj2 = 1;
                    i5++;
                    i4 = max2;
                    i3 = max;
                    obj = obj2;
                }
            }
            obj2 = obj;
            max = i3;
            max2 = i4;
            i5++;
            i4 = max2;
            i3 = max;
            obj = obj2;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        if (obj != null) {
            a(true);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        boolean z = false;
        while (i5 < childCount) {
            boolean z2;
            View childAt = getChildAt(i5);
            q qVar = (q) childAt.getLayoutParams();
            if (qVar.j) {
                n nVar = qVar.a;
                if (nVar != null) {
                    nVar.b(this, childAt, i4);
                    z2 = true;
                    i5++;
                    z = z2;
                }
            }
            z2 = z;
            i5++;
            z = z2;
        }
        if (z) {
            a(true);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.y.a = i;
        this.q = view;
        this.r = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).getLayoutParams();
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            SparseArray sparseArray = savedState.a;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                n nVar = b(childAt).a;
                if (!(id == -1 || nVar == null)) {
                    Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                    if (parcelable2 != null) {
                        nVar.a(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            n nVar = ((q) childAt.getLayoutParams()).a;
            if (!(id == -1 || nVar == null)) {
                Parcelable b = nVar.b(this, childAt);
                if (b != null) {
                    sparseArray.append(id, b);
                }
            }
        }
        savedState.a = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        int childCount = getChildCount();
        int i2 = 0;
        boolean z = false;
        while (i2 < childCount) {
            boolean z2;
            View childAt = getChildAt(i2);
            q qVar = (q) childAt.getLayoutParams();
            n nVar = qVar.a;
            if (nVar != null) {
                boolean a = nVar.a(this, childAt, view, i);
                z |= a;
                qVar.j = a;
                z2 = z;
            } else {
                qVar.j = false;
                z2 = z;
            }
            i2++;
            z = z2;
        }
        return z;
    }

    public void onStopNestedScroll(View view) {
        this.y.a = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            q qVar = (q) childAt.getLayoutParams();
            if (qVar.j) {
                n nVar = qVar.a;
                if (nVar != null) {
                    nVar.a(this, childAt, view);
                }
                qVar.j = false;
                qVar.k = false;
            }
        }
        this.q = null;
        this.r = null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int a = ay.a(motionEvent);
        boolean z2;
        MotionEvent motionEvent2;
        if (this.p == null) {
            boolean a2 = a(motionEvent, 1);
            if (a2) {
                z2 = a2;
            } else {
                z2 = a2;
                z = false;
                if (this.p == null) {
                    z |= super.onTouchEvent(motionEvent);
                    motionEvent2 = null;
                } else if (z2) {
                    motionEvent2 = null;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    super.onTouchEvent(motionEvent2);
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                if (a == 1 || a == 3) {
                    a();
                }
                return z;
            }
        }
        z2 = false;
        n nVar = ((q) this.p.getLayoutParams()).a;
        z = nVar != null ? nVar.b(this, this.p, motionEvent) : false;
        if (this.p == null) {
            z |= super.onTouchEvent(motionEvent);
            motionEvent2 = null;
        } else if (z2) {
            motionEvent2 = null;
        } else {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            motionEvent2 = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEvent2);
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        a();
        return z;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            a();
        }
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.x = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.w != drawable) {
            if (this.w != null) {
                this.w.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.w = drawable2;
            if (this.w != null) {
                if (this.w.isStateful()) {
                    this.w.setState(getDrawableState());
                }
                android.support.v4.c.a.a.b(this.w, bq.h(this));
                this.w.setVisible(getVisibility() == 0, false);
                this.w.setCallback(this);
            }
            bq.d(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? android.support.v4.b.a.a(getContext(), i) : null);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.w != null && this.w.isVisible() != z) {
            this.w.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.w;
    }
}
