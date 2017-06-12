package ccnet.pku.edu.cn.ipgw_android;

import android.view.View;
import android.view.View.OnClickListener;
import b.af;
import b.ag;
import b.ao;
import b.ap;
import com.kaopiz.kprogresshud.f;

final class bu implements OnClickListener {
    final /* synthetic */ bs a;

    bu(bs bsVar) {
        this.a = bsVar;
    }

    public final void onClick(View view) {
        f c = fn.c(this.a.m.e);
        c.a();
        int d = this.a.d();
        String str = ((bw) this.a.m.c.get(d)).a;
        ap a = ap.a(af.a("application/x-www-form-urlencoded; charset=utf-8"), "cmd=disconnect&username=" + this.a.m.f + "&password=" + this.a.m.g + "&ip=" + str + "&lang=" + fn.b());
        String str2 = "https://its.pku.edu.cn/cas/ITSClient";
        ag a2 = fn.a();
        try {
            bi biVar = this.a.m;
            a2.a(new ao().a(str2).a("User-Agent", fn.a(biVar.e)).a("POST", a).a()).a(new bj(biVar, c, this.a.m.e.getWindow().getDecorView().getRootView(), str, d));
        } catch (Exception e) {
        }
    }
}
