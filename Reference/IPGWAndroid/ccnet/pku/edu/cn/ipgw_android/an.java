package ccnet.pku.edu.cn.ipgw_android;

import android.app.Activity;
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

final class an implements OnClickListener {
    final /* synthetic */ Activity_ResetPasswd a;

    an(Activity_ResetPasswd activity_ResetPasswd) {
        this.a = activity_ResetPasswd;
    }

    public final void onClick(View view) {
        String trim = ((EditText) this.a.findViewById(R.id.userName_ResetPasswd)).getText().toString().trim();
        if (trim.length() == 0) {
            this.a.p = fn.a(this.a.getWindow().getDecorView().getRootView(), this.a.getResources().getString(R.string.error_no_username));
            this.a.p.show();
        } else if (trim.length() < 2 || trim.length() > 20) {
            this.a.p = fn.a(this.a.getWindow().getDecorView().getRootView(), this.a.getResources().getString(R.string.error_username));
            this.a.p.show();
        } else {
            String trim2 = ((EditText) this.a.findViewById(R.id.authenCode_ResetPasswd)).getText().toString().trim();
            if (trim2.length() == 0) {
                this.a.p = fn.a(this.a.getWindow().getDecorView().getRootView(), this.a.getResources().getString(R.string.error_no_verificationcodes));
                this.a.p.show();
            } else if (trim2.length() <= 2 || trim2.length() >= 10) {
                this.a.p = fn.a(this.a.getWindow().getDecorView().getRootView(), this.a.getResources().getString(R.string.error_verificationcodes));
                this.a.p.show();
            } else {
                String trim3 = ((EditText) this.a.findViewById(R.id.newPasswd_ResetPasswd)).getText().toString().trim();
                if (trim3.length() == 0) {
                    this.a.p = fn.a(this.a.getWindow().getDecorView().getRootView(), this.a.getResources().getString(R.string.error_no_newpasswd));
                    this.a.p.show();
                } else if (trim3.length() < 8 || trim3.length() > 20) {
                    this.a.p = fn.a(this.a.getWindow().getDecorView().getRootView(), this.a.getResources().getString(R.string.error_newpasswdLen));
                    this.a.p.show();
                } else {
                    String trim4 = ((EditText) this.a.findViewById(R.id.confirmPasswd_ResetPasswd)).getText().toString().trim();
                    if (trim4.length() == 0) {
                        this.a.p = fn.a(this.a.getWindow().getDecorView().getRootView(), this.a.getResources().getString(R.string.error_no_second_newpasswd));
                        this.a.p.show();
                    } else if (trim4.equals(trim3)) {
                        f c = fn.c(this.a);
                        c.a();
                        ap a = ap.a(af.a("application/x-www-form-urlencoded; charset=utf-8"), "cmd=resetpasswd&username=" + trim + "&codes=" + trim2 + "&passwd=" + trim3 + "&lang=" + fn.b());
                        trim2 = "https://its.pku.edu.cn/cas/ITSClient";
                        ag a2 = fn.a();
                        try {
                            Activity activity = this.a;
                            a2.a(new ao().a(trim2).a("User-Agent", fn.a(activity)).a("POST", a).a()).a(new az(activity, c));
                        } catch (Exception e) {
                            new Handler(Looper.getMainLooper()).post(new ao(this));
                        }
                    } else {
                        this.a.p = fn.a(this.a.getWindow().getDecorView().getRootView(), this.a.getResources().getString(R.string.error_passwds_notmatch));
                        this.a.p.show();
                    }
                }
            }
        }
    }
}
