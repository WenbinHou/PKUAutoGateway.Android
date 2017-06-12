package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class fq extends ContextWrapper {
    private static final ArrayList<WeakReference<fq>> a = new ArrayList();
    private Resources b;
    private final Theme c = getResources().newTheme();

    private fq(Context context) {
        super(context);
        this.c.setTo(context.getTheme());
    }

    public static Context a(Context context) {
        Object obj = context instanceof fq ? null : context.getResources() instanceof fs ? null : 1;
        if (obj == null) {
            return context;
        }
        Context context2;
        int size = a.size();
        for (int i = 0; i < size; i++) {
            WeakReference weakReference = (WeakReference) a.get(i);
            context2 = weakReference != null ? (fq) weakReference.get() : null;
            if (context2 != null && context2.getBaseContext() == context) {
                return context2;
            }
        }
        context2 = new fq(context);
        a.add(new WeakReference(context2));
        return context2;
    }

    public final Resources getResources() {
        if (this.b == null) {
            this.b = new fs(this, super.getResources());
        }
        return this.b;
    }

    public final Theme getTheme() {
        return this.c;
    }

    public final void setTheme(int i) {
        this.c.applyStyle(i, true);
    }
}
