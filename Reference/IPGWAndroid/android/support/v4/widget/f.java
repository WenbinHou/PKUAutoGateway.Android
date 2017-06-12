package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;

public final class f {
    private static final i a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            a = new g();
        } else if (i >= 21) {
            a = new j();
        } else {
            a = new h();
        }
    }

    public static Drawable a(CompoundButton compoundButton) {
        return a.a(compoundButton);
    }

    public static void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        a.a(compoundButton, colorStateList);
    }

    public static void a(CompoundButton compoundButton, Mode mode) {
        a.a(compoundButton, mode);
    }
}
