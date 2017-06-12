package ccnet.pku.edu.cn.ipgw_android;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import b.ar;
import b.h;
import com.kaopiz.kprogresshud.f;
import org.json.JSONObject;

final class ca implements h {
    Handler a = new Handler(Looper.getMainLooper());
    final /* synthetic */ f b;
    final /* synthetic */ View c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ bz f;

    ca(bz bzVar, f fVar, View view, String str, String str2) {
        this.f = bzVar;
        this.b = fVar;
        this.c = view;
        this.d = str;
        this.e = str2;
    }

    public final void a() {
        this.a.post(new cb(this));
    }

    public final void a(ar arVar) {
        if (arVar.a()) {
            try {
                JSONObject jSONObject = new JSONObject(arVar.g.d());
                this.a.post(new cd(this));
                if (jSONObject.has("error")) {
                    this.a.post(new ce(this, jSONObject.getString("error")));
                    return;
                } else if (jSONObject.has("succ")) {
                    jSONObject.getString("succ");
                    if (jSONObject.has("SCOPE") && jSONObject.has("IP") && jSONObject.has("CONNECTIONS")) {
                        String str;
                        String string = jSONObject.getString("SCOPE");
                        String string2 = jSONObject.getString("IP");
                        String string3 = jSONObject.getString("CONNECTIONS");
                        String string4 = string.equals("international") ? this.f.c().getString(R.string.notfree) : this.f.c().getString(R.string.free);
                        string = jSONObject.getString("FIXRATE");
                        String str2 = string == null ? "" : !string.equals("YES") ? "NO" : string;
                        String string5 = jSONObject.getString("FR_DESC_CN");
                        if (string5 == null) {
                            string5 = "";
                        }
                        string = jSONObject.getString("FR_DESC_EN");
                        if (string == null) {
                            string = "";
                        }
                        String e = fm.e(this.f.a());
                        if (string5.equals("")) {
                            string5 = str2.equals("YES") ? this.f.c().getString(R.string.month_plan) : this.f.c().getString(R.string.no_month_plan);
                        } else if (!e.equals("zh")) {
                            string5 = string;
                        }
                        string = "";
                        if (e.equals("zh")) {
                            str2 = jSONObject.getString("BALANCE_CN");
                            if (str2 == null) {
                                str = "";
                            } else {
                                if (!str2.equals("")) {
                                    string = this.f.c().getString(R.string.balance) + str2;
                                }
                                str = string;
                            }
                        } else {
                            str2 = jSONObject.getString("BALANCE_EN");
                            str = str2 == null ? "" : !str2.equals("") ? this.f.c().getString(R.string.balance) + str2 : string;
                        }
                        if (e.equals("zh")) {
                            string = jSONObject.getString("FR_TIME_CN");
                            e = (string == null || string.equals("")) ? this.f.c().getString(R.string.time_left) + this.f.c().getString(R.string.time_notcount) : this.f.c().getString(R.string.time_left) + string;
                        } else {
                            string = jSONObject.getString("FR_TIME_EN");
                            e = (string == null || string.equals("")) ? this.f.c().getString(R.string.time_left) + this.f.c().getString(R.string.time_notcount) : this.f.c().getString(R.string.time_left) + string;
                        }
                        this.a.post(new cg(this, string3, string4, string2, string5, e, str));
                        if (fm.c(this.c.getContext()).equals("Y")) {
                            fm.b(this.c.getContext(), this.d);
                            if (fm.d(this.c.getContext()).equals("Y")) {
                                fm.a(this.e);
                            }
                        }
                        fm.a(this.c.getContext(), string2);
                        string = jSONObject.getString("succ").trim();
                        if (!string.equals("")) {
                            this.a.post(new ch(this, string));
                            return;
                        }
                        return;
                    }
                    this.a.post(new cf(this));
                    return;
                } else {
                    this.a.post(new ci(this));
                    return;
                }
            } catch (Exception e2) {
                this.a.post(new cj(this));
                return;
            }
        }
        this.a.post(new cc(this));
    }
}
