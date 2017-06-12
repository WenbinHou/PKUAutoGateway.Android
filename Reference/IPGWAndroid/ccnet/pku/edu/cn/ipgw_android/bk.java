package ccnet.pku.edu.cn.ipgw_android;

final class bk implements Runnable {
    final /* synthetic */ bj a;

    bk(bj bjVar) {
        this.a = bjVar;
    }

    public final void run() {
        this.a.b.b();
        this.a.f.i = fn.a(this.a.c, this.a.f.e.getResources().getString(R.string.kCFURLErrorOthers));
        this.a.f.i.show();
    }
}
