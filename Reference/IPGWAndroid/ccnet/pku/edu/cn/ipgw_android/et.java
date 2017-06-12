package ccnet.pku.edu.cn.ipgw_android;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import b.ar;
import b.h;
import org.json.JSONObject;

final class et implements h {
    Handler a = new Handler(Looper.getMainLooper());
    final /* synthetic */ Context b;
    final /* synthetic */ String c;
    final /* synthetic */ IPGWWidgetProvider d;

    et(IPGWWidgetProvider iPGWWidgetProvider, Context context, String str) {
        this.d = iPGWWidgetProvider;
        this.b = context;
        this.c = str;
    }

    public final void a() {
        this.a.post(new eu(this));
    }

    public final void a(ar arVar) {
        if (arVar.a()) {
            try {
                JSONObject jSONObject = new JSONObject(arVar.g.d());
                if (jSONObject.has("error")) {
                    jSONObject.getString("error");
                    this.a.post(new ew(this));
                    return;
                } else if (jSONObject.has("succ")) {
                    jSONObject.getString("succ");
                    if (jSONObject.has("SCOPE") && jSONObject.has("IP") && jSONObject.has("CONNECTIONS")) {
                        String string = jSONObject.getString("SCOPE");
                        String string2 = jSONObject.getString("IP");
                        string = string.equals("international") ? this.b.getResources().getString(R.string.notfree) : this.b.getResources().getString(R.string.free);
                        fm.e(this.b);
                        this.a.post(new ex(this, string));
                        fm.a(this.b, string2);
                        return;
                    }
                    IPGWWidgetProvider.a(this.b, this.b.getResources().getString(R.string.error_serverresponse));
                    return;
                } else {
                    this.a.post(new ey(this));
                    return;
                }
            } catch (Exception e) {
                this.a.post(new ez(this));
                return;
            }
        }
        this.a.post(new ev(this));
    }
}
