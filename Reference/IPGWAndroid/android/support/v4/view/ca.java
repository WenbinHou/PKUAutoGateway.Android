package android.support.v4.view;

import android.view.View;

class ca extends bz {
    ca() {
    }

    public final boolean H(View view) {
        return view.isLaidOut();
    }

    public final boolean J(View view) {
        return view.isAttachedToWindow();
    }

    public final void c(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public final void k(View view) {
        view.setAccessibilityLiveRegion(1);
    }
}
