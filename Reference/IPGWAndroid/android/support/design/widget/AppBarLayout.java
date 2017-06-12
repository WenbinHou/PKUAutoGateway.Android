package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.g;
import android.support.design.h;
import android.support.v4.e.a;
import android.support.v4.view.bq;
import android.support.v4.view.ed;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@o(a = Behavior.class)
public class AppBarLayout extends LinearLayout {
    boolean a;
    private int b;
    private int c;
    private int d;
    private float e;
    private int f;
    private ed g;
    private final List<Object> h;

    public class Behavior extends al<AppBarLayout> {
        private int b;
        private boolean c;
        private boolean d;
        private bz e;
        private int f = -1;
        private boolean g;
        private float h;
        private WeakReference<View> i;
        private e j;

        public class SavedState extends BaseSavedState {
            public static final Creator<SavedState> CREATOR = a.a(new f());
            int a;
            float b;
            boolean c;

            public SavedState(Parcel parcel) {
                super(parcel);
                this.a = parcel.readInt();
                this.b = parcel.readFloat();
                this.c = parcel.readByte() != (byte) 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.a);
                parcel.writeFloat(this.b);
                parcel.writeByte((byte) (this.c ? 1 : 0));
            }
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private static void a(AppBarLayout appBarLayout) {
            List h = appBarLayout.h;
            int size = h.size();
            for (int i = 0; i < size; i++) {
                h.get(i);
            }
        }

        private void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int i;
            View view;
            int a = a();
            int childCount = appBarLayout.getChildCount();
            for (i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                if (childAt.getTop() <= (-a) && childAt.getBottom() >= (-a)) {
                    view = childAt;
                    break;
                }
            }
            view = null;
            if (view != null) {
                g gVar = (g) view.getLayoutParams();
                if ((gVar.a & 17) == 17) {
                    childCount = -view.getTop();
                    i = -view.getBottom();
                    int q = (gVar.a & 2) == 2 ? bq.q(view) + i : i;
                    if (a >= (q + childCount) / 2) {
                        q = childCount;
                    }
                    a(coordinatorLayout, appBarLayout, ao.a(q, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        private void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            int a = a();
            if (a != i) {
                if (this.e == null) {
                    this.e = cv.a();
                    this.e.a(a.e);
                    this.e.a(new d(this, coordinatorLayout, appBarLayout));
                } else {
                    this.e.a.e();
                }
                this.e.a(Math.round(((((float) Math.abs(a - i)) / coordinatorLayout.getResources().getDisplayMetrics().density) * 1000.0f) / 300.0f));
                this.e.a(a, i);
                this.e.a.a();
            } else if (this.e != null && this.e.a.b()) {
                this.e.a.e();
            }
        }

        final int a() {
            return super.c() + this.b;
        }

        final /* synthetic */ int a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int a = a();
            if (i2 == 0 || a < i2 || a > i3) {
                this.b = 0;
                return 0;
            }
            int a2 = ao.a(i, i2, i3);
            if (a == a2) {
                return 0;
            }
            int abs;
            int i4;
            int height;
            if (appBarLayout.a) {
                abs = Math.abs(a2);
                int childCount = appBarLayout.getChildCount();
                i4 = 0;
                while (i4 < childCount) {
                    View childAt = appBarLayout.getChildAt(i4);
                    g gVar = (g) childAt.getLayoutParams();
                    Interpolator interpolator = gVar.b;
                    if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                        i4++;
                    } else {
                        if (interpolator != null) {
                            i4 = gVar.a;
                            if ((i4 & 1) != 0) {
                                height = (gVar.bottomMargin + (childAt.getHeight() + gVar.topMargin)) + 0;
                                if ((i4 & 2) != 0) {
                                    height -= bq.q(childAt);
                                }
                            } else {
                                height = 0;
                            }
                            if (bq.v(childAt)) {
                                height -= appBarLayout.getTopInset();
                            }
                            if (height > 0) {
                                i4 = abs - childAt.getTop();
                                height = Math.round(interpolator.getInterpolation(((float) i4) / ((float) height)) * ((float) height));
                                height = (height + childAt.getTop()) * Integer.signum(a2);
                            }
                        }
                        height = a2;
                    }
                }
                height = a2;
            } else {
                height = a2;
            }
            boolean a3 = super.a(height);
            i4 = a - a2;
            this.b = a2 - height;
            if (!a3 && appBarLayout.a) {
                abs = coordinatorLayout.g.size();
                a = 0;
                a2 = 0;
                while (a < abs) {
                    View view2 = (View) coordinatorLayout.g.get(a);
                    if (view2 == appBarLayout) {
                        height = 1;
                    } else {
                        if (a2 != 0) {
                            q qVar = (q) view2.getLayoutParams();
                            n nVar = qVar.a;
                            if (nVar != null && qVar.a((View) appBarLayout)) {
                                nVar.b(coordinatorLayout, view2, (View) appBarLayout);
                            }
                        }
                        height = a2;
                    }
                    a++;
                    a2 = height;
                }
            }
            a(appBarLayout);
            return i4;
        }

        final /* synthetic */ int a(View view) {
            return ((AppBarLayout) view).getTotalScrollRange();
        }

        public final /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.a(coordinatorLayout, (View) appBarLayout, savedState.getSuperState());
                this.f = savedState.a;
                this.h = savedState.b;
                this.g = savedState.c;
                return;
            }
            super.a(coordinatorLayout, (View) appBarLayout, parcelable);
            this.f = -1;
        }

        public final /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (!this.d) {
                a(coordinatorLayout, appBarLayout);
            }
            this.c = false;
            this.d = false;
            this.i = new WeakReference(view2);
        }

        public final /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int[] iArr) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i != 0 && !this.c) {
                int i2;
                int b;
                if (i < 0) {
                    i2 = -appBarLayout.getTotalScrollRange();
                    b = i2 + appBarLayout.getDownNestedPreScrollRange();
                } else {
                    i2 = -appBarLayout.getUpNestedPreScrollRange();
                    b = 0;
                }
                iArr[1] = b(coordinatorLayout, appBarLayout, i, i2, b);
            }
        }

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, float f, boolean z) {
            boolean z2 = true;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (z) {
                int b;
                if (f < 0.0f) {
                    b = (-appBarLayout.getTotalScrollRange()) + appBarLayout.getDownNestedPreScrollRange();
                    if (a() < b) {
                        a(coordinatorLayout, appBarLayout, b);
                    }
                } else {
                    b = -appBarLayout.getUpNestedPreScrollRange();
                    if (a() > b) {
                        a(coordinatorLayout, appBarLayout, b);
                    }
                }
                z2 = false;
            } else {
                z2 = a(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange(), -f);
            }
            this.d = z2;
            return z2;
        }

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean a = super.a(coordinatorLayout, appBarLayout, i);
            int e = appBarLayout.getPendingAction();
            if (e != 0) {
                int i2 = (e & 4) != 0 ? 1 : 0;
                if ((e & 2) != 0) {
                    e = -appBarLayout.getUpNestedPreScrollRange();
                    if (i2 != 0) {
                        a(coordinatorLayout, appBarLayout, e);
                    } else {
                        a_(coordinatorLayout, appBarLayout, e);
                    }
                } else if ((e & 1) != 0) {
                    if (i2 != 0) {
                        a(coordinatorLayout, appBarLayout, 0);
                    } else {
                        a_(coordinatorLayout, appBarLayout, 0);
                    }
                }
            } else if (this.f >= 0) {
                View childAt = appBarLayout.getChildAt(this.f);
                e = -childAt.getBottom();
                super.a(this.g ? bq.q(childAt) + e : Math.round(((float) childAt.getHeight()) * this.h) + e);
            }
            appBarLayout.f = 0;
            this.f = -1;
            super.a(ao.a(super.c(), -appBarLayout.getTotalScrollRange(), 0));
            a(appBarLayout);
            return a;
        }

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean z = (i & 2) != 0 && AppBarLayout.a(appBarLayout) && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight();
            if (z && this.e != null) {
                this.e.a.e();
            }
            this.i = null;
            return z;
        }

        final /* synthetic */ int b(View view) {
            return -((AppBarLayout) view).getDownNestedScrollRange();
        }

        public final /* synthetic */ Parcelable b(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = false;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            Parcelable b = super.b(coordinatorLayout, appBarLayout);
            int c = super.c();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + c;
                if (childAt.getTop() + c > 0 || bottom < 0) {
                    i++;
                } else {
                    SavedState savedState = new SavedState(b);
                    savedState.a = i;
                    if (bottom == bq.q(childAt)) {
                        z = true;
                    }
                    savedState.c = z;
                    savedState.b = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return b;
        }

        public final /* synthetic */ void b(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i < 0) {
                b(coordinatorLayout, appBarLayout, i, -appBarLayout.getDownNestedScrollRange(), 0);
                this.c = true;
                return;
            }
            this.c = false;
        }

        final /* synthetic */ boolean b() {
            if (this.j != null) {
                return this.j.a();
            }
            if (this.i != null) {
                View view = (View) this.i.get();
                if (view == null || !view.isShown() || bq.b(view, -1)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ int c() {
            return super.c();
        }
    }

    public class ScrollingViewBehavior extends an {
        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.ScrollingViewBehavior_Params);
            this.b = obtainStyledAttributes.getDimensionPixelSize(h.ScrollingViewBehavior_Params_behavior_overlapTop, 0);
            obtainStyledAttributes.recycle();
        }

        final View a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return view;
                }
            }
            return null;
        }

        public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.a(coordinatorLayout, view, i);
        }

        public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, view, i, i2, i3, i4);
        }

        public final boolean a_(View view) {
            return view instanceof AppBarLayout;
        }

        final float b(View view) {
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int b = appBarLayout.getDownNestedPreScrollRange();
                n nVar = ((q) appBarLayout.getLayoutParams()).a;
                int a = nVar instanceof Behavior ? ((Behavior) nVar).a() : 0;
                if (b != 0 && totalScrollRange + a <= b) {
                    return 0.0f;
                }
                totalScrollRange -= b;
                if (totalScrollRange != 0) {
                    return (((float) a) / ((float) totalScrollRange)) + 1.0f;
                }
            }
            return 0.0f;
        }

        public final boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            n nVar = ((q) view2.getLayoutParams()).a;
            if (nVar instanceof Behavior) {
                int bottom = view2.getBottom() - view.getTop();
                view.offsetTopAndBottom(((((Behavior) nVar).b + bottom) + this.a) - d(view2));
            }
            return false;
        }

        public final /* bridge */ /* synthetic */ int c() {
            return super.c();
        }

        final int c(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.c(view);
        }
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.f = 0;
        setOrientation(1);
        by.a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.AppBarLayout, 0, g.Widget_Design_AppBarLayout);
        this.e = (float) obtainStyledAttributes.getDimensionPixelSize(h.AppBarLayout_elevation, 0);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(h.AppBarLayout_android_background));
        if (obtainStyledAttributes.hasValue(h.AppBarLayout_expanded)) {
            setExpanded(obtainStyledAttributes.getBoolean(h.AppBarLayout_expanded, false));
        }
        obtainStyledAttributes.recycle();
        cv.a(this);
        this.h = new ArrayList();
        bq.f((View) this, this.e);
        bq.a((View) this, new c(this));
    }

    private g a(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    private static g a(LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new g((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof MarginLayoutParams ? new g((MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    static /* synthetic */ ed a(AppBarLayout appBarLayout, ed edVar) {
        ed edVar2 = null;
        if (bq.v(appBarLayout)) {
            edVar2 = edVar;
        }
        if (edVar2 != appBarLayout.g) {
            appBarLayout.g = edVar2;
            appBarLayout.a();
        }
        return edVar;
    }

    private void a() {
        this.b = -1;
        this.c = -1;
        this.d = -1;
    }

    static /* synthetic */ boolean a(AppBarLayout appBarLayout) {
        return appBarLayout.getTotalScrollRange() != 0;
    }

    private int getDownNestedPreScrollRange() {
        if (this.c != -1) {
            return this.c;
        }
        int i;
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            g gVar = (g) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = gVar.a;
            if ((i3 & 5) != 5) {
                if (i2 > 0) {
                    break;
                }
                i = i2;
            } else {
                i = (gVar.bottomMargin + gVar.topMargin) + i2;
                i = (i3 & 8) != 0 ? i + bq.q(childAt) : (i3 & 2) != 0 ? i + (measuredHeight - bq.q(childAt)) : i + measuredHeight;
            }
            childCount--;
            i2 = i;
        }
        i = Math.max(0, i2 - getTopInset());
        this.c = i;
        return i;
    }

    private int getDownNestedScrollRange() {
        if (this.d != -1) {
            return this.d;
        }
        int i;
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            g gVar = (g) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (gVar.topMargin + gVar.bottomMargin);
            i = gVar.a;
            if ((i & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i & 2) != 0) {
                i = i2 - (bq.q(childAt) + getTopInset());
                break;
            }
        }
        i = i2;
        i = Math.max(0, i);
        this.d = i;
        return i;
    }

    private int getPendingAction() {
        return this.f;
    }

    private int getTopInset() {
        return this.g != null ? this.g.b() : 0;
    }

    private int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof g;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    protected /* synthetic */ LinearLayout.LayoutParams m0generateDefaultLayoutParams() {
        return new g();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public /* synthetic */ LinearLayout.LayoutParams m1generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ LinearLayout.LayoutParams m2generateLayoutParams(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int q = bq.q(this);
        if (q != 0) {
            return topInset + (q * 2);
        }
        q = getChildCount();
        return q > 0 ? topInset + (bq.q(getChildAt(q - 1)) * 2) : 0;
    }

    public float getTargetElevation() {
        return this.e;
    }

    public final int getTotalScrollRange() {
        if (this.b != -1) {
            return this.b;
        }
        int q;
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            g gVar = (g) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = gVar.a;
            if ((i3 & 1) == 0) {
                break;
            }
            i += gVar.bottomMargin + (measuredHeight + gVar.topMargin);
            if ((i3 & 2) != 0) {
                q = i - bq.q(childAt);
                break;
            }
        }
        q = i;
        q = Math.max(0, q - getTopInset());
        this.b = q;
        return q;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a();
        this.a = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((g) getChildAt(i5).getLayoutParams()).b != null) {
                this.a = true;
                return;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        a();
    }

    public void setExpanded(boolean z) {
        boolean F = bq.F(this);
        this.f = (F ? 4 : 0) | (z ? 1 : 2);
        requestLayout();
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setTargetElevation(float f) {
        this.e = f;
    }
}
