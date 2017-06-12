package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.b.fd;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@fd
public class NativeAdOptionsParcel implements SafeParcelable {
    public static final a CREATOR = new a();
    public final int a;
    public final boolean b;
    public final int c;
    public final boolean d;

    public NativeAdOptionsParcel(int i, boolean z, int i2, boolean z2) {
        this.a = i;
        this.b = z;
        this.c = i2;
        this.d = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel);
    }
}
