package ccnet.pku.edu.cn.ipgw_android;

final class j implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ e b;

    j(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    public final void run() {
        this.b.d.q = fn.a(this.b.c, this.a);
        this.b.d.q.show();
    }
}
