package android.support.design.widget;

import android.widget.ImageButton;

class da extends ImageButton {
    private int a;

    final void a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.a = i;
        }
    }

    final int getUserSetVisibility() {
        return this.a;
    }

    public void setVisibility(int i) {
        a(i, true);
    }
}
