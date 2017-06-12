package ccnet.pku.edu.cn.ipgw_android;

final class ad implements Runnable {
    final /* synthetic */ x a;

    ad(x xVar) {
        this.a = xVar;
    }

    public final void run() {
        this.a.e.l = fn.a(this.a.e.getWindow().getDecorView().getRootView(), this.a.e.getResources().getString(R.string.action_failed));
        this.a.e.l.show();
    }
}
