package com.alipay.sdk.auth;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.app.a.a;
import com.alipay.sdk.k.j;
import com.alipay.sdk.k.k;

final class b extends WebViewClient {
    final /* synthetic */ AuthActivity a;

    private b(AuthActivity authActivity) {
        this.a = authActivity;
    }

    public final void onPageFinished(WebView webView, String str) {
        AuthActivity.g(this.a);
        this.a.d.removeCallbacks(this.a.g);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        AuthActivity.d(this.a);
        this.a.d.postDelayed(this.a.g, 30000);
        super.onPageStarted(webView, str, bitmap);
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.a.f = true;
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.a.e) {
            sslErrorHandler.proceed();
            this.a.e = false;
            return;
        }
        this.a.runOnUiThread(new g(this, sslErrorHandler));
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.toLowerCase().startsWith("alipays://platformapi/startApp?".toLowerCase()) || str.toLowerCase().startsWith("intent://platformapi/startapp?".toLowerCase())) {
            try {
                k a = j.a(this.a, "com.eg.android.AlipayGphone");
                if (a == null) {
                    return true;
                }
                String a2 = j.a(a.a);
                if (a2 == null || TextUtils.equals(a2, "b6cbad6cbd5ed0d209afc69ad3b7a617efaae9b3c47eabe0be42d924936fa78c8001b1fd74b079e5ff9690061dacfa4768e981a526b9ca77156ca36251cf2f906d105481374998a7e6e6e18f75ca98b8ed2eaf86ff402c874cca0a263053f22237858206867d210020daa38c48b20cc9dfd82b44a51aeb5db459b22794e2d649")) {
                    if (str.startsWith("intent://platformapi/startapp")) {
                        str = str.replaceFirst("intent://platformapi/startapp?", "alipays://platformapi/startApp?");
                    }
                    this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                }
                a.a("biz", "ClientSignError", a2);
                return true;
            } catch (Throwable th) {
                return true;
            }
        } else if (!AuthActivity.a(this.a, str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        } else {
            webView.stopLoading();
            return true;
        }
    }
}
