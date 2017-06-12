package ccnet.pku.edu.cn.ipgw_android;

final class cf implements Runnable {
    final /* synthetic */ ca a;

    cf(ca caVar) {
        this.a = caVar;
    }

    public final void run() {
        this.a.f.ag = fn.a(this.a.c, this.a.f.c().getString(R.string.error_serverresponse));
        this.a.f.ag.show();
        this.a.f.a(this.a.c, this.a.f.c().getString(R.string.action_failed));
    }
}
