package ccnet.pku.edu.cn.ipgw_android;

final class cq implements Runnable {
    final /* synthetic */ co a;

    cq(co coVar) {
        this.a = coVar;
    }

    public final void run() {
        this.a.b.b();
        this.a.d.ag = fn.a(this.a.c, this.a.d.c().getString(R.string.error_response_getmsg));
        this.a.d.ag.show();
        this.a.d.a(this.a.c, this.a.d.c().getString(R.string.action_failed));
    }
}
