package ccnet.pku.edu.cn.ipgw_android;

final class dv implements Runnable {
    final /* synthetic */ dn a;

    dv(dn dnVar) {
        this.a = dnVar;
    }

    public final void run() {
        this.a.c.ak.setRefreshing(false);
        this.a.c.al = fn.a(this.a.b, this.a.c.c().getString(R.string.error_serverresponse));
        this.a.c.al.show();
    }
}
