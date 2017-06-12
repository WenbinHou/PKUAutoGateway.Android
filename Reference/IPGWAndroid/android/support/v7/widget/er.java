package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.f;
import android.support.v4.view.a.p;
import android.support.v4.view.bq;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;

public final class er extends a {
    final RecyclerView b;
    final a c = new es(this);

    public er(RecyclerView recyclerView) {
        this.b = recyclerView;
    }

    public final void a(View view, f fVar) {
        super.a(view, fVar);
        fVar.a(RecyclerView.class.getName());
        if (!a() && this.b.getLayoutManager() != null) {
            eb layoutManager = this.b.getLayoutManager();
            eh ehVar = layoutManager.q.a;
            en enVar = layoutManager.q.o;
            if (bq.b(layoutManager.q, -1) || bq.a(layoutManager.q, -1)) {
                fVar.a(8192);
                fVar.a(true);
            }
            if (bq.b(layoutManager.q, 1) || bq.a(layoutManager.q, 1)) {
                fVar.a(4096);
                fVar.a(true);
            }
            f.a.a(fVar.b, new p(f.a.a(layoutManager.a(ehVar, enVar), layoutManager.b(ehVar, enVar))).a);
        }
    }

    final boolean a() {
        RecyclerView recyclerView = this.b;
        return !recyclerView.f || recyclerView.h || recyclerView.b.d();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (a() || this.b.getLayoutManager() == null) {
            return false;
        }
        eb layoutManager = this.b.getLayoutManager();
        eh ehVar = layoutManager.q.a;
        en enVar = layoutManager.q.o;
        if (layoutManager.q == null) {
            return false;
        }
        int size;
        int i2;
        switch (i) {
            case 4096:
                size = bq.b(layoutManager.q, 1) ? (MeasureSpec.getSize(layoutManager.x) - layoutManager.n()) - layoutManager.p() : 0;
                if (bq.a(layoutManager.q, 1)) {
                    i2 = size;
                    size = (MeasureSpec.getSize(layoutManager.w) - layoutManager.m()) - layoutManager.o();
                    break;
                }
            case 8192:
                size = bq.b(layoutManager.q, -1) ? -((MeasureSpec.getSize(layoutManager.x) - layoutManager.n()) - layoutManager.p()) : 0;
                if (bq.a(layoutManager.q, -1)) {
                    i2 = size;
                    size = -((MeasureSpec.getSize(layoutManager.w) - layoutManager.m()) - layoutManager.o());
                    break;
                }
            default:
                size = 0;
                i2 = 0;
                break;
        }
        if (i2 == 0 && size == 0) {
            return false;
        }
        layoutManager.q.scrollBy(size, i2);
        return true;
    }

    public final void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !a()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().a(accessibilityEvent);
            }
        }
    }
}
