package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;

@fd
@TargetApi(14)
public final class l implements ActivityLifecycleCallbacks {
    Activity a;
    Context b;
    private final Object c;

    private void a(Activity activity) {
        synchronized (this.c) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.a = activity;
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.c) {
            if (this.a == null) {
            } else if (this.a.equals(activity)) {
                this.a = null;
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        a(activity);
    }

    public final void onActivityResumed(Activity activity) {
        a(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        a(activity);
    }

    public final void onActivityStopped(Activity activity) {
    }
}
