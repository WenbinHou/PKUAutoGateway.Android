package com.google.android.gms.ads.internal.purchase;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.a.d;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class a implements Creator<GInAppPurchaseManagerInfoParcel> {
    static void a(GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, gInAppPurchaseManagerInfoParcel.a);
        c.a(parcel, 3, d.a(gInAppPurchaseManagerInfoParcel.b).asBinder());
        c.a(parcel, 4, d.a(gInAppPurchaseManagerInfoParcel.c).asBinder());
        c.a(parcel, 5, d.a(gInAppPurchaseManagerInfoParcel.d).asBinder());
        c.a(parcel, 6, d.a(gInAppPurchaseManagerInfoParcel.e).asBinder());
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.d(parcel, readInt);
                    break;
                case 3:
                    iBinder4 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, readInt);
                    break;
                case 4:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, readInt);
                    break;
                case 5:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, readInt);
                    break;
                case 6:
                    iBinder = com.google.android.gms.common.internal.safeparcel.a.f(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new GInAppPurchaseManagerInfoParcel(i, iBinder4, iBinder3, iBinder2, iBinder);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GInAppPurchaseManagerInfoParcel[i];
    }
}
