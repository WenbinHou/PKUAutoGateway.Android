package com.google.android.gms.b;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.a.a;

public abstract class bf extends Binder implements be {
    public static be a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof be)) ? new bg(iBinder) : (be) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                a a = a();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                Uri b = b();
                parcel2.writeNoException();
                if (b != null) {
                    parcel2.writeInt(1);
                    b.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                double c = c();
                parcel2.writeNoException();
                parcel2.writeDouble(c);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
