package android.support.a.a;

import android.content.res.TypedArray;

final class l extends o {
    public l(l lVar) {
        super(lVar);
    }

    final void a(TypedArray typedArray) {
        String string = typedArray.getString(0);
        if (string != null) {
            this.n = string;
        }
        string = typedArray.getString(1);
        if (string != null) {
            this.m = f.a(string);
        }
    }

    public final boolean a() {
        return true;
    }
}
