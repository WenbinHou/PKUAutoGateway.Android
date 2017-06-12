package com.alipay.sdk.a;

import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

final class f extends TimerTask {
    final /* synthetic */ a a;
    final /* synthetic */ d b;

    f(d dVar, a aVar) {
        this.b = dVar;
        this.a = aVar;
    }

    public final void run() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("toastCallBack", "true");
        } catch (JSONException e) {
        }
        a aVar = new a("callback");
        aVar.a = this.a.a;
        aVar.e = jSONObject;
        this.b.a.a(aVar);
    }
}
