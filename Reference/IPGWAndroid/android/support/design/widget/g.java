package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.h;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout.LayoutParams;

public final class g extends LayoutParams {
    int a = 1;
    Interpolator b;

    public g() {
        super(-1, -2);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.AppBarLayout_LayoutParams);
        this.a = obtainStyledAttributes.getInt(h.AppBarLayout_LayoutParams_layout_scrollFlags, 0);
        if (obtainStyledAttributes.hasValue(h.AppBarLayout_LayoutParams_layout_scrollInterpolator)) {
            this.b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(h.AppBarLayout_LayoutParams_layout_scrollInterpolator, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public g(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public g(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public g(LayoutParams layoutParams) {
        super(layoutParams);
    }
}
