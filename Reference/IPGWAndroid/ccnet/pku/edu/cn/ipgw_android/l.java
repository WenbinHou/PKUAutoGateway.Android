package ccnet.pku.edu.cn.ipgw_android;

final class l implements Runnable {
    final /* synthetic */ e a;

    l(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        this.a.b.b();
        this.a.d.q = fn.a(this.a.c, this.a.d.getResources().getString(R.string.error_disconnectall));
        this.a.d.q.show();
    }
}
