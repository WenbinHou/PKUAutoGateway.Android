package ccnet.pku.edu.cn.ipgw_android;

import android.os.Handler;
import android.os.Looper;
import b.h;
import com.kaopiz.kprogresshud.f;
import org.json.JSONObject;

final class ar implements h {
    Handler a = new Handler(Looper.getMainLooper());
    final /* synthetic */ f b;
    final /* synthetic */ Activity_ResetPasswd c;

    ar(Activity_ResetPasswd activity_ResetPasswd, f fVar) {
        this.c = activity_ResetPasswd;
        this.b = fVar;
    }

    public final void a() {
        this.a.post(new as(this));
    }

    public final void a(b.ar arVar) {
        if (arVar.a()) {
            try {
                JSONObject jSONObject = new JSONObject(arVar.g.d());
                this.a.post(new au(this));
                if (jSONObject.has("error")) {
                    this.a.post(new av(this, jSONObject.getString("error")));
                    return;
                } else if (jSONObject.has("succ")) {
                    this.a.post(new aw(this, jSONObject.getString("succ")));
                    return;
                } else {
                    this.a.post(new ax(this));
                    return;
                }
            } catch (Exception e) {
                this.a.post(new ay(this));
                return;
            }
        }
        this.a.post(new at(this));
    }
}
