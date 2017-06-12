package android.support.v4.app;

import android.os.Handler;
import android.os.Message;

final class r extends Handler {
    final /* synthetic */ q a;

    r(q qVar) {
        this.a = qVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.a.e) {
                    this.a.a(false);
                    return;
                }
                return;
            case 2:
                this.a.a_();
                this.a.b.b();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
