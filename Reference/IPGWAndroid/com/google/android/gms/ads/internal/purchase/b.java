package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.b.fd;

@fd
public final class b {
    Object a;
    final Context b;
    final boolean c;

    public b(Context context) {
        this(context, (byte) 0);
    }

    private b(Context context, byte b) {
        this.b = context;
        this.c = true;
    }

    public final Bundle a(String str, String str2, String str3) {
        try {
            Class loadClass = this.b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getBuyIntent", new Class[]{Integer.TYPE, String.class, String.class, String.class, String.class}).invoke(loadClass.cast(this.a), new Object[]{Integer.valueOf(3), str, str2, "inapp", str3});
        } catch (Throwable e) {
            if (this.c) {
                com.google.android.gms.ads.internal.util.client.b.c("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return null;
        }
    }
}
