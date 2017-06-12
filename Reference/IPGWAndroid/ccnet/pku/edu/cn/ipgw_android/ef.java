package ccnet.pku.edu.cn.ipgw_android;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import b.ar;
import b.h;
import org.json.JSONObject;

final class ef implements h {
    Handler a = new Handler(Looper.getMainLooper());
    final /* synthetic */ Context b;
    final /* synthetic */ IPGWWidgetProvider c;

    ef(IPGWWidgetProvider iPGWWidgetProvider, Context context) {
        this.c = iPGWWidgetProvider;
        this.b = context;
    }

    public final void a() {
        this.a.post(new eg(this));
    }

    public final void a(ar arVar) {
        if (arVar.a()) {
            try {
                JSONObject jSONObject = new JSONObject(arVar.g.d());
                if (jSONObject.has("succ")) {
                    this.a.post(new ei(this));
                    return;
                } else if (jSONObject.has("error")) {
                    this.a.post(new ej(this, jSONObject.getString("error")));
                    return;
                } else {
                    this.a.post(new ek(this));
                    return;
                }
            } catch (Exception e) {
                this.a.post(new el(this));
                return;
            }
        }
        this.a.post(new eh(this));
    }
}
