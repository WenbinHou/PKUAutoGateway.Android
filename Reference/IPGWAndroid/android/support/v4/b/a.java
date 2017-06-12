package android.support.v4.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public class a {
    public static final Drawable a(Context context, int i) {
        return VERSION.SDK_INT >= 21 ? context.getDrawable(i) : context.getResources().getDrawable(i);
    }
}
