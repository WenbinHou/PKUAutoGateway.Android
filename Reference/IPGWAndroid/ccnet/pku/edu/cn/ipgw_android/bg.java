package ccnet.pku.edu.cn.ipgw_android;

final class bg implements Runnable {
    final /* synthetic */ az a;

    bg(az azVar) {
        this.a = azVar;
    }

    public final void run() {
        this.a.c.p = fn.a(this.a.c.getWindow().getDecorView().getRootView(), this.a.c.getResources().getString(R.string.action_failed));
        this.a.c.p.show();
    }
}
