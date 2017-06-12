package android.support.design.widget;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;

public abstract class n<V extends View> {
    public n(Context context, AttributeSet attributeSet) {
    }

    public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
    }

    public void a(CoordinatorLayout coordinatorLayout, V v, View view) {
    }

    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int[] iArr) {
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, float f, boolean z) {
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        return false;
    }

    public boolean a_(View view) {
        return false;
    }

    public Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
        return BaseSavedState.EMPTY_STATE;
    }

    public void b(CoordinatorLayout coordinatorLayout, V v, int i) {
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        return false;
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, View view) {
        return false;
    }
}
