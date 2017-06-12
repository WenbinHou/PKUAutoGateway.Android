package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.g.g;

final class aq extends g<Integer, PorterDuffColorFilter> {
    static int a(int i, Mode mode) {
        return ((i + 31) * 31) + mode.hashCode();
    }
}
