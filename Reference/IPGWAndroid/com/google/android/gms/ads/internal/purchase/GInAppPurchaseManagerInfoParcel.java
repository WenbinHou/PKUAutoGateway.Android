package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.b;
import com.google.android.gms.a.d;
import com.google.android.gms.b.el;
import com.google.android.gms.b.fd;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@fd
public final class GInAppPurchaseManagerInfoParcel implements SafeParcelable {
    public static final a CREATOR = new a();
    public final int a;
    public final i b;
    public final el c;
    public final Context d;
    public final h e;

    GInAppPurchaseManagerInfoParcel(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.a = i;
        this.b = (i) d.a(b.a(iBinder));
        this.c = (el) d.a(b.a(iBinder2));
        this.d = (Context) d.a(b.a(iBinder3));
        this.e = (h) d.a(b.a(iBinder4));
    }

    public static GInAppPurchaseManagerInfoParcel a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
            return (GInAppPurchaseManagerInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel);
    }
}
