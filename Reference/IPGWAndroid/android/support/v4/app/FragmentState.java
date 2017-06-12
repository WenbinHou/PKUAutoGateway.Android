package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR = new ah();
    final String a;
    final int b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    Bundle j;
    n k;

    public FragmentState(Parcel parcel) {
        boolean z = true;
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.h = z;
        this.i = parcel.readBundle();
        this.j = parcel.readBundle();
    }

    public FragmentState(n nVar) {
        this.a = nVar.getClass().getName();
        this.b = nVar.g;
        this.c = nVar.o;
        this.d = nVar.w;
        this.e = nVar.x;
        this.f = nVar.y;
        this.g = nVar.B;
        this.h = nVar.A;
        this.i = nVar.i;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        if (!this.h) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.i);
        parcel.writeBundle(this.j);
    }
}
