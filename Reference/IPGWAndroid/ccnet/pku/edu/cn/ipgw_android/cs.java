package ccnet.pku.edu.cn.ipgw_android;

final class cs implements Runnable {
    final /* synthetic */ co a;

    cs(co coVar) {
        this.a = coVar;
    }

    public final void run() {
        this.a.d.a(this.a.c, this.a.d.c().getString(R.string.disconnected));
    }
}
