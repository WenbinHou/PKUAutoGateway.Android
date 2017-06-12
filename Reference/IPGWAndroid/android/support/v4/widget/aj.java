package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

class aj extends ai {
    aj() {
    }

    public void a(PopupWindow popupWindow, int i) {
        if (!an.b) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                an.a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception e) {
            }
            an.b = true;
        }
        if (an.a != null) {
            try {
                an.a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
            }
        }
    }
}
