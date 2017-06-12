package com.alipay.sdk.l;

final class d implements Runnable {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        if (this.a.b != null) {
            try {
                this.a.b.dismiss();
            } catch (Exception e) {
            }
        }
    }
}
