package ccnet.pku.edu.cn.ipgw_android;

final class ej implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ef b;

    ej(ef efVar, String str) {
        this.b = efVar;
        this.a = str;
    }

    public final void run() {
        IPGWWidgetProvider.a(this.b.b, this.a);
    }
}
