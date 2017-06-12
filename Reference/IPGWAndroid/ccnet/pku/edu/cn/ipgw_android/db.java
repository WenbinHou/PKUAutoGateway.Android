package ccnet.pku.edu.cn.ipgw_android;

final class db implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ cw b;

    db(cw cwVar, String str) {
        this.b = cwVar;
        this.a = str;
    }

    public final void run() {
        this.b.f.ag = fn.a(this.b.c, this.a);
        this.b.f.ag.show();
        this.b.f.a(this.b.c, this.b.f.c().getString(R.string.action_failed));
    }
}
