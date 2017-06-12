package ccnet.pku.edu.cn.ipgw_android;

final class p implements Runnable {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    public final void run() {
        this.a.b.a.l.setRefreshing(false);
        this.a.b.a.n = fn.a(this.a.b.a.getWindow().getDecorView().getRootView(), this.a.b.a.getResources().getString(R.string.kCFURLErrorOthers));
        this.a.b.a.n.show();
    }
}
