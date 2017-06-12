package ccnet.pku.edu.cn.ipgw_android;

final class ct implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ co b;

    ct(co coVar, String str) {
        this.b = coVar;
        this.a = str;
    }

    public final void run() {
        this.b.d.ag = fn.a(this.b.c, this.a);
        this.b.d.ag.show();
        this.b.d.a(this.b.c, this.b.d.c().getString(R.string.disconnected));
    }
}
