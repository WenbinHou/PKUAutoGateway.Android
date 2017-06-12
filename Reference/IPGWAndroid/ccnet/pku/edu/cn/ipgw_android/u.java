package ccnet.pku.edu.cn.ipgw_android;

import android.content.Context;

final class u extends fk {
    final /* synthetic */ Activity_MsgContent a;

    u(Activity_MsgContent activity_MsgContent, Context context) {
        this.a = activity_MsgContent;
        super(context);
    }

    public final void a() {
        if (this.a.n != null && this.a.n.isShowing()) {
            this.a.n.dismiss();
            this.a.n = null;
        }
        this.a.finish();
        this.a.overridePendingTransition(R.animator.trans_right_in, R.animator.trans_right_out);
    }
}
