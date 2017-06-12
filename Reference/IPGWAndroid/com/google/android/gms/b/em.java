package com.google.android.gms.b;

import android.os.Binder;
import android.os.Parcel;

public abstract class em extends Binder implements el {
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                String a = a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                b(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
