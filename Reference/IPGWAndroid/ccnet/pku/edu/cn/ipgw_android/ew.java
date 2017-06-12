package ccnet.pku.edu.cn.ipgw_android;

final class ew implements Runnable {
    final /* synthetic */ et a;

    ew(et etVar) {
        this.a = etVar;
    }

    public final void run() {
        IPGWWidgetProvider.a(this.a.b, this.a.b.getResources().getString(R.string.error));
    }
}
