package com.alipay.sdk.app.a;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.alipay.sdk.f.a.c;
import com.alipay.sdk.k.i;
import java.io.IOException;

final class b implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;

    b(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    public final void run() {
        c cVar = new c();
        try {
            String b = i.b(this.a, "alipay_cashier_statistic_record", null);
            if (!(TextUtils.isEmpty(b) || cVar.a(this.a, b) == null)) {
                try {
                    PreferenceManager.getDefaultSharedPreferences(this.a).edit().remove("alipay_cashier_statistic_record").commit();
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
        try {
            if (!TextUtils.isEmpty(this.b)) {
                cVar.a(this.a, this.b);
            }
        } catch (IOException e) {
            i.a(this.a, "alipay_cashier_statistic_record", this.b);
        } catch (Throwable th3) {
        }
    }
}
