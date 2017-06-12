package ccnet.pku.edu.cn.ipgw_android;

final class en implements Runnable {
    final /* synthetic */ em a;

    en(em emVar) {
        this.a = emVar;
    }

    public final void run() {
        IPGWWidgetProvider.a(this.a.b, this.a.b.getResources().getString(R.string.kCFURLErrorOthers));
    }
}
