package ccnet.pku.edu.cn.ipgw_android;

final class ey implements Runnable {
    final /* synthetic */ et a;

    ey(et etVar) {
        this.a = etVar;
    }

    public final void run() {
        IPGWWidgetProvider.a(this.a.b, this.a.b.getResources().getString(R.string.error_serverresponse));
    }
}
