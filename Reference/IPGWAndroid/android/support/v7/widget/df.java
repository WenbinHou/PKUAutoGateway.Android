package android.support.v7.widget;

import android.support.v4.view.bq;

final class df implements Runnable {
    final /* synthetic */ cu a;

    private df(cu cuVar) {
        this.a = cuVar;
    }

    public final void run() {
        if (this.a.d != null && bq.H(this.a.d) && this.a.d.getCount() > this.a.d.getChildCount() && this.a.d.getChildCount() <= this.a.j) {
            this.a.c.setInputMethodMode(2);
            this.a.b();
        }
    }
}
