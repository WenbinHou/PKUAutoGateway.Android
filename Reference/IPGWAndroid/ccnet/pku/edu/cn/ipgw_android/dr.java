package ccnet.pku.edu.cn.ipgw_android;

final class dr implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ dn b;

    dr(dn dnVar, String str) {
        this.b = dnVar;
        this.a = str;
    }

    public final void run() {
        this.b.c.al = fn.a(this.b.b, this.a);
        this.b.c.al.show();
    }
}
