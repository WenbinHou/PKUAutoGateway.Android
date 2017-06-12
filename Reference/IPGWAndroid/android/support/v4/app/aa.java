package android.support.v4.app;

import android.view.View;
import android.view.animation.Animation;

final class aa extends ab {
    final /* synthetic */ n a;
    final /* synthetic */ y b;

    aa(y yVar, View view, Animation animation, n nVar) {
        this.b = yVar;
        this.a = nVar;
        super(view, animation);
    }

    public final void onAnimationEnd(Animation animation) {
        super.onAnimationEnd(animation);
        if (this.a.c != null) {
            this.a.c = null;
            this.b.a(this.a, this.a.d, 0, 0, false);
        }
    }
}
