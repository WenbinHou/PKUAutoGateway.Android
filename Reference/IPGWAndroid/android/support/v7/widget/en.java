package android.support.v7.widget;

import android.util.SparseArray;

public final class en {
    int a = -1;
    int b = 1;
    int c = 0;
    int d = 0;
    int e = 0;
    boolean f = false;
    boolean g = false;
    boolean h = false;
    boolean i = false;
    boolean j = false;
    boolean k = false;
    private SparseArray<Object> l;

    public final int a() {
        return this.g ? this.d - this.e : this.c;
    }

    final void a(int i) {
        if ((this.b & i) == 0) {
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.b));
        }
    }

    public final String toString() {
        return "State{mTargetPosition=" + this.a + ", mData=" + this.l + ", mItemCount=" + this.c + ", mPreviousLayoutItemCount=" + this.d + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.e + ", mStructureChanged=" + this.f + ", mInPreLayout=" + this.g + ", mRunSimpleAnimations=" + this.h + ", mRunPredictiveAnimations=" + this.i + '}';
    }
}
