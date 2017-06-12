package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.b.fd;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@fd
public class AdSizeParcel implements SafeParcelable {
    public static final j CREATOR = new j();
    public final int a;
    public final String b;
    public final int c;
    public final int d;
    public final boolean e;
    public final int f;
    public final int g;
    public final AdSizeParcel[] h;
    public final boolean i;
    public final boolean j;
    public boolean k;

    public AdSizeParcel() {
        this(5, "interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    AdSizeParcel(int i, String str, int i2, int i3, boolean z, int i4, int i5, AdSizeParcel[] adSizeParcelArr, boolean z2, boolean z3, boolean z4) {
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.e = z;
        this.f = i4;
        this.g = i5;
        this.h = adSizeParcelArr;
        this.i = z2;
        this.j = z3;
        this.k = z4;
    }

    public AdSizeParcel(Context context, c cVar) {
        this(context, new c[]{cVar});
    }

    public AdSizeParcel(Context context, c[] cVarArr) {
        int i;
        int i2;
        c cVar = cVarArr[0];
        this.a = 5;
        this.e = false;
        boolean z = cVar.i == -3 && cVar.j == -4;
        this.j = z;
        if (this.j) {
            this.f = c.a.i;
            this.c = c.a.j;
        } else {
            this.f = cVar.i;
            this.c = cVar.j;
        }
        z = this.f == -1;
        boolean z2 = this.c == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            double d;
            n.a();
            if (a.a(context)) {
                n.a();
                if (a.b(context)) {
                    i = displayMetrics.widthPixels;
                    n.a();
                    this.g = i - a.c(context);
                    d = (double) (((float) this.g) / displayMetrics.density);
                    i = (int) d;
                    if (d - ((double) ((int) d)) >= 0.01d) {
                        i++;
                    }
                    i2 = i;
                }
            }
            this.g = displayMetrics.widthPixels;
            d = (double) (((float) this.g) / displayMetrics.density);
            i = (int) d;
            if (d - ((double) ((int) d)) >= 0.01d) {
                i++;
            }
            i2 = i;
        } else {
            i = this.f;
            n.a();
            this.g = a.a(displayMetrics, this.f);
            i2 = i;
        }
        i = z2 ? c(displayMetrics) : this.c;
        n.a();
        this.d = a.a(displayMetrics, i);
        if (z || z2) {
            this.b = i2 + "x" + i + "_as";
        } else if (this.j) {
            this.b = "320x50_mb";
        } else {
            this.b = cVar.toString();
        }
        if (cVarArr.length > 1) {
            this.h = new AdSizeParcel[cVarArr.length];
            for (int i3 = 0; i3 < cVarArr.length; i3++) {
                this.h[i3] = new AdSizeParcel(context, cVarArr[i3]);
            }
        } else {
            this.h = null;
        }
        this.i = false;
        this.k = false;
    }

    public static int a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int b(DisplayMetrics displayMetrics) {
        return (int) (((float) c(displayMetrics)) * displayMetrics.density);
    }

    private static int c(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return i <= 400 ? 32 : i <= 720 ? 50 : 90;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        j.a(this, parcel, i);
    }
}
