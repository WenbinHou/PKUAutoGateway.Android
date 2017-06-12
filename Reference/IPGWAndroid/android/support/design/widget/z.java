package android.support.design.widget;

import android.view.animation.Animation;

final class z extends b {
    final /* synthetic */ boolean a = false;
    final /* synthetic */ aj b = null;
    final /* synthetic */ y c;

    z(y yVar) {
        this.c = yVar;
    }

    public final void onAnimationEnd(Animation animation) {
        this.c.p = false;
        this.c.k.a(8, this.a);
    }

    public final void onAnimationStart(Animation animation) {
        this.c.p = true;
    }
}
