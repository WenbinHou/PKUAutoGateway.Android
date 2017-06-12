package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class k implements Callable<SharedPreferences> {
    final /* synthetic */ Context a;

    k(Context context) {
        this.a = context;
    }

    public final /* synthetic */ Object call() {
        return this.a.getSharedPreferences("google_sdk_flags", 1);
    }
}
