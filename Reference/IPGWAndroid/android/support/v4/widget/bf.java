package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

class bf implements bj {
    bf() {
    }

    public int a(TextView textView) {
        if (!bk.d) {
            bk.c = bk.a("mMaxMode");
            bk.d = true;
        }
        if (bk.c != null && bk.a(bk.c, textView) == 1) {
            if (!bk.b) {
                bk.a = bk.a("mMaximum");
                bk.b = true;
            }
            if (bk.a != null) {
                return bk.a(bk.a, textView);
            }
        }
        return -1;
    }

    public void a(TextView textView, Drawable drawable) {
        textView.setCompoundDrawables(drawable, null, null, null);
    }
}
