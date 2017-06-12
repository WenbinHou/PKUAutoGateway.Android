package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class j implements Creator<AdSizeParcel> {
    public static AdSizeParcel a(Parcel parcel) {
        int a = a.a(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        AdSizeParcel[] adSizeParcelArr = null;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    str = a.e(parcel, readInt);
                    break;
                case 3:
                    i2 = a.d(parcel, readInt);
                    break;
                case 4:
                    i3 = a.d(parcel, readInt);
                    break;
                case 5:
                    z = a.c(parcel, readInt);
                    break;
                case 6:
                    i4 = a.d(parcel, readInt);
                    break;
                case 7:
                    i5 = a.d(parcel, readInt);
                    break;
                case 8:
                    Object[] objArr;
                    Creator creator = AdSizeParcel.CREATOR;
                    int a2 = a.a(parcel, readInt);
                    int dataPosition = parcel.dataPosition();
                    if (a2 == 0) {
                        objArr = null;
                    } else {
                        objArr = parcel.createTypedArray(creator);
                        parcel.setDataPosition(dataPosition + a2);
                    }
                    adSizeParcelArr = (AdSizeParcel[]) objArr;
                    break;
                case 9:
                    z2 = a.c(parcel, readInt);
                    break;
                case 10:
                    z3 = a.c(parcel, readInt);
                    break;
                case 11:
                    z4 = a.c(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new AdSizeParcel(i, str, i2, i3, z, i4, i5, adSizeParcelArr, z2, z3, z4);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    static void a(AdSizeParcel adSizeParcel, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, adSizeParcel.a);
        c.a(parcel, 2, adSizeParcel.b);
        c.b(parcel, 3, adSizeParcel.c);
        c.b(parcel, 4, adSizeParcel.d);
        c.a(parcel, 5, adSizeParcel.e);
        c.b(parcel, 6, adSizeParcel.f);
        c.b(parcel, 7, adSizeParcel.g);
        AdSizeParcel[] adSizeParcelArr = adSizeParcel.h;
        if (adSizeParcelArr != null) {
            int a2 = c.a(parcel, 8);
            parcel.writeInt(r5);
            for (Parcelable parcelable : adSizeParcelArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    int dataPosition = parcel.dataPosition();
                    parcel.writeInt(1);
                    int dataPosition2 = parcel.dataPosition();
                    parcelable.writeToParcel(parcel, i);
                    int dataPosition3 = parcel.dataPosition();
                    parcel.setDataPosition(dataPosition);
                    parcel.writeInt(dataPosition3 - dataPosition2);
                    parcel.setDataPosition(dataPosition3);
                }
            }
            c.b(parcel, a2);
        }
        c.a(parcel, 9, adSizeParcel.i);
        c.a(parcel, 10, adSizeParcel.j);
        c.a(parcel, 11, adSizeParcel.k);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AdSizeParcel[i];
    }
}
