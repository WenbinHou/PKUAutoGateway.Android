package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.design.widget.BottomSheetBehavior.SavedState;

final class i implements Creator<SavedState> {
    i() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SavedState(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SavedState[i];
    }
}
