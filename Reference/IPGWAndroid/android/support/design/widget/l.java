package android.support.design.widget;

import android.view.View;
import java.util.Comparator;

final class l implements Comparator<View> {
    final /* synthetic */ CoordinatorLayout a;

    l(CoordinatorLayout coordinatorLayout) {
        this.a = coordinatorLayout;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        View view = (View) obj;
        View view2 = (View) obj2;
        if (view != view2) {
            if (((q) view.getLayoutParams()).a(view2)) {
                return 1;
            }
            if (((q) view2.getLayoutParams()).a(view)) {
                return -1;
            }
        }
        return 0;
    }
}
