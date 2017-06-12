package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.b;
import com.google.android.gms.a.d;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.bn;
import com.google.android.gms.b.cc;
import com.google.android.gms.b.fd;
import com.google.android.gms.b.gv;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@fd
public final class AdOverlayInfoParcel implements SafeParcelable {
    public static final k CREATOR = new k();
    public final int a;
    public final AdLauncherIntentInfoParcel b;
    public final a c;
    public final l d;
    public final gv e;
    public final bn f;
    public final String g;
    public final boolean h;
    public final String i;
    public final s j;
    public final int k;
    public final int l;
    public final String m;
    public final VersionInfoParcel n;
    public final cc o;
    public final String p;
    public final InterstitialAdParameterParcel q;

    AdOverlayInfoParcel(int i, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, VersionInfoParcel versionInfoParcel, IBinder iBinder6, String str4, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.a = i;
        this.b = adLauncherIntentInfoParcel;
        this.c = (a) d.a(b.a(iBinder));
        this.d = (l) d.a(b.a(iBinder2));
        this.e = (gv) d.a(b.a(iBinder3));
        this.f = (bn) d.a(b.a(iBinder4));
        this.g = str;
        this.h = z;
        this.i = str2;
        this.j = (s) d.a(b.a(iBinder5));
        this.k = i2;
        this.l = i3;
        this.m = str3;
        this.n = versionInfoParcel;
        this.o = (cc) d.a(b.a(iBinder6));
        this.p = str4;
        this.q = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(a aVar, l lVar, s sVar, gv gvVar, boolean z, int i, VersionInfoParcel versionInfoParcel) {
        this.a = 4;
        this.b = null;
        this.c = aVar;
        this.d = lVar;
        this.e = gvVar;
        this.f = null;
        this.g = null;
        this.h = z;
        this.i = null;
        this.j = sVar;
        this.k = i;
        this.l = 2;
        this.m = null;
        this.n = versionInfoParcel;
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public AdOverlayInfoParcel(a aVar, l lVar, bn bnVar, s sVar, gv gvVar, boolean z, int i, String str, VersionInfoParcel versionInfoParcel, cc ccVar) {
        this.a = 4;
        this.b = null;
        this.c = aVar;
        this.d = lVar;
        this.e = gvVar;
        this.f = bnVar;
        this.g = null;
        this.h = z;
        this.i = null;
        this.j = sVar;
        this.k = i;
        this.l = 3;
        this.m = str;
        this.n = versionInfoParcel;
        this.o = ccVar;
        this.p = null;
        this.q = null;
    }

    public AdOverlayInfoParcel(a aVar, l lVar, bn bnVar, s sVar, gv gvVar, boolean z, int i, String str, String str2, VersionInfoParcel versionInfoParcel, cc ccVar) {
        this.a = 4;
        this.b = null;
        this.c = aVar;
        this.d = lVar;
        this.e = gvVar;
        this.f = bnVar;
        this.g = str2;
        this.h = z;
        this.i = str;
        this.j = sVar;
        this.k = i;
        this.l = 3;
        this.m = null;
        this.n = versionInfoParcel;
        this.o = ccVar;
        this.p = null;
        this.q = null;
    }

    public AdOverlayInfoParcel(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, a aVar, l lVar, s sVar, VersionInfoParcel versionInfoParcel) {
        this.a = 4;
        this.b = adLauncherIntentInfoParcel;
        this.c = aVar;
        this.d = lVar;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = null;
        this.j = sVar;
        this.k = -1;
        this.l = 4;
        this.m = null;
        this.n = versionInfoParcel;
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public static AdOverlayInfoParcel a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public static void a(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        k.a(this, parcel, i);
    }
}
