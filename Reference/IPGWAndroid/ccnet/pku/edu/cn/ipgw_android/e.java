package ccnet.pku.edu.cn.ipgw_android;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import b.ar;
import b.h;
import com.kaopiz.kprogresshud.f;
import org.json.JSONObject;

final class e implements h {
    Handler a = new Handler(Looper.getMainLooper());
    final /* synthetic */ f b;
    final /* synthetic */ View c;
    final /* synthetic */ Activity_Conns d;

    e(Activity_Conns activity_Conns, f fVar, View view) {
        this.d = activity_Conns;
        this.b = fVar;
        this.c = view;
    }

    public final void a() {
        this.a.post(new f(this));
    }

    public final void a(ar arVar) {
        if (arVar.a()) {
            try {
                JSONObject jSONObject = new JSONObject(arVar.g.d());
                this.a.post(new h(this));
                if (jSONObject.has("succ")) {
                    this.a.post(new i(this));
                    return;
                } else if (jSONObject.has("error")) {
                    this.a.post(new j(this, jSONObject.getString("error")));
                    return;
                } else {
                    this.a.post(new k(this));
                    return;
                }
            } catch (Exception e) {
                this.a.post(new l(this));
                return;
            }
        }
        this.a.post(new g(this));
    }
}
