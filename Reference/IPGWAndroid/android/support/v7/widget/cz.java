package android.support.v7.widget;

final class cz implements Runnable {
    final /* synthetic */ cy a;

    private cz(cy cyVar) {
        this.a = cyVar;
    }

    public final void run() {
        this.a.d.getParent().requestDisallowInterceptTouchEvent(true);
    }
}
