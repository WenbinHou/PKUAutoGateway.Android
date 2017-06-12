package com.google.android.gms.b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.i;
import com.google.android.gms.ads.internal.client.j;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.c;

public abstract class cz extends Binder implements cy {
    public static cy a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof cy)) ? new da(iBinder) : (cy) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        AdRequestParcel adRequestParcel = null;
        a a;
        j jVar;
        AdSizeParcel a2;
        i iVar;
        AdRequestParcel a3;
        IBinder asBinder;
        AdRequestParcel a4;
        i iVar2;
        String readString;
        Bundle j;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                a = b.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    jVar = AdSizeParcel.CREATOR;
                    a2 = j.a(parcel);
                } else {
                    a2 = null;
                }
                if (parcel.readInt() != 0) {
                    iVar = AdRequestParcel.CREATOR;
                    a3 = i.a(parcel);
                } else {
                    a3 = null;
                }
                a(a, a2, a3, parcel.readString(), dc.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                a = a();
                parcel2.writeNoException();
                if (a != null) {
                    asBinder = a.asBinder();
                }
                parcel2.writeStrongBinder(asBinder);
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                a = b.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    iVar = AdRequestParcel.CREATOR;
                    adRequestParcel = i.a(parcel);
                }
                a(a, adRequestParcel, parcel.readString(), dc.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                b();
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                c();
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                a = b.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    jVar = AdSizeParcel.CREATOR;
                    a2 = j.a(parcel);
                } else {
                    a2 = null;
                }
                if (parcel.readInt() != 0) {
                    iVar = AdRequestParcel.CREATOR;
                    a3 = i.a(parcel);
                } else {
                    a3 = null;
                }
                a(a, a2, a3, parcel.readString(), parcel.readString(), dc.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                a = b.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    iVar = AdRequestParcel.CREATOR;
                    a4 = i.a(parcel);
                } else {
                    a4 = null;
                }
                a(a, a4, parcel.readString(), parcel.readString(), dc.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                d();
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                e();
                parcel2.writeNoException();
                return true;
            case 10:
                com.google.android.gms.ads.internal.reward.mediation.client.a aVar;
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                a = b.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    iVar2 = AdRequestParcel.CREATOR;
                    a4 = i.a(parcel);
                } else {
                    a4 = null;
                }
                readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    aVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof com.google.android.gms.ads.internal.reward.mediation.client.a)) {
                        Object cVar = new c(readStrongBinder);
                    } else {
                        aVar = (com.google.android.gms.ads.internal.reward.mediation.client.a) queryLocalInterface;
                    }
                }
                a(a, a4, readString, aVar, parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                if (parcel.readInt() != 0) {
                    iVar = AdRequestParcel.CREATOR;
                    adRequestParcel = i.a(parcel);
                }
                a(adRequestParcel, parcel.readString());
                parcel2.writeNoException();
                return true;
            case 12:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                f();
                parcel2.writeNoException();
                return true;
            case 13:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                boolean g = g();
                parcel2.writeNoException();
                parcel2.writeInt(g ? 1 : 0);
                return true;
            case 14:
                NativeAdOptionsParcel a5;
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                a = b.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    iVar2 = AdRequestParcel.CREATOR;
                    a4 = i.a(parcel);
                } else {
                    a4 = null;
                }
                readString = parcel.readString();
                String readString2 = parcel.readString();
                db a6 = dc.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    com.google.android.gms.ads.internal.formats.a aVar2 = NativeAdOptionsParcel.CREATOR;
                    a5 = com.google.android.gms.ads.internal.formats.a.a(parcel);
                } else {
                    a5 = null;
                }
                a(a, a4, readString, readString2, a6, a5, parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 15:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                di h = h();
                parcel2.writeNoException();
                if (h != null) {
                    asBinder = h.asBinder();
                }
                parcel2.writeStrongBinder(asBinder);
                return true;
            case 16:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                dl i3 = i();
                parcel2.writeNoException();
                if (i3 != null) {
                    asBinder = i3.asBinder();
                }
                parcel2.writeStrongBinder(asBinder);
                return true;
            case 17:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                j = j();
                parcel2.writeNoException();
                if (j != null) {
                    parcel2.writeInt(1);
                    j.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 18:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                j = k();
                parcel2.writeNoException();
                if (j != null) {
                    parcel2.writeInt(1);
                    j.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 19:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                j = l();
                parcel2.writeNoException();
                if (j != null) {
                    parcel2.writeInt(1);
                    j.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 20:
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                if (parcel.readInt() != 0) {
                    iVar = AdRequestParcel.CREATOR;
                    adRequestParcel = i.a(parcel);
                }
                a(adRequestParcel, parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
