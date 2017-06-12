package ccnet.pku.edu.cn.ipgw_android;

import android.content.Context;

final class w extends fk {
    final /* synthetic */ Activity_Payment a;

    w(Activity_Payment activity_Payment, Context context) {
        this.a = activity_Payment;
        super(context);
    }

    public final void a() {
        if (this.a.l != null && this.a.l.isShowing()) {
            this.a.l.dismiss();
            this.a.l = null;
        }
        this.a.finish();
        this.a.overridePendingTransition(R.animator.trans_right_in, R.animator.trans_right_out);
    }
}
