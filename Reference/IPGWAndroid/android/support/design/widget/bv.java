package android.support.design.widget;

import android.support.v4.view.cy;
import java.lang.ref.WeakReference;

public final class bv implements cy {
    int a;
    int b;
    private final WeakReference<TabLayout> c;

    public bv(TabLayout tabLayout) {
        this.c = new WeakReference(tabLayout);
    }

    public final void a(int i) {
        this.a = this.b;
        this.b = i;
    }

    public final void a(int i, float f) {
        boolean z = false;
        TabLayout tabLayout = (TabLayout) this.c.get();
        if (tabLayout != null) {
            boolean z2 = this.b != 2 || this.a == 1;
            if (!(this.b == 2 && this.a == 0)) {
                z = true;
            }
            tabLayout.a(i, f, z2, z);
        }
    }

    public final void b(int i) {
        TabLayout tabLayout = (TabLayout) this.c.get();
        if (tabLayout != null && tabLayout.getSelectedTabPosition() != i) {
            boolean z = this.b == 0 || (this.b == 2 && this.a == 0);
            tabLayout.a(tabLayout.a(i), z);
        }
    }
}
