package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

public final class bd {
    static final bj a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            a = new be();
        } else if (i >= 18) {
            a = new bh();
        } else if (i >= 17) {
            a = new bg();
        } else if (i >= 16) {
            a = new bi();
        } else {
            a = new bf();
        }
    }

    public static int a(TextView textView) {
        return a.a(textView);
    }

    public static void a(TextView textView, Drawable drawable) {
        a.a(textView, drawable);
    }
}
