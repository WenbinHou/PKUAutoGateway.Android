package com.google.android.gms.b;

import android.content.SharedPreferences;

final class ac extends ab<Boolean> {
    ac(int i, String str, Boolean bool) {
        super(i, str, bool);
    }

    public final /* synthetic */ Object a(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(this.a, ((Boolean) this.b).booleanValue()));
    }
}
