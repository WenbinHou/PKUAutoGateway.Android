package ccnet.pku.edu.cn.ipgw_android;

import android.os.Handler;
import android.os.Looper;
import b.ao;

final class n implements Runnable {
    final /* synthetic */ Activity_MsgContent a;

    n(Activity_MsgContent activity_MsgContent) {
        this.a = activity_MsgContent;
    }

    public final void run() {
        Handler handler = new Handler(Looper.getMainLooper());
        try {
            fn.a().a(new ao().a(this.a.m).a("User-Agent", fn.a(this.a)).a()).a(new o(this));
        } catch (Exception e) {
            handler.post(new s(this));
        }
    }
}
