package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.google.android.gms.b.fd;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@fd
public final class VersionInfoParcel implements SafeParcelable {
    public static final c CREATOR = new c();
    public final int a;
    public String b;
    public int c;
    public int d;
    public boolean e;

    VersionInfoParcel(int i, String str, int i2, int i3, boolean z) {
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.e = z;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        c.a(this, parcel);
    }
}
