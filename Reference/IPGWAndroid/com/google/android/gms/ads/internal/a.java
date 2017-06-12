package com.google.android.gms.ads.internal;

import android.app.Activity;
import com.google.android.gms.ads.internal.client.l;
import com.google.android.gms.ads.internal.client.m;
import com.google.android.gms.ads.internal.purchase.c;
import com.google.android.gms.b.ee;
import com.google.android.gms.b.eq;

public class a implements m {
    public static void a() {
        l.b = a.class.getName();
    }

    public final eq a(Activity activity) {
        return new c(activity);
    }

    public final ee b(Activity activity) {
        return new com.google.android.gms.ads.internal.overlay.c(activity);
    }
}
