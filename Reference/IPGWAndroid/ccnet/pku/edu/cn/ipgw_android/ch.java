package ccnet.pku.edu.cn.ipgw_android;

final class ch implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ca b;

    ch(ca caVar, String str) {
        this.b = caVar;
        this.a = str;
    }

    public final void run() {
        this.b.f.ag = fn.b(this.b.c, this.a);
        this.b.f.ag.show();
    }
}
