package android.support.v7.widget;

import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

final class ez {
    Method a;
    Method b;
    Method c;
    private Method d;

    ez() {
        try {
            this.a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
            this.a.setAccessible(true);
        } catch (NoSuchMethodException e) {
        }
        try {
            this.b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            this.b.setAccessible(true);
        } catch (NoSuchMethodException e2) {
        }
        try {
            this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
            this.c.setAccessible(true);
        } catch (NoSuchMethodException e3) {
        }
        try {
            this.d = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
            this.d.setAccessible(true);
        } catch (NoSuchMethodException e4) {
        }
    }
}
