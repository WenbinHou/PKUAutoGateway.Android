package android.support.design.widget;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

final class p implements OnHierarchyChangeListener {
    final /* synthetic */ CoordinatorLayout a;

    private p(CoordinatorLayout coordinatorLayout) {
        this.a = coordinatorLayout;
    }

    public final void onChildViewAdded(View view, View view2) {
        if (this.a.x != null) {
            this.a.x.onChildViewAdded(view, view2);
        }
    }

    public final void onChildViewRemoved(View view, View view2) {
        CoordinatorLayout coordinatorLayout = this.a;
        int size = coordinatorLayout.g.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            View view3 = (View) coordinatorLayout.g.get(i);
            if (view3 == view2) {
                obj2 = 1;
            } else {
                if (obj != null) {
                    view3.getLayoutParams();
                }
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
        if (this.a.x != null) {
            this.a.x.onChildViewRemoved(view, view2);
        }
    }
}
