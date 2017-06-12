package com.google.android.gms.b;

import android.webkit.ValueCallback;
import android.webkit.WebView;

final class o implements Runnable {
    ValueCallback<String> a = new p(this);
    final /* synthetic */ j b;
    final /* synthetic */ WebView c;
    final /* synthetic */ boolean d;
    final /* synthetic */ m e;

    o(m mVar, j jVar, WebView webView, boolean z) {
        this.e = mVar;
        this.b = jVar;
        this.c = webView;
        this.d = z;
    }

    public final void run() {
        if (this.c.getSettings().getJavaScriptEnabled()) {
            try {
                this.c.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.a);
            } catch (Throwable th) {
                this.a.onReceiveValue("");
            }
        }
    }
}
