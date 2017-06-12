package com.kaopiz.kprogresshud;

final class q implements Runnable {
    final /* synthetic */ p a;

    q(p pVar) {
        this.a = pVar;
    }

    public final void run() {
        this.a.a = this.a.a + 30.0f;
        this.a.a = this.a.a < 360.0f ? this.a.a : this.a.a - 360.0f;
        this.a.invalidate();
        if (this.a.c) {
            this.a.postDelayed(this, (long) this.a.b);
        }
    }
}
