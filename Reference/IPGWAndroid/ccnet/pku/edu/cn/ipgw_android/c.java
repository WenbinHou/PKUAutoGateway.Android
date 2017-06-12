package ccnet.pku.edu.cn.ipgw_android;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import b.af;
import b.ag;
import b.ao;
import b.ap;
import com.kaopiz.kprogresshud.f;

final class c implements OnClickListener {
    final /* synthetic */ Activity_Conns a;

    c(Activity_Conns activity_Conns) {
        this.a = activity_Conns;
    }

    public final void onClick(View view) {
        f c = fn.c(this.a);
        c.a();
        ap a = ap.a(af.a("application/x-www-form-urlencoded; charset=utf-8"), "cmd=closeall&username=" + this.a.l + "&password=" + this.a.m + "&lang=" + fn.b());
        String str = "https://its.pku.edu.cn/cas/ITSClient";
        ag a2 = fn.a();
        try {
            Activity activity = this.a;
            a2.a(new ao().a(str).a("User-Agent", fn.a(activity)).a("POST", a).a()).a(new e(activity, c, this.a.getWindow().getDecorView().getRootView()));
        } catch (Exception e) {
        }
    }
}
