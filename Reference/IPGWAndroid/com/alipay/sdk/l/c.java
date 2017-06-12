package com.alipay.sdk.l;

final class c implements Runnable {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        if (this.a.b == null) {
            this.a.b = new b(this.a, this.a.c);
        }
        try {
            if (!this.a.b.isShowing()) {
                this.a.b.show();
            }
        } catch (Exception e) {
        }
    }
}
