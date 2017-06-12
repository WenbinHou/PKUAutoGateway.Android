package com.alipay.sdk.auth;

final class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ AuthActivity b;

    e(AuthActivity authActivity, String str) {
        this.b = authActivity;
        this.a = str;
    }

    public final void run() {
        try {
            this.b.a.loadUrl("javascript:" + this.a);
        } catch (Exception e) {
        }
    }
}
