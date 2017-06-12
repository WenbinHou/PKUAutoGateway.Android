package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

class bh extends bg {
    bh() {
    }

    public final void a(TextView textView, Drawable drawable) {
        textView.setCompoundDrawablesRelative(drawable, null, null, null);
    }
}
