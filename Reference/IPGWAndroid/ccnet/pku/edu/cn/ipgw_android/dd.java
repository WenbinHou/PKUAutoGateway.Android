package ccnet.pku.edu.cn.ipgw_android;

final class dd implements Runnable {
    final /* synthetic */ cw a;

    dd(cw cwVar) {
        this.a = cwVar;
    }

    public final void run() {
        this.a.b.b();
        this.a.f.ag = fn.a(this.a.c, this.a.f.c().getString(R.string.action_failed));
        this.a.f.ag.show();
        this.a.f.a(this.a.c, this.a.f.c().getString(R.string.action_failed));
    }
}
