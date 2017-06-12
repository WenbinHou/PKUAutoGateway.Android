package android.support.v7.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow.OnDismissListener;

final class bl implements OnDismissListener {
    final /* synthetic */ OnGlobalLayoutListener a;
    final /* synthetic */ bi b;

    bl(bi biVar, OnGlobalLayoutListener onGlobalLayoutListener) {
        this.b = biVar;
        this.a = onGlobalLayoutListener;
    }

    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.b.b.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.a);
        }
    }
}
