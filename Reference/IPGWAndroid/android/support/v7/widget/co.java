package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.bq;
import android.support.v4.view.v;
import android.support.v7.b.l;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class co extends ViewGroup {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    public co(Context context) {
        this(context, null);
    }

    public co(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public co(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        this.b = -1;
        this.c = 0;
        this.e = 8388659;
        ft a = ft.a(context, attributeSet, l.LinearLayoutCompat, i);
        int a2 = a.a(l.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.a(l.LinearLayoutCompat_android_gravity, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.a(l.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.g = a.a.getFloat(l.LinearLayoutCompat_android_weightSum, -1.0f);
        this.b = a.a(l.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.h = a.a(l.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.a(l.LinearLayoutCompat_divider));
        this.n = a.a(l.LinearLayoutCompat_showDividers, 0);
        this.o = a.c(l.LinearLayoutCompat_dividerPadding, 0);
        a.a.recycle();
    }

    private void a(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                cp cpVar = (cp) childAt.getLayoutParams();
                if (cpVar.width == -1) {
                    int i4 = cpVar.height;
                    cpVar.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    cpVar.height = i4;
                }
            }
        }
    }

    private void a(Canvas canvas, int i) {
        this.k.setBounds(getPaddingLeft() + this.o, i, (getWidth() - getPaddingRight()) - this.o, this.m + i);
        this.k.draw(canvas);
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    private boolean a(int i) {
        if (i == 0) {
            return (this.n & 1) != 0;
        } else {
            if (i == getChildCount()) {
                return (this.n & 4) != 0;
            } else {
                if ((this.n & 2) == 0) {
                    return false;
                }
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    if (getChildAt(i2).getVisibility() != 8) {
                        return true;
                    }
                }
                return false;
            }
        }
    }

    private void b(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int measuredHeight;
        int baseline;
        cp cpVar;
        this.f = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Object obj = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj2 = null;
        Object obj3 = null;
        if (this.i == null || this.j == null) {
            this.i = new int[4];
            this.j = new int[4];
        }
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.a;
        boolean z2 = this.h;
        Object obj4 = mode == 1073741824 ? 1 : null;
        int i10 = Integer.MIN_VALUE;
        int i11 = 0;
        while (i11 < virtualChildCount) {
            cp cpVar2;
            Object obj5;
            Object obj6;
            int a;
            Object obj7;
            int i12;
            View childAt = getChildAt(i11);
            if (childAt == null) {
                this.f += 0;
                i3 = i11;
            } else {
                float f2;
                Object obj8;
                if (childAt.getVisibility() != 8) {
                    if (a(i11)) {
                        this.f += this.l;
                    }
                    cpVar2 = (cp) childAt.getLayoutParams();
                    float f3 = f + cpVar2.g;
                    if (mode == 1073741824 && cpVar2.width == 0 && cpVar2.g > 0.0f) {
                        if (obj4 != null) {
                            this.f += cpVar2.leftMargin + cpVar2.rightMargin;
                        } else {
                            i3 = this.f;
                            this.f = Math.max(i3, (cpVar2.leftMargin + i3) + cpVar2.rightMargin);
                        }
                        if (z) {
                            i3 = MeasureSpec.makeMeasureSpec(0, 0);
                            childAt.measure(i3, i3);
                            i4 = i10;
                            obj5 = obj3;
                        } else {
                            i4 = i10;
                            i10 = 1;
                        }
                    } else {
                        i3 = Integer.MIN_VALUE;
                        if (cpVar2.width == 0 && cpVar2.g > 0.0f) {
                            i3 = 0;
                            cpVar2.width = -2;
                        }
                        int i13 = i3;
                        a(childAt, i, f3 == 0.0f ? this.f : 0, i2, 0);
                        if (i13 != Integer.MIN_VALUE) {
                            cpVar2.width = i13;
                        }
                        i3 = childAt.getMeasuredWidth();
                        if (obj4 != null) {
                            this.f += ((cpVar2.leftMargin + i3) + cpVar2.rightMargin) + 0;
                        } else {
                            int i14 = this.f;
                            this.f = Math.max(i14, (((i14 + i3) + cpVar2.leftMargin) + cpVar2.rightMargin) + 0);
                        }
                        if (z2) {
                            i4 = Math.max(i3, i10);
                            obj5 = obj3;
                        } else {
                            i4 = i10;
                            obj5 = obj3;
                        }
                    }
                    Object obj9 = null;
                    if (mode2 == 1073741824 || cpVar2.height != -1) {
                        obj6 = obj2;
                    } else {
                        obj6 = 1;
                        obj9 = 1;
                    }
                    i5 = cpVar2.topMargin + cpVar2.bottomMargin;
                    measuredHeight = childAt.getMeasuredHeight() + i5;
                    a = gi.a(i7, bq.j(childAt));
                    if (z) {
                        baseline = childAt.getBaseline();
                        if (baseline != -1) {
                            int i15 = ((((cpVar2.h < 0 ? this.e : cpVar2.h) & 112) >> 4) & -2) >> 1;
                            iArr[i15] = Math.max(iArr[i15], baseline);
                            iArr2[i15] = Math.max(iArr2[i15], measuredHeight - baseline);
                        }
                    }
                    baseline = Math.max(i6, measuredHeight);
                    obj7 = (obj == null || cpVar2.height != -1) ? null : 1;
                    if (cpVar2.g > 0.0f) {
                        i3 = obj9 != null ? i5 : measuredHeight;
                        f2 = f3;
                        obj8 = obj7;
                        i12 = i8;
                        obj7 = obj5;
                        i10 = baseline;
                        int i16 = i4;
                        i4 = Math.max(i9, i3);
                        i3 = i16;
                    } else {
                        if (obj9 == null) {
                            i5 = measuredHeight;
                        }
                        i3 = Math.max(i8, i5);
                        f2 = f3;
                        obj8 = obj7;
                        i12 = i3;
                        obj7 = obj5;
                        i3 = i4;
                        i4 = i9;
                        i10 = baseline;
                    }
                } else {
                    i3 = i10;
                    obj7 = obj3;
                    f2 = f;
                    obj8 = obj;
                    i4 = i9;
                    i12 = i8;
                    obj6 = obj2;
                    i10 = i6;
                    a = i7;
                }
                obj = obj8;
                i9 = i4;
                i8 = i12;
                i7 = a;
                i6 = i10;
                i10 = i3;
                obj2 = obj6;
                i3 = i11 + 0;
                f = f2;
                obj3 = obj7;
            }
            i11 = i3 + 1;
        }
        if (this.f > 0 && a(virtualChildCount)) {
            this.f += this.l;
        }
        i5 = (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) ? i6 : Math.max(i6, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f = 0;
            i15 = 0;
            while (i15 < virtualChildCount) {
                View childAt2 = getChildAt(i15);
                if (childAt2 == null) {
                    this.f += 0;
                    i3 = i15;
                } else if (childAt2.getVisibility() == 8) {
                    i3 = i15 + 0;
                } else {
                    cpVar = (cp) childAt2.getLayoutParams();
                    if (obj4 != null) {
                        this.f = ((cpVar.rightMargin + (cpVar.leftMargin + i10)) + 0) + this.f;
                        i3 = i15;
                    } else {
                        measuredHeight = this.f;
                        this.f = Math.max(measuredHeight, (cpVar.rightMargin + ((measuredHeight + i10) + cpVar.leftMargin)) + 0);
                        i3 = i15;
                    }
                }
                i15 = i3 + 1;
            }
        }
        this.f += getPaddingLeft() + getPaddingRight();
        i6 = bq.a(Math.max(this.f, getSuggestedMinimumWidth()), i, 0);
        measuredHeight = (16777215 & i6) - this.f;
        View view;
        if (obj3 != null || (measuredHeight != 0 && f > 0.0f)) {
            if (this.g > 0.0f) {
                f = this.g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f = 0;
            i9 = 0;
            obj5 = obj;
            baseline = i8;
            int i17 = -1;
            i4 = i7;
            while (i9 < virtualChildCount) {
                float f4;
                View childAt3 = getChildAt(i9);
                if (childAt3 == null || childAt3.getVisibility() == 8) {
                    f4 = f;
                    i15 = measuredHeight;
                    i5 = baseline;
                    obj6 = obj5;
                    measuredHeight = i4;
                    i4 = i17;
                } else {
                    int childMeasureSpec;
                    float f5;
                    cpVar = (cp) childAt3.getLayoutParams();
                    float f6 = cpVar.g;
                    if (f6 > 0.0f) {
                        i15 = (int) ((((float) measuredHeight) * f6) / f);
                        f6 = f - f6;
                        measuredHeight -= i15;
                        childMeasureSpec = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + cpVar.topMargin) + cpVar.bottomMargin, cpVar.height);
                        if (cpVar.width != 0 || mode != 1073741824) {
                            i15 += childAt3.getMeasuredWidth();
                            if (i15 < 0) {
                                i15 = 0;
                            }
                            view = childAt3;
                        } else if (i15 > 0) {
                            view = childAt3;
                        } else {
                            i15 = 0;
                            view = childAt3;
                        }
                        view.measure(MeasureSpec.makeMeasureSpec(i15, 1073741824), childMeasureSpec);
                        childMeasureSpec = gi.a(i4, bq.j(childAt3) & -16777216);
                        f5 = f6;
                        i12 = measuredHeight;
                    } else {
                        i12 = measuredHeight;
                        childMeasureSpec = i4;
                        f5 = f;
                    }
                    if (obj4 != null) {
                        this.f += ((childAt3.getMeasuredWidth() + cpVar.leftMargin) + cpVar.rightMargin) + 0;
                    } else {
                        i15 = this.f;
                        this.f = Math.max(i15, (((childAt3.getMeasuredWidth() + i15) + cpVar.leftMargin) + cpVar.rightMargin) + 0);
                    }
                    obj7 = (mode2 == 1073741824 || cpVar.height != -1) ? null : 1;
                    i14 = cpVar.topMargin + cpVar.bottomMargin;
                    measuredHeight = childAt3.getMeasuredHeight() + i14;
                    i17 = Math.max(i17, measuredHeight);
                    i14 = Math.max(baseline, obj7 != null ? i14 : measuredHeight);
                    obj7 = (obj5 == null || cpVar.height != -1) ? null : 1;
                    if (z) {
                        i5 = childAt3.getBaseline();
                        if (i5 != -1) {
                            i3 = ((((cpVar.h < 0 ? this.e : cpVar.h) & 112) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i5);
                            iArr2[i3] = Math.max(iArr2[i3], measuredHeight - i5);
                        }
                    }
                    f4 = f5;
                    i5 = i14;
                    measuredHeight = childMeasureSpec;
                    obj6 = obj7;
                    i4 = i17;
                    i15 = i12;
                }
                i9++;
                obj5 = obj6;
                baseline = i5;
                i17 = i4;
                i4 = measuredHeight;
                f = f4;
                measuredHeight = i15;
            }
            this.f += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i17 = Math.max(i17, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            i3 = baseline;
            i7 = i4;
            i15 = i17;
            obj = obj5;
        } else {
            baseline = Math.max(i8, i9);
            if (z2 && mode != 1073741824) {
                for (i15 = 0; i15 < virtualChildCount; i15++) {
                    view = getChildAt(i15);
                    if (!(view == null || view.getVisibility() == 8 || ((cp) view.getLayoutParams()).g <= 0.0f)) {
                        view.measure(MeasureSpec.makeMeasureSpec(i10, 1073741824), MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = baseline;
            i15 = i5;
        }
        if (obj != null || mode2 == 1073741824) {
            i3 = i15;
        }
        setMeasuredDimension((-16777216 & i7) | i6, bq.a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i7 << 16));
        if (obj2 != null) {
            measuredHeight = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
            for (int i18 = 0; i18 < virtualChildCount; i18++) {
                childAt = getChildAt(i18);
                if (childAt.getVisibility() != 8) {
                    cpVar2 = (cp) childAt.getLayoutParams();
                    if (cpVar2.height == -1) {
                        a = cpVar2.width;
                        cpVar2.width = childAt.getMeasuredWidth();
                        measureChildWithMargins(childAt, i, 0, measuredHeight, 0);
                        cpVar2.width = a;
                    }
                }
            }
        }
    }

    private void b(Canvas canvas, int i) {
        this.k.setBounds(i, getPaddingTop() + this.o, this.l + i, (getHeight() - getPaddingBottom()) - this.o);
        this.k.draw(canvas);
    }

    private static void b(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    private static int getChildrenSkipCount$5359dca7() {
        return 0;
    }

    private static int getLocationOffset$3c7ec8d0() {
        return 0;
    }

    private static int getNextLocationOffset$3c7ec8d0() {
        return 0;
    }

    public cp a(AttributeSet attributeSet) {
        return new cp(getContext(), attributeSet);
    }

    protected cp b(LayoutParams layoutParams) {
        return new cp(layoutParams);
    }

    protected cp c() {
        return this.d == 0 ? new cp(-2, -2) : this.d == 1 ? new cp(-1, -2) : null;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof cp;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return c();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return b(layoutParams);
    }

    public int getBaseline() {
        if (this.b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.c;
            if (this.d == 1) {
                i = this.e & 112;
                if (i != 48) {
                    switch (i) {
                        case 16:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f) / 2);
                            break;
                        case 80:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f;
                            break;
                    }
                }
            }
            i = i2;
            return (((cp) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    public int getOrientation() {
        return this.d;
    }

    public int getShowDividers() {
        return this.n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    protected void onDraw(Canvas canvas) {
        if (this.k != null) {
            int virtualChildCount;
            int i;
            View childAt;
            if (this.d == 1) {
                virtualChildCount = getVirtualChildCount();
                i = 0;
                while (i < virtualChildCount) {
                    View childAt2 = getChildAt(i);
                    if (!(childAt2 == null || childAt2.getVisibility() == 8 || !a(i))) {
                        a(canvas, (childAt2.getTop() - ((cp) childAt2.getLayoutParams()).topMargin) - this.m);
                    }
                    i++;
                }
                if (a(virtualChildCount)) {
                    childAt = getChildAt(virtualChildCount - 1);
                    a(canvas, childAt == null ? (getHeight() - getPaddingBottom()) - this.m : ((cp) childAt.getLayoutParams()).bottomMargin + childAt.getBottom());
                    return;
                }
                return;
            }
            cp cpVar;
            virtualChildCount = getVirtualChildCount();
            boolean a = gi.a(this);
            i = 0;
            while (i < virtualChildCount) {
                View childAt3 = getChildAt(i);
                if (!(childAt3 == null || childAt3.getVisibility() == 8 || !a(i))) {
                    cpVar = (cp) childAt3.getLayoutParams();
                    b(canvas, a ? cpVar.rightMargin + childAt3.getRight() : (childAt3.getLeft() - cpVar.leftMargin) - this.l);
                }
                i++;
            }
            if (a(virtualChildCount)) {
                int paddingLeft;
                childAt = getChildAt(virtualChildCount - 1);
                if (childAt == null) {
                    paddingLeft = a ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.l;
                } else {
                    cpVar = (cp) childAt.getLayoutParams();
                    paddingLeft = a ? (childAt.getLeft() - cpVar.leftMargin) - this.l : cpVar.rightMargin + childAt.getRight();
                }
                b(canvas, paddingLeft);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(co.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(co.class.getName());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int paddingRight;
        int paddingRight2;
        int virtualChildCount;
        int i6;
        int i7;
        int i8;
        int measuredWidth;
        cp cpVar;
        int i9;
        if (this.d == 1) {
            paddingLeft = getPaddingLeft();
            i5 = i3 - i;
            paddingRight = i5 - getPaddingRight();
            paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
            virtualChildCount = getVirtualChildCount();
            i6 = 8388615 & this.e;
            switch (this.e & 112) {
                case 16:
                    i5 = getPaddingTop() + (((i4 - i2) - this.f) / 2);
                    break;
                case 80:
                    i5 = ((getPaddingTop() + i4) - i2) - this.f;
                    break;
                default:
                    i5 = getPaddingTop();
                    break;
            }
            i7 = 0;
            i8 = i5;
            while (i7 < virtualChildCount) {
                View childAt = getChildAt(i7);
                if (childAt == null) {
                    i8 += 0;
                    i5 = i7;
                } else if (childAt.getVisibility() != 8) {
                    measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    cpVar = (cp) childAt.getLayoutParams();
                    i9 = cpVar.h;
                    if (i9 < 0) {
                        i9 = i6;
                    }
                    switch (v.a(i9, bq.h(this)) & 7) {
                        case 1:
                            i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + cpVar.leftMargin) - cpVar.rightMargin;
                            break;
                        case 5:
                            i9 = (paddingRight - measuredWidth) - cpVar.rightMargin;
                            break;
                        default:
                            i9 = cpVar.leftMargin + paddingLeft;
                            break;
                    }
                    if (a(i7)) {
                        i8 += this.m;
                    }
                    i8 += cpVar.topMargin;
                    b(childAt, i9, i8 + 0, measuredWidth, measuredHeight);
                    i8 += (cpVar.bottomMargin + measuredHeight) + 0;
                    i5 = i7 + 0;
                } else {
                    i5 = i7;
                }
                i7 = i5 + 1;
            }
            return;
        }
        boolean a = gi.a(this);
        paddingLeft = getPaddingTop();
        i5 = i4 - i2;
        int paddingBottom = i5 - getPaddingBottom();
        measuredWidth = (i5 - paddingLeft) - getPaddingBottom();
        measuredHeight = getVirtualChildCount();
        i5 = this.e & 8388615;
        virtualChildCount = this.e & 112;
        boolean z2 = this.a;
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        switch (v.a(i5, bq.h(this))) {
            case 1:
                paddingRight = getPaddingLeft() + (((i3 - i) - this.f) / 2);
                break;
            case 5:
                paddingRight = ((getPaddingLeft() + i3) - i) - this.f;
                break;
            default:
                paddingRight = getPaddingLeft();
                break;
        }
        if (a) {
            i6 = measuredHeight - 1;
            i9 = -1;
        } else {
            i6 = 0;
            i9 = 1;
        }
        paddingRight2 = 0;
        while (paddingRight2 < measuredHeight) {
            int i10 = i6 + (i9 * paddingRight2);
            View childAt2 = getChildAt(i10);
            if (childAt2 == null) {
                paddingRight += 0;
                i5 = paddingRight2;
            } else if (childAt2.getVisibility() != 8) {
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int measuredHeight2 = childAt2.getMeasuredHeight();
                i8 = -1;
                cpVar = (cp) childAt2.getLayoutParams();
                if (z2 && cpVar.height != -1) {
                    i8 = childAt2.getBaseline();
                }
                i7 = cpVar.h;
                if (i7 < 0) {
                    i7 = virtualChildCount;
                }
                switch (i7 & 112) {
                    case 16:
                        i8 = ((((measuredWidth - measuredHeight2) / 2) + paddingLeft) + cpVar.topMargin) - cpVar.bottomMargin;
                        break;
                    case 48:
                        i7 = cpVar.topMargin + paddingLeft;
                        if (i8 != -1) {
                            i8 = (iArr[1] - i8) + i7;
                            break;
                        }
                    case 80:
                        i7 = (paddingBottom - measuredHeight2) - cpVar.bottomMargin;
                        if (i8 != -1) {
                            i8 = i7 - (iArr2[2] - (childAt2.getMeasuredHeight() - i8));
                            break;
                        }
                    default:
                        i8 = paddingLeft;
                        break;
                }
                i7 = (a(i10) ? this.l + paddingRight : paddingRight) + cpVar.leftMargin;
                b(childAt2, i7 + 0, i8, measuredWidth2, measuredHeight2);
                paddingRight = i7 + ((cpVar.rightMargin + measuredWidth2) + 0);
                i5 = paddingRight2 + 0;
            } else {
                i5 = paddingRight2;
            }
            paddingRight2 = i5 + 1;
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.d == 1) {
            int i3;
            int i4;
            int i5;
            int i6;
            int measuredWidth;
            int max;
            int i7;
            int i8;
            cp cpVar;
            this.f = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            Object obj = 1;
            float f = 0.0f;
            int virtualChildCount = getVirtualChildCount();
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            Object obj2 = null;
            Object obj3 = null;
            int i13 = this.b;
            boolean z = this.h;
            int i14 = Integer.MIN_VALUE;
            int i15 = 0;
            while (i15 < virtualChildCount) {
                View childAt = getChildAt(i15);
                if (childAt == null) {
                    this.f += 0;
                    i3 = i15;
                } else {
                    Object obj4;
                    int a;
                    Object obj5;
                    float f2;
                    Object obj6;
                    if (childAt.getVisibility() != 8) {
                        Object obj7;
                        if (a(i15)) {
                            this.f += this.m;
                        }
                        cp cpVar2 = (cp) childAt.getLayoutParams();
                        float f3 = f + cpVar2.g;
                        if (mode2 == 1073741824 && cpVar2.height == 0 && cpVar2.g > 0.0f) {
                            i3 = this.f;
                            this.f = Math.max(i3, (cpVar2.topMargin + i3) + cpVar2.bottomMargin);
                            i4 = i14;
                            obj7 = 1;
                        } else {
                            i3 = Integer.MIN_VALUE;
                            if (cpVar2.height == 0 && cpVar2.g > 0.0f) {
                                i3 = 0;
                                cpVar2.height = -2;
                            }
                            int i16 = i3;
                            a(childAt, i, 0, i2, f3 == 0.0f ? this.f : 0);
                            if (i16 != Integer.MIN_VALUE) {
                                cpVar2.height = i16;
                            }
                            i3 = childAt.getMeasuredHeight();
                            i5 = this.f;
                            this.f = Math.max(i5, (((i5 + i3) + cpVar2.topMargin) + cpVar2.bottomMargin) + 0);
                            if (z) {
                                i4 = Math.max(i3, i14);
                                obj7 = obj3;
                            } else {
                                i4 = i14;
                                obj7 = obj3;
                            }
                        }
                        if (i13 >= 0 && i13 == i15 + 1) {
                            this.c = this.f;
                        }
                        if (i15 >= i13 || cpVar2.g <= 0.0f) {
                            Object obj8 = null;
                            if (mode == 1073741824 || cpVar2.width != -1) {
                                obj4 = obj2;
                            } else {
                                obj4 = 1;
                                obj8 = 1;
                            }
                            i6 = cpVar2.leftMargin + cpVar2.rightMargin;
                            measuredWidth = childAt.getMeasuredWidth() + i6;
                            max = Math.max(i9, measuredWidth);
                            a = gi.a(i10, bq.j(childAt));
                            obj5 = (obj == null || cpVar2.width != -1) ? null : 1;
                            if (cpVar2.g > 0.0f) {
                                i3 = obj8 != null ? i6 : measuredWidth;
                                f2 = f3;
                                obj6 = obj5;
                                i7 = i11;
                                obj5 = obj7;
                                i14 = max;
                                int i17 = i4;
                                i4 = Math.max(i12, i3);
                                i3 = i17;
                            } else {
                                if (obj8 == null) {
                                    i6 = measuredWidth;
                                }
                                i3 = Math.max(i11, i6);
                                f2 = f3;
                                obj6 = obj5;
                                i7 = i3;
                                obj5 = obj7;
                                i3 = i4;
                                i4 = i12;
                                i14 = max;
                            }
                        } else {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                    }
                    i3 = i14;
                    obj5 = obj3;
                    f2 = f;
                    obj6 = obj;
                    i4 = i12;
                    i7 = i11;
                    obj4 = obj2;
                    i14 = i9;
                    a = i10;
                    obj = obj6;
                    i12 = i4;
                    i11 = i7;
                    i10 = a;
                    i9 = i14;
                    i14 = i3;
                    obj2 = obj4;
                    i3 = i15 + 0;
                    f = f2;
                    obj3 = obj5;
                }
                i15 = i3 + 1;
            }
            if (this.f > 0 && a(virtualChildCount)) {
                this.f += this.m;
            }
            if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
                this.f = 0;
                i8 = 0;
                while (i8 < virtualChildCount) {
                    View childAt2 = getChildAt(i8);
                    if (childAt2 == null) {
                        this.f += 0;
                        i3 = i8;
                    } else if (childAt2.getVisibility() == 8) {
                        i3 = i8 + 0;
                    } else {
                        cpVar = (cp) childAt2.getLayoutParams();
                        i6 = this.f;
                        this.f = Math.max(i6, (cpVar.bottomMargin + ((i6 + i14) + cpVar.topMargin)) + 0);
                        i3 = i8;
                    }
                    i8 = i3 + 1;
                }
            }
            this.f += getPaddingTop() + getPaddingBottom();
            i15 = bq.a(Math.max(this.f, getSuggestedMinimumHeight()), i2, 0);
            i6 = (16777215 & i15) - this.f;
            int i18;
            if (obj3 != null || (i6 != 0 && f > 0.0f)) {
                if (this.g > 0.0f) {
                    f = this.g;
                }
                this.f = 0;
                i12 = 0;
                obj3 = obj;
                i18 = i11;
                i14 = i10;
                int i19 = i9;
                while (i12 < virtualChildCount) {
                    float f4;
                    Object obj9;
                    View childAt3 = getChildAt(i12);
                    if (childAt3.getVisibility() != 8) {
                        cpVar = (cp) childAt3.getLayoutParams();
                        float f5 = cpVar.g;
                        if (f5 > 0.0f) {
                            View view;
                            i8 = (int) ((((float) i6) * f5) / f);
                            f5 = f - f5;
                            i7 = i6 - i8;
                            i5 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + cpVar.leftMargin) + cpVar.rightMargin, cpVar.width);
                            if (cpVar.height != 0 || mode2 != 1073741824) {
                                i8 += childAt3.getMeasuredHeight();
                                if (i8 < 0) {
                                    i8 = 0;
                                }
                                view = childAt3;
                            } else if (i8 > 0) {
                                view = childAt3;
                            } else {
                                i8 = 0;
                                view = childAt3;
                            }
                            view.measure(i5, MeasureSpec.makeMeasureSpec(i8, 1073741824));
                            i5 = i7;
                            i6 = gi.a(i14, bq.j(childAt3) & -256);
                            f4 = f5;
                        } else {
                            f4 = f;
                            i5 = i6;
                            i6 = i14;
                        }
                        i4 = cpVar.leftMargin + cpVar.rightMargin;
                        i7 = childAt3.getMeasuredWidth() + i4;
                        i14 = Math.max(i19, i7);
                        obj = (mode == 1073741824 || cpVar.width != -1) ? null : 1;
                        if (obj == null) {
                            i4 = i7;
                        }
                        i7 = Math.max(i18, i4);
                        obj9 = (obj3 == null || cpVar.width != -1) ? null : 1;
                        max = this.f;
                        this.f = Math.max(max, (cpVar.bottomMargin + ((childAt3.getMeasuredHeight() + max) + cpVar.topMargin)) + 0);
                        i3 = i7;
                        measuredWidth = i14;
                    } else {
                        f4 = f;
                        obj9 = obj3;
                        i3 = i18;
                        measuredWidth = i19;
                        i5 = i6;
                        i6 = i14;
                    }
                    i12++;
                    obj3 = obj9;
                    i18 = i3;
                    i14 = i6;
                    i19 = measuredWidth;
                    i6 = i5;
                    f = f4;
                }
                this.f += getPaddingTop() + getPaddingBottom();
                i3 = i18;
                i10 = i14;
                i8 = i19;
                obj = obj3;
            } else {
                i18 = Math.max(i11, i12);
                if (z && mode2 != 1073741824) {
                    for (i8 = 0; i8 < virtualChildCount; i8++) {
                        View childAt4 = getChildAt(i8);
                        if (!(childAt4 == null || childAt4.getVisibility() == 8 || ((cp) childAt4.getLayoutParams()).g <= 0.0f)) {
                            childAt4.measure(MeasureSpec.makeMeasureSpec(childAt4.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i14, 1073741824));
                        }
                    }
                }
                i3 = i18;
                i8 = i9;
            }
            if (obj != null || mode == 1073741824) {
                i3 = i8;
            }
            setMeasuredDimension(bq.a(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i10), i15);
            if (obj2 != null) {
                a(virtualChildCount, i2);
                return;
            }
            return;
        }
        b(i, i2);
    }

    public void setBaselineAligned(boolean z) {
        this.a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.b = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.k) {
            this.k = drawable;
            if (drawable != null) {
                this.l = drawable.getIntrinsicWidth();
                this.m = drawable.getIntrinsicHeight();
            } else {
                this.l = 0;
                this.m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.o = i;
    }

    public void setGravity(int i) {
        if (this.e != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.e & 8388615) != i2) {
            this.e = i2 | (this.e & -8388616);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.h = z;
    }

    public void setOrientation(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.n) {
            requestLayout();
        }
        this.n = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.e & 112) != i2) {
            this.e = i2 | (this.e & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.g = Math.max(0.0f, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
