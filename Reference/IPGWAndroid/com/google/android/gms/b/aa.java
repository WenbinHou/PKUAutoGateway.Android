package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Environment;
import com.google.android.gms.common.internal.c;

@fd
public final class aa {
    private final Context a;

    public aa(Context context) {
        c.a(context, "Context can not be null");
        this.a = context;
    }

    public final boolean a() {
        return "mounted".equals(Environment.getExternalStorageState()) && this.a.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public final boolean a(Intent intent) {
        c.a(intent, "Intent can not be null");
        return !this.a.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    @TargetApi(14)
    public final boolean b() {
        return VERSION.SDK_INT >= 14 && a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}
