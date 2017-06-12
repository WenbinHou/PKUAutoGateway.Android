package ccnet.pku.edu.cn.ipgw_android;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import b.ar;
import b.h;
import org.json.JSONObject;

final class dn implements h {
    Handler a = new Handler(Looper.getMainLooper());
    final /* synthetic */ View b;
    final /* synthetic */ dj c;

    dn(dj djVar, View view) {
        this.c = djVar;
        this.b = view;
    }

    public final void a() {
        this.a.post(new do(this));
    }

    public final void a(ar arVar) {
        if (arVar.a()) {
            try {
                JSONObject jSONObject = new JSONObject(arVar.g.d());
                this.a.post(new dq(this));
                if (jSONObject.has("error")) {
                    this.a.post(new dr(this, jSONObject.getString("error")));
                    return;
                } else if (jSONObject.has("succ")) {
                    String string = jSONObject.getString("succ");
                    if (string == null) {
                        this.a.post(new ds(this));
                        return;
                    } else {
                        this.a.post(new dt(this, string));
                        return;
                    }
                } else {
                    this.a.post(new du(this));
                    return;
                }
            } catch (Exception e) {
                this.a.post(new dv(this));
                return;
            }
        }
        this.a.post(new dp(this));
    }
}
