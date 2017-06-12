package com.google.android.gms.b;

import android.content.SharedPreferences;

final class af extends ab<String> {
    af(int i, String str, String str2) {
        super(i, str, str2);
    }

    public final /* synthetic */ Object a(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(this.a, (String) this.b);
    }
}
