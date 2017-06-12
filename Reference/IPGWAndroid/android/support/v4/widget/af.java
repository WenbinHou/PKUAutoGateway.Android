package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

public final class af {
    static final al a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            a = new ah();
        } else if (i >= 21) {
            a = new ag();
        } else if (i >= 19) {
            a = new ak();
        } else if (i >= 9) {
            a = new aj();
        } else {
            a = new ai();
        }
    }

    public static void a(PopupWindow popupWindow, int i) {
        a.a(popupWindow, i);
    }

    public static void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        a.a(popupWindow, view, i, i2, i3);
    }

    public static void a(PopupWindow popupWindow, boolean z) {
        a.a(popupWindow, z);
    }
}
