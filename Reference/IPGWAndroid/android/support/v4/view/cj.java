package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public final class cj {
    static final co a;

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new cn();
        } else if (VERSION.SDK_INT >= 11) {
            a = new cm();
        } else if (VERSION.SDK_INT >= 8) {
            a = new cl();
        } else {
            a = new ck();
        }
    }

    public static int a(ViewConfiguration viewConfiguration) {
        return a.a(viewConfiguration);
    }

    public static boolean b(ViewConfiguration viewConfiguration) {
        return a.b(viewConfiguration);
    }
}
