package ccnet.pku.edu.cn.ipgw_android;

import android.os.Message;
import com.alipay.sdk.app.PayTask;

final class ae implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ x b;

    ae(x xVar, String str) {
        this.b = xVar;
        this.a = str;
    }

    public final void run() {
        String pay = new PayTask(this.b.e).pay(this.a, true);
        Message message = new Message();
        message.what = 1;
        message.obj = pay;
        this.b.e.m.sendMessage(message);
    }
}
