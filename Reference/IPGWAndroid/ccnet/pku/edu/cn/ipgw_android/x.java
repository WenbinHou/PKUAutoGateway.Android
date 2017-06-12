package ccnet.pku.edu.cn.ipgw_android;

import android.os.Handler;
import android.os.Looper;
import b.ar;
import b.h;
import com.alipay.sdk.g.a.c;
import com.kaopiz.kprogresshud.f;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

final class x implements h {
    Handler a = new Handler(Looper.getMainLooper());
    final /* synthetic */ f b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ Activity_Payment e;

    x(Activity_Payment activity_Payment, f fVar, String str, String str2) {
        this.e = activity_Payment;
        this.b = fVar;
        this.c = str;
        this.d = str2;
    }

    public final void a() {
        this.a.post(new y(this));
    }

    public final void a(ar arVar) {
        if (arVar.a()) {
            try {
                JSONObject jSONObject = new JSONObject(arVar.g.d());
                this.a.post(new aa(this));
                if (jSONObject.has("error")) {
                    this.a.post(new ab(this, jSONObject.getString("error")));
                    return;
                } else if (!jSONObject.has("succ")) {
                    this.a.post(new af(this));
                    return;
                } else if (jSONObject.has("tradeNo")) {
                    String string = jSONObject.getString("tradeNo");
                    if (string.equals("")) {
                        this.a.post(new ad(this));
                        return;
                    }
                    String a = ((((((((((("partner=\"2088201805289742\"" + "&seller_id=\"alipay@pku.edu.cn\"") + "&out_trade_no=\"" + string + "\"") + "&subject=\"" + ("PKUCC1" + string) + "\"") + "&body=\"" + ("app,网络信息服务费,uid=" + this.c) + "\"") + "&total_fee=\"" + this.d + "\"") + "&notify_url=\"http://tree.pku.edu.cn/user/user.PayBankAlipayBackend\"") + "&service=\"mobile.securitypay.pay\"") + "&payment_type=\"1\"") + "&_input_charset=\"utf-8\"") + "&it_b_pay=\"30m\"") + "&return_url=\"m.alipay.com\"");
                    try {
                        string = URLEncoder.encode(c.a(a, "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALfZAp03a17h8bmUs3s2A4aKOqX5OR/Ful6Ja6CidW2QbWyHTVH+C0ZkQ+lolwwdgEiuzrF/HzxX3rw16v3fCZBxG83YcG2B7/vg0Ce/+HXJ1C6HcMoc4s4WaaX7jhs/I1odqCTFC1hmAb+Z3cK0MQbG3dWPKP6GY1BzoE+OR0ihAgMBAAECgYEAkUaHXUpsquZqB9asWSFeedMC8yJT9HpfgdKfXKjjl/d3sDnebHsN18rlKyy9pxIsy8JujC3CtgFNfXYxwfib6dIO73yiJhOzvGiQ/uDkUKBHDkQ0XgcL8wl1PGkuHKEPYqtjz8DhXT9LPa/L81/CNWUQx79k3ve2qzgZWqLB6hECQQDv4NRuehLKkYWr1HhnXtf6M6++SX5RLpjbhyKjg4jLx1uSetaab02AgoETSZxe/ta8Q+EuGnFM+CGEPj/TJus1AkEAxDQo4H2AWb5K4dWb+AQzrgsmVqcvB0k0THT9SKezmYbVokFGkfB1h9fkmz5cx69+yYgSEWCUVHSdk+drOfbpPQJASx1SKA4d2ETdYMM1uNjgNL7+p02IOo+m2gdk92L28SjKKgJBNTbpQ/aZyJpiVvTh9S4kUzWAiSOiCzEa91nWiQJAcHk6KZ6oMkn84UMzutSlz5LCso/6TKHxYhb6j2jbcxoxY2cqDkUbCvl/KmNwimQXOW5QdTe5MET9hCj4de0OPQJAKO+63Zddaig0nd0Gu2+wlAVWnZQfZqRWgUwZplDDoIZH9sfvHn5vpmzfXK019ikgP++YnH2soiyp88AN0OJWvA=="), "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                    }
                    new Thread(new ae(this, a + "&sign=\"" + string + "\"&" + "sign_type=\"RSA\"")).start();
                    return;
                } else {
                    this.a.post(new ac(this));
                    return;
                }
            } catch (Exception e2) {
                this.a.post(new ag(this));
                return;
            }
        }
        this.a.post(new z(this));
    }
}
