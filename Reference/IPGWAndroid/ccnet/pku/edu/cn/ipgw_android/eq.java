package ccnet.pku.edu.cn.ipgw_android;

final class eq implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ em b;

    eq(em emVar, String str) {
        this.b = emVar;
        this.a = str;
    }

    public final void run() {
        IPGWWidgetProvider.a(this.b.b, this.a);
    }
}
