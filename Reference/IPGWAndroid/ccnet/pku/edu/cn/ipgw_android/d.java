package ccnet.pku.edu.cn.ipgw_android;

import android.content.Context;

final class d extends fk {
    final /* synthetic */ Activity_Conns a;

    d(Activity_Conns activity_Conns, Context context) {
        this.a = activity_Conns;
        super(context);
    }

    public final void a() {
        this.a.finish();
        this.a.overridePendingTransition(R.animator.trans_right_in, R.animator.trans_right_out);
    }
}
