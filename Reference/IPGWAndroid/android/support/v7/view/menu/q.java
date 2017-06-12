package android.support.v7.view.menu;

import android.support.v7.view.d;
import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

final class q extends FrameLayout implements d {
    final CollapsibleActionView a;

    q(View view) {
        super(view.getContext());
        this.a = (CollapsibleActionView) view;
        addView(view);
    }

    public final void a() {
        this.a.onActionViewExpanded();
    }

    public final void b() {
        this.a.onActionViewCollapsed();
    }
}
