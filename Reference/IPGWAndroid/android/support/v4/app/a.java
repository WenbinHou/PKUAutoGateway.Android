package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;

public final class a extends android.support.v4.b.a {
    public static void a(Activity activity, Intent intent, int i) {
        if (VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, null);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }
}
