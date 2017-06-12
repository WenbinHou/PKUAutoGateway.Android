package ccnet.pku.edu.cn.ipgw_android;

final class cb implements Runnable {
    final /* synthetic */ ca a;

    cb(ca caVar) {
        this.a = caVar;
    }

    public final void run() {
        this.a.b.b();
        this.a.f.ag = fn.a(this.a.c, this.a.f.c().getString(R.string.kCFURLErrorOthers));
        this.a.f.ag.show();
        this.a.f.a(this.a.c, this.a.f.c().getString(R.string.action_failed));
    }
}
