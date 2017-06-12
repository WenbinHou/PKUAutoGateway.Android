package com.alipay.sdk.auth;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.alipay.sdk.a.b;
import com.alipay.sdk.a.d;
import com.alipay.sdk.a.e;
import com.alipay.sdk.k.j;
import com.alipay.sdk.l.a;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled", "DefaultLocale"})
public class AuthActivity extends Activity {
    private WebView a;
    private String b;
    private a c;
    private Handler d;
    private boolean e;
    private boolean f;
    private Runnable g = new f(this);

    static /* synthetic */ void a(AuthActivity authActivity, com.alipay.sdk.a.a aVar) {
        if (authActivity.a != null && aVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("clientId", aVar.a);
                jSONObject.put("func", aVar.c);
                jSONObject.put("param", aVar.e);
                jSONObject.put("msgType", aVar.d);
                authActivity.runOnUiThread(new e(authActivity, String.format("AlipayJSBridge._invokeJS(%s)", new Object[]{jSONObject.toString()})));
            } catch (JSONException e) {
            }
        }
    }

    static /* synthetic */ boolean a(AuthActivity authActivity, String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith("https://")) {
            return false;
        }
        if (!"SDKLite://h5quit".equalsIgnoreCase(str)) {
            if (TextUtils.equals(str, authActivity.b)) {
                str = str + "?resultCode=150";
            }
            j.a(authActivity, str);
        }
        authActivity.finish();
        return true;
    }

    static /* synthetic */ void b(AuthActivity authActivity, String str) {
        Object obj;
        d dVar = new d(authActivity.getApplicationContext(), new d(authActivity));
        try {
            JSONObject jSONObject = new JSONObject(str);
            Object string = jSONObject.getString("clientId");
            try {
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("param");
                    jSONObject2 = jSONObject2 instanceof JSONObject ? jSONObject2 : null;
                    String string2 = jSONObject.getString("func");
                    String string3 = jSONObject.getString("bundleName");
                    com.alipay.sdk.a.a aVar = new com.alipay.sdk.a.a("call");
                    aVar.b = string3;
                    aVar.c = string2;
                    aVar.e = jSONObject2;
                    aVar.a = string;
                    if (TextUtils.isEmpty(aVar.c)) {
                        dVar.a(aVar.a, b.c);
                        return;
                    }
                    Runnable eVar = new e(dVar, aVar);
                    if ((Looper.getMainLooper() == Looper.myLooper() ? 1 : null) != null) {
                        eVar.run();
                    } else {
                        new Handler(Looper.getMainLooper()).post(eVar);
                    }
                }
            } catch (Exception e) {
                obj = string;
                if (!TextUtils.isEmpty(obj)) {
                    try {
                        dVar.a(obj, b.d);
                    } catch (JSONException e2) {
                    }
                }
            }
        } catch (Exception e3) {
            obj = null;
            if (!TextUtils.isEmpty(obj)) {
                dVar.a(obj, b.d);
            }
        }
    }

    static /* synthetic */ void d(AuthActivity authActivity) {
        try {
            if (authActivity.c == null) {
                authActivity.c = new a(authActivity, "正在加载");
            }
            authActivity.c.a();
        } catch (Exception e) {
            authActivity.c = null;
        }
    }

    static /* synthetic */ void g(AuthActivity authActivity) {
        if (authActivity.c != null) {
            authActivity.c.b();
        }
        authActivity.c = null;
    }

    public void onBackPressed() {
        if (!this.a.canGoBack()) {
            j.a(this, this.b + "?resultCode=150");
            finish();
        } else if (this.f) {
            j.a(this, this.b + "?resultCode=150");
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
            if (extras == null) {
                finish();
                return;
            }
            try {
                this.b = extras.getString("redirectUri");
                String string = extras.getString("params");
                if (j.b(string)) {
                    Method method;
                    super.requestWindowFeature(1);
                    this.d = new Handler(getMainLooper());
                    View linearLayout = new LinearLayout(this);
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    linearLayout.setOrientation(1);
                    setContentView(linearLayout, layoutParams);
                    this.a = new WebView(this);
                    layoutParams.weight = 1.0f;
                    this.a.setVisibility(0);
                    linearLayout.addView(this.a, layoutParams);
                    WebSettings settings = this.a.getSettings();
                    settings.setUserAgentString(settings.getUserAgentString() + j.c(getApplicationContext()));
                    settings.setRenderPriority(RenderPriority.HIGH);
                    settings.setSupportMultipleWindows(true);
                    settings.setJavaScriptEnabled(true);
                    settings.setSavePassword(false);
                    settings.setJavaScriptCanOpenWindowsAutomatically(true);
                    settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
                    settings.setAllowFileAccess(false);
                    settings.setTextSize(TextSize.NORMAL);
                    this.a.setVerticalScrollbarOverlay(true);
                    this.a.setWebViewClient(new b());
                    this.a.setWebChromeClient(new a());
                    this.a.setDownloadListener(new c(this));
                    this.a.loadUrl(string);
                    if (VERSION.SDK_INT >= 7) {
                        try {
                            method = this.a.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[]{Boolean.TYPE});
                            if (method != null) {
                                method.invoke(this.a.getSettings(), new Object[]{Boolean.valueOf(true)});
                            }
                        } catch (Exception e) {
                        }
                    }
                    try {
                        this.a.removeJavascriptInterface("searchBoxJavaBridge_");
                        this.a.removeJavascriptInterface("accessibility");
                        this.a.removeJavascriptInterface("accessibilityTraversal");
                    } catch (Throwable th) {
                    }
                    if (VERSION.SDK_INT >= 19) {
                        this.a.getSettings().setCacheMode(1);
                        return;
                    }
                    return;
                }
                finish();
            } catch (Exception e2) {
                finish();
            }
        } catch (Exception e3) {
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
