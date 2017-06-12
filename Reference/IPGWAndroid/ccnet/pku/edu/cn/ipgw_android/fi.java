package ccnet.pku.edu.cn.ipgw_android;

import android.support.v4.app.ag;
import android.support.v4.app.n;
import android.support.v4.app.x;
import android.view.ViewGroup;

final class fi extends ag {
    final /* synthetic */ MainActivity b;

    public fi(MainActivity mainActivity, x xVar) {
        this.b = mainActivity;
        super(xVar);
    }

    public final n a(int i) {
        return i == 0 ? new bz() : i == 1 ? new dj() : i == 2 ? new dw() : null;
    }

    public final Object a(ViewGroup viewGroup, int i) {
        return (n) super.a(viewGroup, i);
    }
}
