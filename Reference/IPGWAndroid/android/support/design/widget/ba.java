package android.support.design.widget;

import android.support.design.widget.Snackbar.SnackbarLayout;
import android.view.MotionEvent;
import android.view.View;

final class ba extends SwipeDismissBehavior<SnackbarLayout> {
    final /* synthetic */ Snackbar a;

    ba(Snackbar snackbar) {
        this.a = snackbar;
    }

    private boolean a(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
        if (coordinatorLayout.a((View) snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    bd.a().a(this.a.c);
                    break;
                case 1:
                case 3:
                    bd.a().b(this.a.c);
                    break;
            }
        }
        return super.a(coordinatorLayout, (View) snackbarLayout, motionEvent);
    }

    public final boolean b(View view) {
        return view instanceof SnackbarLayout;
    }
}
