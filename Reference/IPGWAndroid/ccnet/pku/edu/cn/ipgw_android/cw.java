package ccnet.pku.edu.cn.ipgw_android;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.n;
import android.view.View;
import b.ar;
import b.h;
import com.kaopiz.kprogresshud.f;
import org.json.JSONObject;

final class cw implements h {
    Handler a = new Handler(Looper.getMainLooper());
    final /* synthetic */ f b;
    final /* synthetic */ View c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ bz f;

    cw(bz bzVar, f fVar, View view, String str, String str2) {
        this.f = bzVar;
        this.b = fVar;
        this.c = view;
        this.d = str;
        this.e = str2;
    }

    public final void a() {
        this.a.post(new cx(this));
    }

    public final void a(ar arVar) {
        if (arVar.a()) {
            try {
                JSONObject jSONObject = new JSONObject(arVar.g.d());
                this.a.post(new cz(this));
                if (jSONObject.has("succ")) {
                    String[] a = bz.a(jSONObject.getString("succ"));
                    if (a == null) {
                        this.a.post(new da(this));
                        return;
                    }
                    if (fm.c(this.c.getContext()).equals("Y")) {
                        fm.b(this.c.getContext(), this.d);
                        if (fm.d(this.c.getContext()).equals("Y")) {
                            fm.a(this.e);
                        }
                    }
                    Intent intent = new Intent(this.f.b(), Activity_Conns.class);
                    intent.putExtra("ConnectoinStringInfo", a);
                    intent.putExtra("UserNameStringInfo", this.d);
                    intent.putExtra("PasswdStringInfo", this.e);
                    n nVar = this.f;
                    if (nVar.t == null) {
                        throw new IllegalStateException("Fragment " + nVar + " not attached to Activity");
                    }
                    nVar.t.a(nVar, intent, 1000);
                    return;
                } else if (jSONObject.has("error")) {
                    this.a.post(new db(this, jSONObject.getString("error")));
                    return;
                } else {
                    this.a.post(new dc(this));
                    return;
                }
            } catch (Exception e) {
                this.a.post(new dd(this));
                return;
            }
        }
        this.a.post(new cy(this));
    }
}
