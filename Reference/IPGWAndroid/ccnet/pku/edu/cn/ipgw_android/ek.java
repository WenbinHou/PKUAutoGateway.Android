package ccnet.pku.edu.cn.ipgw_android;

final class ek implements Runnable {
    final /* synthetic */ ef a;

    ek(ef efVar) {
        this.a = efVar;
    }

    public final void run() {
        IPGWWidgetProvider.a(this.a.b, this.a.b.getResources().getString(R.string.error_disconnect));
    }
}
