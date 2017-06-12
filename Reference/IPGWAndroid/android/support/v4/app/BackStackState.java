package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new k();
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;

    public BackStackState(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
    }

    public BackStackState(e eVar) {
        int i = 0;
        for (i iVar = eVar.c; iVar != null; iVar = iVar.a) {
            if (iVar.i != null) {
                i += iVar.i.size();
            }
        }
        this.a = new int[(i + (eVar.e * 7))];
        if (eVar.l) {
            i = 0;
            for (i iVar2 = eVar.c; iVar2 != null; iVar2 = iVar2.a) {
                int i2 = i + 1;
                this.a[i] = iVar2.c;
                int i3 = i2 + 1;
                this.a[i2] = iVar2.d != null ? iVar2.d.g : -1;
                int i4 = i3 + 1;
                this.a[i3] = iVar2.e;
                i2 = i4 + 1;
                this.a[i4] = iVar2.f;
                i4 = i2 + 1;
                this.a[i2] = iVar2.g;
                i2 = i4 + 1;
                this.a[i4] = iVar2.h;
                if (iVar2.i != null) {
                    int size = iVar2.i.size();
                    i4 = i2 + 1;
                    this.a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.a[i4] = ((n) iVar2.i.get(i2)).g;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.a[i2] = 0;
                }
            }
            this.b = eVar.j;
            this.c = eVar.k;
            this.d = eVar.n;
            this.e = eVar.p;
            this.f = eVar.q;
            this.g = eVar.r;
            this.h = eVar.s;
            this.i = eVar.t;
            this.j = eVar.u;
            this.k = eVar.v;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public final e a(y yVar) {
        e eVar = new e(yVar);
        int i = 0;
        int i2 = 0;
        while (i2 < this.a.length) {
            i iVar = new i();
            int i3 = i2 + 1;
            iVar.c = this.a[i2];
            if (y.a) {
                Log.v("FragmentManager", "Instantiate " + eVar + " op #" + i + " base fragment #" + this.a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.a[i3];
            if (i2 >= 0) {
                iVar.d = (n) yVar.f.get(i2);
            } else {
                iVar.d = null;
            }
            i3 = i4 + 1;
            iVar.e = this.a[i4];
            i4 = i3 + 1;
            iVar.f = this.a[i3];
            i3 = i4 + 1;
            iVar.g = this.a[i4];
            int i5 = i3 + 1;
            iVar.h = this.a[i3];
            i4 = i5 + 1;
            int i6 = this.a[i5];
            if (i6 > 0) {
                iVar.i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (y.a) {
                        Log.v("FragmentManager", "Instantiate " + eVar + " set remove fragment #" + this.a[i4]);
                    }
                    i5 = i4 + 1;
                    iVar.i.add((n) yVar.f.get(this.a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            eVar.f = iVar.e;
            eVar.g = iVar.f;
            eVar.h = iVar.g;
            eVar.i = iVar.h;
            eVar.a(iVar);
            i++;
            i2 = i4;
        }
        eVar.j = this.b;
        eVar.k = this.c;
        eVar.n = this.d;
        eVar.p = this.e;
        eVar.l = true;
        eVar.q = this.f;
        eVar.r = this.g;
        eVar.s = this.h;
        eVar.t = this.i;
        eVar.u = this.j;
        eVar.v = this.k;
        eVar.a(1);
        return eVar;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
    }
}
