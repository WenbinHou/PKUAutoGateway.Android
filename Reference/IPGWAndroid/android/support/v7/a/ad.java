package android.support.v7.a;

final class ad implements Runnable {
    final /* synthetic */ ac a;

    ad(ac acVar) {
        this.a = acVar;
    }

    public final void run() {
        if ((this.a.I & 1) != 0) {
            ac.a(this.a, 0);
        }
        if ((this.a.I & 4096) != 0) {
            ac.a(this.a, 108);
        }
        this.a.H = false;
        this.a.I = 0;
    }
}
