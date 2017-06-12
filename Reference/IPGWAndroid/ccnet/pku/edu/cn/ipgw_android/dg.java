package ccnet.pku.edu.cn.ipgw_android;

import android.view.View;
import android.view.View.OnFocusChangeListener;

final class dg implements OnFocusChangeListener {
    final /* synthetic */ bz a;

    dg(bz bzVar) {
        this.a = bzVar;
    }

    public final void onFocusChange(View view, boolean z) {
        if (!z) {
            fn.b(this.a.b());
        }
    }
}
