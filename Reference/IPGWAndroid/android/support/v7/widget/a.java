package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ay;
import android.support.v4.view.bq;
import android.support.v4.view.dk;
import android.support.v7.b.b;
import android.support.v7.b.h;
import android.support.v7.b.l;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

abstract class a extends ViewGroup {
    protected final b a;
    protected final Context b;
    protected ActionMenuView c;
    protected k d;
    protected int e;
    protected dk f;
    private boolean g;
    private boolean h;

    a(Context context) {
        this(context, null);
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new b(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(b.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.b = context;
        } else {
            this.b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected static int a(View view, int i, int i2) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) + 0);
    }

    protected static int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public dk a(int i, long j) {
        if (this.f != null) {
            this.f.a();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                bq.c((View) this, 0.0f);
            }
            dk a = bq.r(this).a(1.0f);
            a.a(j);
            a.a(this.a.a(a, i));
            return a;
        }
        a = bq.r(this).a(0.0f);
        a.a(j);
        a.a(this.a.a(a, i));
        return a;
    }

    public boolean a() {
        return this.d != null ? this.d.c() : false;
    }

    public int getAnimatedVisibility() {
        return this.f != null ? this.a.a : getVisibility();
    }

    public int getContentHeight() {
        return this.e;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, l.ActionBar, b.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(l.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.d != null) {
            k kVar = this.d;
            if (!kVar.m) {
                kVar.l = kVar.b.getResources().getInteger(h.abc_max_action_buttons);
            }
            if (kVar.c != null) {
                kVar.c.b(true);
            }
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = ay.a(motionEvent);
        if (a == 9) {
            this.h = false;
        }
        if (!this.h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.h = true;
            }
        }
        if (a == 10 || a == 3) {
            this.h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = ay.a(motionEvent);
        if (a == 0) {
            this.g = false;
        }
        if (!this.g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.g = true;
            }
        }
        if (a == 1 || a == 3) {
            this.g = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.e = i;
        requestLayout();
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f != null) {
                this.f.a();
            }
            super.setVisibility(i);
        }
    }
}
