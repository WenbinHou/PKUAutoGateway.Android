package ccnet.pku.edu.cn.ipgw_android;

final class bo implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ bj b;

    bo(bj bjVar, String str) {
        this.b = bjVar;
        this.a = str;
    }

    public final void run() {
        this.b.f.i = fn.a(this.b.c, this.a);
        this.b.f.i.show();
    }
}
