package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.a.a;
import com.google.android.gms.a.d;
import com.google.android.gms.b.ih;
import com.google.android.gms.b.ij;

public class FlagProviderImpl extends ih {
    private boolean a = false;
    private SharedPreferences b;

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return ((Boolean) ij.a(new c(this.b, str, Boolean.valueOf(z)))).booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        return ((Integer) ij.a(new e(this.b, str, Integer.valueOf(i)))).intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        return ((Long) ij.a(new g(this.b, str, Long.valueOf(j)))).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        return (String) ij.a(new i(this.b, str, str2));
    }

    public void init(a aVar) {
        Context context = (Context) d.a(aVar);
        if (!this.a) {
            try {
                this.b = j.a(context.createPackageContext("com.google.android.gms", 0));
                this.a = true;
            } catch (NameNotFoundException e) {
            }
        }
    }
}
