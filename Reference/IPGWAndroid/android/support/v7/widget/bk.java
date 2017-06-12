package android.support.v7.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class bk implements OnGlobalLayoutListener {
    final /* synthetic */ bi a;

    bk(bi biVar) {
        this.a = biVar;
    }

    public final void onGlobalLayout() {
        if (bi.a(this.a, this.a.b)) {
            this.a.a();
            super.b();
            return;
        }
        this.a.d();
    }
}
