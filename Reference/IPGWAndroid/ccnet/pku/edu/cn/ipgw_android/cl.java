package ccnet.pku.edu.cn.ipgw_android;

import android.view.View;
import android.view.View.OnClickListener;
import b.af;
import b.ag;
import b.ao;
import b.ap;
import com.kaopiz.kprogresshud.f;

final class cl implements OnClickListener {
    final /* synthetic */ bz a;

    cl(bz bzVar) {
        this.a = bzVar;
    }

    public final void onClick(View view) {
        fn.b(this.a.b());
        f c = fn.c(this.a.b());
        c.a();
        ap a = ap.a(af.a("application/x-www-form-urlencoded; charset=utf-8"), "cmd=close&lang=" + fn.b());
        String str = "https://its.pku.edu.cn/cas/ITSClient";
        ag a2 = fn.a();
        try {
            bz bzVar = this.a;
            a2.a(new ao().a(str).a("User-Agent", fn.a(bzVar.b())).a("POST", a).a()).a(new co(bzVar, c, this.a.b().getWindow().getDecorView().getRootView()));
        } catch (Exception e) {
        }
    }
}
