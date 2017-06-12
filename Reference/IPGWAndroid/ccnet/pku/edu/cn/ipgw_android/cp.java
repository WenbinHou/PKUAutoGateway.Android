package ccnet.pku.edu.cn.ipgw_android;

final class cp implements Runnable {
    final /* synthetic */ co a;

    cp(co coVar) {
        this.a = coVar;
    }

    public final void run() {
        this.a.b.b();
        this.a.d.ag = fn.b(this.a.c, this.a.d.c().getString(R.string.error_disconnect));
        this.a.d.ag.show();
        this.a.d.a(this.a.c, this.a.d.c().getString(R.string.action_failed));
    }
}
