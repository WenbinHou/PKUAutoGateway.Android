package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.b.l;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class cp extends MarginLayoutParams {
    public float g;
    public int h;

    public cp(int i, int i2) {
        super(i, i2);
        this.h = -1;
        this.g = 0.0f;
    }

    public cp(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.LinearLayoutCompat_Layout);
        this.g = obtainStyledAttributes.getFloat(l.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
        this.h = obtainStyledAttributes.getInt(l.LinearLayoutCompat_Layout_android_layout_gravity, -1);
        obtainStyledAttributes.recycle();
    }

    public cp(LayoutParams layoutParams) {
        super(layoutParams);
        this.h = -1;
    }
}
