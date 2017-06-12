package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.ay;
import android.support.v4.view.bq;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public final class bm {
    private static final Interpolator v = new bn();
    public int a;
    public int b;
    public int c;
    private int d = -1;
    private float[] e;
    private float[] f;
    private float[] g;
    private float[] h;
    private int[] i;
    private int[] j;
    private int[] k;
    private int l;
    private VelocityTracker m;
    private float n;
    private float o;
    private int p;
    private ap q;
    private final bp r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private final Runnable w = new bo(this);

    private bm(Context context, ViewGroup viewGroup, bp bpVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (bpVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.u = viewGroup;
            this.r = bpVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.p = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.b = viewConfiguration.getScaledTouchSlop();
            this.n = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.o = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.q = ap.a(context, v);
        }
    }

    private static float a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        return abs < f2 ? 0.0f : abs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    private int a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        int i4 = width / 2;
        float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, ((float) Math.abs(i)) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        return Math.min(i4 > 0 ? Math.round(Math.abs(sin / ((float) i4)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    public static bm a(ViewGroup viewGroup, float f, bp bpVar) {
        bm a = a(viewGroup, bpVar);
        a.b = (int) (((float) a.b) * (1.0f / f));
        return a;
    }

    public static bm a(ViewGroup viewGroup, bp bpVar) {
        return new bm(viewGroup.getContext(), viewGroup, bpVar);
    }

    private void a(float f, float f2) {
        this.t = true;
        this.r.a(this.s, f, f2);
        this.t = false;
        if (this.a == 1) {
            a(0);
        }
    }

    private void a(float f, float f2, int i) {
        int i2 = 0;
        if (this.e == null || this.e.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.e != null) {
                System.arraycopy(this.e, 0, obj, 0, this.e.length);
                System.arraycopy(this.f, 0, obj2, 0, this.f.length);
                System.arraycopy(this.g, 0, obj3, 0, this.g.length);
                System.arraycopy(this.h, 0, obj4, 0, this.h.length);
                System.arraycopy(this.i, 0, obj5, 0, this.i.length);
                System.arraycopy(this.j, 0, obj6, 0, this.j.length);
                System.arraycopy(this.k, 0, obj7, 0, this.k.length);
            }
            this.e = obj;
            this.f = obj2;
            this.g = obj3;
            this.h = obj4;
            this.i = obj5;
            this.j = obj6;
            this.k = obj7;
        }
        float[] fArr = this.e;
        this.g[i] = f;
        fArr[i] = f;
        fArr = this.f;
        this.h[i] = f2;
        fArr[i] = f2;
        int[] iArr = this.i;
        int i3 = (int) f;
        int i4 = (int) f2;
        if (i3 < this.u.getLeft() + this.p) {
            i2 = 1;
        }
        if (i4 < this.u.getTop() + this.p) {
            i2 |= 4;
        }
        if (i3 > this.u.getRight() - this.p) {
            i2 |= 2;
        }
        if (i4 > this.u.getBottom() - this.p) {
            i2 |= 8;
        }
        iArr[i] = i2;
        this.l |= 1 << i;
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        return ((this.i[i] & i2) != i2 || (this.c & i2) == 0 || (this.k[i] & i2) == i2 || (this.j[i] & i2) == i2) ? false : (abs > ((float) this.b) || Math.abs(f2) > ((float) this.b)) && (this.j[i] & i2) == 0 && abs > ((float) this.b);
    }

    private boolean a(int i, int i2, int i3, int i4) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.q.h();
            a(0);
            return false;
        }
        View view = this.s;
        int b = b(i3, (int) this.o, (int) this.n);
        int b2 = b(i4, (int) this.o, (int) this.n);
        int abs = Math.abs(i5);
        int abs2 = Math.abs(i6);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        this.q.a(left, top, i5, i6, (int) (((b2 != 0 ? ((float) abs4) / ((float) i7) : ((float) abs2) / ((float) i8)) * ((float) a(i6, b2, this.r.a()))) + ((b != 0 ? ((float) abs3) / ((float) i7) : ((float) abs) / ((float) i8)) * ((float) a(i5, b, this.r.b(view))))));
        a(2);
        return true;
    }

    private boolean a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.r.b(view) > 0;
        boolean z2 = this.r.a() > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.b * this.b)) : z ? Math.abs(f) > ((float) this.b) : z2 && Math.abs(f2) > ((float) this.b);
    }

    private static int b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        return abs < i2 ? 0 : abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    private View b(int i, int i2) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.u.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private void b(float f, float f2, int i) {
        int i2 = 1;
        if (!a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.j;
            iArr[i] = iArr[i] | i2;
            this.r.a(i2, i);
        }
    }

    private void b(int i) {
        if (this.e != null) {
            this.e[i] = 0.0f;
            this.f[i] = 0.0f;
            this.g[i] = 0.0f;
            this.h[i] = 0.0f;
            this.i[i] = 0;
            this.j[i] = 0;
            this.k[i] = 0;
            this.l &= (1 << i) ^ -1;
        }
    }

    private boolean b(View view, int i) {
        if (view == this.s && this.d == i) {
            return true;
        }
        if (view == null || !this.r.a(view, i)) {
            return false;
        }
        this.d = i;
        a(view, i);
        return true;
    }

    private void c() {
        this.d = -1;
        if (this.e != null) {
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.h, 0.0f);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.j, 0);
            Arrays.fill(this.k, 0);
            this.l = 0;
        }
        if (this.m != null) {
            this.m.recycle();
            this.m = null;
        }
    }

    private void c(MotionEvent motionEvent) {
        int c = ay.c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = ay.b(motionEvent, i);
            float c2 = ay.c(motionEvent, i);
            float d = ay.d(motionEvent, i);
            this.g[b] = c2;
            this.h[b] = d;
        }
    }

    private boolean c(int i) {
        if ((this.l & (1 << i)) != 0) {
            int i2 = 1;
        } else {
            boolean z = false;
        }
        if (i2 != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void d() {
        this.m.computeCurrentVelocity(1000, this.n);
        a(a(android.support.v4.view.bm.a(this.m, this.d), this.o, this.n), a(android.support.v4.view.bm.b(this.m, this.d), this.o, this.n));
    }

    public final void a() {
        c();
        if (this.a == 2) {
            int b = this.q.b();
            int c = this.q.c();
            this.q.h();
            int b2 = this.q.b();
            int c2 = this.q.c();
            this.r.a(this.s, b2, c2, b2 - b, c2 - c);
        }
        a(0);
    }

    final void a(int i) {
        this.u.removeCallbacks(this.w);
        if (this.a != i) {
            this.a = i;
            this.r.a(i);
            if (this.a == 0) {
                this.s = null;
            }
        }
    }

    public final void a(View view, int i) {
        if (view.getParent() != this.u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
        }
        this.s = view;
        this.d = i;
        this.r.a(view);
        a(1);
    }

    public final boolean a(int i, int i2) {
        if (this.t) {
            return a(i, i2, (int) android.support.v4.view.bm.a(this.m, this.d), (int) android.support.v4.view.bm.b(this.m, this.d));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(MotionEvent motionEvent) {
        int a = ay.a(motionEvent);
        int b = ay.b(motionEvent);
        if (a == 0) {
            c();
        }
        if (this.m == null) {
            this.m = VelocityTracker.obtain();
        }
        this.m.addMovement(motionEvent);
        float x;
        float y;
        int b2;
        switch (a) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                b2 = ay.b(motionEvent, 0);
                a(x, y, b2);
                View b3 = b((int) x, (int) y);
                if (b3 == this.s && this.a == 2) {
                    b(b3, b2);
                }
                if ((this.i[b2] & this.c) != 0) {
                    break;
                }
                break;
            case 1:
            case 3:
                c();
                break;
            case 2:
                if (!(this.e == null || this.f == null)) {
                    b2 = ay.c(motionEvent);
                    for (b = 0; b < b2; b++) {
                        int b4 = ay.b(motionEvent, b);
                        if (c(b4)) {
                            x = ay.c(motionEvent, b);
                            float d = ay.d(motionEvent, b);
                            float f = x - this.e[b4];
                            float f2 = d - this.f[b4];
                            View b5 = b((int) x, (int) d);
                            Object obj = (b5 == null || !a(b5, f, f2)) ? null : 1;
                            if (obj != null) {
                                int left = b5.getLeft();
                                int c = this.r.c(b5, ((int) f) + left);
                                int top = b5.getTop();
                                int b6 = this.r.b(b5, ((int) f2) + top);
                                int b7 = this.r.b(b5);
                                int a2 = this.r.a();
                                if (b7 != 0) {
                                    if (b7 > 0) {
                                    }
                                }
                                if (a2 != 0) {
                                    if (a2 > 0 && b6 == top) {
                                    }
                                }
                                c(motionEvent);
                                break;
                            }
                            b(f, f2, b4);
                            if (this.a != 1) {
                                if (obj != null && b(b5, b4)) {
                                }
                            }
                            c(motionEvent);
                        }
                    }
                    c(motionEvent);
                }
                break;
            case 5:
                a = ay.b(motionEvent, b);
                float c2 = ay.c(motionEvent, b);
                y = ay.d(motionEvent, b);
                a(c2, y, a);
                if (this.a != 0 && this.a == 2) {
                    View b8 = b((int) c2, (int) y);
                    if (b8 == this.s) {
                        b(b8, a);
                        break;
                    }
                }
                break;
            case 6:
                b(ay.b(motionEvent, b));
                break;
        }
        return this.a == 1;
    }

    public final boolean a(View view, int i, int i2) {
        this.s = view;
        this.d = -1;
        boolean a = a(i, i2, 0, 0);
        if (!(a || this.a != 0 || this.s == null)) {
            this.s = null;
        }
        return a;
    }

    public final void b(MotionEvent motionEvent) {
        int i = 0;
        int a = ay.a(motionEvent);
        int b = ay.b(motionEvent);
        if (a == 0) {
            c();
        }
        if (this.m == null) {
            this.m = VelocityTracker.obtain();
        }
        this.m.addMovement(motionEvent);
        float x;
        int c;
        float c2;
        int left;
        switch (a) {
            case 0:
                x = motionEvent.getX();
                float y = motionEvent.getY();
                i = ay.b(motionEvent, 0);
                View b2 = b((int) x, (int) y);
                a(x, y, i);
                b(b2, i);
                if ((this.i[i] & this.c) == 0) {
                    return;
                }
                return;
            case 1:
                if (this.a == 1) {
                    d();
                }
                c();
                return;
            case 2:
                if (this.a != 1) {
                    c = ay.c(motionEvent);
                    while (i < c) {
                        a = ay.b(motionEvent, i);
                        if (c(a)) {
                            c2 = ay.c(motionEvent, i);
                            float d = ay.d(motionEvent, i);
                            float f = c2 - this.e[a];
                            float f2 = d - this.f[a];
                            b(f, f2, a);
                            if (this.a != 1) {
                                View b3 = b((int) c2, (int) d);
                                if (a(b3, f, f2) && b(b3, a)) {
                                }
                            }
                            c(motionEvent);
                            return;
                        }
                        i++;
                    }
                    c(motionEvent);
                    return;
                } else if (c(this.d)) {
                    i = ay.a(motionEvent, this.d);
                    x = ay.c(motionEvent, i);
                    c = (int) (x - this.g[this.d]);
                    i = (int) (ay.d(motionEvent, i) - this.h[this.d]);
                    left = this.s.getLeft() + c;
                    a = this.s.getTop() + i;
                    b = this.s.getLeft();
                    int top = this.s.getTop();
                    if (c != 0) {
                        left = this.r.c(this.s, left);
                        bq.e(this.s, left - b);
                    }
                    if (i != 0) {
                        a = this.r.b(this.s, a);
                        bq.d(this.s, a - top);
                    }
                    if (!(c == 0 && i == 0)) {
                        this.r.a(this.s, left, a, left - b, a - top);
                    }
                    c(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.a == 1) {
                    a(0.0f, 0.0f);
                }
                c();
                return;
            case 5:
                c = ay.b(motionEvent, b);
                float c3 = ay.c(motionEvent, b);
                c2 = ay.d(motionEvent, b);
                a(c3, c2, c);
                if (this.a == 0) {
                    b(b((int) c3, (int) c2), c);
                    return;
                }
                a = (int) c3;
                b = (int) c2;
                View view = this.s;
                if (view != null && a >= view.getLeft() && a < view.getRight() && b >= view.getTop() && b < view.getBottom()) {
                    i = 1;
                }
                if (i != 0) {
                    b(this.s, c);
                    return;
                }
                return;
            case 6:
                a = ay.b(motionEvent, b);
                if (this.a == 1 && a == this.d) {
                    left = ay.c(motionEvent);
                    while (i < left) {
                        b = ay.b(motionEvent, i);
                        if (b != this.d) {
                            if (b((int) ay.c(motionEvent, i), (int) ay.d(motionEvent, i)) == this.s && b(this.s, b)) {
                                i = this.d;
                                if (i == -1) {
                                    d();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        d();
                    }
                }
                b(a);
                return;
            default:
                return;
        }
    }

    public final boolean b() {
        if (this.a == 2) {
            boolean z;
            boolean g = this.q.g();
            int b = this.q.b();
            int c = this.q.c();
            int left = b - this.s.getLeft();
            int top = c - this.s.getTop();
            if (left != 0) {
                bq.e(this.s, left);
            }
            if (top != 0) {
                bq.d(this.s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.r.a(this.s, b, c, left, top);
            }
            if (g && b == this.q.d() && c == this.q.e()) {
                this.q.h();
                z = false;
            } else {
                z = g;
            }
            if (!z) {
                this.u.post(this.w);
            }
        }
        return this.a == 2;
    }
}
