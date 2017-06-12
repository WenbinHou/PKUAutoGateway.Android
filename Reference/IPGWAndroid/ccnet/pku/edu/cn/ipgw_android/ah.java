package ccnet.pku.edu.cn.ipgw_android;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.alipay.sdk.g.a.b;

final class ah extends Handler {
    final /* synthetic */ Activity_Payment a;

    ah(Activity_Payment activity_Payment) {
        this.a = activity_Payment;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                CharSequence charSequence = new b((String) message.obj).a;
                if (TextUtils.equals(charSequence, "9000")) {
                    this.a.l = fn.a(this.a.getWindow().getDecorView().getRootView(), this.a.getResources().getString(R.string.pay_success), new ai(this));
                    this.a.l.show();
                    return;
                } else if (TextUtils.equals(charSequence, "8000")) {
                    this.a.l = fn.a(this.a.getWindow().getDecorView().getRootView(), this.a.getResources().getString(R.string.pay_processing));
                    this.a.l.show();
                    return;
                } else {
                    TextUtils.equals(charSequence, "6001");
                    this.a.l = fn.a(this.a.getWindow().getDecorView().getRootView(), this.a.getResources().getString(R.string.pay_canceled));
                    this.a.l.show();
                    return;
                }
            default:
                return;
        }
    }
}
