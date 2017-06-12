package com.google.android.gms.b;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;

final class bg implements be {
    private IBinder a;

    bg(IBinder iBinder) {
        this.a = iBinder;
    }

    public final a a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            a a = b.a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.a;
    }

    public final Uri b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            this.a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            Uri uri = obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return uri;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final double c() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            this.a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            double readDouble = obtain2.readDouble();
            return readDouble;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
