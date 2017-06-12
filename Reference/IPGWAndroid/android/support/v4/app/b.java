package android.support.v4.app;

import android.content.Context;
import android.os.Build.VERSION;

public final class b {
    private static final d a;

    static {
        if (VERSION.SDK_INT >= 23) {
            a = new c();
        } else {
            a = new d();
        }
    }

    public static int a(Context context, String str, String str2) {
        return a.a(context, str, str2);
    }

    public static String a(String str) {
        return a.a(str);
    }
}
