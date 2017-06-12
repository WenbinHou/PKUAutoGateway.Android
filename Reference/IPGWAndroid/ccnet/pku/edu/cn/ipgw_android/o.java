package ccnet.pku.edu.cn.ipgw_android;

import android.os.Handler;
import android.os.Looper;
import b.ar;
import b.h;
import java.io.IOException;

final class o implements h {
    Handler a = new Handler(Looper.getMainLooper());
    final /* synthetic */ n b;

    o(n nVar) {
        this.b = nVar;
    }

    public final void a() {
        this.a.post(new p(this));
    }

    public final void a(ar arVar) {
        if (arVar.a()) {
            String d;
            try {
                d = arVar.g.d();
            } catch (IOException e) {
                d = "";
            }
            this.a.post(new r(this, d));
            return;
        }
        this.a.post(new q(this));
    }
}
