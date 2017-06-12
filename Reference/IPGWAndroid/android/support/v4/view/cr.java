package android.support.v4.view;

final class cr implements Runnable {
    final /* synthetic */ ViewPager a;

    cr(ViewPager viewPager) {
        this.a = viewPager;
    }

    public final void run() {
        this.a.setScrollState(0);
        this.a.b();
    }
}
