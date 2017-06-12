package ccnet.pku.edu.cn.ipgw_android;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import b.af;
import b.ag;
import b.ao;
import b.ap;
import com.kaopiz.kprogresshud.f;
import java.text.DecimalFormat;

final class v implements OnClickListener {
    final /* synthetic */ Activity_Payment a;

    v(Activity_Payment activity_Payment) {
        this.a = activity_Payment;
    }

    public final void onClick(View view) {
        EditText editText = (EditText) this.a.findViewById(R.id.passwd_Pay);
        String trim = ((EditText) this.a.findViewById(R.id.userName_Pay)).getText().toString().trim();
        String trim2 = editText.getText().toString().trim();
        if (trim.length() == 0 || trim2.length() == 0) {
            this.a.l = fn.a(this.a.getWindow().getDecorView().getRootView(), this.a.getResources().getString(R.string.no_username_passwd));
            this.a.l.show();
        } else if (trim.length() < 2 || trim.length() > 20 || trim2.length() < 8 || trim2.length() > 20) {
            this.a.l = fn.a(this.a.getWindow().getDecorView().getRootView(), this.a.getResources().getString(R.string.error_username_passwd));
            this.a.l.show();
        } else {
            String trim3 = ((EditText) this.a.findViewById(R.id.fee)).getText().toString().trim();
            if (trim3.length() == 0) {
                this.a.l = fn.a(this.a.getWindow().getDecorView().getRootView(), this.a.getResources().getString(R.string.amount_error));
                this.a.l.show();
                return;
            }
            Double valueOf = Double.valueOf(Double.parseDouble(trim3));
            if (valueOf.doubleValue() < 0.01d) {
                this.a.l = fn.a(this.a.getWindow().getDecorView().getRootView(), this.a.getResources().getString(R.string.amount_error));
                this.a.l.show();
                return;
            }
            f c = fn.c(this.a);
            c.a();
            trim3 = new DecimalFormat("#.##").format(valueOf);
            ap a = ap.a(af.a("application/json; charset=utf-8"), "{\"username\":\"" + trim + "\",\"passwd\":\"" + trim2 + "\",\"amount\":\"" + trim3 + "\", \"lang\":\"" + fn.b() + "\"}");
            String str = "https://its.pku.edu.cn/paybank/user.PayBankOrder?operation=Confirm&paytype=app";
            ag a2 = fn.a();
            try {
                Activity activity = this.a;
                a2.a(new ao().a(str).a("User-Agent", fn.a(activity)).a("POST", a).a()).a(new x(activity, c, trim, trim3));
            } catch (Exception e) {
            }
        }
    }
}
