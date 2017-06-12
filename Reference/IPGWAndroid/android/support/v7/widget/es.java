package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.f;
import android.view.View;

final class es extends a {
    final /* synthetic */ er b;

    es(er erVar) {
        this.b = erVar;
    }

    public final void a(View view, f fVar) {
        super.a(view, fVar);
        if (!this.b.a() && this.b.b.getLayoutManager() != null) {
            this.b.b.getLayoutManager().a(view, fVar);
        }
    }

    public final boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (this.b.a() || this.b.b.getLayoutManager() == null) {
            return false;
        }
        eb layoutManager = this.b.b.getLayoutManager();
        eh ehVar = layoutManager.q.a;
        en enVar = layoutManager.q.o;
        return false;
    }
}
