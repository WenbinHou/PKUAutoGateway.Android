package com.google.android.gms.b;

import android.content.SharedPreferences;

final class ae extends ab<Long> {
    ae(String str, Long l) {
        super(0, str, l);
    }

    public final /* synthetic */ Object a(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(this.a, ((Long) this.b).longValue()));
    }
}
