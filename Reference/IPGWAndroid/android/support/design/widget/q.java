package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.design.h;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public final class q extends MarginLayoutParams {
    n a;
    boolean b = false;
    public int c = 0;
    public int d = 0;
    public int e = -1;
    int f = -1;
    View g;
    View h;
    boolean i;
    boolean j;
    boolean k;
    final Rect l = new Rect();
    Object m;

    public q() {
        super(-2, -2);
    }

    q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.CoordinatorLayout_LayoutParams);
        this.c = obtainStyledAttributes.getInteger(h.CoordinatorLayout_LayoutParams_android_layout_gravity, 0);
        this.f = obtainStyledAttributes.getResourceId(h.CoordinatorLayout_LayoutParams_layout_anchor, -1);
        this.d = obtainStyledAttributes.getInteger(h.CoordinatorLayout_LayoutParams_layout_anchorGravity, 0);
        this.e = obtainStyledAttributes.getInteger(h.CoordinatorLayout_LayoutParams_layout_keyline, -1);
        this.b = obtainStyledAttributes.hasValue(h.CoordinatorLayout_LayoutParams_layout_behavior);
        if (this.b) {
            this.a = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(h.CoordinatorLayout_LayoutParams_layout_behavior));
        }
        obtainStyledAttributes.recycle();
    }

    public q(q qVar) {
        super(qVar);
    }

    public q(LayoutParams layoutParams) {
        super(layoutParams);
    }

    public q(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public final void a(n nVar) {
        if (this.a != nVar) {
            this.a = nVar;
            this.m = null;
            this.b = true;
        }
    }

    final boolean a(View view) {
        return view == this.h || (this.a != null && this.a.a_(view));
    }
}
