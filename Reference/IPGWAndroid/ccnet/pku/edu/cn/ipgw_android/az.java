package ccnet.pku.edu.cn.ipgw_android;

import android.os.Handler;
import android.os.Looper;
import b.ar;
import b.h;
import com.kaopiz.kprogresshud.f;
import org.json.JSONObject;

final class az implements h {
    Handler a = new Handler(Looper.getMainLooper());
    final /* synthetic */ f b;
    final /* synthetic */ Activity_ResetPasswd c;

    az(Activity_ResetPasswd activity_ResetPasswd, f fVar) {
        this.c = activity_ResetPasswd;
        this.b = fVar;
    }

    public final void a() {
        this.a.post(new ba(this));
    }

    public final void a(ar arVar) {
        if (arVar.a()) {
            try {
                JSONObject jSONObject = new JSONObject(arVar.g.d());
                this.a.post(new bc(this));
                if (jSONObject.has("error")) {
                    this.a.post(new bd(this, jSONObject.getString("error")));
                    return;
                } else if (jSONObject.has("succ")) {
                    this.a.post(new be(this, jSONObject.getString("succ")));
                    return;
                } else {
                    this.a.post(new bg(this));
                    return;
                }
            } catch (Exception e) {
                this.a.post(new bh(this));
                return;
            }
        }
        this.a.post(new bb(this));
    }
}
