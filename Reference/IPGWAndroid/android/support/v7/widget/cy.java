package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v4.view.ay;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public abstract class cy implements OnTouchListener {
    private final float a;
    private final int b;
    private final int c;
    private final View d;
    private Runnable e;
    private Runnable f;
    private boolean g;
    private boolean h;
    private int i;
    private final int[] j = new int[2];

    public cy(View view) {
        this.d = view;
        this.a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.b = ViewConfiguration.getTapTimeout();
        this.c = (this.b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private boolean a(MotionEvent motionEvent) {
        View view = this.d;
        cu a = a();
        if (a == null || !a.c.isShowing()) {
            return false;
        }
        View a2 = a.d;
        if (a2 == null || !a2.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        int[] iArr = this.j;
        view.getLocationOnScreen(iArr);
        obtainNoHistory.offsetLocation((float) iArr[0], (float) iArr[1]);
        int[] iArr2 = this.j;
        a2.getLocationOnScreen(iArr2);
        obtainNoHistory.offsetLocation((float) (-iArr2[0]), (float) (-iArr2[1]));
        boolean a3 = a2.a(obtainNoHistory, this.i);
        obtainNoHistory.recycle();
        int a4 = ay.a(motionEvent);
        boolean z = (a4 == 1 || a4 == 3) ? false : true;
        return a3 && z;
    }

    static /* synthetic */ void b(cy cyVar) {
        cyVar.d();
        View view = cyVar.d;
        if (view.isEnabled() && !view.isLongClickable() && cyVar.b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            cyVar.g = true;
            cyVar.h = true;
        }
    }

    private void d() {
        if (this.f != null) {
            this.d.removeCallbacks(this.f);
        }
        if (this.e != null) {
            this.d.removeCallbacks(this.e);
        }
    }

    public abstract cu a();

    public boolean b() {
        cu a = a();
        if (!(a == null || a.c.isShowing())) {
            a.b();
        }
        return true;
    }

    protected boolean c() {
        cu a = a();
        if (a != null && a.c.isShowing()) {
            a.d();
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean a;
        boolean z = this.g;
        if (z) {
            a = this.h ? a(motionEvent) : a(motionEvent) || !c();
        } else {
            View view2 = this.d;
            if (view2.isEnabled()) {
                switch (ay.a(motionEvent)) {
                    case 0:
                        this.i = motionEvent.getPointerId(0);
                        this.h = false;
                        if (this.e == null) {
                            this.e = new cz();
                        }
                        view2.postDelayed(this.e, (long) this.b);
                        if (this.f == null) {
                            this.f = new da();
                        }
                        view2.postDelayed(this.f, (long) this.c);
                    case 1:
                    case 3:
                        d();
                    case 2:
                        int findPointerIndex = motionEvent.findPointerIndex(this.i);
                        if (findPointerIndex >= 0) {
                            float x = motionEvent.getX(findPointerIndex);
                            float y = motionEvent.getY(findPointerIndex);
                            float f = this.a;
                            a = x >= (-f) && y >= (-f) && x < ((float) (view2.getRight() - view2.getLeft())) + f && y < ((float) (view2.getBottom() - view2.getTop())) + f;
                            if (!a) {
                                d();
                                view2.getParent().requestDisallowInterceptTouchEvent(true);
                                a = true;
                                break;
                            }
                        }
                        break;
                }
            }
            a = false;
            boolean z2 = a && b();
            if (z2) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.d.onTouchEvent(obtain);
                obtain.recycle();
            }
            a = z2;
        }
        this.g = a;
        return a || z;
    }
}
