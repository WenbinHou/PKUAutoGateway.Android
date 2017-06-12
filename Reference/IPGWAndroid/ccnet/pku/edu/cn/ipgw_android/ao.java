package ccnet.pku.edu.cn.ipgw_android;

final class ao implements Runnable {
    final /* synthetic */ an a;

    ao(an anVar) {
        this.a = anVar;
    }

    public final void run() {
        this.a.a.p = fn.a(this.a.a.getWindow().getDecorView().getRootView(), this.a.a.getResources().getString(R.string.action_failed));
        this.a.a.p.show();
    }
}
