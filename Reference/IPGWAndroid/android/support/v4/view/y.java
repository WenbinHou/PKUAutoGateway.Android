package android.support.v4.view;

import android.graphics.Rect;
import android.view.Gravity;

final class y implements w {
    y() {
    }

    public final int a(int i, int i2) {
        return Gravity.getAbsoluteGravity(i, i2);
    }

    public final void a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        Gravity.apply(i, i2, i3, rect, rect2, i4);
    }
}
