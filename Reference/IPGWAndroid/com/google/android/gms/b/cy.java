package com.google.android.gms.b;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.a.a;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import java.util.List;

public interface cy extends IInterface {
    a a();

    void a(a aVar, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.a aVar2, String str2);

    void a(a aVar, AdRequestParcel adRequestParcel, String str, db dbVar);

    void a(a aVar, AdRequestParcel adRequestParcel, String str, String str2, db dbVar);

    void a(a aVar, AdRequestParcel adRequestParcel, String str, String str2, db dbVar, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list);

    void a(a aVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, db dbVar);

    void a(a aVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, db dbVar);

    void a(AdRequestParcel adRequestParcel, String str);

    void a(AdRequestParcel adRequestParcel, String str, String str2);

    void b();

    void c();

    void d();

    void e();

    void f();

    boolean g();

    di h();

    dl i();

    Bundle j();

    Bundle k();

    Bundle l();
}
