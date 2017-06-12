package ccnet.pku.edu.cn.ipgw_android;

import android.content.Context;

final class ap extends fk {
    final /* synthetic */ Activity_ResetPasswd a;

    ap(Activity_ResetPasswd activity_ResetPasswd, Context context) {
        this.a = activity_ResetPasswd;
        super(context);
    }

    public final void a() {
        if (this.a.p != null && this.a.p.isShowing()) {
            this.a.p.dismiss();
            this.a.p = null;
        }
        this.a.finish();
        this.a.overridePendingTransition(R.animator.trans_right_in, R.animator.trans_right_out);
    }
}
