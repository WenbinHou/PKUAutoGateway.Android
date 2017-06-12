package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class d implements Creator<InterstitialAdParameterParcel> {
    static void a(InterstitialAdParameterParcel interstitialAdParameterParcel, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, interstitialAdParameterParcel.a);
        c.a(parcel, 2, interstitialAdParameterParcel.b);
        c.a(parcel, 3, interstitialAdParameterParcel.c);
        c.a(parcel, 4, interstitialAdParameterParcel.d);
        c.a(parcel, 5, interstitialAdParameterParcel.e);
        float f = interstitialAdParameterParcel.f;
        c.a(parcel, 6, 4);
        parcel.writeFloat(f);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int a = a.a(parcel);
        String str = null;
        float f = 0.0f;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    z3 = a.c(parcel, readInt);
                    break;
                case 3:
                    z2 = a.c(parcel, readInt);
                    break;
                case 4:
                    str = a.e(parcel, readInt);
                    break;
                case 5:
                    z = a.c(parcel, readInt);
                    break;
                case 6:
                    a.a(parcel, readInt, 4);
                    f = parcel.readFloat();
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new InterstitialAdParameterParcel(i, z3, z2, str, z, f);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new InterstitialAdParameterParcel[i];
    }
}
