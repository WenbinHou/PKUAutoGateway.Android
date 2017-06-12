package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class fi implements Creator<FullSpanItem> {
    fi() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new FullSpanItem(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new FullSpanItem[i];
    }
}
