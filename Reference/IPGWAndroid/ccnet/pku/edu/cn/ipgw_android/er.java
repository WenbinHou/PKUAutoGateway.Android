package ccnet.pku.edu.cn.ipgw_android;

final class er implements Runnable {
    final /* synthetic */ em a;

    er(em emVar) {
        this.a = emVar;
    }

    public final void run() {
        IPGWWidgetProvider.a(this.a.b, this.a.b.getResources().getString(R.string.error_disconnectall));
    }
}
