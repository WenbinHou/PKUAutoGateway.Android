package android.support.v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

final class dm implements Runnable {
    WeakReference<View> a;
    dk b;
    final /* synthetic */ dl c;

    private dm(dl dlVar, dk dkVar, View view) {
        this.c = dlVar;
        this.a = new WeakReference(view);
        this.b = dkVar;
    }

    public final void run() {
        View view = (View) this.a.get();
        if (view != null) {
            this.c.c(this.b, view);
        }
    }
}
