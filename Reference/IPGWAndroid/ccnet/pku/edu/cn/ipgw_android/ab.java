package ccnet.pku.edu.cn.ipgw_android;

final class ab implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ x b;

    ab(x xVar, String str) {
        this.b = xVar;
        this.a = str;
    }

    public final void run() {
        this.b.e.l = fn.a(this.b.e.getWindow().getDecorView().getRootView(), this.a);
        this.b.e.l.show();
    }
}
