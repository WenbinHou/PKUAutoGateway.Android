package ccnet.pku.edu.cn.ipgw_android;

import a.a.a.a;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.bu;
import android.support.v4.view.ViewPager;
import android.support.v7.a.q;
import android.support.v7.a.s;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import b.af;
import b.ag;
import b.ao;
import b.ap;
import b.e;
import com.a.a.o;
import com.a.a.p;
import com.a.a.r;
import com.a.a.y;
import java.util.Locale;

public class MainActivity extends s {
    q l = null;
    private fi m;
    private ViewPager n;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Locale locale = new Locale(fm.e(getBaseContext()));
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        setContentView((int) R.layout.activity_main);
        fm.g(getApplicationContext());
        this.m = new fi(this, this.b.a.f);
        this.n = (ViewPager) findViewById(R.id.container);
        this.n.setAdapter(this.m);
        this.n.setOffscreenPageLimit(3);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(this.n);
        View inflate = getLayoutInflater().inflate(R.layout.tabview_home, null);
        TextView textView = (TextView) inflate.findViewById(R.id.tab_textview_home);
        ((ImageView) inflate.findViewById(R.id.tab_imageview_home)).setColorFilter(getResources().getColor(R.color.colorPKURed), Mode.SRC_IN);
        textView.setTextColor(getResources().getColor(R.color.colorPKURed));
        View inflate2 = getLayoutInflater().inflate(R.layout.tabview_info, null);
        ((TextView) inflate2.findViewById(R.id.badge_textView)).setVisibility(4);
        View inflate3 = getLayoutInflater().inflate(R.layout.tabview_more, null);
        bu a = tabLayout.a();
        bu a2 = tabLayout.a();
        bu a3 = tabLayout.a();
        a.a(inflate);
        a2.a(inflate2);
        a3.a(inflate3);
        tabLayout.a(0).a(inflate);
        tabLayout.a(1).a(inflate2);
        tabLayout.a(2).a(inflate3);
        tabLayout.setOnTabSelectedListener(new fh(this));
        Context applicationContext = getApplicationContext();
        String c = fm.c(applicationContext);
        if (c.equals("")) {
            fm.c(applicationContext, "Y");
            fm.d(applicationContext, "Y");
        } else if (c.equals("N")) {
            fm.d(applicationContext, "N");
            fm.b(applicationContext, "");
            fm.a("");
        }
        c = fm.d(applicationContext);
        if (c.equals("")) {
            fm.d(applicationContext, "Y");
        } else if (c.equals("N")) {
            fm.a("");
        }
        if (fm.f(applicationContext).equals("")) {
            fm.f(applicationContext, "N");
        }
        if (fm.e(applicationContext).equals("")) {
            if (Locale.getDefault().getLanguage().equals("en")) {
                fm.e(applicationContext, "en");
            } else {
                fm.e(applicationContext, "zh");
            }
        }
        applicationContext = getApplicationContext();
        if (by.a == null) {
            by.a = new bx(applicationContext);
        }
        fn.e(this);
        if (fn.a.equals("")) {
            a aVar = new a(getApplicationContext());
            c = aVar.a();
            String b = aVar.b();
            if (c == null) {
                c = "";
            }
            if (b == null) {
                b = "";
            }
            fn.a = c + b;
        }
        if (!o.a()) {
            p a4 = o.a((Context) this);
            a4.a = r.b;
            a4.c = p.a(this);
            a4.b = y.a;
            a4.b();
        }
        this.n.a(new fe(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    public void onStart() {
        super.onStart();
        try {
            ap a = ap.a(af.a("application/x-www-form-urlencoded; charset=utf-8"), "cmd=getmsgs");
            ag a2 = fn.a();
            getWindow().getDecorView().getRootView();
            a2.a(new ao().a("https://its.pku.edu.cn/cas/ITSClient").a("User-Agent", fn.a(this)).a("POST", a).a()).a(new ff(this));
        } catch (Exception e) {
        }
        String string = getApplicationContext().getSharedPreferences("preference_file_key", 0).getString("store_update_alerttime", "");
        if (System.currentTimeMillis() - (string.equals("") ? 0 : Long.parseLong(string)) >= 43200000) {
            ag agVar = new ag();
            ao a3 = new ao().a("https://its.pku.edu.cn/pku_gateway_apps/ver_android.txt").a("User-Agent", fn.a(this));
            String eVar = e.a.toString();
            agVar.a((eVar.isEmpty() ? a3.b("Cache-Control") : a3.a("Cache-Control", eVar)).a()).a(new fa(this));
        }
    }

    public void onStop() {
        super.onStop();
        if (this.l != null && this.l.isShowing()) {
            this.l.dismiss();
            this.l = null;
        }
    }
}
