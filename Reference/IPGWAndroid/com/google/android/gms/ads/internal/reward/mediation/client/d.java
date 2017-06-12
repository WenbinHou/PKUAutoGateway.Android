package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class d implements Creator<RewardItemParcel> {
    public static RewardItemParcel a(Parcel parcel) {
        int i = 0;
        int a = a.a(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = a.d(parcel, readInt);
                    break;
                case 2:
                    str = a.e(parcel, readInt);
                    break;
                case 3:
                    i = a.d(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new RewardItemParcel(i2, str, i);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    static void a(RewardItemParcel rewardItemParcel, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, rewardItemParcel.a);
        c.a(parcel, 2, rewardItemParcel.b);
        c.b(parcel, 3, rewardItemParcel.c);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new RewardItemParcel[i];
    }
}
