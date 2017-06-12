package android.support.v4.view;

import android.view.View;

class by extends bx {
    by() {
    }

    public final boolean C(View view) {
        return view.isPaddingRelative();
    }

    public final void a(View view, int i, int i2, int i3, int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    public final int h(View view) {
        return view.getLayoutDirection();
    }

    public final int l(View view) {
        return view.getPaddingStart();
    }

    public final int m(View view) {
        return view.getPaddingEnd();
    }

    public final int u(View view) {
        return view.getWindowSystemUiVisibility();
    }
}
