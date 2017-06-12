package ccnet.pku.edu.cn.ipgw_android;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import b.ar;
import b.h;
import com.kaopiz.kprogresshud.f;
import org.json.JSONObject;

final class co implements h {
    Handler a = new Handler(Looper.getMainLooper());
    final /* synthetic */ f b;
    final /* synthetic */ View c;
    final /* synthetic */ bz d;

    co(bz bzVar, f fVar, View view) {
        this.d = bzVar;
        this.b = fVar;
        this.c = view;
    }

    public final void a() {
        this.a.post(new cp(this));
    }

    public final void a(ar arVar) {
        if (arVar.a()) {
            try {
                JSONObject jSONObject = new JSONObject(arVar.g.d());
                this.a.post(new cr(this));
                if (jSONObject.has("succ")) {
                    this.a.post(new cs(this));
                    return;
                } else if (jSONObject.has("error")) {
                    this.a.post(new ct(this, jSONObject.getString("error")));
                    return;
                } else {
                    this.a.post(new cu(this));
                    return;
                }
            } catch (Exception e) {
                this.a.post(new cv(this));
                return;
            }
        }
        this.a.post(new cq(this));
    }
}
