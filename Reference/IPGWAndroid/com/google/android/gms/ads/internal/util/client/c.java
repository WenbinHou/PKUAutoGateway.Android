package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class c implements Creator<VersionInfoParcel> {
    static void a(VersionInfoParcel versionInfoParcel, Parcel parcel) {
        int a = com.google.android.gms.common.internal.safeparcel.c.a(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, 1, versionInfoParcel.a);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, versionInfoParcel.b);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, 3, versionInfoParcel.c);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, 4, versionInfoParcel.d);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 5, versionInfoParcel.e);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int a = a.a(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i3 = a.d(parcel, readInt);
                    break;
                case 2:
                    str = a.e(parcel, readInt);
                    break;
                case 3:
                    i2 = a.d(parcel, readInt);
                    break;
                case 4:
                    i = a.d(parcel, readInt);
                    break;
                case 5:
                    z = a.c(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new VersionInfoParcel(i3, str, i2, i, z);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new VersionInfoParcel[i];
    }
}
