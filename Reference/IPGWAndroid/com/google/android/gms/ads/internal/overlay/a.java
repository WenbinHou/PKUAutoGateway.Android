package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.fd;
import com.google.android.gms.b.fk;
import com.google.android.gms.b.fs;

@fd
public final class a {
    private static boolean a(Context context, Intent intent) {
        try {
            fk.e("Launching an intent: " + intent.toURI());
            f.c();
            fs.a(context, intent);
            return true;
        } catch (ActivityNotFoundException e) {
            b.d(e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        int i = 0;
        if (adLauncherIntentInfoParcel == null) {
            b.d("No intent data for launcher overlay.");
            return i;
        } else if (adLauncherIntentInfoParcel.i != null) {
            return a(context, adLauncherIntentInfoParcel.i);
        } else {
            Intent intent = new Intent();
            if (TextUtils.isEmpty(adLauncherIntentInfoParcel.c)) {
                b.d("Open GMSG did not contain a URL.");
                return i;
            }
            if (TextUtils.isEmpty(adLauncherIntentInfoParcel.d)) {
                intent.setData(Uri.parse(adLauncherIntentInfoParcel.c));
            } else {
                intent.setDataAndType(Uri.parse(adLauncherIntentInfoParcel.c), adLauncherIntentInfoParcel.d);
            }
            intent.setAction("android.intent.action.VIEW");
            if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.e)) {
                intent.setPackage(adLauncherIntentInfoParcel.e);
            }
            if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.f)) {
                String[] split = adLauncherIntentInfoParcel.f.split("/", 2);
                if (split.length < 2) {
                    b.d("Could not parse component name from open GMSG: " + adLauncherIntentInfoParcel.f);
                    return i;
                }
                intent.setClassName(split[i], split[1]);
            }
            Object obj = adLauncherIntentInfoParcel.g;
            if (!TextUtils.isEmpty(obj)) {
                try {
                    i = Integer.parseInt(obj);
                } catch (NumberFormatException e) {
                    b.d("Could not parse intent flags.");
                }
                intent.addFlags(i);
            }
            return a(context, intent);
        }
    }
}
