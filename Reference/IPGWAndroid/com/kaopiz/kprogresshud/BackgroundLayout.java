package com.kaopiz.kprogresshud;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.LinearLayout;

class BackgroundLayout extends LinearLayout {
    float a;
    int b;

    public BackgroundLayout(Context context) {
        super(context);
        a();
    }

    public BackgroundLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    @TargetApi(11)
    public BackgroundLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        a(getContext().getResources().getColor(l.kprogresshud_default_color), this.a);
    }

    final void a(int i, float f) {
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(f);
        if (VERSION.SDK_INT >= 16) {
            setBackground(gradientDrawable);
        } else {
            setBackgroundDrawable(gradientDrawable);
        }
    }
}
