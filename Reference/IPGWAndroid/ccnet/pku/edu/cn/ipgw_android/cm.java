package ccnet.pku.edu.cn.ipgw_android;

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import b.af;
import b.ag;
import b.ao;
import b.ap;
import com.kaopiz.kprogresshud.f;

final class cm implements OnClickListener {
    final /* synthetic */ SwitchCompat a;
    final /* synthetic */ bz b;

    cm(bz bzVar, SwitchCompat switchCompat) {
        this.b = bzVar;
        this.a = switchCompat;
    }

    public final void onClick(View view) {
        fn.b(this.b.b());
        EditText editText = (EditText) this.b.b().findViewById(R.id.passwd);
        String trim = ((EditText) this.b.b().findViewById(R.id.userName)).getText().toString().trim();
        String trim2 = editText.getText().toString().trim();
        if (trim.length() == 0 || trim2.length() == 0) {
            this.b.ag = fn.a(this.b.b().getWindow().getDecorView().getRootView(), this.b.c().getString(R.string.no_username_passwd));
            this.b.ag.show();
            this.b.a(this.b.b().getWindow().getDecorView().getRootView(), this.b.c().getString(R.string.action_failed));
        } else if (trim.length() < 2 || trim.length() > 20 || trim2.length() < 8 || trim2.length() > 20) {
            this.b.ag = fn.a(this.b.b().getWindow().getDecorView().getRootView(), this.b.c().getString(R.string.error_username_passwd));
            this.b.ag.show();
            this.b.a(this.b.b().getWindow().getDecorView().getRootView(), this.b.c().getString(R.string.action_failed));
        } else {
            f c = fn.c(this.b.b());
            c.a();
            String str = this.a.isChecked() ? "fee" : "free";
            String a = fm.a(this.b.b().getApplicationContext());
            if (a.equals("")) {
                a = "";
            }
            ap a2 = ap.a(af.a("application/x-www-form-urlencoded; charset=utf-8"), "cmd=open&username=" + trim + "&password=" + trim2 + "&iprange=" + str + "&ip=" + a + "&lang=" + fn.b() + "&app=" + fn.a(this.b.b()));
            String str2 = "https://its.pku.edu.cn/cas/ITSClient";
            ag a3 = fn.a();
            try {
                bz bzVar = this.b;
                a3.a(new ao().a(str2).a("User-Agent", fn.a(bzVar.b())).a("POST", a2).a()).a(new ca(bzVar, c, this.b.b().getWindow().getDecorView().getRootView(), trim, trim2));
            } catch (Exception e) {
            }
        }
    }
}
