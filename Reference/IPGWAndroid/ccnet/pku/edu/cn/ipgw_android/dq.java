package ccnet.pku.edu.cn.ipgw_android;

final class dq implements Runnable {
    final /* synthetic */ dn a;

    dq(dn dnVar) {
        this.a = dnVar;
    }

    public final void run() {
        this.a.c.ak.setRefreshing(false);
    }
}
