package ccnet.pku.edu.cn.ipgw_android;

final class eg implements Runnable {
    final /* synthetic */ ef a;

    eg(ef efVar) {
        this.a = efVar;
    }

    public final void run() {
        IPGWWidgetProvider.a(this.a.b, this.a.b.getResources().getString(R.string.kCFURLErrorOthers));
    }
}
