package ccnet.pku.edu.cn.ipgw_android;

final class ax implements Runnable {
    final /* synthetic */ ar a;

    ax(ar arVar) {
        this.a = arVar;
    }

    public final void run() {
        this.a.c.p = fn.a(this.a.c.getWindow().getDecorView().getRootView(), this.a.c.getResources().getString(R.string.action_failed));
        this.a.c.p.show();
    }
}
