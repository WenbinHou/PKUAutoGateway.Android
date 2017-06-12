package ccnet.pku.edu.cn.ipgw_android;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import b.af;
import b.ag;
import b.ao;
import b.ap;
import com.kaopiz.kprogresshud.f;

final class ck implements OnClickListener {
    final /* synthetic */ bz a;

    ck(bz bzVar) {
        this.a = bzVar;
    }

    public final void onClick(View view) {
        EditText editText = (EditText) this.a.b().findViewById(R.id.passwd);
        String trim = ((EditText) this.a.b().findViewById(R.id.userName)).getText().toString().trim();
        String trim2 = editText.getText().toString().trim();
        if (trim.length() == 0 || trim2.length() == 0) {
            this.a.ag = fn.a(this.a.b().getWindow().getDecorView().getRootView(), this.a.c().getString(R.string.no_username_passwd));
            this.a.ag.show();
            this.a.a(this.a.b().getWindow().getDecorView().getRootView(), this.a.c().getString(R.string.action_failed));
        } else if (trim.length() < 2 || trim.length() > 20 || trim2.length() < 8 || trim2.length() > 20) {
            this.a.ag = fn.a(this.a.b().getWindow().getDecorView().getRootView(), this.a.c().getString(R.string.error_username_passwd));
            this.a.ag.show();
            this.a.a(this.a.b().getWindow().getDecorView().getRootView(), this.a.c().getString(R.string.action_failed));
        } else {
            bz bzVar = this.a;
            f c = fn.c(bzVar.b());
            c.a();
            ap a = ap.a(af.a("application/x-www-form-urlencoded; charset=utf-8"), "cmd=getconnections&username=" + trim + "&password=" + trim2 + "&lang=" + fn.b());
            String str = "https://its.pku.edu.cn/cas/ITSClient";
            ag a2 = fn.a();
            try {
                a2.a(new ao().a(str).a("User-Agent", fn.a(bzVar.b())).a("POST", a).a()).a(new cw(bzVar, c, bzVar.b().getWindow().getDecorView().getRootView(), trim, trim2));
            } catch (Exception e) {
                new Handler(Looper.getMainLooper()).post(new cn(bzVar));
            }
        }
    }
}
