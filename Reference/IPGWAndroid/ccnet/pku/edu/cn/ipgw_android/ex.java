package ccnet.pku.edu.cn.ipgw_android;

final class ex implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ et b;

    ex(et etVar, String str) {
        this.b = etVar;
        this.a = str;
    }

    public final void run() {
        IPGWWidgetProvider.a(this.b.b, this.b.c + " " + this.b.b.getResources().getString(R.string.today_connected) + " (" + this.a + ")");
    }
}
