package ccnet.pku.edu.cn.ipgw_android;

final class cn implements Runnable {
    final /* synthetic */ bz a;

    cn(bz bzVar) {
        this.a = bzVar;
    }

    public final void run() {
        this.a.ag = fn.a(this.a.b().getWindow().getDecorView().getRootView(), this.a.c().getString(R.string.error_response_getmsg));
        this.a.ag.show();
        this.a.a(this.a.b().getWindow().getDecorView().getRootView(), this.a.c().getString(R.string.action_failed));
    }
}
