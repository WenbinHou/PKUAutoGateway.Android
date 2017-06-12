package ccnet.pku.edu.cn.ipgw_android;

final class ei implements Runnable {
    final /* synthetic */ ef a;

    ei(ef efVar) {
        this.a = efVar;
    }

    public final void run() {
        IPGWWidgetProvider.a(this.a.b, this.a.b.getResources().getString(R.string.disconnected));
    }
}
