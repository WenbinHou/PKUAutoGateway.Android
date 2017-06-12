package android.support.v7.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Method;

final class as implements OnClickListener {
    private final View a;
    private final String b;
    private Method c;
    private Context d;

    public as(View view, String str) {
        this.a = view;
        this.b = str;
    }

    public final void onClick(View view) {
        if (this.c == null) {
            for (Context context = this.a.getContext(); context != null; context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null) {
                try {
                    if (!context.isRestricted()) {
                        Method method = context.getClass().getMethod(this.b, new Class[]{View.class});
                        if (method != null) {
                            this.c = method;
                            this.d = context;
                        }
                    }
                } catch (NoSuchMethodException e) {
                }
            }
            int id = this.a.getId();
            throw new IllegalStateException("Could not find method " + this.b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.a.getClass() + (id == -1 ? "" : " with id '" + this.a.getContext().getResources().getResourceEntryName(id) + "'"));
        }
        try {
            this.c.invoke(this.d, new Object[]{view});
        } catch (Throwable e2) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
        } catch (Throwable e22) {
            throw new IllegalStateException("Could not execute method for android:onClick", e22);
        }
    }
}
