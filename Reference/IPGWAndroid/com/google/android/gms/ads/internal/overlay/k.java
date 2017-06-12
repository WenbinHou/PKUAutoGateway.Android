package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.a.d;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class k implements Creator<AdOverlayInfoParcel> {
    static void a(AdOverlayInfoParcel adOverlayInfoParcel, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, adOverlayInfoParcel.a);
        c.a(parcel, 2, adOverlayInfoParcel.b, i);
        c.a(parcel, 3, d.a(adOverlayInfoParcel.c).asBinder());
        c.a(parcel, 4, d.a(adOverlayInfoParcel.d).asBinder());
        c.a(parcel, 5, d.a(adOverlayInfoParcel.e).asBinder());
        c.a(parcel, 6, d.a(adOverlayInfoParcel.f).asBinder());
        c.a(parcel, 7, adOverlayInfoParcel.g);
        c.a(parcel, 8, adOverlayInfoParcel.h);
        c.a(parcel, 9, adOverlayInfoParcel.i);
        c.a(parcel, 10, d.a(adOverlayInfoParcel.j).asBinder());
        c.b(parcel, 11, adOverlayInfoParcel.k);
        c.b(parcel, 12, adOverlayInfoParcel.l);
        c.a(parcel, 13, adOverlayInfoParcel.m);
        c.a(parcel, 14, adOverlayInfoParcel.n, i);
        c.a(parcel, 15, d.a(adOverlayInfoParcel.o).asBinder());
        c.a(parcel, 17, adOverlayInfoParcel.q, i);
        c.a(parcel, 16, adOverlayInfoParcel.p);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = a.a(parcel);
        int i = 0;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        VersionInfoParcel versionInfoParcel = null;
        IBinder iBinder6 = null;
        String str4 = null;
        InterstitialAdParameterParcel interstitialAdParameterParcel = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    adLauncherIntentInfoParcel = (AdLauncherIntentInfoParcel) a.a(parcel, readInt, AdLauncherIntentInfoParcel.CREATOR);
                    break;
                case 3:
                    iBinder = a.f(parcel, readInt);
                    break;
                case 4:
                    iBinder2 = a.f(parcel, readInt);
                    break;
                case 5:
                    iBinder3 = a.f(parcel, readInt);
                    break;
                case 6:
                    iBinder4 = a.f(parcel, readInt);
                    break;
                case 7:
                    str = a.e(parcel, readInt);
                    break;
                case 8:
                    z = a.c(parcel, readInt);
                    break;
                case 9:
                    str2 = a.e(parcel, readInt);
                    break;
                case 10:
                    iBinder5 = a.f(parcel, readInt);
                    break;
                case 11:
                    i2 = a.d(parcel, readInt);
                    break;
                case 12:
                    i3 = a.d(parcel, readInt);
                    break;
                case 13:
                    str3 = a.e(parcel, readInt);
                    break;
                case 14:
                    versionInfoParcel = (VersionInfoParcel) a.a(parcel, readInt, (Creator) VersionInfoParcel.CREATOR);
                    break;
                case 15:
                    iBinder6 = a.f(parcel, readInt);
                    break;
                case 16:
                    str4 = a.e(parcel, readInt);
                    break;
                case 17:
                    interstitialAdParameterParcel = (InterstitialAdParameterParcel) a.a(parcel, readInt, (Creator) InterstitialAdParameterParcel.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new AdOverlayInfoParcel(i, adLauncherIntentInfoParcel, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, versionInfoParcel, iBinder6, str4, interstitialAdParameterParcel);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }
}
