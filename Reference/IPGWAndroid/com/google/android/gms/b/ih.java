package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.a.b;

public abstract class ih extends Binder implements ig {
    public ih() {
        attachInterface(this, "com.google.android.gms.flags.IFlagProvider");
    }

    public static ig asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof ig)) ? new ii(iBinder) : (ig) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3 = 0;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                init(b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                boolean booleanFlagValue = getBooleanFlagValue(parcel.readString(), parcel.readInt() != 0, parcel.readInt());
                parcel2.writeNoException();
                if (booleanFlagValue) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                int intFlagValue = getIntFlagValue(parcel.readString(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(intFlagValue);
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                long longFlagValue = getLongFlagValue(parcel.readString(), parcel.readLong(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeLong(longFlagValue);
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                String stringFlagValue = getStringFlagValue(parcel.readString(), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeString(stringFlagValue);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.flags.IFlagProvider");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
