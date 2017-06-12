package ccnet.pku.edu.cn.ipgw_android;

final class f implements Runnable {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        this.a.b.b();
        this.a.d.q = fn.a(this.a.c, this.a.d.getResources().getString(R.string.kCFURLErrorOthers));
        this.a.d.q.show();
    }
}
