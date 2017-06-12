package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class ak extends EpicenterCallback {
    final /* synthetic */ Rect a;

    ak(Rect rect) {
        this.a = rect;
    }

    public final Rect onGetEpicenter(Transition transition) {
        return this.a;
    }
}
