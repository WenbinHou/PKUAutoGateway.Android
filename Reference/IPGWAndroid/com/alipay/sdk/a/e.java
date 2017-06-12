package com.alipay.sdk.a;

import android.widget.Toast;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

public final class e implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ d b;

    public e(d dVar, a aVar) {
        this.b = dVar;
        this.a = aVar;
    }

    public final void run() {
        int i;
        d dVar = this.b;
        a aVar = this.a;
        if (aVar != null && "toast".equals(aVar.c)) {
            JSONObject jSONObject = aVar.e;
            CharSequence optString = jSONObject.optString("content");
            int optInt = jSONObject.optInt("duration");
            i = 1;
            if (optInt < 2500) {
                i = 0;
            }
            Toast.makeText(dVar.b, optString, i).show();
            new Timer().schedule(new f(dVar, aVar), (long) i);
        }
        i = b.a;
        if (i != b.a) {
            try {
                this.b.a(this.a.a, i);
            } catch (JSONException e) {
            }
        }
    }
}
