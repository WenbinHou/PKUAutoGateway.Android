package com.chauthai.swipereveallayout;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

final class c extends SimpleOnGestureListener {
    final /* synthetic */ SwipeRevealLayout a;

    c(SwipeRevealLayout swipeRevealLayout) {
        this.a = swipeRevealLayout;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        this.a.j = false;
        return true;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.a.j = true;
        return false;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.a.j = true;
        if (this.a.getParent() != null) {
            this.a.getParent().requestDisallowInterceptTouchEvent(true);
        }
        return false;
    }
}
