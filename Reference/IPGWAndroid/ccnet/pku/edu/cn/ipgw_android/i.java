package ccnet.pku.edu.cn.ipgw_android;

import java.util.ArrayList;

final class i implements Runnable {
    final /* synthetic */ e a;

    i(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        this.a.d.p = true;
        this.a.d.q = fn.b(this.a.c, this.a.d.getResources().getString(R.string.all_disconnected));
        this.a.d.q.show();
        this.a.d.r.a(new ArrayList());
    }
}
