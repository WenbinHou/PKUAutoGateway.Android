package com.google.android.gms.b;

import android.os.Binder;
import android.os.Parcel;

public abstract class dg extends Binder implements df {
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                int a = a();
                parcel2.writeNoException();
                parcel2.writeInt(a);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
