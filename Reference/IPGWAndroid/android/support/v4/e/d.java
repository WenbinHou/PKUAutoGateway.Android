package android.support.v4.e;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

final class d<T> implements ClassLoaderCreator<T> {
    private final c<T> a;

    public d(c<T> cVar) {
        this.a = cVar;
    }

    public final T createFromParcel(Parcel parcel) {
        return this.a.a(parcel, null);
    }

    public final T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.a.a(parcel, classLoader);
    }

    public final T[] newArray(int i) {
        return this.a.a(i);
    }
}
