package ccnet.pku.edu.cn.ipgw_android;

import android.os.Handler;
import android.os.Looper;
import b.ar;
import b.h;
import org.json.JSONObject;

final class ff implements h {
    Handler a = new Handler(Looper.getMainLooper());
    final /* synthetic */ MainActivity b;

    ff(MainActivity mainActivity) {
        this.b = mainActivity;
    }

    public final void a() {
    }

    public final void a(ar arVar) {
        if (arVar.a()) {
            try {
                JSONObject jSONObject = new JSONObject(arVar.g.d());
                if (!jSONObject.has("error") && jSONObject.has("succ")) {
                    String string = jSONObject.getString("succ");
                    if (string != null) {
                        this.a.post(new fg(this, string));
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
