package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.List;

public final class i implements Creator<AdRequestParcel> {
    public static AdRequestParcel a(Parcel parcel) {
        int a = a.a(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        SearchAdRequestParcel searchAdRequestParcel = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        List list2 = null;
        String str3 = null;
        String str4 = null;
        boolean z3 = false;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    a.a(parcel, readInt, 8);
                    j = parcel.readLong();
                    break;
                case 3:
                    bundle = a.g(parcel, readInt);
                    break;
                case 4:
                    i2 = a.d(parcel, readInt);
                    break;
                case 5:
                    list = a.h(parcel, readInt);
                    break;
                case 6:
                    z = a.c(parcel, readInt);
                    break;
                case 7:
                    i3 = a.d(parcel, readInt);
                    break;
                case 8:
                    z2 = a.c(parcel, readInt);
                    break;
                case 9:
                    str = a.e(parcel, readInt);
                    break;
                case 10:
                    searchAdRequestParcel = (SearchAdRequestParcel) a.a(parcel, readInt, SearchAdRequestParcel.CREATOR);
                    break;
                case 11:
                    location = (Location) a.a(parcel, readInt, Location.CREATOR);
                    break;
                case 12:
                    str2 = a.e(parcel, readInt);
                    break;
                case 13:
                    bundle2 = a.g(parcel, readInt);
                    break;
                case 14:
                    bundle3 = a.g(parcel, readInt);
                    break;
                case 15:
                    list2 = a.h(parcel, readInt);
                    break;
                case 16:
                    str3 = a.e(parcel, readInt);
                    break;
                case 17:
                    str4 = a.e(parcel, readInt);
                    break;
                case 18:
                    z3 = a.c(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new AdRequestParcel(i, j, bundle, i2, list, z, i3, z2, str, searchAdRequestParcel, location, str2, bundle2, bundle3, list2, str3, str4, z3);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    static void a(AdRequestParcel adRequestParcel, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, adRequestParcel.a);
        long j = adRequestParcel.b;
        c.a(parcel, 2, 8);
        parcel.writeLong(j);
        c.a(parcel, 3, adRequestParcel.c);
        c.b(parcel, 4, adRequestParcel.d);
        c.a(parcel, 5, adRequestParcel.e);
        c.a(parcel, 6, adRequestParcel.f);
        c.b(parcel, 7, adRequestParcel.g);
        c.a(parcel, 8, adRequestParcel.h);
        c.a(parcel, 9, adRequestParcel.i);
        c.a(parcel, 10, adRequestParcel.j, i);
        c.a(parcel, 11, adRequestParcel.k, i);
        c.a(parcel, 12, adRequestParcel.l);
        c.a(parcel, 13, adRequestParcel.m);
        c.a(parcel, 14, adRequestParcel.n);
        c.a(parcel, 15, adRequestParcel.o);
        c.a(parcel, 17, adRequestParcel.q);
        c.a(parcel, 16, adRequestParcel.p);
        c.a(parcel, 18, adRequestParcel.r);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AdRequestParcel[i];
    }
}
