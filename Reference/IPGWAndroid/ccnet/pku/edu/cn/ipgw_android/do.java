package ccnet.pku.edu.cn.ipgw_android;

final class do implements Runnable {
    final /* synthetic */ dn a;

    do(dn dnVar) {
        this.a = dnVar;
    }

    public final void run() {
        this.a.c.al = fn.a(this.a.c.I, this.a.c.c().getString(R.string.kCFURLErrorOthers));
        this.a.c.al.show();
        this.a.c.ak.setRefreshing(false);
    }
}
