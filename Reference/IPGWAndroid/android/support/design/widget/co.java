package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

final class co {
    private static final cp a;

    static {
        if (VERSION.SDK_INT >= 11) {
            a = new cr();
        } else {
            a = new cq();
        }
    }

    static void a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        a.a(viewGroup, view, rect);
    }
}
