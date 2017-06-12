package com.google.android.gms.b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;

final class bj implements bh {
    private IBinder a;

    bj(IBinder iBinder) {
        this.a = iBinder;
    }

    public final IBinder a(a aVar, a aVar2, a aVar3, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
            obtain.writeStrongBinder(aVar2 != null ? aVar2.asBinder() : null);
            if (aVar3 != null) {
                iBinder = aVar3.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            iBinder = obtain2.readStrongBinder();
            return iBinder;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.a;
    }
}
