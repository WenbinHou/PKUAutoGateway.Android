package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import com.google.android.gms.b.fd;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@fd
public final class RewardItemParcel implements SafeParcelable {
    public static final d CREATOR = new d();
    public final int a;
    public final String b;
    public final int c;

    public RewardItemParcel(int i, String str, int i2) {
        this.a = i;
        this.b = str;
        this.c = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RewardItemParcel)) {
            return false;
        }
        RewardItemParcel rewardItemParcel = (RewardItemParcel) obj;
        return b.a(this.b, rewardItemParcel.b) && b.a(Integer.valueOf(this.c), Integer.valueOf(rewardItemParcel.c));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, Integer.valueOf(this.c)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        d.a(this, parcel);
    }
}
