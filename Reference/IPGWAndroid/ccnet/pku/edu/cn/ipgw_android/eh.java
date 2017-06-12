package ccnet.pku.edu.cn.ipgw_android;

final class eh implements Runnable {
    final /* synthetic */ ef a;

    eh(ef efVar) {
        this.a = efVar;
    }

    public final void run() {
        IPGWWidgetProvider.a(this.a.b, this.a.b.getResources().getString(R.string.error_response_getmsg));
    }
}
