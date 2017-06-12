package android.support.v4.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b<T> implements Creator<T> {
    final c<T> a;

    public b(c<T> cVar) {
        this.a = cVar;
    }

    public final T createFromParcel(Parcel parcel) {
        return this.a.a(parcel, null);
    }

    public final T[] newArray(int i) {
        return this.a.a(i);
    }
}
