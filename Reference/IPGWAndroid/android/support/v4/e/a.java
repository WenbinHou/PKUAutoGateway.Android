package android.support.v4.e;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

public final class a {
    public static <T> Creator<T> a(c<T> cVar) {
        return VERSION.SDK_INT >= 13 ? new d(cVar) : new b(cVar);
    }
}
