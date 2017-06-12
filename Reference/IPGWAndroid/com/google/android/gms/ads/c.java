package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.n;
import com.google.android.gms.ads.internal.util.client.a;

public final class c {
    public static final c a = new c(320, 50, "320x50_mb");
    public static final c b = new c(468, 60, "468x60_as");
    public static final c c = new c(320, 100, "320x100_as");
    public static final c d = new c(728, 90, "728x90_as");
    public static final c e = new c(300, 250, "300x250_as");
    public static final c f = new c(160, 600, "160x600_as");
    public static final c g = new c(-1, -2, "smart_banner");
    public static final c h = new c(-3, -4, "fluid");
    public final int i;
    public final int j;
    private final String k;

    public c(int i, int i2) {
        this(i, i2, (i == -1 ? "FULL" : String.valueOf(i)) + "x" + (i2 == -2 ? "AUTO" : String.valueOf(i2)) + "_as");
    }

    public c(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i);
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.i = i;
            this.j = i2;
            this.k = str;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i2);
        }
    }

    public final int a(Context context) {
        switch (this.j) {
            case -4:
            case -3:
                return -1;
            case -2:
                return AdSizeParcel.b(context.getResources().getDisplayMetrics());
            default:
                n.a();
                return a.a(context, this.j);
        }
    }

    public final int b(Context context) {
        switch (this.i) {
            case -4:
            case -3:
                return -1;
            case -1:
                return AdSizeParcel.a(context.getResources().getDisplayMetrics());
            default:
                n.a();
                return a.a(context, this.i);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.i == cVar.i && this.j == cVar.j && this.k.equals(cVar.k);
    }

    public final int hashCode() {
        return this.k.hashCode();
    }

    public final String toString() {
        return this.k;
    }
}
