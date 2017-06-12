package ccnet.pku.edu.cn.ipgw_android;

final class eo implements Runnable {
    final /* synthetic */ em a;

    eo(em emVar) {
        this.a = emVar;
    }

    public final void run() {
        IPGWWidgetProvider.a(this.a.b, this.a.b.getResources().getString(R.string.error_response_getmsg));
    }
}
