package com.google.android.gms.b;

import android.os.IBinder;
import android.os.Parcel;

final class dh implements df {
    private IBinder a;

    dh(IBinder iBinder) {
        this.a = iBinder;
    }

    public final int a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.a;
    }
}
