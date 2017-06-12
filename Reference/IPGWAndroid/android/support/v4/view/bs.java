package android.support.v4.view;

import android.util.Log;
import android.view.ViewGroup;

class bs extends br {
    bs() {
    }

    public final void a(ViewGroup viewGroup) {
        if (cf.a == null) {
            try {
                cf.a = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (Throwable e) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e);
            }
            cf.a.setAccessible(true);
        }
        try {
            cf.a.invoke(viewGroup, new Object[]{Boolean.valueOf(true)});
        } catch (Throwable e2) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e2);
        } catch (Throwable e22) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e22);
        } catch (Throwable e222) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e222);
        }
    }
}
