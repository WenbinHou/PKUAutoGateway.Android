package android.support.v7.widget;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.a.c;
import android.support.v7.b.b;
import android.support.v7.b.e;
import android.support.v7.b.l;
import android.support.v7.view.a;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;

public final class ev extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator i = new DecelerateInterpolator();
    Runnable a;
    int b;
    int c;
    private co d;
    private Spinner e;
    private boolean f;
    private int g;
    private int h;

    static /* synthetic */ ey a(ev evVar, c cVar) {
        ey eyVar = new ey(evVar, evVar.getContext(), cVar);
        eyVar.setBackgroundDrawable(null);
        eyVar.setLayoutParams(new LayoutParams(-1, evVar.g));
        return eyVar;
    }

    private boolean a() {
        return this.e != null && this.e.getParent() == this;
    }

    private boolean b() {
        if (a()) {
            removeView(this.e);
            addView(this.d, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.e.getSelectedItemPosition());
        }
        return false;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            post(this.a);
        }
    }

    protected final void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        a a = a.a(getContext());
        TypedArray obtainStyledAttributes = a.a.obtainStyledAttributes(null, l.ActionBar, b.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(l.ActionBar_height, 0);
        Resources resources = a.a.getResources();
        if (!a.a()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(e.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        setContentHeight(layoutDimension);
        this.c = a.a.getResources().getDimensionPixelSize(e.abc_action_bar_stacked_tab_max_width);
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            removeCallbacks(this.a);
        }
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public final void onMeasure(int i, int i2) {
        byte b = (byte) 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.d.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.b = -1;
        } else {
            if (childCount > 2) {
                this.b = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.b = MeasureSpec.getSize(i) / 2;
            }
            this.b = Math.min(this.b, this.c);
        }
        mode = MeasureSpec.makeMeasureSpec(this.g, 1073741824);
        if (z || !this.f) {
            b = (byte) 0;
        }
        if (b != (byte) 0) {
            this.d.measure(0, mode);
            if (this.d.getMeasuredWidth() <= MeasureSpec.getSize(i)) {
                b();
            } else if (!a()) {
                if (this.e == null) {
                    Spinner bfVar = new bf(getContext(), null, b.actionDropDownStyle);
                    bfVar.setLayoutParams(new cp(-2, -1));
                    bfVar.setOnItemSelectedListener(this);
                    this.e = bfVar;
                }
                removeView(this.d);
                addView(this.e, new ViewGroup.LayoutParams(-2, -1));
                if (this.e.getAdapter() == null) {
                    this.e.setAdapter(new ex());
                }
                if (this.a != null) {
                    removeCallbacks(this.a);
                    this.a = null;
                }
                this.e.setSelection(this.h);
            }
        } else {
            b();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            setTabSelected(this.h);
        }
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }

    public final void setAllowCollapse(boolean z) {
        this.f = z;
    }

    public final void setContentHeight(int i) {
        this.g = i;
        requestLayout();
    }

    public final void setTabSelected(int i) {
        this.h = i;
        int childCount = this.d.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.d.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                View childAt2 = this.d.getChildAt(i);
                if (this.a != null) {
                    removeCallbacks(this.a);
                }
                this.a = new ew(this, childAt2);
                post(this.a);
            }
            i2++;
        }
        if (this.e != null && i >= 0) {
            this.e.setSelection(i);
        }
    }
}
