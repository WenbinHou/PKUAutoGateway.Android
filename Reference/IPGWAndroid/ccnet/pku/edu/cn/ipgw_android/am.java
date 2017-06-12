package ccnet.pku.edu.cn.ipgw_android;

final class am implements Runnable {
    final /* synthetic */ ak a;

    am(ak akVar) {
        this.a = akVar;
    }

    public final void run() {
        this.a.a.p = fn.a(this.a.a.getWindow().getDecorView().getRootView(), this.a.a.getResources().getString(R.string.action_failed));
        this.a.a.p.show();
    }
}
