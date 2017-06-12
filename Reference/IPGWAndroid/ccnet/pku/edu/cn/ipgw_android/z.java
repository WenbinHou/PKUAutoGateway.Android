package ccnet.pku.edu.cn.ipgw_android;

final class z implements Runnable {
    final /* synthetic */ x a;

    z(x xVar) {
        this.a = xVar;
    }

    public final void run() {
        this.a.b.b();
        this.a.e.l = fn.a(this.a.e.getWindow().getDecorView().getRootView(), this.a.e.getResources().getString(R.string.error_response_getmsg));
        this.a.e.l.show();
    }
}
