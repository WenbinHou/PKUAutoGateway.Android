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
public final class ec extends e<eh> {
    private static final ec a = new ec();

    private ec() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static ee a(Activity activity) {
        try {
            Intent intent = activity.getIntent();
            if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
                if (!intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false)) {
                    ee b = a.b(activity);
                    if (b != null) {
                        return b;
                    }
                }
                b.a("Using AdOverlay from the client jar.");
                return n.b().a.b(activity);
            }
            throw new ed("Ad overlay requires the useClientJar flag in intent extras.");
        } catch (ed e) {
            b.d(e.getMessage());
            return null;
        }
    }

    private ee b(Activity activity) {
        try {
            return ef.a(((eh) a((Context) activity)).a(d.a((Object) activity)));
        } catch (Throwable e) {
            b.c("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            b.c("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected final /* synthetic */ Object a(IBinder iBinder) {
        return ei.a(iBinder);
    }
}
