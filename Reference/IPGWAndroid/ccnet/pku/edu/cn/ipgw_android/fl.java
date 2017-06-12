package ccnet.pku.edu.cn.ipgw_android;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

final class fl extends SimpleOnGestureListener {
    final /* synthetic */ fk a;

    private fl(fk fkVar) {
        this.a = fkVar;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        try {
            float y = motionEvent2.getY() - motionEvent.getY();
            float x = motionEvent2.getX() - motionEvent.getX();
            if (Math.abs(x) > Math.abs(y)) {
                if (Math.abs(x) > 100.0f && Math.abs(f) > 100.0f && x > 0.0f) {
                    this.a.a();
                }
            } else if (Math.abs(y) > 100.0f) {
                Math.abs(f2);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
