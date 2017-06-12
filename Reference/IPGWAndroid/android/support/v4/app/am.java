package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class am extends EpicenterCallback {
    final /* synthetic */ ao a;
    private Rect b;

    am(ao aoVar) {
        this.a = aoVar;
    }

    public final Rect onGetEpicenter(Transition transition) {
        if (this.b == null && this.a.a != null) {
            this.b = aj.a(this.a.a);
        }
        return this.b;
    }
}
