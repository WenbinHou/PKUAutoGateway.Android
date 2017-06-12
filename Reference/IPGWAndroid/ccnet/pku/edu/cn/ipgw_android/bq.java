package ccnet.pku.edu.cn.ipgw_android;

final class bq implements Runnable {
    final /* synthetic */ bj a;

    bq(bj bjVar) {
        this.a = bjVar;
    }

    public final void run() {
        this.a.b.b();
        this.a.f.i = fn.a(this.a.c, this.a.f.e.getResources().getString(R.string.error_disconnect));
        this.a.f.i.show();
    }
}
