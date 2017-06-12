package android.support.design.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class bh {
    final ArrayList<bj> a = new ArrayList();
    bj b = null;
    Animation c = null;
    WeakReference<View> d;
    private AnimationListener e = new bi(this);

    bh() {
    }

    final View a() {
        return this.d == null ? null : (View) this.d.get();
    }

    public final void a(int[] iArr, Animation animation) {
        bj bjVar = new bj(iArr, animation);
        animation.setAnimationListener(this.e);
        this.a.add(bjVar);
    }
}
