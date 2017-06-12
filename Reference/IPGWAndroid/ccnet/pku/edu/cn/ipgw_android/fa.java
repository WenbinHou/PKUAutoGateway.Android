package ccnet.pku.edu.cn.ipgw_android;

import android.os.Handler;
import android.os.Looper;
import b.ar;
import b.h;
import org.json.JSONObject;

final class fa implements h {
    final /* synthetic */ MainActivity a;

    fa(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public final void a() {
    }

    public final void a(ar arVar) {
        if (arVar.a()) {
            try {
                JSONObject jSONObject = new JSONObject(arVar.g.d());
                if (jSONObject.has("ver") && jSONObject.has("url")) {
                    String string = jSONObject.getString("ver");
                    String string2 = jSONObject.getString("url");
                    if (string != null && string2 != null) {
                        String trim = string.trim();
                        string = string2.trim();
                        if (!trim.equals("") && !string.equals("")) {
                            if (string.startsWith("/")) {
                                string = string.substring(1);
                            }
                            string2 = fn.d(this.a);
                            if (string2 != null && !trim.equals(string2) && fn.a(string2, trim) < 0) {
                                new Handler(Looper.getMainLooper()).post(new fb(this, string));
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
