package com.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class ab implements ac {
    private final SharedPreferences a;

    ab(Context context, String str) {
        this.a = context.getSharedPreferences(str, 0);
    }

    private Editor a() {
        return this.a.edit();
    }

    public final <T> T a(String str) {
        return this.a.getString(str, null);
    }

    public final <T> boolean a(String str, T t) {
        x.a("key", (Object) str);
        return a().putString(str, String.valueOf(t)).commit();
    }

    public final boolean b(String str) {
        return a().remove(str).commit();
    }

    public final boolean c(String str) {
        return this.a.contains(str);
    }
}
