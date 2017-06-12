package com.google.android.gms.b;

import android.content.SharedPreferences;

final class ad extends ab<Integer> {
    ad(int i, String str, Integer num) {
        super(i, str, num);
    }

    public final /* synthetic */ Object a(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(this.a, ((Integer) this.b).intValue()));
    }
}
