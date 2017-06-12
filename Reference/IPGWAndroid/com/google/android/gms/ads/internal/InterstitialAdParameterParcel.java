package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.b.fd;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@fd
public final class InterstitialAdParameterParcel implements SafeParcelable {
    public static final d CREATOR = new d();
    public final int a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public final boolean e;
    public final float f;

    InterstitialAdParameterParcel(int i, boolean z, boolean z2, String str, boolean z3, float f) {
        this.a = i;
        this.b = z;
        this.c = z2;
        this.d = str;
        this.e = z3;
        this.f = f;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        d.a(this, parcel);
    }
}
