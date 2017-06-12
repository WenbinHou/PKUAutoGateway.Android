package ccnet.pku.edu.cn.ipgw_android;

import android.support.v7.widget.dt;

final class bn implements Runnable {
    final /* synthetic */ bj a;

    bn(bj bjVar) {
        this.a = bjVar;
    }

    public final void run() {
        this.a.f.i = fn.b(this.a.c, this.a.f.e.getResources().getString(R.string.disconnected));
        this.a.f.i.show();
        Activity_Conns activity_Conns = (Activity_Conns) this.a.f.e;
        activity_Conns.n++;
        this.a.f.c.remove(this.a.e);
        dt dtVar = this.a.f;
        dtVar.a.a(this.a.e);
    }
}
