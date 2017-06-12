package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.k;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.y;
import android.support.v7.view.menu.z;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends co implements k, z {
    i a;
    boolean b;
    k c;
    private Context d;
    private int e;
    private y f;
    private j g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private w l;

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.j = (int) (56.0f * f);
        this.k = (int) (f * 4.0f);
        this.d = context;
        this.e = 0;
    }

    static int a(View view, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = false;
        u uVar = (u) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.b();
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z2 && r1 < 2) {
                i5 = 2;
            }
        }
        if (!uVar.a && z2) {
            z = true;
        }
        uVar.d = z;
        uVar.b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    public static u a() {
        u d = d();
        d.a = true;
        return d;
    }

    protected static u a(LayoutParams layoutParams) {
        if (layoutParams == null) {
            return d();
        }
        u uVar = layoutParams instanceof u ? new u((u) layoutParams) : new u(layoutParams);
        if (uVar.h > 0) {
            return uVar;
        }
        uVar.h = 16;
        return uVar;
    }

    private boolean a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof s)) {
            z = ((s) childAt).d() | 0;
        }
        return (i <= 0 || !(childAt2 instanceof s)) ? z : ((s) childAt2).c() | z;
    }

    private u b(AttributeSet attributeSet) {
        return new u(getContext(), attributeSet);
    }

    private static u d() {
        u uVar = new u();
        uVar.h = 16;
        return uVar;
    }

    public final /* synthetic */ cp a(AttributeSet attributeSet) {
        return b(attributeSet);
    }

    public final void a(i iVar) {
        this.a = iVar;
    }

    public final void a(y yVar, j jVar) {
        this.f = yVar;
        this.g = jVar;
    }

    public final boolean a(m mVar) {
        return this.a.a((MenuItem) mVar, null, 0);
    }

    protected final /* synthetic */ cp b(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public final void b() {
        if (this.c != null) {
            this.c.e();
        }
    }

    protected final /* synthetic */ cp c() {
        return d();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof u);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return d();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return b(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public Menu getMenu() {
        if (this.a == null) {
            Context context = getContext();
            this.a = new i(context);
            this.a.a(new v());
            this.c = new k(context);
            this.c.b();
            this.c.f = this.f != null ? this.f : new t();
            this.a.a(this.c, this.d);
            this.c.a(this);
        }
        return this.a;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        k kVar = this.c;
        return kVar.i != null ? kVar.i.getDrawable() : kVar.k ? kVar.j : null;
    }

    public int getPopupTheme() {
        return this.e;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.c != null) {
            this.c.b(false);
            if (this.c.g()) {
                this.c.d();
                this.c.c();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.h) {
            u uVar;
            int measuredWidth;
            int paddingLeft;
            int i5;
            int childCount = getChildCount();
            int i6 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i7 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean a = gi.a(this);
            int i8 = 0;
            while (i8 < childCount) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8) {
                    uVar = (u) childAt.getLayoutParams();
                    if (uVar.a) {
                        measuredWidth = childAt.getMeasuredWidth();
                        if (a(i8)) {
                            measuredWidth += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = uVar.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + measuredWidth;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - uVar.rightMargin;
                            paddingLeft = i5 - measuredWidth;
                        }
                        int i9 = i6 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i9, i5, measuredHeight + i9);
                        paddingLeft = paddingRight - measuredWidth;
                        obj = 1;
                        measuredWidth = i7;
                    } else {
                        paddingLeft = paddingRight - (uVar.rightMargin + (childAt.getMeasuredWidth() + uVar.leftMargin));
                        a(i8);
                        measuredWidth = i7 + 1;
                    }
                } else {
                    paddingLeft = paddingRight;
                    measuredWidth = i7;
                }
                i8++;
                i7 = measuredWidth;
                paddingRight = paddingLeft;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                measuredWidth = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (measuredWidth / 2);
                i7 = i6 - (i5 / 2);
                childAt2.layout(paddingRight, i7, measuredWidth + paddingRight, i5 + i7);
                return;
            }
            paddingLeft = i7 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            int i10;
            if (a) {
                measuredWidth = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    uVar = (u) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8 || uVar.a) {
                        paddingLeft = measuredWidth;
                    } else {
                        measuredWidth -= uVar.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        dividerWidth = childAt3.getMeasuredHeight();
                        i10 = i6 - (dividerWidth / 2);
                        childAt3.layout(measuredWidth - i8, i10, measuredWidth, dividerWidth + i10);
                        paddingLeft = measuredWidth - ((uVar.leftMargin + i8) + paddingRight);
                    }
                    i5++;
                    measuredWidth = paddingLeft;
                }
                return;
            }
            measuredWidth = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                uVar = (u) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8 || uVar.a) {
                    paddingLeft = measuredWidth;
                } else {
                    measuredWidth += uVar.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    dividerWidth = childAt3.getMeasuredHeight();
                    i10 = i6 - (dividerWidth / 2);
                    childAt3.layout(measuredWidth, i10, measuredWidth + i8, dividerWidth + i10);
                    paddingLeft = ((uVar.rightMargin + i8) + paddingRight) + measuredWidth;
                }
                i5++;
                measuredWidth = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.h;
        this.h = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.h) {
            this.i = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.h || this.a == null || size == this.i)) {
            this.i = size;
            this.a.b(true);
        }
        int childCount = getChildCount();
        int i3;
        if (!this.h || childCount <= 0) {
            for (i3 = 0; i3 < childCount; i3++) {
                u uVar = (u) getChildAt(i3).getLayoutParams();
                uVar.rightMargin = 0;
                uVar.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i2);
        size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        i3 = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i4 = size - i3;
        int i5 = i4 / this.j;
        size = i4 % this.j;
        if (i5 == 0) {
            setMeasuredDimension(i4, 0);
            return;
        }
        Object obj;
        int i6 = this.j + (size / i5);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        i3 = 0;
        Object obj2 = null;
        long j = 0;
        int childCount2 = getChildCount();
        int i10 = 0;
        while (i10 < childCount2) {
            int i11;
            int i12;
            int i13;
            long j2;
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                boolean z2 = childAt instanceof ActionMenuItemView;
                i11 = i3 + 1;
                if (z2) {
                    childAt.setPadding(this.k, 0, this.k, 0);
                }
                uVar = (u) childAt.getLayoutParams();
                uVar.f = false;
                uVar.c = 0;
                uVar.b = 0;
                uVar.d = false;
                uVar.leftMargin = 0;
                uVar.rightMargin = 0;
                z = z2 && ((ActionMenuItemView) childAt).b();
                uVar.e = z;
                int a = a(childAt, i6, uVar.a ? 1 : i5, childMeasureSpec, paddingTop);
                i8 = Math.max(i8, a);
                i3 = uVar.d ? i9 + 1 : i9;
                obj = uVar.a ? 1 : obj2;
                int i14 = i5 - a;
                i9 = Math.max(i7, childAt.getMeasuredHeight());
                if (a == 1) {
                    long j3 = ((long) (1 << i10)) | j;
                    i12 = i9;
                    i13 = i14;
                    i9 = i3;
                    obj2 = obj;
                    j2 = j3;
                    i5 = i8;
                    childCount = i11;
                } else {
                    childCount = i11;
                    i5 = i8;
                    long j4 = j;
                    i12 = i9;
                    i13 = i14;
                    obj2 = obj;
                    i9 = i3;
                    j2 = j4;
                }
            } else {
                childCount = i3;
                j2 = j;
                i12 = i7;
                i13 = i5;
                i5 = i8;
            }
            i10++;
            i8 = i5;
            i7 = i12;
            i5 = i13;
            j = j2;
            i3 = childCount;
        }
        Object obj3 = (obj2 == null || i3 != 2) ? null : 1;
        Object obj4 = null;
        long j5 = j;
        paddingTop = i5;
        while (i9 > 0 && paddingTop > 0) {
            i11 = Integer.MAX_VALUE;
            j = 0;
            i5 = 0;
            int i15 = 0;
            while (i15 < childCount2) {
                uVar = (u) getChildAt(i15).getLayoutParams();
                if (uVar.d) {
                    if (uVar.b < i11) {
                        i5 = uVar.b;
                        j = (long) (1 << i15);
                        size = 1;
                    } else if (uVar.b == i11) {
                        j |= (long) (1 << i15);
                        size = i5 + 1;
                        i5 = i11;
                    }
                    i15++;
                    i11 = i5;
                    i5 = size;
                }
                size = i5;
                i5 = i11;
                i15++;
                i11 = i5;
                i5 = size;
            }
            j5 |= j;
            if (i5 > paddingTop) {
                break;
            }
            i15 = i11 + 1;
            i11 = 0;
            i5 = paddingTop;
            long j6 = j5;
            while (i11 < childCount2) {
                View childAt2 = getChildAt(i11);
                uVar = (u) childAt2.getLayoutParams();
                if ((((long) (1 << i11)) & j) != 0) {
                    if (obj3 != null && uVar.e && i5 == 1) {
                        childAt2.setPadding(this.k + i6, 0, this.k, 0);
                    }
                    uVar.b++;
                    uVar.f = true;
                    size = i5 - 1;
                } else if (uVar.b == i15) {
                    j6 |= (long) (1 << i11);
                    size = i5;
                } else {
                    size = i5;
                }
                i11++;
                i5 = size;
            }
            j5 = j6;
            i10 = 1;
            paddingTop = i5;
        }
        j = j5;
        obj = (obj2 == null && i3 == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= i3 - 1 && obj == null && i8 <= 1)) {
            obj3 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((u) getChildAt(0).getLayoutParams()).e)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount2 - 1))) & j) == 0 || ((u) getChildAt(childCount2 - 1).getLayoutParams()).e)) {
                    f = bitCount - 0.5f;
                    i3 = f <= 0.0f ? (int) (((float) (paddingTop * i6)) / f) : 0;
                    i5 = 0;
                    obj3 = obj4;
                    while (i5 < childCount2) {
                        if ((((long) (1 << i5)) & j) != 0) {
                            childAt3 = getChildAt(i5);
                            uVar = (u) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                uVar.c = i3;
                                uVar.f = true;
                                if (i5 == 0 && !uVar.e) {
                                    uVar.leftMargin = (-i3) / 2;
                                }
                                obj = 1;
                            } else if (uVar.a) {
                                if (i5 != 0) {
                                    uVar.leftMargin = i3 / 2;
                                }
                                if (i5 != childCount2 - 1) {
                                    uVar.rightMargin = i3 / 2;
                                }
                            } else {
                                uVar.c = i3;
                                uVar.f = true;
                                uVar.rightMargin = (-i3) / 2;
                                obj = 1;
                            }
                            i5++;
                            obj3 = obj;
                        }
                        obj = obj3;
                        i5++;
                        obj3 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i5 = 0;
            obj3 = obj4;
            while (i5 < childCount2) {
                if ((((long) (1 << i5)) & j) != 0) {
                    childAt3 = getChildAt(i5);
                    uVar = (u) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        uVar.c = i3;
                        uVar.f = true;
                        uVar.leftMargin = (-i3) / 2;
                        obj = 1;
                    } else if (uVar.a) {
                        if (i5 != 0) {
                            uVar.leftMargin = i3 / 2;
                        }
                        if (i5 != childCount2 - 1) {
                            uVar.rightMargin = i3 / 2;
                        }
                    } else {
                        uVar.c = i3;
                        uVar.f = true;
                        uVar.rightMargin = (-i3) / 2;
                        obj = 1;
                    }
                    i5++;
                    obj3 = obj;
                }
                obj = obj3;
                i5++;
                obj3 = obj;
            }
        }
        if (obj3 != null) {
            for (i3 = 0; i3 < childCount2; i3++) {
                childAt = getChildAt(i3);
                uVar = (u) childAt.getLayoutParams();
                if (uVar.f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(uVar.c + (uVar.b * i6), 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i7 = size2;
        }
        setMeasuredDimension(i4, i7);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.c.n = z;
    }

    public void setOnMenuItemClickListener(w wVar) {
        this.l = wVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        k kVar = this.c;
        if (kVar.i != null) {
            kVar.i.setImageDrawable(drawable);
            return;
        }
        kVar.k = true;
        kVar.j = drawable;
    }

    public void setOverflowReserved(boolean z) {
        this.b = z;
    }

    public void setPopupTheme(int i) {
        if (this.e != i) {
            this.e = i;
            if (i == 0) {
                this.d = getContext();
            } else {
                this.d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(k kVar) {
        this.c = kVar;
        this.c.a(this);
    }
}
