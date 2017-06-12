package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public final class b implements Creator<AdLauncherIntentInfoParcel> {
    static void a(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, adLauncherIntentInfoParcel.a);
        c.a(parcel, 2, adLauncherIntentInfoParcel.b);
        c.a(parcel, 3, adLauncherIntentInfoParcel.c);
        c.a(parcel, 4, adLauncherIntentInfoParcel.d);
        c.a(parcel, 5, adLauncherIntentInfoParcel.e);
        c.a(parcel, 6, adLauncherIntentInfoParcel.f);
        c.a(parcel, 7, adLauncherIntentInfoParcel.g);
        c.a(parcel, 8, adLauncherIntentInfoParcel.h);
        c.a(parcel, 9, adLauncherIntentInfoParcel.i, i);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Intent intent = null;
        int a = a.a(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    str7 = a.e(parcel, readInt);
                    break;
                case 3:
                    str6 = a.e(parcel, readInt);
                    break;
                case 4:
                    str5 = a.e(parcel, readInt);
                    break;
                case 5:
                    str4 = a.e(parcel, readInt);
                    break;
                case 6:
                    str3 = a.e(parcel, readInt);
                    break;
                case 7:
                    str2 = a.e(parcel, readInt);
                    break;
                case 8:
                    str = a.e(parcel, readInt);
                    break;
                case 9:
                    intent = (Intent) a.a(parcel, readInt, Intent.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new AdLauncherIntentInfoParcel(i, str7, str6, str5, str4, str3, str2, str, intent);
        }
        throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AdLauncherIntentInfoParcel[i];
    }
}
