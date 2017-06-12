package android.support.design.widget;

import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.design.b;
import android.support.v4.view.bq;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

final class ar implements Callback {
    ar() {
    }

    public final boolean handleMessage(Message message) {
        Snackbar snackbar;
        switch (message.what) {
            case 0:
                snackbar = (Snackbar) message.obj;
                if (snackbar.b.getParent() == null) {
                    LayoutParams layoutParams = snackbar.b.getLayoutParams();
                    if (layoutParams instanceof q) {
                        n baVar = new ba(snackbar);
                        baVar.d = SwipeDismissBehavior.a(0.1f);
                        baVar.e = SwipeDismissBehavior.a(0.6f);
                        baVar.c = 0;
                        baVar.b = new at(snackbar);
                        ((q) layoutParams).a(baVar);
                    }
                    snackbar.a.addView(snackbar.b);
                }
                snackbar.b.setOnAttachStateChangeListener(new au(snackbar));
                if (bq.F(snackbar.b)) {
                    snackbar.a();
                } else {
                    snackbar.b.setOnLayoutChangeListener(new aw(snackbar));
                }
                return true;
            case 1:
                snackbar = (Snackbar) message.obj;
                int i = message.arg1;
                if (snackbar.b.getVisibility() != 0) {
                    snackbar.b();
                } else if (VERSION.SDK_INT >= 14) {
                    bq.r(snackbar.b).c((float) snackbar.b.getHeight()).a(a.b).a(250).a(new az(snackbar, i)).b();
                } else {
                    Animation loadAnimation = AnimationUtils.loadAnimation(snackbar.b.getContext(), b.design_snackbar_out);
                    loadAnimation.setInterpolator(a.b);
                    loadAnimation.setDuration(250);
                    loadAnimation.setAnimationListener(new as(snackbar, i));
                    snackbar.b.startAnimation(loadAnimation);
                }
                return true;
            default:
                return false;
        }
    }
}
