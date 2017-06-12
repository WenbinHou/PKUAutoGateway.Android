package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class ct<V extends View> extends n<V> {
    private cu a;
    private int b = 0;
    private int c = 0;

    public ct(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(int i) {
        if (this.a != null) {
            return this.a.a(i);
        }
        this.b = i;
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        c(coordinatorLayout, v, i);
        if (this.a == null) {
            this.a = new cu(v);
        }
        cu cuVar = this.a;
        cuVar.b = cuVar.a.getTop();
        cuVar.c = cuVar.a.getLeft();
        cuVar.a();
        if (this.b != 0) {
            this.a.a(this.b);
            this.b = 0;
        }
        if (this.c != 0) {
            cuVar = this.a;
            int i2 = this.c;
            if (cuVar.e != i2) {
                cuVar.e = i2;
                cuVar.a();
            }
            this.c = 0;
        }
        return true;
    }

    public int c() {
        return this.a != null ? this.a.d : 0;
    }

    protected void c(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.a((View) v, i);
    }
}
