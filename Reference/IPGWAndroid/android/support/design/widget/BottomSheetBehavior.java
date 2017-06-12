package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.h;
import android.support.v4.view.ay;
import android.support.v4.view.be;
import android.support.v4.view.bq;
import android.support.v4.widget.bm;
import android.support.v4.widget.bp;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends n<V> {
    private float a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private int f = 4;
    private bm g;
    private boolean h;
    private int i;
    private boolean j;
    private int k;
    private WeakReference<V> l;
    private WeakReference<View> m;
    private VelocityTracker n;
    private int o;
    private int p;
    private boolean q;
    private final bp r = new h(this);

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new i();
        final int a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.a = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.BottomSheetBehavior_Params);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(h.BottomSheetBehavior_Params_behavior_peekHeight, 0);
        this.b = Math.max(0, dimensionPixelSize);
        this.d = this.k - dimensionPixelSize;
        this.e = obtainStyledAttributes.getBoolean(h.BottomSheetBehavior_Params_behavior_hideable, false);
        obtainStyledAttributes.recycle();
        this.a = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void a() {
        this.o = -1;
        if (this.n != null) {
            this.n.recycle();
            this.n = null;
        }
    }

    private void a(int i) {
        if (this.f != i) {
            this.f = i;
            this.l.get();
        }
    }

    private boolean a(View view, float f) {
        return view.getTop() >= this.d && Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.d)) / ((float) this.b) > 0.5f;
    }

    private View b(View view) {
        if (view instanceof be) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View b = b(viewGroup.getChildAt(i));
                if (b != null) {
                    return b;
                }
            }
        }
        return null;
    }

    private void b() {
        this.l.get();
    }

    public final void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.a(coordinatorLayout, (View) v, savedState.getSuperState());
        if (savedState.a == 1 || savedState.a == 2) {
            this.f = 4;
        } else {
            this.f = savedState.a;
        }
    }

    public final void a(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i = 3;
        if (v.getTop() == this.c) {
            a(3);
        } else if (view == this.m.get() && this.j) {
            int i2;
            if (this.i > 0) {
                i2 = this.c;
            } else {
                if (this.e) {
                    this.n.computeCurrentVelocity(1000, this.a);
                    if (a((View) v, android.support.v4.view.bm.b(this.n, this.o))) {
                        i2 = this.k;
                        i = 5;
                    }
                }
                if (this.i == 0) {
                    int top = v.getTop();
                    if (Math.abs(top - this.c) < Math.abs(top - this.d)) {
                        i2 = this.c;
                    } else {
                        i2 = this.d;
                        i = 4;
                    }
                } else {
                    i2 = this.d;
                    i = 4;
                }
            }
            if (this.g.a((View) v, v.getLeft(), i2)) {
                a(2);
                bq.a((View) v, new j(this, v, i));
            } else {
                a(i);
            }
            this.j = false;
        }
    }

    public final void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int[] iArr) {
        if (view == ((View) this.m.get())) {
            int top = v.getTop();
            int i2 = top - i;
            if (i > 0) {
                if (i2 < this.c) {
                    iArr[1] = top - this.c;
                    bq.d((View) v, -iArr[1]);
                    a(3);
                } else {
                    iArr[1] = i;
                    bq.d((View) v, -i);
                    a(1);
                }
            } else if (i < 0 && !bq.b(view, -1)) {
                if (i2 <= this.d || this.e) {
                    iArr[1] = i;
                    bq.d((View) v, -i);
                    a(1);
                } else {
                    iArr[1] = top - this.d;
                    bq.d((View) v, -iArr[1]);
                    a(4);
                }
            }
            v.getTop();
            b();
            this.i = i;
            this.j = true;
        }
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (!(this.f == 1 || this.f == 2)) {
            coordinatorLayout.a((View) v, i);
        }
        this.k = coordinatorLayout.getHeight();
        this.c = Math.max(0, this.k - v.getHeight());
        this.d = Math.max(this.k - this.b, this.c);
        if (this.f == 3) {
            bq.d((View) v, this.c);
        } else if (this.e && this.f == 5) {
            bq.d((View) v, this.k);
        } else if (this.f == 4) {
            bq.d((View) v, this.d);
        }
        if (this.g == null) {
            this.g = bm.a((ViewGroup) coordinatorLayout, this.r);
        }
        this.l = new WeakReference(v);
        this.m = new WeakReference(b((View) v));
        return true;
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        View view;
        int a = ay.a(motionEvent);
        if (a == 0) {
            a();
        }
        if (this.n == null) {
            this.n = VelocityTracker.obtain();
        }
        this.n.addMovement(motionEvent);
        switch (a) {
            case 0:
                int x = (int) motionEvent.getX();
                this.p = (int) motionEvent.getY();
                view = (View) this.m.get();
                if (view != null && coordinatorLayout.a(view, x, this.p)) {
                    this.o = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.q = true;
                }
                boolean z = this.o == -1 && !coordinatorLayout.a((View) v, x, this.p);
                this.h = z;
                break;
            case 1:
            case 3:
                this.q = false;
                this.o = -1;
                if (this.h) {
                    this.h = false;
                    return false;
                }
                break;
        }
        if (!this.h && this.g.a(motionEvent)) {
            return true;
        }
        view = (View) this.m.get();
        return (a != 2 || view == null || this.h || this.f == 1 || coordinatorLayout.a(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.p) - motionEvent.getY()) <= ((float) this.g.b)) ? false : true;
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.m.get() && (this.f != 3 || super.a(coordinatorLayout, (View) v, view, f, f2));
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        this.i = 0;
        this.j = false;
        return (i & 2) != 0;
    }

    public final Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.b(coordinatorLayout, v), this.f);
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int a = ay.a(motionEvent);
        if (this.f == 1 && a == 0) {
            return true;
        }
        this.g.b(motionEvent);
        if (a == 0) {
            a();
        }
        if (this.n == null) {
            this.n = VelocityTracker.obtain();
        }
        this.n.addMovement(motionEvent);
        if (a != 2 || Math.abs(((float) this.p) - motionEvent.getY()) <= ((float) this.g.b)) {
            return true;
        }
        this.g.a((View) v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        return true;
    }
}
