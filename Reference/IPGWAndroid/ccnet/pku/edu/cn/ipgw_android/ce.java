package ccnet.pku.edu.cn.ipgw_android;

final class ce implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ca b;

    ce(ca caVar, String str) {
        this.b = caVar;
        this.a = str;
    }

    public final void run() {
        this.b.f.ag = fn.a(this.b.c, this.a);
        this.b.f.ag.show();
        this.b.f.a(this.b.c, this.b.f.c().getString(R.string.action_failed));
    }
}
