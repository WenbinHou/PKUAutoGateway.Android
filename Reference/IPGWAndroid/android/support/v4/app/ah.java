package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ah implements Creator<FragmentState> {
    ah() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new FragmentState(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new FragmentState[i];
    }
}
