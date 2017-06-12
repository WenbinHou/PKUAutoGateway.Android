package com.alipay.sdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.i.b;
import com.alipay.sdk.k.i;
import org.json.JSONObject;

public final class a {
    private static a c;
    public String a = "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&";
    private int b = 3500;

    public static a b() {
        if (c == null) {
            a aVar = new a();
            c = aVar;
            aVar.a(i.b(b.a().a, "alipay_cashier_dynamic_config", null));
        }
        return c;
    }

    public final int a() {
        if (this.b < 1000 || this.b > 20000) {
            return 3500;
        }
        new StringBuilder("DynamicConfig::getJumpTimeout >").append(this.b);
        return this.b;
    }

    public final void a(Context context) {
        new Thread(new b(this, context)).start();
    }

    final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("st_sdk_config");
                this.b = optJSONObject.optInt("timeout", 3500);
                this.a = optJSONObject.optString("tbreturl", "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&").trim();
            } catch (Throwable th) {
            }
        }
    }
}
