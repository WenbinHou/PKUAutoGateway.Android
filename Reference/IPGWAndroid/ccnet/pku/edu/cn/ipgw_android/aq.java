package ccnet.pku.edu.cn.ipgw_android;

import android.widget.TextView;

final class aq implements Runnable {
    final /* synthetic */ TextView a;
    final /* synthetic */ Activity_ResetPasswd b;

    aq(Activity_ResetPasswd activity_ResetPasswd, TextView textView) {
        this.b = activity_ResetPasswd;
        this.a = textView;
    }

    public final void run() {
        if (Activity_ResetPasswd.m <= 0) {
            this.a.setText(this.b.getResources().getString(R.string.send_authencodes));
            this.a.setTextColor(this.b.getResources().getColor(R.color.black1));
            this.a.setEnabled(true);
            Activity_ResetPasswd.o.cancel();
            Activity_ResetPasswd.o = null;
            Activity_ResetPasswd.l = false;
            return;
        }
        Activity_ResetPasswd.m -= 2;
        this.a.setText(this.b.getResources().getString(R.string.send_authencodes_wait) + Activity_ResetPasswd.m);
    }
}
