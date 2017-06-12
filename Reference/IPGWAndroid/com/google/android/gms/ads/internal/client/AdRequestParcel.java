package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.b.fd;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;

@fd
public final class AdRequestParcel implements SafeParcelable {
    public static final i CREATOR = new i();
    public final int a;
    public final long b;
    public final Bundle c;
    public final int d;
    public final List<String> e;
    public final boolean f;
    public final int g;
    public final boolean h;
    public final String i;
    public final SearchAdRequestParcel j;
    public final Location k;
    public final String l;
    public final Bundle m;
    public final Bundle n;
    public final List<String> o;
    public final String p;
    public final String q;
    public final boolean r;

    public AdRequestParcel(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, SearchAdRequestParcel searchAdRequestParcel, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3) {
        this.a = i;
        this.b = j;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.c = bundle;
        this.d = i2;
        this.e = list;
        this.f = z;
        this.g = i3;
        this.h = z2;
        this.i = str;
        this.j = searchAdRequestParcel;
        this.k = location;
        this.l = str2;
        this.m = bundle2;
        this.n = bundle3;
        this.o = list2;
        this.p = str3;
        this.q = str4;
        this.r = z3;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AdRequestParcel)) {
            return false;
        }
        AdRequestParcel adRequestParcel = (AdRequestParcel) obj;
        return this.a == adRequestParcel.a && this.b == adRequestParcel.b && b.a(this.c, adRequestParcel.c) && this.d == adRequestParcel.d && b.a(this.e, adRequestParcel.e) && this.f == adRequestParcel.f && this.g == adRequestParcel.g && this.h == adRequestParcel.h && b.a(this.i, adRequestParcel.i) && b.a(this.j, adRequestParcel.j) && b.a(this.k, adRequestParcel.k) && b.a(this.l, adRequestParcel.l) && b.a(this.m, adRequestParcel.m) && b.a(this.n, adRequestParcel.n) && b.a(this.o, adRequestParcel.o) && b.a(this.p, adRequestParcel.p) && b.a(this.q, adRequestParcel.q) && this.r == adRequestParcel.r;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Long.valueOf(this.b), this.c, Integer.valueOf(this.d), this.e, Boolean.valueOf(this.f), Integer.valueOf(this.g), Boolean.valueOf(this.h), this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, Boolean.valueOf(this.r)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i.a(this, parcel, i);
    }
}
