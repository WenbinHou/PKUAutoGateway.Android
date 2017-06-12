package ccnet.pku.edu.cn.ipgw_android;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import b.ar;
import b.h;
import com.kaopiz.kprogresshud.f;
import org.json.JSONObject;

final class bj implements h {
    Handler a = new Handler(Looper.getMainLooper());
    final /* synthetic */ f b;
    final /* synthetic */ View c;
    final /* synthetic */ String d;
    final /* synthetic */ int e;
    final /* synthetic */ bi f;

    bj(bi biVar, f fVar, View view, String str, int i) {
        this.f = biVar;
        this.b = fVar;
        this.c = view;
        this.d = str;
        this.e = i;
    }

    public final void a() {
        this.a.post(new bk(this));
    }

    public final void a(ar arVar) {
        if (arVar.a()) {
            try {
                JSONObject jSONObject = new JSONObject(arVar.g.d());
                this.a.post(new bm(this));
                if (jSONObject.has("succ")) {
                    if (!this.f.h.equals("") && this.f.h.equals(this.d)) {
                        ((Activity_Conns) this.f.e).o = true;
                    }
                    Activity_Conns activity_Conns = (Activity_Conns) this.f.e;
                    activity_Conns.n++;
                    this.a.post(new bn(this));
                    return;
                } else if (jSONObject.has("error")) {
                    this.a.post(new bo(this, jSONObject.getString("error")));
                    return;
                } else {
                    this.a.post(new bp(this));
                    return;
                }
            } catch (Exception e) {
                this.a.post(new bq(this));
                return;
            }
        }
        this.a.post(new bl(this));
    }
}
