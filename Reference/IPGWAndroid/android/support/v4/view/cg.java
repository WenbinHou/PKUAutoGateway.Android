package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

final class cg {
    private static void a(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    static void a(View view, int i) {
        view.offsetTopAndBottom(i);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            a((View) parent);
        }
    }

    static void b(View view, int i) {
        view.offsetLeftAndRight(i);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            a((View) parent);
        }
    }
}
