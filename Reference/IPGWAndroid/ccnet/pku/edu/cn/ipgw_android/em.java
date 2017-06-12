package ccnet.pku.edu.cn.ipgw_android;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import b.ar;
import b.h;
import org.json.JSONObject;

final class em implements h {
    Handler a = new Handler(Looper.getMainLooper());
    final /* synthetic */ Context b;
    final /* synthetic */ String c;
    final /* synthetic */ IPGWWidgetProvider d;

    em(IPGWWidgetProvider iPGWWidgetProvider, Context context, String str) {
        this.d = iPGWWidgetProvider;
        this.b = context;
        this.c = str;
    }

    public final void a() {
        this.a.post(new en(this));
    }

    public final void a(ar arVar) {
        if (arVar.a()) {
            try {
                JSONObject jSONObject = new JSONObject(arVar.g.d());
                if (jSONObject.has("succ")) {
                    this.a.post(new ep(this));
                    return;
                } else if (jSONObject.has("error")) {
                    this.a.post(new eq(this, jSONObject.getString("error")));
                    return;
                } else {
                    this.a.post(new er(this));
                    return;
                }
            } catch (Exception e) {
                this.a.post(new es(this));
                return;
            }
        }
        this.a.post(new eo(this));
    }
}
