package android.support.v7.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.b.l;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class b extends MarginLayoutParams {
    public int a;

    public b() {
        super(-2, -2);
        this.a = 0;
        this.a = 8388627;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ActionBarLayout);
        this.a = obtainStyledAttributes.getInt(l.ActionBarLayout_android_layout_gravity, 0);
        obtainStyledAttributes.recycle();
    }

    public b(b bVar) {
        super(bVar);
        this.a = 0;
        this.a = bVar.a;
    }

    public b(LayoutParams layoutParams) {
        super(layoutParams);
        this.a = 0;
    }
}
