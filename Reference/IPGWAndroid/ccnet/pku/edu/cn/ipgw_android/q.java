package ccnet.pku.edu.cn.ipgw_android;

final class q implements Runnable {
    final /* synthetic */ o a;

    q(o oVar) {
        this.a = oVar;
    }

    public final void run() {
        this.a.b.a.l.setRefreshing(false);
        this.a.b.a.n = fn.a(this.a.b.a.getWindow().getDecorView().getRootView(), this.a.b.a.getResources().getString(R.string.error_serverresponse));
        this.a.b.a.n.show();
    }
}
