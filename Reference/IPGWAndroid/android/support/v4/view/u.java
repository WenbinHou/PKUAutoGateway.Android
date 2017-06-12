package android.support.v4.view;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

final class u implements r {
    private final GestureDetector a;

    public u(Context context, OnGestureListener onGestureListener) {
        this.a = new GestureDetector(context, onGestureListener, null);
    }

    public final boolean a(MotionEvent motionEvent) {
        return this.a.onTouchEvent(motionEvent);
    }
}
