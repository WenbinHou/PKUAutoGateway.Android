package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.a.b;

public abstract class bi extends Binder implements bh {
    public static bh a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof bh)) ? new bj(iBinder) : (bh) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                IBinder a = a(b.a(parcel.readStrongBinder()), b.a(parcel.readStrongBinder()), b.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
