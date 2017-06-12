package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.bq;
import android.support.v4.view.v;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

abstract class an extends ct<View> {
    int a = 0;
    int b;
    private final Rect c = new Rect();
    private final Rect d = new Rect();

    public an(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    abstract View a(List<View> list);

    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View a = a(coordinatorLayout.a(view));
            if (a != null) {
                if (bq.v(a) && !bq.v(view)) {
                    bq.w(view);
                    if (bq.v(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                if (bq.F(a)) {
                    int size = MeasureSpec.getSize(i3);
                    if (size == 0) {
                        size = coordinatorLayout.getHeight();
                    }
                    coordinatorLayout.a(view, i, i2, MeasureSpec.makeMeasureSpec(c(a) + (size - a.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                    return true;
                }
            }
        }
        return false;
    }

    float b(View view) {
        return 1.0f;
    }

    int c(View view) {
        return view.getMeasuredHeight();
    }

    protected final void c(CoordinatorLayout coordinatorLayout, View view, int i) {
        View a = a(coordinatorLayout.a(view));
        if (a != null) {
            q qVar = (q) view.getLayoutParams();
            Rect rect = this.c;
            rect.set(coordinatorLayout.getPaddingLeft() + qVar.leftMargin, a.getBottom() + qVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - qVar.rightMargin, ((coordinatorLayout.getHeight() + a.getBottom()) - coordinatorLayout.getPaddingBottom()) - qVar.bottomMargin);
            Rect rect2 = this.d;
            int i2 = qVar.c;
            if (i2 == 0) {
                i2 = 8388659;
            }
            v.a(i2, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            i2 = d(a);
            view.layout(rect2.left, rect2.top - i2, rect2.right, rect2.bottom - i2);
            this.a = rect2.top - a.getBottom();
            return;
        }
        super.c(coordinatorLayout, view, i);
        this.a = 0;
    }

    final int d(View view) {
        return this.b == 0 ? 0 : ao.a(Math.round(b(view) * ((float) this.b)), 0, this.b);
    }
}
