package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

final class ba extends az {
    ba() {
    }

    public final Intent a(Activity activity) {
        Intent parentActivityIntent = activity.getParentActivityIntent();
        return parentActivityIntent == null ? super.a(activity) : parentActivityIntent;
    }

    public final String a(Context context, ActivityInfo activityInfo) {
        String str = activityInfo.parentActivityName;
        return str == null ? super.a(context, activityInfo) : str;
    }

    public final boolean a(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }

    public final void b(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }
}
