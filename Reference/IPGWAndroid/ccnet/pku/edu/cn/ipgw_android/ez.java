package ccnet.pku.edu.cn.ipgw_android;

final class ez implements Runnable {
    final /* synthetic */ et a;

    ez(et etVar) {
        this.a = etVar;
    }

    public final void run() {
        IPGWWidgetProvider.a(this.a.b, this.a.b.getResources().getString(R.string.action_failed));
    }
}
