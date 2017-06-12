package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.util.client.b;

@fd
@TargetApi(11)
public class hi extends WebChromeClient {
    private final gv a;

    public hi(gv gvVar) {
        this.a = gvVar;
    }

    private static Context a(WebView webView) {
        if (!(webView instanceof gv)) {
            return webView.getContext();
        }
        gv gvVar = (gv) webView;
        Context c = gvVar.c();
        return c == null ? gvVar.getContext() : c;
    }

    private static boolean a(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            Builder builder = new Builder(context);
            builder.setTitle(str);
            if (z) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                View textView = new TextView(context);
                textView.setText(str2);
                View editText = new EditText(context);
                editText.setText(str3);
                linearLayout.addView(textView);
                linearLayout.addView(editText);
                builder.setView(linearLayout).setPositiveButton(17039370, new ho(jsPromptResult, editText)).setNegativeButton(17039360, new hn(jsPromptResult)).setOnCancelListener(new hm(jsPromptResult)).create().show();
            } else {
                builder.setMessage(str2).setPositiveButton(17039370, new hl(jsResult)).setNegativeButton(17039360, new hk(jsResult)).setOnCancelListener(new hj(jsResult)).create().show();
            }
        } catch (Throwable e) {
            b.c("Fail to display Dialog.", e);
        }
        return true;
    }

    protected final void a(View view, int i, CustomViewCallback customViewCallback) {
        c f = this.a.f();
        if (f == null) {
            b.d("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        f.h = new FrameLayout(f.b);
        f.h.setBackgroundColor(-16777216);
        f.h.addView(view, -1, -1);
        f.b.setContentView(f.h);
        f.p = true;
        f.i = customViewCallback;
        f.g = true;
        f.a(i);
    }

    public final void onCloseWindow(WebView webView) {
        if (webView instanceof gv) {
            c f = ((gv) webView).f();
            if (f == null) {
                b.d("Tried to close an AdWebView not associated with an overlay.");
                return;
            } else {
                f.a();
                return;
            }
        }
        b.d("Tried to close a WebView that wasn't an AdWebView.");
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        if (str.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (hp.a[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                b.b(str);
                break;
            case 2:
                b.d(str);
                break;
            case 3:
            case 4:
                b.c(str);
                break;
            case 5:
                b.a(str);
                break;
            default:
                b.c(str);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebViewTransport webViewTransport = (WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(this.a.i());
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j != 0) {
            if (j2 == 0) {
                j = Math.min(Math.min(131072, j4) + j, 1048576);
            } else if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        } else if (j2 > j4 || j2 > 1048576) {
            j2 = 0;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        if (callback != null) {
            boolean z;
            f.c();
            if (!fs.a(this.a.getContext().getPackageManager(), this.a.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION")) {
                f.c();
                if (!fs.a(this.a.getContext().getPackageManager(), this.a.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }

    public final void onHideCustomView() {
        c f = this.a.f();
        if (f == null) {
            b.d("Could not get ad overlay when hiding custom view.");
        } else {
            f.b();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return a(a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return a(a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return a(a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return a(a(webView), str, str2, str3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        long j3 = 131072 + j;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        a(view, -1, customViewCallback);
    }
}
