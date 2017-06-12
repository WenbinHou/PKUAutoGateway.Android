package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;

class cb extends ca {
    cb() {
    }

    public final boolean D(View view) {
        return view.isNestedScrollingEnabled();
    }

    public final ColorStateList E(View view) {
        return view.getBackgroundTintList();
    }

    public final Mode F(View view) {
        return view.getBackgroundTintMode();
    }

    public final void G(View view) {
        view.stopNestedScroll();
    }

    public final float I(View view) {
        return view.getZ();
    }

    public final ed a(View view, ed edVar) {
        if (!(edVar instanceof ee)) {
            return edVar;
        }
        WindowInsets windowInsets = ((ee) edVar).a;
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        return onApplyWindowInsets != windowInsets ? new ee(onApplyWindowInsets) : edVar;
    }

    public final void a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    public final void a(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    public final void a(View view, bi biVar) {
        if (biVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new ci(biVar));
        }
    }

    public final ed b(View view, ed edVar) {
        if (!(edVar instanceof ee)) {
            return edVar;
        }
        WindowInsets windowInsets = ((ee) edVar).a;
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        return dispatchApplyWindowInsets != windowInsets ? new ee(dispatchApplyWindowInsets) : edVar;
    }

    public void e(View view, int i) {
        Object obj;
        Rect a = ch.a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        cg.b(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    public final void f(View view, float f) {
        view.setElevation(f);
    }

    public void f(View view, int i) {
        Object obj;
        Rect a = ch.a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        cg.a(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    public final void v(View view) {
        view.requestApplyInsets();
    }

    public final float w(View view) {
        return view.getElevation();
    }

    public final float x(View view) {
        return view.getTranslationZ();
    }
}
