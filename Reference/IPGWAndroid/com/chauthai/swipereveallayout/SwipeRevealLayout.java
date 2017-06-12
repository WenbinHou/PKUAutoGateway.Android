package com.chauthai.swipereveallayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v4.view.bq;
import android.support.v4.view.q;
import android.support.v4.widget.bm;
import android.support.v4.widget.bp;
import android.util.AttributeSet;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

@SuppressLint({"RtlHardcoded"})
public class SwipeRevealLayout extends ViewGroup {
    public volatile boolean a = false;
    public bm b;
    private View c;
    private View d;
    private Rect e = new Rect();
    private Rect f = new Rect();
    private Rect g = new Rect();
    private Rect h = new Rect();
    private boolean i = false;
    private volatile boolean j = false;
    private volatile boolean k = false;
    private int l = 300;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 1;
    private q r;
    private e s;
    private f t;
    private final OnGestureListener u = new c(this);
    private final bp v = new d(this);

    public SwipeRevealLayout(Context context) {
        super(context);
        a(context, null);
    }

    public SwipeRevealLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public SwipeRevealLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (!(attributeSet == null || context == null)) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, b.SwipeRevealLayout, 0, 0);
            this.q = obtainStyledAttributes.getInteger(b.SwipeRevealLayout_dragEdge, 1);
            this.l = obtainStyledAttributes.getInteger(b.SwipeRevealLayout_flingVelocity, 300);
            this.n = obtainStyledAttributes.getInteger(b.SwipeRevealLayout_mode, 0);
        }
        this.b = bm.a((ViewGroup) this, 1.0f, this.v);
        this.b.c = 15;
        this.r = new q(context, this.u);
    }

    private int getHalfwayPivotHorizontal() {
        return this.q == 1 ? this.e.left + (this.d.getWidth() / 2) : this.e.right - (this.d.getWidth() / 2);
    }

    private int getHalfwayPivotVertical() {
        return this.q == 4 ? this.e.top + (this.d.getHeight() / 2) : this.e.bottom - (this.d.getHeight() / 2);
    }

    private int getMainOpenLeft() {
        switch (this.q) {
            case 1:
                return this.e.left + this.d.getWidth();
            case 2:
                return this.e.left - this.d.getWidth();
            case 4:
                return this.e.left;
            case 8:
                return this.e.left;
            default:
                return 0;
        }
    }

    private int getMainOpenTop() {
        switch (this.q) {
            case 1:
                return this.e.top;
            case 2:
                return this.e.top;
            case 4:
                return this.e.top + this.d.getHeight();
            case 8:
                return this.e.top - this.d.getHeight();
            default:
                return 0;
        }
    }

    private int getSecOpenLeft() {
        return (this.n == 0 || this.q == 8 || this.q == 4) ? this.g.left : this.q == 1 ? this.g.left + this.d.getWidth() : this.g.left - this.d.getWidth();
    }

    private int getSecOpenTop() {
        return (this.n == 0 || this.q == 1 || this.q == 2) ? this.g.top : this.q == 4 ? this.g.top + this.d.getHeight() : this.g.top - this.d.getHeight();
    }

    public final void a(boolean z) {
        this.i = true;
        this.a = false;
        if (z) {
            this.m = 3;
            this.b.a(this.c, this.f.left, this.f.top);
            if (this.s != null) {
                this.s.a(this.m);
            }
        } else {
            this.m = 2;
            this.b.a();
            this.c.layout(this.f.left, this.f.top, this.f.right, this.f.bottom);
            this.d.layout(this.h.left, this.h.top, this.h.right, this.h.bottom);
        }
        bq.d(this);
    }

    public final void b(boolean z) {
        this.i = false;
        this.a = false;
        if (z) {
            this.m = 1;
            this.b.a(this.c, this.e.left, this.e.top);
            if (this.s != null) {
                this.s.a(this.m);
            }
        } else {
            this.m = 0;
            this.b.a();
            this.c.layout(this.e.left, this.e.top, this.e.right, this.e.bottom);
            this.d.layout(this.g.left, this.g.top, this.g.right, this.g.bottom);
        }
        bq.d(this);
    }

    public void computeScroll() {
        if (this.b.b()) {
            bq.d(this);
        }
    }

    public int getDragEdge() {
        return this.q;
    }

    public int getMinFlingVelocity() {
        return this.l;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() >= 2) {
            this.d = getChildAt(0);
            this.c = getChildAt(1);
        } else if (getChildCount() == 1) {
            this.c = getChildAt(0);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.b.b(motionEvent);
        this.r.a(motionEvent);
        boolean z = this.b.a == 2;
        boolean z2 = this.b.a == 0 && this.j;
        return z || z2;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.a = false;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            int min;
            int min2;
            View childAt = getChildAt(i5);
            int paddingLeft = getPaddingLeft();
            int max = Math.max((i3 - getPaddingRight()) - i, 0);
            int paddingTop = getPaddingTop();
            int max2 = Math.max((i4 - getPaddingBottom()) - i2, 0);
            switch (this.q) {
                case 1:
                    min = Math.min(getPaddingLeft(), max);
                    min2 = Math.min(getPaddingTop(), max2);
                    max = Math.min(childAt.getMeasuredWidth() + getPaddingLeft(), max);
                    paddingLeft = Math.min(childAt.getMeasuredHeight() + getPaddingTop(), max2);
                    break;
                case 2:
                    min = Math.max(((i3 - childAt.getMeasuredWidth()) - getPaddingRight()) - i, paddingLeft);
                    min2 = Math.min(getPaddingTop(), max2);
                    max = Math.max((i3 - getPaddingRight()) - i, paddingLeft);
                    paddingLeft = Math.min(childAt.getMeasuredHeight() + getPaddingTop(), max2);
                    break;
                case 4:
                    min = Math.min(getPaddingLeft(), max);
                    min2 = Math.min(getPaddingTop(), max2);
                    max = Math.min(childAt.getMeasuredWidth() + getPaddingLeft(), max);
                    paddingLeft = Math.min(childAt.getMeasuredHeight() + getPaddingTop(), max2);
                    break;
                case 8:
                    min = Math.min(getPaddingLeft(), max);
                    min2 = Math.max(((i4 - childAt.getMeasuredHeight()) - getPaddingBottom()) - i2, paddingTop);
                    max = Math.min(childAt.getMeasuredWidth() + getPaddingLeft(), max);
                    paddingLeft = Math.max((i4 - getPaddingBottom()) - i2, paddingTop);
                    break;
                default:
                    paddingLeft = 0;
                    min2 = 0;
                    max = 0;
                    min = 0;
                    break;
            }
            childAt.layout(min, min2, max, paddingLeft);
        }
        if (this.n == 1) {
            switch (this.q) {
                case 1:
                    this.d.offsetLeftAndRight(-this.d.getWidth());
                    break;
                case 2:
                    this.d.offsetLeftAndRight(this.d.getWidth());
                    break;
                case 4:
                    this.d.offsetTopAndBottom(-this.d.getHeight());
                    break;
                case 8:
                    this.d.offsetTopAndBottom(this.d.getHeight());
                    break;
            }
        }
        this.e.set(this.c.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
        this.g.set(this.d.getLeft(), this.d.getTop(), this.d.getRight(), this.d.getBottom());
        this.f.set(getMainOpenLeft(), getMainOpenTop(), getMainOpenLeft() + this.c.getWidth(), getMainOpenTop() + this.c.getHeight());
        this.h.set(getSecOpenLeft(), getSecOpenTop(), getSecOpenLeft() + this.d.getWidth(), getSecOpenTop() + this.d.getHeight());
        if (this.i) {
            a(false);
        } else {
            b(false);
        }
        this.o = this.c.getLeft();
        this.p = this.c.getTop();
    }

    protected void onMeasure(int i, int i2) {
        if (getChildCount() < 2) {
            throw new RuntimeException("Layout must have two children");
        }
        int i3;
        LayoutParams layoutParams = getLayoutParams();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int i4 = 0;
        int i5 = 0;
        for (i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams2 = childAt.getLayoutParams();
            if (layoutParams2 != null) {
                if (layoutParams2.height == -1) {
                    childAt.setMinimumHeight(size2);
                }
                if (layoutParams2.width == -1) {
                    childAt.setMinimumWidth(size);
                }
            }
            measureChild(childAt, i, i2);
            i4 = Math.max(childAt.getMeasuredWidth(), i4);
            i5 = Math.max(childAt.getMeasuredHeight(), i5);
        }
        i3 = (getPaddingLeft() + getPaddingRight()) + i4;
        i5 += getPaddingTop() + getPaddingBottom();
        if (mode == 1073741824) {
            i3 = size;
        } else {
            if (layoutParams.width == -1) {
                i3 = size;
            }
            if (mode != Integer.MIN_VALUE) {
                i4 = i3;
                if (mode2 != 1073741824) {
                    i3 = size2;
                } else {
                    i3 = layoutParams.height != -1 ? size2 : i5;
                    if (mode2 == Integer.MIN_VALUE && i3 > size2) {
                        i3 = size2;
                    }
                }
                setMeasuredDimension(i4, i3);
            } else if (i3 > size) {
                i3 = size;
            }
        }
        i4 = i3;
        if (mode2 != 1073741824) {
            if (layoutParams.height != -1) {
            }
            i3 = size2;
        } else {
            i3 = size2;
        }
        setMeasuredDimension(i4, i3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.r.a(motionEvent);
        this.b.b(motionEvent);
        return true;
    }

    public void setDragEdge(int i) {
        this.q = i;
    }

    public void setDragStateChangeListener(e eVar) {
        this.s = eVar;
    }

    public void setLockDrag(boolean z) {
        this.k = z;
    }

    public void setMinFlingVelocity(int i) {
        this.l = i;
    }

    public void setSwipeListener(f fVar) {
        this.t = fVar;
    }
}
