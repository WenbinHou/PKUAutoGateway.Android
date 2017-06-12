package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.ay;
import android.support.v4.view.bm;
import android.support.v4.view.bq;
import android.support.v4.widget.ap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

abstract class al<V extends View> extends ct<V> {
    ap a;
    private Runnable b;
    private boolean c;
    private int d = -1;
    private int e;
    private int f = -1;
    private VelocityTracker g;

    public al(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d() {
        if (this.g == null) {
            this.g = VelocityTracker.obtain();
        }
    }

    int a() {
        return c();
    }

    int a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int c = c();
        if (i2 == 0 || c < i2 || c > i3) {
            return 0;
        }
        int a = ao.a(i, i2, i3);
        if (c == a) {
            return 0;
        }
        a(a);
        return c - a;
    }

    int a(V v) {
        return v.getHeight();
    }

    void a(CoordinatorLayout coordinatorLayout, V v) {
    }

    final boolean a(CoordinatorLayout coordinatorLayout, V v, int i, float f) {
        if (this.b != null) {
            v.removeCallbacks(this.b);
            this.b = null;
        }
        if (this.a == null) {
            this.a = ap.a(v.getContext(), null);
        }
        this.a.a(c(), 0, Math.round(f), 0, 0, i, 0);
        if (this.a.g()) {
            this.b = new am(this, coordinatorLayout, v);
            bq.a((View) v, this.b);
            return true;
        }
        a(coordinatorLayout, v);
        return false;
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f < 0) {
            this.f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.c) {
            return true;
        }
        int y;
        switch (ay.a(motionEvent)) {
            case 0:
                this.c = false;
                int x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                if (b() && coordinatorLayout.a((View) v, x, y)) {
                    this.e = y;
                    this.d = ay.b(motionEvent, 0);
                    d();
                    break;
                }
            case 1:
            case 3:
                this.c = false;
                this.d = -1;
                if (this.g != null) {
                    this.g.recycle();
                    this.g = null;
                    break;
                }
                break;
            case 2:
                y = this.d;
                if (y != -1) {
                    y = ay.a(motionEvent, y);
                    if (y != -1) {
                        y = (int) ay.d(motionEvent, y);
                        if (Math.abs(y - this.e) > this.f) {
                            this.c = true;
                            this.e = y;
                            break;
                        }
                    }
                }
                break;
        }
        if (this.g != null) {
            this.g.addMovement(motionEvent);
        }
        return this.c;
    }

    final int a_(CoordinatorLayout coordinatorLayout, V v, int i) {
        return a(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    final int b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return a(coordinatorLayout, v, a() - i, i2, i3);
    }

    int b(V v) {
        return -v.getHeight();
    }

    boolean b() {
        return false;
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f < 0) {
            this.f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (ay.a(motionEvent)) {
            case 0:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.a((View) v, (int) motionEvent.getX(), y) && b()) {
                    this.e = y;
                    this.d = ay.b(motionEvent, 0);
                    d();
                    break;
                }
                return false;
                break;
            case 1:
                if (this.g != null) {
                    this.g.addMovement(motionEvent);
                    this.g.computeCurrentVelocity(1000);
                    a(coordinatorLayout, v, -a(v), bm.b(this.g, this.d));
                    break;
                }
                break;
            case 2:
                int a = ay.a(motionEvent, this.d);
                if (a != -1) {
                    a = (int) ay.d(motionEvent, a);
                    int i = this.e - a;
                    if (!this.c && Math.abs(i) > this.f) {
                        this.c = true;
                        i = i > 0 ? i - this.f : i + this.f;
                    }
                    if (this.c) {
                        this.e = a;
                        b(coordinatorLayout, v, i, b(v), 0);
                        break;
                    }
                }
                return false;
                break;
            case 3:
                break;
        }
        this.c = false;
        this.d = -1;
        if (this.g != null) {
            this.g.recycle();
            this.g = null;
        }
        if (this.g != null) {
            this.g.addMovement(motionEvent);
        }
        return true;
    }
}
