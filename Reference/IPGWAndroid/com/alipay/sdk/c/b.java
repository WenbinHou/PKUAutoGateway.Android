package com.alipay.sdk.c;

import android.content.Context;
import com.alipay.sdk.b.a;
import com.alipay.sdk.k.i;
import org.json.JSONObject;

final class b implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ a b;

    b(a aVar, Context context) {
        this.b = aVar;
        this.a = context;
    }

    public final void run() {
        try {
            com.alipay.sdk.f.b a = new com.alipay.sdk.f.a.b().a(this.a, "", a.a, true);
            if (a != null) {
                this.b.a(a.b);
                a aVar = this.b;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("timeout", aVar.a());
                    jSONObject.put("tbreturl", aVar.a);
                    i.a(com.alipay.sdk.i.b.a().a, "alipay_cashier_dynamic_config", jSONObject.toString());
                } catch (Exception e) {
                }
            }
        } catch (Throwable th) {
        }
    }
}
