package ccnet.pku.edu.cn.ipgw_android;

final class av implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ar b;

    av(ar arVar, String str) {
        this.b = arVar;
        this.a = str;
    }

    public final void run() {
        this.b.c.p = fn.a(this.b.c.getWindow().getDecorView().getRootView(), this.a);
        this.b.c.p.show();
    }
}
