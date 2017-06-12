package android.support.design.widget;

import android.os.Build.VERSION;
import android.view.View;

final class cv {
    static final cf a = new cw();
    private static final cx b;

    static {
        if (VERSION.SDK_INT >= 21) {
            b = new cz();
        } else {
            b = new cy();
        }
    }

    static bz a() {
        return a.a();
    }

    static void a(View view) {
        b.a(view);
    }
}
