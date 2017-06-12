package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.a;
import android.support.v4.view.a.ae;
import android.support.v4.view.a.f;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

final class cw extends a {
    final /* synthetic */ ViewPager b;

    cw(ViewPager viewPager) {
        this.b = viewPager;
    }

    private boolean a() {
        if (this.b.i == null) {
            return false;
        }
        this.b.i;
        return true;
    }

    public final void a(View view, f fVar) {
        super.a(view, fVar);
        fVar.a(ViewPager.class.getName());
        fVar.a(a());
        if (this.b.canScrollHorizontally(1)) {
            fVar.a(4096);
        }
        if (this.b.canScrollHorizontally(-1)) {
            fVar.a(8192);
        }
    }

    public final boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (!this.b.canScrollHorizontally(1)) {
                    return false;
                }
                this.b.setCurrentItem(this.b.j + 1);
                return true;
            case 8192:
                if (!this.b.canScrollHorizontally(-1)) {
                    return false;
                }
                this.b.setCurrentItem(this.b.j - 1);
                return true;
            default:
                return false;
        }
    }

    public final void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        ae a = a.a(accessibilityEvent);
        a.a(a());
        if (accessibilityEvent.getEventType() == 4096 && this.b.i != null) {
            this.b.i;
            a.a(3);
            a.b(this.b.j);
            a.c(this.b.j);
        }
    }
}
