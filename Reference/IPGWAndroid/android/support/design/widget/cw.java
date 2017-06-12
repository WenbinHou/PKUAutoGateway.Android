package android.support.design.widget;

import android.os.Build.VERSION;

final class cw implements cf {
    cw() {
    }

    public final bz a() {
        return new bz(VERSION.SDK_INT >= 12 ? new cl() : new cj());
    }
}
