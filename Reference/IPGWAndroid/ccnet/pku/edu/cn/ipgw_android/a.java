package ccnet.pku.edu.cn.ipgw_android;

import android.content.Context;

final class a extends fk {
    final /* synthetic */ Activity_AboutUs a;

    a(Activity_AboutUs activity_AboutUs, Context context) {
        this.a = activity_AboutUs;
        super(context);
    }

    public final void a() {
        this.a.finish();
        this.a.overridePendingTransition(R.animator.trans_right_in, R.animator.trans_right_out);
    }
}
