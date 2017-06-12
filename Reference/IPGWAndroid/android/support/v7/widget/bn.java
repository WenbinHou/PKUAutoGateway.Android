package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

final class bn extends bm {
    private static final int[] b = new int[]{16843666, 16843667};
    private fr c;
    private fr d;

    bn(TextView textView) {
        super(textView);
    }

    final void a() {
        super.a();
        if (this.c != null || this.d != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.c);
            a(compoundDrawablesRelative[2], this.d);
        }
    }

    final void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        Context context = this.a.getContext();
        ao a = ao.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.c = bm.a(context, a, obtainStyledAttributes.getResourceId(0, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.d = bm.a(context, a, obtainStyledAttributes.getResourceId(1, 0));
        }
        obtainStyledAttributes.recycle();
    }
}
