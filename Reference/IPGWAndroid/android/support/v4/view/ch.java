package android.support.v4.view;

import android.graphics.Rect;

final class ch {
    private static ThreadLocal<Rect> a;

    static Rect a() {
        if (a == null) {
            a = new ThreadLocal();
        }
        Rect rect = (Rect) a.get();
        if (rect == null) {
            rect = new Rect();
            a.set(rect);
        }
        rect.setEmpty();
        return rect;
    }
}
