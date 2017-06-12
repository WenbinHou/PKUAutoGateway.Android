package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

public final class fs extends Resources {
    private final WeakReference<Context> a;

    public fs(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.a = new WeakReference(context);
    }

    public final Drawable getDrawable(int i) {
        Context context = (Context) this.a.get();
        if (context == null) {
            return super.getDrawable(i);
        }
        ao a = ao.a();
        Drawable a2 = a.a(context, i);
        if (a2 == null) {
            a2 = super.getDrawable(i);
        }
        return a2 != null ? a.a(context, i, false, a2) : null;
    }
}
