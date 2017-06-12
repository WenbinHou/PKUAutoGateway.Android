package com.google.android.gms.b;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import java.io.File;

public final class d {
    public static hv a(Context context) {
        iy izVar;
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = packageName + "/" + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (NameNotFoundException e) {
        }
        if (VERSION.SDK_INT >= 9) {
            izVar = new iz();
        } else {
            Object ivVar = new iv(AndroidHttpClient.newInstance(str));
        }
        hv hvVar = new hv(new is(file, (byte) 0), new ip(izVar), (byte) 0);
        hvVar.a();
        return hvVar;
    }
}
