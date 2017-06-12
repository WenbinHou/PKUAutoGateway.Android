package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class a implements Creator<NativeAdOptionsParcel> {
    public static NativeAdOptionsParcel a(Parcel parcel) {
        boolean z = false;
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int i = 0;
        boolean z2 = false;
        int i2 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.d(parcel, readInt);
                    break;
                case 2:
                    z2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.a.d(parcel, readInt);
                    break;
                case 4:
                    z = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new NativeAdOptionsParcel(i2, z2, i, z);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    static void a(NativeAdOptionsParcel nativeAdOptionsParcel, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, nativeAdOptionsParcel.a);
        c.a(parcel, 2, nativeAdOptionsParcel.b);
        c.b(parcel, 3, nativeAdOptionsParcel.c);
        c.a(parcel, 4, nativeAdOptionsParcel.d);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new NativeAdOptionsParcel[i];
    }
}
