package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.k.j;

public class H5PayActivity extends Activity {
    private WebView a;
    private WebViewClient b;

    public void a() {
        Object obj = PayTask.a;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception e) {
            }
        }
    }

    public void finish() {
        a();
        super.finish();
    }

    public void onBackPressed() {
        if (!this.a.canGoBack()) {
            j.a = j.a();
            finish();
        } else if (((d) this.b).a) {
            k a = k.a(k.NETWORK_ERROR.h);
            j.a = j.a(a.h, a.i, "");
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            String string = extras.getString("url");
            if (j.b(string)) {
                String string2 = extras.getString("cookie");
                super.requestWindowFeature(1);
                this.a = j.a((Activity) this, string, string2);
                this.b = new d(this);
                this.a.setWebViewClient(this.b);
                return;
            }
            finish();
        } catch (Exception e) {
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.a != null) {
            this.a.removeAllViews();
            try {
                this.a.destroy();
            } catch (Throwable th) {
            }
            this.a = null;
        }
    }
}
