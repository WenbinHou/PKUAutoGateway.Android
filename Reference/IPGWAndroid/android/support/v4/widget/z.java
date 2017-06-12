package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class z implements AnimationListener {
    final /* synthetic */ ab a;
    final /* synthetic */ x b;

    z(x xVar, ab abVar) {
        this.b = xVar;
        this.a = abVar;
    }

    public final void onAnimationEnd(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
        this.a.b();
        ab abVar = this.a;
        abVar.a(abVar.a());
        this.a.a(this.a.e);
        if (this.b.b) {
            this.b.b = false;
            animation.setDuration(1332);
            this.a.a(false);
            return;
        }
        this.b.k = (this.b.k + 1.0f) % 5.0f;
    }

    public final void onAnimationStart(Animation animation) {
        this.b.k = 0.0f;
    }
}
