package ccnet.pku.edu.cn.ipgw_android;

final class bl implements Runnable {
    final /* synthetic */ bj a;

    bl(bj bjVar) {
        this.a = bjVar;
    }

    public final void run() {
        this.a.b.b();
        this.a.f.i = fn.a(this.a.c, this.a.f.e.getResources().getString(R.string.error_response_getmsg));
        this.a.f.i.show();
    }
}
