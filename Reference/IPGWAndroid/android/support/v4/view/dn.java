package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class dn extends dl {
    WeakHashMap<View, Integer> b = null;

    dn() {
    }

    public final long a(View view) {
        return view.animate().getDuration();
    }

    public final void a(dk dkVar, View view) {
        view.animate().cancel();
    }

    public final void a(dk dkVar, View view, float f) {
        view.animate().alpha(f);
    }

    public void a(dk dkVar, View view, ea eaVar) {
        view.setTag(2113929216, eaVar);
        view.animate().setListener(new dv(new do(dkVar), view));
    }

    public final void a(View view, long j) {
        view.animate().setDuration(j);
    }

    public final void a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public final void b(dk dkVar, View view) {
        view.animate().start();
    }

    public final void b(dk dkVar, View view, float f) {
        view.animate().translationX(f);
    }

    public final void b(View view, long j) {
        view.animate().setStartDelay(j);
    }

    public final void c(dk dkVar, View view, float f) {
        view.animate().translationY(f);
    }
}
