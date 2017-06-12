package com.alipay.sdk.app;

import android.webkit.SslErrorHandler;

final class e implements Runnable {
    final /* synthetic */ SslErrorHandler a;
    final /* synthetic */ d b;

    e(d dVar, SslErrorHandler sslErrorHandler) {
        this.b = dVar;
        this.a = sslErrorHandler;
    }

    public final void run() {
        com.alipay.sdk.l.e.a(this.b.b, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，可能存在风险，请选择是否继续？", "继续", new f(this), "退出", new g(this));
    }
}
