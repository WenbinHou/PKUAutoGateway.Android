package ccnet.pku.edu.cn.ipgw_android;

final class cu implements Runnable {
    final /* synthetic */ co a;

    cu(co coVar) {
        this.a = coVar;
    }

    public final void run() {
        this.a.d.ag = fn.a(this.a.c, this.a.d.c().getString(R.string.error_disconnect));
        this.a.d.ag.show();
        this.a.d.a(this.a.c, this.a.d.c().getString(R.string.action_failed));
    }
}
