package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.b.b;

public final class ax {
    private static final ay a;

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new ba();
        } else {
            a = new az();
        }
    }

    public static Intent a(Activity activity) {
        return a.a(activity);
    }

    public static Intent a(Context context, ComponentName componentName) {
        String b = b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        return b(context, componentName2) == null ? b.a(componentName2) : new Intent().setComponent(componentName2);
    }

    public static boolean a(Activity activity, Intent intent) {
        return a.a(activity, intent);
    }

    public static String b(Activity activity) {
        try {
            return b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String b(Context context, ComponentName componentName) {
        return a.a(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }

    public static void b(Activity activity, Intent intent) {
        a.b(activity, intent);
    }
}
