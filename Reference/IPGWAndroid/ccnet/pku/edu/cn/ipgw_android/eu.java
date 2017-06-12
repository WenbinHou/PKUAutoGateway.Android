package ccnet.pku.edu.cn.ipgw_android;

final class eu implements Runnable {
    final /* synthetic */ et a;

    eu(et etVar) {
        this.a = etVar;
    }

    public final void run() {
        IPGWWidgetProvider.a(this.a.b, this.a.b.getResources().getString(R.string.kCFURLErrorOthers));
    }
}
