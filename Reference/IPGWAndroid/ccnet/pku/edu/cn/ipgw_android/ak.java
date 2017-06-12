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
import java.util.Timer;

final class ak implements OnClickListener {
    final /* synthetic */ Activity_ResetPasswd a;

    ak(Activity_ResetPasswd activity_ResetPasswd) {
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
            Activity_ResetPasswd.l = true;
            this.a.q.setEnabled(false);
            this.a.q.setTextColor(this.a.getResources().getColor(R.color.black2));
            Activity_ResetPasswd.m = 60;
            if (Activity_ResetPasswd.o == null) {
                Activity_ResetPasswd.o = new Timer();
            }
            Activity_ResetPasswd.o.schedule(new al(this), 0, 2000);
            f c = fn.c(this.a);
            c.a();
            ap a = ap.a(af.a("application/x-www-form-urlencoded; charset=utf-8"), "cmd=sendmsg&username=" + trim + "&lang=" + fn.b());
            String str = "https://its.pku.edu.cn/cas/ITSClient";
            ag a2 = fn.a();
            try {
                Activity activity = this.a;
                a2.a(new ao().a(str).a("User-Agent", fn.a(activity)).a("POST", a).a()).a(new ar(activity, c));
            } catch (Exception e) {
                new Handler(Looper.getMainLooper()).post(new am(this));
            }
        }
    }
}
