package android.support.v7.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class de implements OnTouchListener {
    final /* synthetic */ cu a;

    private de(cu cuVar) {
        this.a = cuVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && this.a.c != null && this.a.c.isShowing() && x >= 0 && x < this.a.c.getWidth() && y >= 0 && y < this.a.c.getHeight()) {
            this.a.C.postDelayed(this.a.x, 250);
        } else if (action == 1) {
            this.a.C.removeCallbacks(this.a.x);
        }
        return false;
    }
}
