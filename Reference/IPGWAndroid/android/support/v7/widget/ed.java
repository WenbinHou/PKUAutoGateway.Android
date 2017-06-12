package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class ed extends MarginLayoutParams {
    eq c;
    final Rect d = new Rect();
    boolean e = true;
    boolean f = false;

    public ed(int i, int i2) {
        super(i, i2);
    }

    public ed(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ed(ed edVar) {
        super(edVar);
    }

    public ed(LayoutParams layoutParams) {
        super(layoutParams);
    }

    public ed(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }
}
