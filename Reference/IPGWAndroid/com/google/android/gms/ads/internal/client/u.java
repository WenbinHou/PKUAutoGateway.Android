package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;
import com.google.android.gms.b.cw;

public abstract class u extends Binder implements t {
    public static t a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof t)) ? new v(iBinder) : (t) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        AdSizeParcel adSizeParcel = null;
        a a;
        j jVar;
        IBinder a2;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                a = b.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    jVar = AdSizeParcel.CREATOR;
                    adSizeParcel = j.a(parcel);
                }
                a2 = a(a, adSizeParcel, parcel.readString(), cw.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a2);
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                a = b.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    jVar = AdSizeParcel.CREATOR;
                    adSizeParcel = j.a(parcel);
                }
                a2 = a(a, adSizeParcel, parcel.readString(), cw.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a2);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
