package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a {
    @Deprecated
    public static final int a = 8487000;
    public static boolean b = false;
    public static boolean c = false;
    static int d = -1;
    static final AtomicBoolean e = new AtomicBoolean();
    private static final Object f = new Object();
    private static String g = null;
    private static Integer h = null;
    private static final AtomicBoolean i = new AtomicBoolean();

    public static Resources a(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Context b(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    @Deprecated
    public static int c(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return i;
        }
    }
}
