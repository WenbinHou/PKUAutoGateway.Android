package ccnet.pku.edu.cn.ipgw_android;

import android.content.Context;

final class b extends fk {
    final /* synthetic */ Activity_AboutUs a;

    b(Activity_AboutUs activity_AboutUs, Context context) {
        this.a = activity_AboutUs;
        super(context);
    }

    public final void a() {
        this.a.finish();
        this.a.overridePendingTransition(R.animator.trans_right_in, R.animator.trans_right_out);
    }
}
