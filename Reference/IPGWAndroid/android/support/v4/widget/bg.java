package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

class bg extends bi {
    bg() {
    }

    public void a(TextView textView, Drawable drawable) {
        Object obj = textView.getLayoutDirection() == 1 ? 1 : null;
        Drawable drawable2 = obj != null ? null : drawable;
        if (obj == null) {
            drawable = null;
        }
        textView.setCompoundDrawables(drawable2, null, drawable, null);
    }
}
