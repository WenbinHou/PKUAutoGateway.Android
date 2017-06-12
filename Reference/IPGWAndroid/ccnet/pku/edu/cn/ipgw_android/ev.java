package ccnet.pku.edu.cn.ipgw_android;

final class ev implements Runnable {
    final /* synthetic */ et a;

    ev(et etVar) {
        this.a = etVar;
    }

    public final void run() {
        IPGWWidgetProvider.a(this.a.b, this.a.b.getResources().getString(R.string.error_response_getmsg));
    }
}
