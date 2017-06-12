package ccnet.pku.edu.cn.ipgw_android;

final class g implements Runnable {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        this.a.b.b();
        this.a.d.q = fn.a(this.a.c, this.a.d.getResources().getString(R.string.error_response_getmsg));
        this.a.d.q.show();
    }
}
