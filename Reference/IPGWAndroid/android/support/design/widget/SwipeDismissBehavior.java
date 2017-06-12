package android.support.design.widget;

import android.support.v4.view.ay;
import android.support.v4.widget.bm;
import android.support.v4.widget.bp;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class SwipeDismissBehavior<V extends View> extends n<V> {
    private bm a;
    bl b;
    int c = 2;
    float d = 0.0f;
    float e = 0.5f;
    private boolean f;
    private float g = 0.0f;
    private boolean h;
    private float i = 0.5f;
    private final bp j = new bk(this);

    static float a(float f) {
        return Math.min(Math.max(0.0f, f), 1.0f);
    }

    static float a(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        switch (ay.a(motionEvent)) {
            case 1:
            case 3:
                if (this.f) {
                    this.f = false;
                    return false;
                }
                break;
            default:
                this.f = !coordinatorLayout.a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        if (this.f) {
            return false;
        }
        if (this.a == null) {
            this.a = this.h ? bm.a((ViewGroup) coordinatorLayout, this.g, this.j) : bm.a((ViewGroup) coordinatorLayout, this.j);
        }
        return this.a.a(motionEvent);
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.a == null) {
            return false;
        }
        this.a.b(motionEvent);
        return true;
    }

    public boolean b(View view) {
        return true;
    }
}
