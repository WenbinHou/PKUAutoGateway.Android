package ccnet.pku.edu.cn.ipgw_android;

import android.view.View;
import android.view.View.OnLongClickListener;

final class bt implements OnLongClickListener {
    final /* synthetic */ bs a;

    bt(bs bsVar) {
        this.a = bsVar;
    }

    public final boolean onLongClick(View view) {
        this.a.n.a(true);
        return true;
    }
}
