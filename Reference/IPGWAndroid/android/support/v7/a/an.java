package android.support.v7.a;

import android.content.Context;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ao;
import android.view.KeyEvent;
import android.view.MotionEvent;

final class an extends ContentFrameLayout {
    final /* synthetic */ ac a;

    public an(ac acVar, Context context) {
        this.a = acVar;
        super(context);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.a.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            boolean z = x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5;
            if (z) {
                this.a.a(this.a.f(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void setBackgroundResource(int i) {
        setBackgroundDrawable(ao.a().a(getContext(), i, false));
    }
}
