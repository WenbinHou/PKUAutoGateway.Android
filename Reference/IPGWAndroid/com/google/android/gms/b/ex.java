package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.a.d;
import com.google.android.gms.a.e;
import com.google.android.gms.ads.internal.client.n;
import com.google.android.gms.ads.internal.util.client.b;

@fd
public final class ex extends e<et> {
    private static final ex a = new ex();

    private ex() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    public static eq a(Activity activity) {
        try {
            Intent intent = activity.getIntent();
            if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
                if (!intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false)) {
                    eq b = a.b(activity);
                    if (b != null) {
                        return b;
                    }
                }
                b.a("Using AdOverlay from the client jar.");
                return n.b().a.a(activity);
            }
            throw new ey("InAppPurchaseManager requires the useClientJar flag in intent extras.");
        } catch (ey e) {
            b.d(e.getMessage());
            return null;
        }
    }

    private eq b(Activity activity) {
        try {
            return er.a(((et) a((Context) activity)).a(d.a((Object) activity)));
        } catch (Throwable e) {
            b.c("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            b.c("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    protected final /* synthetic */ Object a(IBinder iBinder) {
        return eu.a(iBinder);
    }
}
