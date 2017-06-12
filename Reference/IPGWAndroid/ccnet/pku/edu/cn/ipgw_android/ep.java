package ccnet.pku.edu.cn.ipgw_android;

final class ep implements Runnable {
    final /* synthetic */ em a;

    ep(em emVar) {
        this.a = emVar;
    }

    public final void run() {
        IPGWWidgetProvider.a(this.a.b, this.a.c + " " + this.a.b.getResources().getString(R.string.all_disconnected));
    }
}
