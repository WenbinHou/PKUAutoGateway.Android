package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class e implements Creator<SearchAdRequestParcel> {
    static void a(SearchAdRequestParcel searchAdRequestParcel, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, searchAdRequestParcel.a);
        c.b(parcel, 2, searchAdRequestParcel.b);
        c.b(parcel, 3, searchAdRequestParcel.c);
        c.b(parcel, 4, searchAdRequestParcel.d);
        c.b(parcel, 5, searchAdRequestParcel.e);
        c.b(parcel, 6, searchAdRequestParcel.f);
        c.b(parcel, 7, searchAdRequestParcel.g);
        c.b(parcel, 8, searchAdRequestParcel.h);
        c.b(parcel, 9, searchAdRequestParcel.i);
        c.a(parcel, 10, searchAdRequestParcel.j);
        c.b(parcel, 11, searchAdRequestParcel.k);
        c.a(parcel, 12, searchAdRequestParcel.l);
        c.b(parcel, 13, searchAdRequestParcel.m);
        c.b(parcel, 14, searchAdRequestParcel.n);
        c.a(parcel, 15, searchAdRequestParcel.o);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = a.a(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    i2 = a.d(parcel, readInt);
                    break;
                case 3:
                    i3 = a.d(parcel, readInt);
                    break;
                case 4:
                    i4 = a.d(parcel, readInt);
                    break;
                case 5:
                    i5 = a.d(parcel, readInt);
                    break;
                case 6:
                    i6 = a.d(parcel, readInt);
                    break;
                case 7:
                    i7 = a.d(parcel, readInt);
                    break;
                case 8:
                    i8 = a.d(parcel, readInt);
                    break;
                case 9:
                    i9 = a.d(parcel, readInt);
                    break;
                case 10:
                    str = a.e(parcel, readInt);
                    break;
                case 11:
                    i10 = a.d(parcel, readInt);
                    break;
                case 12:
                    str2 = a.e(parcel, readInt);
                    break;
                case 13:
                    i11 = a.d(parcel, readInt);
                    break;
                case 14:
                    i12 = a.d(parcel, readInt);
                    break;
                case 15:
                    str3 = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new SearchAdRequestParcel(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SearchAdRequestParcel[i];
    }
}
