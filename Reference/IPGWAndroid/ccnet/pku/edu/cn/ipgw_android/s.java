package ccnet.pku.edu.cn.ipgw_android;

final class s implements Runnable {
    final /* synthetic */ n a;

    s(n nVar) {
        this.a = nVar;
    }

    public final void run() {
        this.a.a.l.setRefreshing(false);
        this.a.a.findViewById(16908290);
        this.a.a.n = fn.a(this.a.a.getWindow().getDecorView().getRootView(), this.a.a.getResources().getString(R.string.kCFURLErrorOthers));
        this.a.a.n.show();
    }
}
