package com.alipay.sdk.a;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

public final class d {
    c a;
    Context b;

    public d(Context context, c cVar) {
        this.b = context;
        this.a = cVar;
    }

    public final void a(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", i - 1);
            a aVar = new a("callback");
            aVar.e = jSONObject;
            aVar.a = str;
            this.a.a(aVar);
        }
    }
}
