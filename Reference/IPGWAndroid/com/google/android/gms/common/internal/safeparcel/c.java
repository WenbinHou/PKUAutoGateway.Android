package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public final class c {
    public static int a(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void a(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static void a(Parcel parcel, int i, Bundle bundle) {
        if (bundle != null) {
            int a = a(parcel, i);
            parcel.writeBundle(bundle);
            b(parcel, a);
        }
    }

    public static void a(Parcel parcel, int i, IBinder iBinder) {
        if (iBinder != null) {
            int a = a(parcel, i);
            parcel.writeStrongBinder(iBinder);
            b(parcel, a);
        }
    }

    public static void a(Parcel parcel, int i, Parcelable parcelable, int i2) {
        if (parcelable != null) {
            int a = a(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            b(parcel, a);
        }
    }

    public static void a(Parcel parcel, int i, String str) {
        if (str != null) {
            int a = a(parcel, i);
            parcel.writeString(str);
            b(parcel, a);
        }
    }

    public static void a(Parcel parcel, int i, List<String> list) {
        if (list != null) {
            int a = a(parcel, i);
            parcel.writeStringList(list);
            b(parcel, a);
        }
    }

    public static void a(Parcel parcel, int i, boolean z) {
        a(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void b(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    public static void b(Parcel parcel, int i, int i2) {
        a(parcel, i, 4);
        parcel.writeInt(i2);
    }
}
