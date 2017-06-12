package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

class bw extends bu {
    static Field b;
    static boolean c = false;

    bw() {
    }

    public final void a(View view, a aVar) {
        view.setAccessibilityDelegate((AccessibilityDelegate) (aVar == null ? null : aVar.a));
    }

    public final boolean a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public final boolean b(View view) {
        if (c) {
            return false;
        }
        if (b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable th) {
                c = true;
                return false;
            }
        }
        try {
            return b.get(view) != null;
        } catch (Throwable th2) {
            c = true;
            return false;
        }
    }

    public final boolean b(View view, int i) {
        return view.canScrollVertically(i);
    }

    public final dk t(View view) {
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        dk dkVar = (dk) this.a.get(view);
        if (dkVar != null) {
            return dkVar;
        }
        dkVar = new dk(view);
        this.a.put(view, dkVar);
        return dkVar;
    }

    public final void z(View view) {
        view.setFitsSystemWindows(true);
    }
}
