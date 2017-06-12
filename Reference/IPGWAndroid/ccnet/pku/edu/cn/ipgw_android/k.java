package ccnet.pku.edu.cn.ipgw_android;

final class k implements Runnable {
    final /* synthetic */ e a;

    k(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        this.a.d.q = fn.a(this.a.c, this.a.d.getResources().getString(R.string.error_disconnectall));
        this.a.d.q.show();
    }
}
