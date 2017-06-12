package ccnet.pku.edu.cn.ipgw_android;

final class dp implements Runnable {
    final /* synthetic */ dn a;

    dp(dn dnVar) {
        this.a = dnVar;
    }

    public final void run() {
        this.a.c.al = fn.a(this.a.b, this.a.c.c().getString(R.string.error_serverresponse));
        this.a.c.al.show();
        this.a.c.ak.setRefreshing(false);
    }
}
