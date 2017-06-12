package android.support.v4.widget;

import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

final class bk {
    static Field a;
    static boolean b;
    static Field c;
    static boolean d;

    static int a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException e) {
            Log.d("TextViewCompatDonut", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    static Field a(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            Log.e("TextViewCompatDonut", "Could not retrieve " + str + " field.");
            return field;
        }
    }
}
